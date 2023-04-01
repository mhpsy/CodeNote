package top.mhpsy.Inet_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class I03SocketClient {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost());//admin/192.168.68.69
            Socket localhost = new Socket(InetAddress.getLocalHost(), 8888);
            OutputStream outputStream = localhost.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.close();
            localhost.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
