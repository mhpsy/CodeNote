package top.mhpsy.Inet_.UDP_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver01 {
    public static void main(String[] args) throws SocketException {
        //new DatagramPacket(byte[] buf, int length)
        //buf:接收数据的缓冲区
        //length:接收数据的最大长度

        try (DatagramSocket datagramSocket = new DatagramSocket(8888)) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            boolean flag = true;
            while (flag) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                int length = datagramPacket.getLength();

                String s = new String(data, 0, length);
                if (s.equals("exit")) {
                    flag = false;
                }

                datagramPacket.setData(new byte[1024]);
                datagramPacket.setLength(1024);

                datagramPacket.setData(s.getBytes());
//                System.out.println(("接收到了 " + s).length());
//                System.out.println(("接收到了 " + s).getBytes().length);
                datagramSocket.send(datagramPacket);

                System.out.println(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
