
//package A.B;
import java.io.*;
import java.net.*;
class TCPDemo {
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

class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 10003);
		//�����ͻ��˵�socket���񣬹��캯���а��˷�������IP�Ͷ˿�
		OutputStream out = s.getOutputStream();
		out.write("Hello��TCPServer!".getBytes());
		s.close();
	}
	
}

class TCPServer {
	public static void main(String[] args) throws Exception {
		sop("�ͻ���" + ip + "����������...");
		//���������socket���񣬲������ͻ��˵Ķ˿�
		ServerSocket ss = new ServerSocket(10003);
		//ͨ��.accept()������ȡ�ͻ���socket����
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		//��ȡ�ͻ��˷��͹���������
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		//.InputStream.read(byte[])�������������뻺���У����ض��뻺����ֽڳ���
		int len = in.read(buf);
		sop(new String(buf, 0, len));
		s.close();
	}
	
	public static void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.println(obj);
	}
}
