import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TransTextDemo {
    public static void main(String[] args) {
        /**
         * TransTextDemo.java文件解决问题：
         * 客户端向服务器发送一个字符串，服务器返回字符串的大写形式
         * 客户端发送结束标记：over时，客户端，服务端都结束
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

/**
 * 需求：建立一个文本转换服务器
 * 客户端给服务器发送一个文本，服务器将文本转换为大写并返回给客户端
 * 服务器需要一直待命进行文本转换，当客户端输入over时，转换结束
 * <p>
 * 分析：
 * 客户端：既然是操作设备上的数据，就可以使用IO技术，按照IO操作规律来思考
 * 源：键盘录入；目的：网络输出流
 * 操作数据是文本数据，因而选择字符流
 * 服务端：
 */
/**
 * 分析：
 *		客户端：既然是操作设备上的数据，就可以使用IO技术，按照IO操作规律来思考
 *				源：键盘录入；目的：网络输出流
 *				操作数据是文本数据，因而选择字符流
 *		服务端：
 */

/**
 * 总结：
 *		出现的问题及原因分析：
 *		现象：客户端和服务端都在莫名地等待。
 *		这是因为，客户端、服务器都使用了 阻塞式方法，这些方法没有读到结束标记
 *				  例如：BufferedReader.readLine()方法，默认以'换行'为结束标记
 *					    那么，.readLine()方法返回的不带'换行'符，需要.newLine()
 */
class TransTextClient {
    /**
     * 操作步骤：
     * 1.建立服务
     * 2.键盘录入字符串保存至缓存，键盘录入缓存写入输出流，准备读取保存服务器返回的输入流
     * 3.关闭键盘读入输入流，关闭socket客户端，即关闭了客户端网络输入流+输出流
     */
    public static void main(String[] args) throws Exception {
        //创建客户端服务，指定要连接的服务器的IP地址，以及服务端口号
        Socket s = new Socket("127.0.0.1", 13140);
        /**
         * 从键盘读取字符流
         * System.in为键盘输入流，使用输入流读指针指向：new InputStreamReader(System.in)
         * 指定输入流读指针的缓存区，new BufferedReader(输入流指针)
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 定义相对于本机的socket输出流--写缓存
         * 定义相对于本机的socket输入流--读缓存
         */
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        /**
         * 目的流：PrintWriter printOut = new PrintWriter(s.getOutputStream(), true);
         * 既能操作字符流，又能操作字节流，自带换行，自带刷新
         */

        //以行读取方式读取键盘输入流，保存在line中，发送给服务端
        String line = null;
        while (null != (line = bufr.readLine())) {
            //结束判断要先执行：否则出现 Software caused connection abort: recv failed异常
            if ("over".equals(line)) {
                break;
            }
            //将键盘读入的字符串写入缓存，注意BufferedReader.readLine()返回结果缺少行结束标记
            bufwOut.write(line);
            //利用BufferedWriter.newLine()补上行结束标记
            bufwOut.newLine();
            //客户端发给服务器的信息还在缓存，需要BufferedWriter.flush()刷新至输出流中
            bufwOut.flush();
            //读取服务器返回的信息
            line = bufrIn.readLine();
            sop("服务器回应：" + line);
        }
        ;
        //关闭键盘输入流
        bufr.close();
        //关闭socket服务(客户端网络流)
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

class TransTextServer {
    /**
     *
     */
    public static void main(String[] args) throws Exception {
        //创建服务器服务，并指定监听端口new ServerSocket(int port)
        ServerSocket ss = new ServerSocket(13140);
        //获取连接服务器的客户端对象.accept()，该对象被服务器获取后，相当于服务器端的客户端镜像
        Socket s = ss.accept();
        //利用Socket.getInetAddress().getHostAddress()获取客户端IP地址
        String ip = s.getInetAddress().getHostAddress();
        //服务器显示输出连接上服务器的客户端IP
        sop("客户端" + ip + "正在连接...");
        /**
         * s.getInputStream()，获取服务器的客户端输入流(客户端发给服务器的，参考为服务器)
         * 创建输入流读指针new InputStreamReader(输入流对象)
         * 为输入流指针创建缓存区指针BufferedReader(输入流指针)
         * 综上所述：new BufferedReader(new InputStreamReader(输入流对象))
         *			 new BufferedWriter(new OutputStreamWriter(输出流对象))
         */
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        //注意：缓存区.readLine()操作，是以行结束标记为特点进行，但是返回结果省去了行结束标记
        while (null != (line = bufrIn.readLine())) {
            sop("客户端" + ip + "传送来的原始数据为：" + line);
            //将客户端发来的原始数据进行大写转换，但是缺少行结束标记
            bufwOut.write(line.toUpperCase());
            //利用缓存区写操作BufferedWriter.newLine()，补上行结束标记
            bufwOut.newLine();
            //BufferedWriter.write()操作，只是将数据写入缓存区，需要使用BufferedWriter.flush()将其写入输出流
            bufwOut.flush();
        }
        //关闭客户端对象
        sop("关闭客户端" + ip + "...");
        s.close();
        //关闭服务端对象，可选
        sop("关闭服务器" + ss.getInetAddress().getHostAddress() + "侦听端口" + ss.getLocalPort());
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

