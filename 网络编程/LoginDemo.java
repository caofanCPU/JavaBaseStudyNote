
import java.util.*;
import java.net.*;
import java.io.*;
class LoginDemo {
	public static void main(String[] args) {
		/**
		 * LoginDemo.java文件解决问题：
		 * 多个客户端并发登陆服务器，登陆方式，输入用户名、密码
		 * 服务器限制客户端最多登陆3次，在3次内登陆，提示用户名错误或密码错误
		 * 登陆3次失败，提示"NND想暴力登陆吗，摸门特！"
		 */
		
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

class LoginServer {
	public static void main(String[] args) throws Exception {
		//服务器加载时就将用户名-密码，键值关系加载入内存
		File loginText = new File("C:\\Users\\CY_XYZ\\Desktop\\D_PDD/LoginPassword.txt");
		BufferedReader bufr = new BufferedReader(new FileReader(loginText));
		String line = null;
		TreeMap<String, String> tm = new TreeMap<String, String>();
		while (null != (line = bufr.readLine())) {
			String[] loginStr = line.trim().split("，");
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
		 * 打印字符串
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
					sop("客户端" + ip + "尝试登陆，输入用户名时异常退出");
					break;
				}
				String loginPassword = bufrIn.readLine();
				if (null == loginPassword) {
					sop("客户端" + ip + "尝试登陆，输入密码时异常退出");
					break;
				}
				for (Iterator<Map.Entry<String, String>> entry = this.tm.entrySet().iterator(); entry.hasNext(); ) {
					Map.Entry<String, String> me = entry.next();
					if (loginName.equals(me.getKey()) && loginPassword.equals(me.getValue())) {
						sop("客户端"+ ip + "用户：" + me.getKey() + "已登陆");
						pwOut.println(me.getKey() + "，欢迎登陆！");
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				} else {
					sop("客户端"+ ip + "尝试登陆");
					pwOut.println("用户名或密码错误，请检查！");
				}
			}
			this.s.close();	
		}
		catch(Exception e) {
			//待处理
			//因为很多客户端都可能出问题，这里可以捕捉异常处理异常，但绝不能抛出RuntimeException异常
		}
	}
	public void sop(Object obj) {
		/**
		 * 打印字符串
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
		//对于文本打印输出流，一定要记得，设置自动行刷新为true
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		for (int i = 0; i < 3; i++) {
			/**
			 * 为防止客户端强制退出引起服务器崩溃，将非空用户名、非空密码分开发送至服务器
			 */
			while (true) {
				sop("请输入用户名：");
				loginName = bufr.readLine();
				if (null == loginName) {
					//pwOut.println("");
					//loginName = "";
					break;
				}
				if (loginName.equals("")) {
					sop("用户名不可为空！\n");
				} else {
					break;
				}
			}
			while (true) {
				sop("请输入密码：");
				loginPassword = bufr.readLine();
				if (null == loginPassword) {
					//pwOut.println("");
					//loginPassword = "";
					break;
				}
				if (loginPassword.equals("")) {
					sop("密码不可为空！\n");
				} else {
					break;
				}
			}
			pwOut.println(loginName);
			pwOut.println(loginPassword);
			/**
			 * 由于客户端向服务器发送的内容是文本字符串，因而考虑使用文本打印输出流
			 */
			loginName = bufrIn.readLine();
			sop(loginName + "\n");
			if (loginName.contains("欢迎")) {
				break;
			}
		}
		sop("客户端正常关闭");
		s.close();
	}

	public static void sop(Object obj) {
		/**
		 * 打印字符串
		 * 
		 */
		System.out.print(obj);
	}
}