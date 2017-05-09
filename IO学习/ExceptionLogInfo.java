
import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionLogInfo {
	public static void main(String[] args) {
		/**
		 * ExceptionLogInfo.java文件解决问题：
		 * 将程序运行的异常信息保存到指定文件中，并附带捕获异常时的时间
		 */
		//改变默认输出流，将JVM运行时的系统信息写入指定文件中
		
		try {
			Properties prop = System.getProperties();
			prop.list(new PrintStream("SystemInfo.txt"));
		}
		catch(IOException ioe) {
			//待处理
			sop("Catch:" + ioe.toString());
		}
		

		//创造异常，将异常信息写入指定文件
		try {
			int[] arr = new int[2];
			sop(arr[3]);
		}
		catch(Exception e) {
			//待处理
			try {
				String dateFormat1 = "yyyy-MM-dd hh:mm:ss";
				String dateFormat2 = "yyyy-mm-dd hh:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat1);
				//获取指定时间格式的异常捕获时间
				String timeStr = sdf.format(new Date());
				//通过创建目的输出流，指向日志文件
				PrintStream ps = new PrintStream("Exception.log");
				//将异常捕获时间写入日志文件
				ps.println(timeStr);
				//将出现在控制台的异常信息写入指定文件，输出流重定向
				System.setOut(ps);
			}
			catch(IOException ioe) {
				//待处理
				throw new RuntimeException("日志文件创建失败！");
			}
			e.printStackTrace(System.out);
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
