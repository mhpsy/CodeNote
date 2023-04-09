package top.mhpsy.Inet_.UDP_;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSender01 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        boolean flag = true;
        try {
            datagramSocket = new DatagramSocket(9999);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);

//            datagramPacket.setAddress(InetAddress.getLocalHost());
            datagramPacket.setAddress(InetAddress.getByName("192.168.68.69"));
            datagramPacket.setPort(8888);

//            datagramPacket.setData("hello".getBytes());
//            datagramSocket.send(datagramPacket);
            while (flag) {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if (s.equals("exit")) {
                    flag = false;
                }
                datagramPacket.setData(s.getBytes());
                datagramSocket.send(datagramPacket);

                datagramPacket.setData(new byte[1024]);
                datagramPacket.setLength(1024);

                datagramSocket.receive(datagramPacket);
//                System.out.println("接收到了 " + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
                byte[] data = datagramPacket.getData();
                int length = datagramPacket.getLength();
                System.out.println(length);
                System.out.println(new String(data, 0, length));
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert datagramSocket != null;
            datagramSocket.close();
        }
    }
}
