
//package A.B;
import java.net.*;
import java.io.*;
class ChatQQ {
	public static void main(String[] args) throws Exception {
		/**
		 * ChatQQ.java�ļ�������⣺
		 * ģ��QQ������ͨ�Ź���
		 */
		int port = 13140;
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receiveSocket = new DatagramSocket(port);
		new Thread(new ChatSend(sendSocket, port)).start();
		new Thread(new ChatReceive(receiveSocket)).start();
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

class ChatSend implements Runnable {
	private DatagramSocket ds;
	private int port;
	public ChatSend(DatagramSocket ds, int port) {
		this.ds = ds;
		this.port = port;
	}
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			sop("����˵�Ի�(��������)��");
			String line = null;
			while (null != (line = bufr.readLine())) {
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,
													   buf.length,
													   InetAddress.getByName("127.0.0.1"),
													   port);
			ds.send(dp);
			}
		}
		catch(Exception e) {
			//������
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}

	public void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.print(obj);
	}
	
}

class ChatReceive implements Runnable {
	private DatagramSocket ds;
	public ChatReceive(DatagramSocket ds) {
		this.ds = ds;
	}
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,
													   buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),
										 0,
										 dp.getLength());
				sop("����" + ip + "����Ϣ��" + data);
			}
		}
		catch(Exception e) {
			//������
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}
	
	public void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.println(obj);
	}
}