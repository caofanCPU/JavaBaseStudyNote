
import java.net.*;
import java.io.*;
class TCPCopyPicture2 {
	public static void main(String[] args) {
		/**
		 * TCPCopyPicture2.java�ļ�������⣺
		 * ����ͻ��˴�ָ��Ŀ¼��ȡһ��ͼƬ�ļ����ϴ���������
		 * ��������ָ��Ŀ¼�洢�ļ������ļ�����ͬ����������ļ�������(����)���зǸ���ʽ���ֱ���
		 * �������յ�����ÿ���ͻ��˷���"�ϴ��ɹ�"
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

class PictureThread implements Runnable {
	private Socket s;
	private String paraDir;
	public PictureThread(Socket s, String paraDir) {
		this.s = s;
		this.paraDir = paraDir;
	}
	//ʵ��Runnable�ӿڣ�����run������������try-catch���������쳣
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		sop("�ͻ���" + ip + "��������...");
		int count = 1;
		try {
			/**
			 * ���ڷ��ı����ݣ�ʹ��������InputStream�������OutputStream���в���
			 */
			File pictureFile = new File(paraDir, "Beautiful.jpg");
			while (pictureFile.exists()) {
				pictureFile = new File(paraDir, "Beautiful(" + (count++) + ").jpg");
			}

			InputStream in = s.getInputStream();
			FileOutputStream fos = new FileOutputStream(pictureFile);
			byte[] buf = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(buf))) {
				fos.write(buf, 0, len);
			}
			OutputStream out = s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());
			fos.close();
			s.close();
		}
		catch(Exception e) {
			//������
			throw new RuntimeException("�ͻ���" + ip + "�ļ��ϴ�ʧ��");
		}
	}

	public static void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.println(obj);
	}
}

class TCPCopyPicServer2 {
	public static void main(String[] args) throws Exception {
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP�ϴ��ļ�";
		File fileDir = new File(paraDir);
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}
		ServerSocket ss = new ServerSocket(22222);
		while (true) {
			Socket s = ss.accept();
			new Thread(new PictureThread(s, paraDir)).start();
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
}

class TCPCopyPicClient2 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 22222);
		String fileStr = ("C:" + File.separator
						  + "Users" + File.separator
						  + "CY_XYZ" + File.separator
						  + "Desktop" + File.separator
						  + "D_PDD" + File.separator
						  + "��ԳPower+.jpg");
		File pictureFile = new File(fileStr);
		if (!pictureFile.exists()) {
			throw new RuntimeException("ͼƬ�ļ�·�������ڣ�");
		}
		FileInputStream fis = new FileInputStream(pictureFile);
		OutputStream out = s.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while (-1 != (len = fis.read(buf))) {
			out.write(buf, 0, len);
		}
		s.shutdownOutput();
		InputStream in = s.getInputStream();
		len = in.read(buf);
		sop(new String(buf, 0, len));
		fis.close();
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