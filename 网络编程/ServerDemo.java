import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerDemo {
    public static void main(String[] args) throws Exception {
        /**
         * ServerDemo.java�ļ�������⣺
         * ����һ������������ʹ����������Է��ʷ�������CMD:TelnetҲ���Է���
         */
        ServerSocket ss = new ServerSocket(13140);
        while (true) {
            Socket s = ss.accept();
            sop("�ͻ��ˣ�" + s.getInetAddress().getHostAddress() + "��������...");
            PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
            /**
             * �ı���ӡ��������������������Զ���ˢ��Ϊtrue
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             */
            pwOut.println("<font color = 'blue' size='10'>�ͻ�����ã�</font>");
            s.close();
        }

        //ss.close();
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
