
//package A.B;
import java.net.*;
import java.io.*;
/**
 * UDP���Ͷ˽������裺
 *		1.����UDP����ͨ��DatagramSocket()��������
 *		2.ȷ��Ҫ���͵����ݣ���װΪ���ݰ���ͨ��DatagramPacket(byte[] buf, buf.length)
 *		3.ͨ��Socket���񣬽���װ�õ����ݰ���ʹ��.send()�������ͳ�ȥ
 *		4.�ر���Դ��.close()����
 */
class UDPSend {
	public static void main(String[] args) throws Exception {
		/**
		 * UDPSend.java�ļ�������⣺
		 * ��ϰ��ͬһ̨���������з������ݣ���������
		 */
		DatagramSocket ds = new DatagramSocket();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while (null != (line = bufr.readLine())) {
			//���ڻ����������ͣ�����������ѭ���ڲ������ⲿ������Ч��Ӱ��û�������
			byte[] buf = line.getBytes();
			//DatagramPacket(byte[], ��װ����, Ŀ��IP��ַ(ͨ����������ȡIP��ַ), Ŀ�Ķ˿ں�)
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
