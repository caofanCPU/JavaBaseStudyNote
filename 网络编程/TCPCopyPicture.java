
import java.net.*;
import java.io.*;
class TCPCopyPicture {
	public static void main(String[] args) {
		/**
		 * TCPCopyPicture.java�ļ�������⣺
		 * �ͻ��˴�ָ��Ŀ¼��ȡһ��ͼƬ�ļ����ϴ���������
		 * �������յ�����ͻ��˷���"�ϴ��ɹ�"
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

class TCPCopyPicServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(22222);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		sop("�ͻ���" + ip + "��������...");
		/**
		 * ���ڷ��ı����ݣ�ʹ��������InputStream�������OutputStream���в���
		 */
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP�ϴ��ļ�";
		File fileDir = new File(paraDir);
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}
		File pictureFile = new File(paraDir, "Beautiful.jpg");
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
		ss.close();
	}

	public static void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.println(obj);
	}
}

class TCPCopyPicClient {
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