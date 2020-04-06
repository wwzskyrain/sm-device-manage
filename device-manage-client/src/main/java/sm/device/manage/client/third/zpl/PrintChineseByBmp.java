package sm.device.manage.client.third.zpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

/**
 * @author gongchang
 * 描述：生成位图，并转16进制字符
 * 时间：2015年10月26日 上午9:11:28
 */
public class PrintChineseByBmp {

    String imgCodes = "", begin = "^XA", content = "", end = "^XZ";
    Integer textNo = 0;

    public void setCommand() {
        printCN("中国", 28, 60, 90);
    }

    public String getCommand() {
        return imgCodes +
                begin + "\n" +
                content +
                end;
    }

    public void printCN(String text, int size, int x, int y) {
        BufferedImage img = createImage(text, size);
        String codeData = convertImageToCode(img);
        String t = ((img.getWidth() / 8 + ((img.getWidth() % 8 == 0) ? 0 : 1)) * img.getHeight()) + "";
        String w = (img.getWidth() / 8 + ((img.getWidth() % 8 == 0) ? 0 : 1)) + "";
//		String zpl = "~DGOUTSTR01," + t + "," + w + "," + codeData;
        ++textNo;
        imgCodes += "~DGtext" + textNo + "," + t + "," + w + "," + codeData + "\n";

        content += "^FO" + x + "," + y + "\n" +
                "^XGtext" + textNo + ",1,1^FS\n";
    }

    public final BufferedImage createImage(String text, int size) {
        size = size == 0 ? 28 : size;
        Font font = new Font("宋体", Font.BOLD, size);
        JTextField txt = new JTextField();
        txt.setText(text);
        txt.setFont(font);

        int width = txt.getPreferredSize().width;
        int height = txt.getPreferredSize().height;

        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, width, height);

        g2.setFont(font);
        g2.setPaint(Color.BLACK);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(text, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.drawString(text, (int) x, (int) baseY);
        return bi;
    }

    public final String convertImageToCode(BufferedImage img) {
        StringBuffer sb = new StringBuffer();
        long clr = 0, n = 0;
        int b = 0;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                b = b * 2;
                clr = img.getRGB(j, i);
                String s = String.format("%X", clr);

                if (s.substring(s.length() - 6, s.length() - 6 + 6).compareTo(
                        "BBBBBB") < 0) {
                    b++;
                }
                n++;
                if (j == (img.getWidth() - 1)) {
                    if (n < 8) {
                        b = b * (2 ^ (8 - (int) n));
                        sb.append(StringUtils.leftPad(String.format("%X", b),
                                2, "0"));
                        // sb.append(String.format("%X", b).PadLeft(2, '0'));
                        b = 0;
                        n = 0;
                    }
                }
                if (n >= 8) {
                    sb.append(StringUtils.leftPad(String.format("%X", b), 2,
                            "0"));
                    // sb.append(String.format("%X", b).PadLeft(2, '0'));
                    b = 0;
                    n = 0;
                }
            }
            sb.append("\n");
        }
        return sb.toString();

    }

    public void runPrint(String str) throws PrintException {
        PrintService pdfWriteService = null;
        for (PrintService printService : PrintServiceLookup.lookupPrintServices(null, null)) {
            if (printService.getName().equals("PDFwriter")) {
                pdfWriteService = printService;
                break;
            }
        }

        DocPrintJob job = pdfWriteService.createPrintJob();
        byte[] by = str.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(by, flavor, null);
        job.print(doc, null);
    }

    public static void main(String[] args) throws PrintException {
        PrintChineseByBmp obj = new PrintChineseByBmp();
        obj.setCommand();
        String command = obj.getCommand();
        obj.runPrint(command);
        System.out.println(command);
    }
}