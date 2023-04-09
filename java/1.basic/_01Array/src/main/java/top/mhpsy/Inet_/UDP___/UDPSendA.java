package top.mhpsy.Inet_.UDP___;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSendA {
    public static void main(String[] args) {
        boolean flag = true;
        try (DatagramSocket datagramSocket = new DatagramSocket(9999)) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            datagramPacket.setAddress(InetAddress.getLocalHost());
            datagramPacket.setPort(8888);
            while (flag) {
                System.out.println("请输入要发送的内容:->>");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if (s.equals("exit")) {
                    flag = false;
                }
                datagramPacket.setData(s.getBytes());

                datagramSocket.send(datagramPacket);

                //发送过去后，接收一下
                datagramSocket.receive(datagramPacket);
                System.out.println("接收到的" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));


            }


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
