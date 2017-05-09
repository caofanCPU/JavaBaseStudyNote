
import java.io.*;
class ReadJavaFile {
	public static void main(String[] args) {
		/**
		 * ReadJavaFile.java文件解决问题：
		 * 读取本代码文件，将其内容打印到控制台上
		 *                 同时复制到另外一个文件中
		 */
		//在try-catch代码块外部建立文件的读引用、写引用
		//在try-catch代码块内部初始化文件读引用、写引用
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("ReadJavaFile.java");
			fw = new FileWriter("ReadJavaFile.txt");
			/**
			 * 缓存区buf、缓存区读取到的字节长度len
			 * 不会发生异常，定义在try代码块内部，方便阅读，同时避免非必要的全局变量
			 */
			char[] buf = new char[1024];
			int len = 0;
			while (-1 != (len = fr.read(buf))) {
				fw.write(buf, 0, len);
				sop(new String(buf, 0, len));
			}
		}
		catch(IOException ioe) {
			//待处理
			sop("Catch:" + ioe.toString());
		}
		finally {
			/**
			 * 使用try-catch+判断指针不为空判断，关闭流资源
			 */
			try {
				if (null != fr) {
					fr.close();
				}
			}
			catch(IOException ioe) {
				//待处理
				sop("Catch:文件读取关闭异常" + ioe.toString());
			}
			try {
				if (null != fw) {
					fw.close();
				}
			}
			catch(IOException ioe) {
				//待处理
				sop("Catch:文件写入关闭异常" + ioe.toString());
			}
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
