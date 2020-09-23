package sm.device.manage.client.third.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * @author erik.wang
 * @date 2020-04-13 07:39
 */
public class TabbedPaneDataShow extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("�ҵĵ��� - ����");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TabbedPaneDataShow(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public TabbedPaneDataShow() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();

        ImageIcon iconCamera = createImageIcon("/pic/camera.png");
        String tabName = "��������";
        JComponent dataPanel = makeTextPanel(tabName);
        tabbedPane.addTab(tabName, iconCamera, dataPanel, "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        String serialPortDataPanelName = "��������";
        JComponent panel2 = makeTextPanel(serialPortDataPanelName);
        tabbedPane.addTab(serialPortDataPanelName, createImageIcon("/pic/compass.png"), panel2, "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        String labelPrintPanel = "��ǩ��ӡ";
        JComponent labelPrint = makeTextPanel(labelPrintPanel);
        tabbedPane.addTab("�߼�", createImageIcon("/pic/periscope.png"), labelPrint, "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        add(tabbedPane);
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }


    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDataShow.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
