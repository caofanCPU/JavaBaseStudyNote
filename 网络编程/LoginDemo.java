
import java.util.*;
import java.net.*;
import java.io.*;
class LoginDemo {
	public static void main(String[] args) {
		/**
		 * LoginDemo.java�ļ�������⣺
		 * ����ͻ��˲�����½����������½��ʽ�������û���������
		 * ���������ƿͻ�������½3�Σ���3���ڵ�½����ʾ�û���������������
		 * ��½3��ʧ�ܣ���ʾ"NND�뱩����½�������أ�"
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

class LoginServer {
	public static void main(String[] args) throws Exception {
		//����������ʱ�ͽ��û���-���룬��ֵ��ϵ�������ڴ�
		File loginText = new File("C:\\Users\\CY_XYZ\\Desktop\\D_PDD/LoginPassword.txt");
		BufferedReader bufr = new BufferedReader(new FileReader(loginText));
		String line = null;
		TreeMap<String, String> tm = new TreeMap<String, String>();
		while (null != (line = bufr.readLine())) {
			String[] loginStr = line.trim().split("��");
			String loginName = loginStr[0].trim().replaceAll("\\s+" ,"");
			String passWord = loginStr[1].trim();
			tm.put(loginName, passWord);
		}
		ServerSocket ss = new ServerSocket(13140);
		while (true) {
			Socket s = ss.accept();
			new Thread(new LoginThread(s, tm)).start();
		}
		//sop(tm);
	}

	public static void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.println(obj);
	}
}

class LoginThread implements Runnable {
	private Socket s;
	private TreeMap<String, String> tm = new TreeMap<String, String>();
	public LoginThread(Socket s, TreeMap<String, String> tm) {
		this.s = s;
		this.tm = tm;
	}
	public void run() {
		String ip = this.s.getInetAddress().getHostAddress();
		boolean flag = false;
		try {
			for (int i = 0; i < 3; i++) {
				BufferedReader bufrIn = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
				PrintWriter pwOut = new PrintWriter(this.s.getOutputStream(), true);
				String loginName = bufrIn.readLine();
				if (null == loginName) {
					sop("�ͻ���" + ip + "���Ե�½�������û���ʱ�쳣�˳�");
					break;
				}
				String loginPassword = bufrIn.readLine();
				if (null == loginPassword) {
					sop("�ͻ���" + ip + "���Ե�½����������ʱ�쳣�˳�");
					break;
				}
				for (Iterator<Map.Entry<String, String>> entry = this.tm.entrySet().iterator(); entry.hasNext(); ) {
					Map.Entry<String, String> me = entry.next();
					if (loginName.equals(me.getKey()) && loginPassword.equals(me.getValue())) {
						sop("�ͻ���"+ ip + "�û���" + me.getKey() + "�ѵ�½");
						pwOut.println(me.getKey() + "����ӭ��½��");
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				} else {
					sop("�ͻ���"+ ip + "���Ե�½");
					pwOut.println("�û���������������飡");
				}
			}
			this.s.close();	
		}
		catch(Exception e) {
			//������
			//��Ϊ�ܶ�ͻ��˶����ܳ����⣬������Բ�׽�쳣�����쳣�����������׳�RuntimeException�쳣
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
//-Xlint:unchecked
class LoginClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 13140);
		String loginName = null;
		String loginPassword = null;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//�����ı���ӡ�������һ��Ҫ�ǵã������Զ���ˢ��Ϊtrue
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		for (int i = 0; i < 3; i++) {
			/**
			 * Ϊ��ֹ�ͻ���ǿ���˳�������������������ǿ��û������ǿ�����ֿ�������������
			 */
			while (true) {
				sop("�������û�����");
				loginName = bufr.readLine();
				if (null == loginName) {
					//pwOut.println("");
					//loginName = "";
					break;
				}
				if (loginName.equals("")) {
					sop("�û�������Ϊ�գ�\n");
				} else {
					break;
				}
			}
			while (true) {
				sop("���������룺");
				loginPassword = bufr.readLine();
				if (null == loginPassword) {
					//pwOut.println("");
					//loginPassword = "";
					break;
				}
				if (loginPassword.equals("")) {
					sop("���벻��Ϊ�գ�\n");
				} else {
					break;
				}
			}
			pwOut.println(loginName);
			pwOut.println(loginPassword);
			/**
			 * ���ڿͻ�������������͵��������ı��ַ������������ʹ���ı���ӡ�����
			 */
			loginName = bufrIn.readLine();
			sop(loginName + "\n");
			if (loginName.contains("��ӭ")) {
				break;
			}
		}
		sop("�ͻ��������ر�");
		s.close();
	}

	public static void sop(Object obj) {
		/**
		 * ��ӡ�ַ���
		 * 
		 */
		System.out.print(obj);
	}
}