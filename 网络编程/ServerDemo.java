import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerDemo {
    public static void main(String[] args) throws Exception {
        /**
         * ServerDemo.java文件解决问题：
         * 建立一个服务器程序，使得浏览器可以访问服务器，CMD:Telnet也可以访问
         */
        ServerSocket ss = new ServerSocket(13140);
        while (true) {
            Socket s = ss.accept();
            sop("客户端：" + s.getInetAddress().getHostAddress() + "正在连接...");
            PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
            /**
             * 文本打印输出流，总是忘记设置自动行刷新为true
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             * PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
             */
            pwOut.println("<font color = 'blue' size='10'>客户端你好！</font>");
            s.close();
        }

        //ss.close();
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
