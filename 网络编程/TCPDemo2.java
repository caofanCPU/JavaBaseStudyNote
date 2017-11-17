//package A.B;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPDemo2 {
    public static void main(String[] args) {
        /**
         * .java文件解决问题：
         *
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

class TCPClient2 {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 10020);
        OutputStream out = s.getOutputStream();
        out.write("TCP服务器，你在吗？".getBytes());
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        sop("服务器说:\"" + new String(buf, 0, len) + "\"");
        s.close();
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}

class TCPServer2 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10020);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1020];
        int len = in.read(buf);
        sop("客户端" + ip + "说:\"" + new String(buf, 0, len) + "\"");
        OutputStream out = s.getOutputStream();
        out.write("TCP客户端，我在呢！".getBytes());
    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }
}
