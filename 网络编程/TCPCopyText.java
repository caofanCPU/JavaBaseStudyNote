import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TCPCopyText {
    public static void main(String[] args) {
        /**
         * TCPCopyText.java文件解决问题：
         * 使用TCP将客户端的文本文件上传至服务器
         */

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

class TCPCopyTextServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(12121);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        sop("客户端" + ip + "正在连接...");
        File textFile = new File("TCPCopyText.txt");
        BufferedWriter bufw = new BufferedWriter(new FileWriter(textFile));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        int i = 1;
        //bufrIn.readLine()当且仅当，读取到流末尾时，才返回null
        while (null != (line = bufrIn.readLine())) {
            bufw.write("[" + i + "]    " + line);
            bufw.newLine();
            bufw.flush();
            i++;
        }
        /**
         * BufferedWriter.write()方法，必须使用3步！
         * 第一步：写入目的字符串
         * 第二步：补上行结束标记
         * 第三步：将输出流缓存刷新至输出流！！
         * 如果，服务器发给客户端的输出流不包含行结束符，又未关闭客户端镜像，也为关闭服务器服务
         * 在客户端执行.readLine()时，因为读取不到行结束标记，从而一直阻塞，直至java.net.SocketException: Connection reset
         */
        bufwOut.write("文件上传成功！");
        bufwOut.newLine();
        bufwOut.flush();

        bufw.close();
        s.close();        //关闭客户端镜像，关闭后客户端与服务器所有链接操作均禁止
        ss.close();
    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }
}

class TCPCopyTextClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 12121);
        File textFile = new File("TCPCopyText.java");
        BufferedReader bufr = new BufferedReader(new FileReader(textFile));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //以行读取方式读取文本文件
        String line = null;
        /**
         * while循环最后一次，bufr.readLine()读到文件尾，因而未发送输出流
         * 若缺少结束标记，服务器很可能死等
         * 因而，使用Socket.shotDownOutput()，禁用输出流，即输出流到达流末尾
         */
        while (null != (line = bufr.readLine())) {
            //将文本文件的每行(未包含行结束标记)写入输出流缓存区
            bufwOut.write(line);
            //补上行结束标记
            bufwOut.newLine();
            //将输出流缓存区数据刷新至输出流，以此通过网卡发送给服务器
            bufwOut.flush();
        }
        //客户端上传文件内容结束后，给服务器发送"输出流末尾"标记
        s.shutdownOutput();
        line = bufrIn.readLine();
        sop(line);
        //关闭流
        bufr.close();
        s.close();
    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }
}