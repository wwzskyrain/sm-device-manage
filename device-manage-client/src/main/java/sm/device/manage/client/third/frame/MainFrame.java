package sm.device.manage.client.third.frame;

import javax.swing.*;
import java.awt.*;

/**
 * @author erik.wang
 * @date 2020-04-13 08:46
 */
public class MainFrame extends JFrame {


    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame("ÎÀÕñ¿Æ¼¼");

    }

    public MainFrame(String title) {
        super(title);
        setLocation(200, 200);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button1=new JButton ("×´Ì¬1");
        TabbedPaneDataShow dataShowPanel = new TabbedPaneDataShow();
        JButton button4=new JButton("ÅäÖÃ");
        JButton button5=new JButton("×´Ì¬");
        add(button1,BorderLayout.NORTH);
        add(dataShowPanel,BorderLayout.CENTER);
        add(button4,BorderLayout.EAST);
        add(button5,BorderLayout.SOUTH);
        setBounds(300,200,600,300);
        setVisible(true);

    }
}
