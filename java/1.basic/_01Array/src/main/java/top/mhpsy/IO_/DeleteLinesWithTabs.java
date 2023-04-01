package top.mhpsy.IO_;

import java.io.*;

public class DeleteLinesWithTabs {
    public static void main(String[] args) throws IOException {
        String folderPath = "C:/Users/User/Desktop/MarkdownFiles"; // 要扫描的文件夹路径
        File folder = new File(folderPath);
        processFolder(folder);
    }

    private static void processFolder(File folder) throws IOException {
        File[] files = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".md"); // 只扫描扩展名为.md的文件
            }
        });

        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("\t")) {
                    // 如果行首有制表符，则跳过该行
                    continue;
                }
                content.append(line).append("\n");
            }
            reader.close();

            // 将修改后的文件内容写回文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();
        }

        File[] subFolders = folder.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory(); // 扫描子文件夹
            }
        });

        for (File subFolder : subFolders) {
            processFolder(subFolder); // 递归扫描子文件夹
        }
    }
}
