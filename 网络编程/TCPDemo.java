
//package A.B;
import java.io.*;
import java.net.*;
class TCPDemo {
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

class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 10003);
		//创建客户端的socket服务，构造函数中绑定了服务器的IP和端口
		OutputStream out = s.getOutputStream();
		out.write("Hello，TCPServer!".getBytes());
		s.close();
	}
	
}

class TCPServer {
	public static void main(String[] args) throws Exception {
		sop("客户端" + ip + "正在连接中...");
		//建立服务端socket服务，并监听客户端的端口
		ServerSocket ss = new ServerSocket(10003);
		//通过.accept()方法获取客户端socket对象
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		//获取客户端发送过来的数据
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		//.InputStream.read(byte[])，将输入流读入缓存中，返回读入缓存的字节长度
		int len = in.read(buf);
		sop(new String(buf, 0, len));
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
