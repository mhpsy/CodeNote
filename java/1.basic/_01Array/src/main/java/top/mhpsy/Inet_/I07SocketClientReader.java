package top.mhpsy.Inet_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class I07SocketClientReader {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (int i = 0; i < 3; i++) {
                bufferedWriter.write("hello server" + i);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                Thread.sleep(1000);
            }
            bufferedWriter.write("over");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            socket.shutdownOutput();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            socket.shutdownInput();

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
