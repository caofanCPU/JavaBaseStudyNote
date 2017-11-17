//package A.B;

import java.io.*;

class CopyTextByBuffer {
    public static void main(String[] args) {
        /**
         * CopyTextByBuffer.java文件解决问题：
         * 通过字符流缓冲区，从源字符类文件复制到目的字符类文件
         * 示例：将本代码文件CopyTextByBuffer.java复制到同目录下CopyTextByBuffer.txt中
         *		 要求，两个文件内容几本一致
         *		 且CopyTextByBuffer.txt中显示了CopyTextByBuffer.java的代码行号
         *		 如第一行代码：import java.io.*; 应对应为[1]  import java.io.*;
         */
        String sourceDir = System.getProperty("user.dir");    //获取本java文件所在的父目录
        String destinationDir = sourceDir;
        //sop(sourceDir);
        copyFile(sourceDir, destinationDir);
        lineSplit();

    }

    public static void copyFile(String sourceDir, String destinationDir) {
        File sourceFile = new File(sourceDir, "CopyTextByBuffer.java");
        File destinationFile = new File(destinationDir, "Java代码将自身内容复制到指定文件.txt");
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        if (!sourceFile.exists()) {
            throw new RuntimeException("源文件路径错误或源文件不存在！");
        }
        if (!sourceFile.isFile()) {
            throw new RuntimeException("源文件不存在，只有同名目录！");
        }
        if (0 == sourceFile.length()) {
            throw new RuntimeException("原文件存在但内容为空");
        }
        if (!destinationFile.getParentFile().isDirectory()) {
            throw new RuntimeException("目的文件指定父目录路径错误！");
        }
        try {
            bufr = new BufferedReader(new FileReader(sourceFile));
            bufw = new BufferedWriter(new FileWriter(destinationFile));
            String line = null;
            int i = 1;
            while (null != (line = bufr.readLine())) {    //注意：.readLine()方法不会返回"换行"
                bufw.write("[" + i + "]  " + line + "\r\n");
                bufw.flush();
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("源文件读取关闭失败！");
            }
            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("目的文件写入关闭失败！");
            }
        }
        sop("Successful!--源文件：\"" + sourceFile.getName() + "\"[复制到]"
                + "目的文件\"" + destinationFile.getName() + "\"");
    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }

    public static void lineSplit() {
        /**
         * 打印分隔符
         *
         */
        sop("---------------------------");
    }
}
