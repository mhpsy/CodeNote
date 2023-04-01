package top.mhpsy.IO_;

import java.io.*;
import java.util.*;

public class RemoveTabsInMdFiles {
    public static void main(String[] args) {
        // 指定要扫描的文件夹路径和扩展名
        String folderPath = "E:\\小娴\\Teresa\\路子And小娴";
        String fileExtension = ".md";

        // 递归扫描文件夹下所有MD文件
        List<File> mdFiles = new ArrayList<>();
        scanFiles(new File(folderPath), fileExtension, mdFiles);

        // 对每个MD文件执行删除行首制表符操作
        for (File mdFile : mdFiles) {
            try {
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(mdFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    // 判断行首是否为制表符，并且制表符后面不为数字或星号
                    if (line.matches("^\\t[^\\d\\*].*")) {
                        // 如果行首为制表符，并且制表符后面不为数字或星号，则删除该制表符
                        line = line.replaceFirst("^\\t", "");
                    }
                    content.append(line).append("\n");
                }
                reader.close();

                // 将修改后的文件内容写回文件
                FileWriter writer = new FileWriter(mdFile);
                writer.write(content.toString());
                writer.close();

                System.out.println("Remove tabs in " + mdFile.getAbsolutePath() + " done!");
            } catch (IOException e) {
                System.err.println("Error occurred when processing " + mdFile.getAbsolutePath() + ": " + e.getMessage());
            }
        }
    }

    /**
     * 递归扫描文件夹下所有指定扩展名的文件
     *
     * @param folder    文件夹
     * @param extension 扩展名
     * @param fileList  文件列表
     */
    public static void scanFiles(File folder, String extension, List<File> fileList) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFiles(file, extension, fileList);
                } else if (file.getName().endsWith(extension)) {
                    fileList.add(file);
                }
            }
        }
    }
}
