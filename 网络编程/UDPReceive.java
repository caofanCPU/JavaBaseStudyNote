
import java.net.*;
import java.io.*;
class UDPReceive {
	public static void main(String[] args) throws Exception {
		/**
		 * UDPReceive.java�ļ�������⣺
		 *		1.����UDP����ͬʱ������Ӧ�ö˿ڣ�ͨ��DatagramSocket(�˿ں�)��������
		 *		2.�������յ����ݰ�����ָ����������ͨ��DatagramPacket(byte[] buf, buf.length)
		 *		3.ͨ��Socket���շ��񣬽��õ������ݰ���ʹ��.receive()�������ճ�ȥ
		 *		4.�������󣬿����Ƿ�ر���Դ��.close()����
		 */
		int sendPort = 12345;
		DatagramSocket ds = new DatagramSocket(sendPort);		//����ָ��˿�12345���׽��ַ���
		sop("���ڽ��ж˿�" + sendPort + "����...");
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,
												   buf.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			//String(byte[], startIndex, length)��ʹ��ƽ̨Ĭ���ַ��������ֽ����飬�����ַ���
			String data = new String(dp.getData(),
									 0,
									 dp.getLength());
			sop("����" + ip + "����Ϣ��" + data);
		}
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
