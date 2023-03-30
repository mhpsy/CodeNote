package top.mhpsy.Inet_.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class uploadImageServer {
    public static void main(String[] args) {
        String filePath = "D:\\IO\\Socket\\server.jpg";

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket accept = serverSocket.accept();

            accept.getInputStream().transferTo(new FileOutputStream(filePath));
            accept.shutdownInput();

            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("上传成功".getBytes());

            accept.shutdownOutput();//这里不用close，因为我用的是shutdownOutput，而不是close
            accept.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
