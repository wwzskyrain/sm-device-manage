package sm.device.manage.client.third.test;

import java.util.Arrays;

/**
 * @author erik.wang
 * @date 2020-04-18 16:40
 */
public class TestMain {

    public static void main(String[] args) {
        byte[] bytesToSend = "AT+Test".getBytes();
        System.out.println(Arrays.toString(bytesToSend));
    }

}
