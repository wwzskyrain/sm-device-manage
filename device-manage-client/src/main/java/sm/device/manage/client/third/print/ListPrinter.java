package sm.device.manage.client.third.print;

import com.alibaba.fastjson.JSON;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DocumentName;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.Sides;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author erik.wang
 * @date 2020-04-05 19:04
 */
public class ListPrinter {

    private static final String PDF_PRINTER_NAME = "PDFwriter";

    public static void main(String[] args) {
        try {
            printPdf();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listPrinters() {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of print services: " + printServices.length);

        for (PrintService printer : printServices) {
            System.out.println(JSON.toJSONString(printer));
        }
    }

    public static void printPdf() throws IOException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
        PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
        patts.add(Sides.DUPLEX);
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
        if (ps.length == 0) {
            throw new IllegalStateException("No Printer found");
        }
        System.out.println("Available printers: " + Arrays.asList(ps));

        PrintService myService = null;
        for (PrintService printService : ps) {
            if (printService.getName().equals(PDF_PRINTER_NAME)) {
                myService = printService;
                break;
            }
        }

        if (myService == null) {
            throw new IllegalStateException("Printer not found");
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("doc/paying.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DocumentName documentName = new DocumentName("pgn_pdf.pdf", null);
        HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet(documentName);
        Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, hashDocAttributeSet);
        DocPrintJob printJob = myService.createPrintJob();
        HashPrintRequestAttributeSet hashPrintRequestAttributeSet = new HashPrintRequestAttributeSet(new JobName("job_name_to_print_a_pgn", null));
        try {
            printJob.print(pdfDoc, hashPrintRequestAttributeSet);
        } catch (PrintException e) {
            e.printStackTrace();
        }
        fis.close();
    }


}
