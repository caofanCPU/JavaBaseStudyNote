//package A.B;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPDemo2 {
    public static void main(String[] args) {
        /**
         * .java�ļ�������⣺
         *
         */

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

class TCPClient2 {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 10020);
        OutputStream out = s.getOutputStream();
        out.write("TCP��������������".getBytes());
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        sop("������˵:\"" + new String(buf, 0, len) + "\"");
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
        sop("�ͻ���" + ip + "˵:\"" + new String(buf, 0, len) + "\"");
        OutputStream out = s.getOutputStream();
        out.write("TCP�ͻ��ˣ������أ�".getBytes());
    }

    public static void sop(Object obj) {
        /**
         * ��ӡ�ַ���
         *
         */
        System.out.println(obj);
    }
}
