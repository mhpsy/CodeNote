package top.mhpsy.Inet_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class I02SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);//端口号
            System.out.println(serverSocket + " is listening");
            Socket accept = serverSocket.accept();//阻塞
            System.out.println(accept);
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
            System.out.println(new String(bytes, 0, read));
            inputStream.close();
            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
