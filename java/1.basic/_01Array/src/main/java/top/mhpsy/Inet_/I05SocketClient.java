package top.mhpsy.Inet_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class I05SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello server".getBytes());
//            outputStream.close();
            socket.shutdownOutput();

            socket.getInputStream().transferTo(System.out);
            socket.shutdownInput();

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
