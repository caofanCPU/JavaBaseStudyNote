
import java.net.*;
import java.io.*;
class TCPCopyText2 {
	public static void main(String[] args) {
		/**
		 * TCPCopyText2.java�ļ�������⣺
		 * ʹ��PrintWriter��+ʱ������������ɿͻ���TCP�ϴ��ͻ����ı��ļ�
		 * ���ļ����࣬�����ڵ�ǰĿ¼�µ�һ���ļ���
		 */
		File dir = new File(System.getProperty("user.dir") + File.separator + "TCP�ϴ��ļ�");
		if (!dir.exists()) {
			dir.mkdir();
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

class TCPCopyTextServer2 {
	public static void main(String[] args) throws Exception {
		//ָ���ļ��ϴ������ļ���
		/**
		 * �������ڱ�������ļ���Ŀ¼
		 * ��һ������Ŀ¼·�������ַ���padaDir
		 * �ڶ������½��ļ������жϸ��ļ����󲻴��ڣ����½�Ŀ¼
		 * ��������ֱ��ʹ��new File(paraDir, "�ļ���(����׺)")
		 */
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP�ϴ��ļ�";
		File fileDir = new File(paraDir);
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}
		File textFile = new File(paraDir, "TCPCopyText2.txt");
		ServerSocket ss = new ServerSocket(13013);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		sop("�ͻ���" + ip + "��������...");
		BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//���ı���ӡ������������д��������ı���ӡ������������������Ϊtrue���Զ�ˢ��
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
		PrintWriter pw = new PrintWriter(new FileWriter(textFile), true);
		/**
		 * ��ȡ�ͻ��˴��͵�ʱ�����ǣ���ȡ�ͻ����ϴ��ļ�����
		 *
		 */
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String timeStr = String.valueOf(dis.readLong());
		String line = null;
		int i = 1;
		while (null != (line = bufrIn.readLine())) {
			if (timeStr.equals(line)) {
				break;
			}
			//д��Ŀ���ַ����������з�
			pw.println("[" + i + "]   " + line);
			i++;
		}
		pwOut.println(textFile.getName() + "�ϴ��ɹ���");
		dis.close();
		pw.close();
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

class TCPCopyTextClient2 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 13013);
		File textFile = new File("TCPCopyText2.java");
		BufferedReader bufr = new BufferedReader(new FileReader(textFile));
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		long time = System.currentTimeMillis();
		//�ͻ������ȷ���ʱ������
		dos.writeLong(time);
		String line = null;
		while (null != (line = bufr.readLine())) {
			pwOut.println(line);
		}
		//�ٴη����ϴ�������ǣ�ʱ���
		pwOut.println(time);
		sop(bufrIn.readLine());
		dos.close();
		bufr.close();
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
