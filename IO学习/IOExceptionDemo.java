
import java.io.*;
class IOExceptionDemo {
	public static void main(String[] args) {
		/**
		 * IOExceptionDemo.java文件解决问题：
		 * 练习IO常见Exception及处理方式
		 */
		FileWriter fw = null;
		try {
			/**
			 * 新建对某文件进行FileWriter操作，可能发生指定文件找不到异常
			 * 若指定文件不带绝对路径，则默认在当前目录下新建一个文件
			 * 向文件.write()操作，也可能出现异常
			 */
			//以向已存在的文件末尾追加字符内容，参数true
			fw = new FileWriter("Demo.txt", true);
			//以覆盖已存在文件内容的方式，若该文件不存在，则新建该文件
			//fw = new FileWriter("Demo.txt");
			fw.write("IO异常处理方式：见IOExceptionDemo.java代码");
		}
		catch(IOException ioe) {
			//待处理
			sop("Catch:" + ioe.toString());
		}
		
		/**
		 * 关闭流资源
		 * 在finally代码块中，继续try关闭流的操作，判断该流是否存在
		 * 流只有在存在的情况下，才可以进行关闭操作
		 */
		finally {
			try {
				if (null != fw) {
					fw.close();
				}
			}
			catch(IOException ioe) {
				//待处理
				sop("Catch:" + ioe.toString());
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
