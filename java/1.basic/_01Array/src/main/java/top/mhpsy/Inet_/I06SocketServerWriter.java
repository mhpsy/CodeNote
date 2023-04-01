package top.mhpsy.Inet_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class I06SocketServerWriter {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(serverSocket + " is listening");

            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("server is reading" + i++);
            }
            System.out.println("reading is over");
            accept.shutdownInput();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bufferedWriter.write("hello client");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            accept.shutdownOutput();

            accept.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
