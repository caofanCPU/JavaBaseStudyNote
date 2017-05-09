
import java.net.*;
import java.io.*;
class UDPReceive {
	public static void main(String[] args) throws Exception {
		/**
		 * UDPReceive.java文件解决问题：
		 *		1.创建UDP服务，同时，监听应用端口，通过DatagramSocket(端口号)创建对象
		 *		2.创建接收的数据包对象，指定缓存区，通过DatagramPacket(byte[] buf, buf.length)
		 *		3.通过Socket接收服务，将得到的数据包，使用.receive()方法接收出去
		 *		4.根据需求，考虑是否关闭资源，.close()方法
		 */
		int sendPort = 12345;
		DatagramSocket ds = new DatagramSocket(sendPort);		//创建指向端口12345的套接字服务
		sop("正在进行端口" + sendPort + "侦听...");
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,
												   buf.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			//String(byte[], startIndex, length)，使用平台默认字符集解码字节数组，返回字符串
			String data = new String(dp.getData(),
									 0,
									 dp.getLength());
			sop("来自" + ip + "的信息：" + data);
		}
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
