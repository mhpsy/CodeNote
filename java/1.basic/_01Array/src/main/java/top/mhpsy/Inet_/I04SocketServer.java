package top.mhpsy.Inet_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class I04SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(serverSocket + " is listening");
            Socket accept = serverSocket.accept();
//            accept.getInputStream().transferTo(System.out);
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
//            inputStream.close();
            accept.shutdownInput();//关闭输入流
            accept.getOutputStream().write("hello client".getBytes());
            accept.shutdownOutput();//关闭输出流
            accept.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
