
import java.net.*;
import java.io.*;
class TCPCopyPicture {
	public static void main(String[] args) {
		/**
		 * TCPCopyPicture.java文件解决问题：
		 * 客户端从指定目录读取一个图片文件，上传至服务器
		 * 服务器收到后，向客户端返回"上传成功"
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

class TCPCopyPicServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(22222);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		sop("客户端" + ip + "正在连接...");
		/**
		 * 对于非文本数据，使用输入流InputStream、输出流OutputStream进行操作
		 */
		String paraDir = System.getProperty("user.dir") + File.separator + "TCP上传文件";
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
		out.write("上传成功".getBytes());
		fos.close();
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

class TCPCopyPicClient {
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