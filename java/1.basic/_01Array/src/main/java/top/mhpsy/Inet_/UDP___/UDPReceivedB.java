package top.mhpsy.Inet_.UDP___;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.atomic.AtomicBoolean;

public class UDPReceivedB {
    static AtomicBoolean flag = new AtomicBoolean(true);
    static boolean f = true;

    public static void main(String[] args) {


        try (DatagramSocket datagramSocket = new DatagramSocket(8888)) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);


            while (f) {
                datagramSocket.receive(datagramPacket);
                new Thread(() -> {

                    setFlag setFlag = ff -> f = false;


                    try {
                        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                        if (s.equals("exit")) {
                            setFlag.set11(false);
                        }
                        System.out.println(s);

                        //接收到什么就发送什么
                        datagramSocket.send(datagramPacket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public interface setFlag {

        void set11(boolean f);
    }

}
