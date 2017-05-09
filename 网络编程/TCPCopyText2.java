
import java.net.*;
import java.io.*;
class TCPCopyText2 {
	public static void main(String[] args) {
		/**
		 * TCPCopyText2.java文件解决问题：
		 * 使用PrintWriter流+时间戳结束标记完成客户端TCP上传客户端文本文件
		 * 本文件主类，创建在当前目录下的一个文件夹
		 */
		File dir = new File(System.getProperty("user.dir") + File.separator + "TCP上传文件");
		if (!dir.exists()) {
			dir.mkdir();
		}
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

class TCPCopyTextServer2 {
	public static void main(String[] args) throws Exception {
		//指定文件上传保存文件夹
		/**
		 * 创建用于保存后续文件的目录
		 * 第一步：将目录路径存入字符串padaDir
		 * 第二步：新建文件对象，判断该文件对象不存在，就新建目录
		 * 第三步：直接使用new File(paraDir, "文件名(带后缀)")
		 */
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP上传文件";
		File fileDir = new File(paraDir);
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}
		File textFile = new File(paraDir, "TCPCopyText2.txt");
		ServerSocket ss = new ServerSocket(13013);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		sop("客户端" + ip + "正在连接...");
		BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//用文本打印输出流替代缓存写输出流，文本打印输出流，构造参数设置为true，自动刷新
		PrintWriter pwOut = new PrintWriter(s.getOutputStream(), true);
		PrintWriter pw = new PrintWriter(new FileWriter(textFile), true);
		/**
		 * 获取客户端传送的时间戳标记，读取客户端上传文件数据
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
			//写入目的字符串，及换行符
			pw.println("[" + i + "]   " + line);
			i++;
		}
		pwOut.println(textFile.getName() + "上传成功！");
		dis.close();
		pw.close();
		s.close();
		ss.close();
	}

	public static void sop(Object obj) {
		/**
		 * 打印字符串
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
		//客户端首先发送时间戳标记
		dos.writeLong(time);
		String line = null;
		while (null != (line = bufr.readLine())) {
			pwOut.println(line);
		}
		//再次发送上传结束标记，时间戳
		pwOut.println(time);
		sop(bufrIn.readLine());
		dos.close();
		bufr.close();
		s.close();
	}

	public static void sop(Object obj) {
		/**
		 * 打印字符串
		 * 
		 */
		System.out.println(obj);
	}
}
