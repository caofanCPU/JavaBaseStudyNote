
import java.net.*;
import java.io.*;
class TCPCopyPicture2 {
	public static void main(String[] args) {
		/**
		 * TCPCopyPicture2.java文件解决问题：
		 * 多个客户端从指定目录读取一个图片文件，上传至服务器
		 * 服务器在指定目录存储文件，若文件名相同，则后来的文件名加上(数字)进行非覆盖式区分保存
		 * 服务器收到后，向每个客户端返回"上传成功"
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

class PictureThread implements Runnable {
	private Socket s;
	private String paraDir;
	public PictureThread(Socket s, String paraDir) {
		this.s = s;
		this.paraDir = paraDir;
	}
	//实现Runnable接口，覆盖run方法，都必须try-catch，不能抛异常
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		sop("客户端" + ip + "正在连接...");
		int count = 1;
		try {
			/**
			 * 对于非文本数据，使用输入流InputStream、输出流OutputStream进行操作
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
			out.write("上传成功".getBytes());
			fos.close();
			s.close();
		}
		catch(Exception e) {
			//待处理
			throw new RuntimeException("客户端" + ip + "文件上传失败");
		}
	}

	public static void sop(Object obj) {
		/**
		 * 打印字符串
		 * 
		 */
		System.out.println(obj);
	}
}

class TCPCopyPicServer2 {
	public static void main(String[] args) throws Exception {
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP上传文件";
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
		 * 打印字符串
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
						  + "码猿Power+.jpg");
		File pictureFile = new File(fileStr);
		if (!pictureFile.exists()) {
			throw new RuntimeException("图片文件路径不存在！");
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
		 * 打印字符串
		 * 
		 */
		System.out.println(obj);
	}
}