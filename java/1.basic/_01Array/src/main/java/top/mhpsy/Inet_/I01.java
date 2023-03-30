package top.mhpsy.Inet_;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class I01 {
    public static void main(String[] args) {
        Inet4Address inet4Address = null;
        try {
            inet4Address = (Inet4Address) Inet4Address.getLocalHost();

            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu);
            System.out.println(baidu.getHostName());
            System.out.println(baidu.getCanonicalHostName()); //110.242.68.4
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        System.out.println(inet4Address);


    }
}

