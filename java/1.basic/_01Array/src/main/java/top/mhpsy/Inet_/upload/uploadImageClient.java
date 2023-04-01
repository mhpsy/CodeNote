package top.mhpsy.Inet_.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class uploadImageClient {
    public static void main(String[] args) {
        String filePath = "D:\\IO\\Socket\\client.png";

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            byte[] bytes = inputStreamToByteArray(bufferedInputStream);//将文件转换为字节数组
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);//这里我没用缓冲流，直接用的字节数组，所以不用flush
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            inputStream.transferTo(System.out);
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //ByteArrayOutputStream:字节数组输出流
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byte[] result = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return result;
    }
}
