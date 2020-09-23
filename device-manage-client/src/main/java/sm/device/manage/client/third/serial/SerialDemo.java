package sm.device.manage.client.third.serial;

import purejavacomm.CommPortIdentifier;
import purejavacomm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author erik.wang
 * @date 2020-04-18 11:11
 */
public class SerialDemo {

    public static void main(String[] args) {
        try {
            // Finding the port
            String portName = "cu.usbserial";
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);

            // Opening the port
            SerialPort port = (SerialPort) portId.open("SerialDemo", 2000);
            OutputStream outStream = port.getOutputStream();
            InputStream inStream = port.getInputStream();

            // Sending data
//            sendCommand(outStream, "Reset");
//            sendCommand(outStream, "AT+Test");

            // Receiving data


            int available;
            do {
                TimeUnit.MILLISECONDS.sleep(4000);
                available = inStream.available();
                byte[] bytes = new byte[available];
                inStream.read(bytes);
                print(bytes);
            } while (available == 0);


//            // Checking the message
//            for (int i = 0; i < received; i++) {
//                if (dataReceived[i] != dataToSend[i]) {
//                    System.err.println("error at " + i + "th byte, sent " + dataToSend[i] + " received " + dataReceived);
//                }
//            }
            System.out.println("Done");
            port.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void print(byte[] content) {

        System.out.println(Arrays.toString(content));
        List<Integer> integerList = new ArrayList<>();
        for (byte b : content) {
            integerList.add(Byte.toUnsignedInt(b));
        }
        System.out.println(integerList);
        System.out.printf("接收到 %d 字节的数据，内容为 \n", content.length);
//
//        Map<String, Charset> availableCharsetUtil = CharsetUtil.getAvailableCharsetUtil();
//        availableCharsetUtil.forEach((charSetName, charSet) ->
//                System.out.printf("charName=%s content:%s \n", charSetName, new String(content, charSet))
//        );


    }

    public static void sendCommand(OutputStream outputStream, String command) {
        try {
            System.out.println("send_command" + command);
            outputStream.write(command.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
