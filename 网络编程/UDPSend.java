
//package A.B;
import java.net.*;
import java.io.*;
/**
 * UDP发送端建立步骤：
 *		1.创建UDP服务，通过DatagramSocket()创建对象
 *		2.确定要发送的数据，封装为数据包，通过DatagramPacket(byte[] buf, buf.length)
 *		3.通过Socket服务，将封装好的数据包，使用.send()方法发送出去
 *		4.关闭资源，.close()方法
 */
class UDPSend {
	public static void main(String[] args) throws Exception {
		/**
		 * UDPSend.java文件解决问题：
		 * 练习在同一台单机，运行发送数据，接收数据
		 */
		DatagramSocket ds = new DatagramSocket();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while (null != (line = bufr.readLine())) {
			//对于基本数据类型，声明定义在循环内部或者外部，对于效率影响没多大区别
			byte[] buf = line.getBytes();
			//DatagramPacket(byte[], 封装长度, 目的IP地址(通过主机名获取IP地址), 目的端口号)
			DatagramPacket dp = new DatagramPacket(buf,
												   buf.length,
												   InetAddress.getByName("127.0.0.1"),
												   12345);
			ds.send(dp);
			if (line.equals("886")) {
				break;
			}
		}
		ds.close();
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
