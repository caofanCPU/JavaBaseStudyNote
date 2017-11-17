//package A.B;

import java.io.*;

class CopyTextByBuffer {
    public static void main(String[] args) {
        /**
         * CopyTextByBuffer.java�ļ�������⣺
         * ͨ���ַ�������������Դ�ַ����ļ����Ƶ�Ŀ���ַ����ļ�
         * ʾ�������������ļ�CopyTextByBuffer.java���Ƶ�ͬĿ¼��CopyTextByBuffer.txt��
         *		 Ҫ�������ļ����ݼ���һ��
         *		 ��CopyTextByBuffer.txt����ʾ��CopyTextByBuffer.java�Ĵ����к�
         *		 ���һ�д��룺import java.io.*; Ӧ��ӦΪ[1]  import java.io.*;
         */
        String sourceDir = System.getProperty("user.dir");    //��ȡ��java�ļ����ڵĸ�Ŀ¼
        String destinationDir = sourceDir;
        //sop(sourceDir);
        copyFile(sourceDir, destinationDir);
        lineSplit();

    }

    public static void copyFile(String sourceDir, String destinationDir) {
        File sourceFile = new File(sourceDir, "CopyTextByBuffer.java");
        File destinationFile = new File(destinationDir, "Java���뽫�������ݸ��Ƶ�ָ���ļ�.txt");
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        if (!sourceFile.exists()) {
            throw new RuntimeException("Դ�ļ�·�������Դ�ļ������ڣ�");
        }
        if (!sourceFile.isFile()) {
            throw new RuntimeException("Դ�ļ������ڣ�ֻ��ͬ��Ŀ¼��");
        }
        if (0 == sourceFile.length()) {
            throw new RuntimeException("ԭ�ļ����ڵ�����Ϊ��");
        }
        if (!destinationFile.getParentFile().isDirectory()) {
            throw new RuntimeException("Ŀ���ļ�ָ����Ŀ¼·������");
        }
        try {
            bufr = new BufferedReader(new FileReader(sourceFile));
            bufw = new BufferedWriter(new FileWriter(destinationFile));
            String line = null;
            int i = 1;
            while (null != (line = bufr.readLine())) {    //ע�⣺.readLine()�������᷵��"����"
                bufw.write("[" + i + "]  " + line + "\r\n");
                bufw.flush();
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException("��дʧ��");
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Դ�ļ���ȡ�ر�ʧ�ܣ�");
            }
            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Ŀ���ļ�д��ر�ʧ�ܣ�");
            }
        }
        sop("Successful!--Դ�ļ���\"" + sourceFile.getName() + "\"[���Ƶ�]"
                + "Ŀ���ļ�\"" + destinationFile.getName() + "\"");
    }

    public static void sop(Object obj) {
        /**
         * ��ӡ�ַ���
         *
         */
        System.out.println(obj);
    }

    public static void lineSplit() {
        /**
         * ��ӡ�ָ���
         *
         */
        sop("---------------------------");
    }
}
