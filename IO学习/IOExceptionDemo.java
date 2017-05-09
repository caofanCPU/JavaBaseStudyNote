
import java.io.*;
class IOExceptionDemo {
	public static void main(String[] args) {
		/**
		 * IOExceptionDemo.java�ļ�������⣺
		 * ��ϰIO����Exception������ʽ
		 */
		FileWriter fw = null;
		try {
			/**
			 * �½���ĳ�ļ�����FileWriter���������ܷ���ָ���ļ��Ҳ����쳣
			 * ��ָ���ļ���������·������Ĭ���ڵ�ǰĿ¼���½�һ���ļ�
			 * ���ļ�.write()������Ҳ���ܳ����쳣
			 */
			//�����Ѵ��ڵ��ļ�ĩβ׷���ַ����ݣ�����true
			fw = new FileWriter("Demo.txt", true);
			//�Ը����Ѵ����ļ����ݵķ�ʽ�������ļ������ڣ����½����ļ�
			//fw = new FileWriter("Demo.txt");
			fw.write("IO�쳣����ʽ����IOExceptionDemo.java����");
		}
		catch(IOException ioe) {
			//������
			sop("Catch:" + ioe.toString());
		}
		
		/**
		 * �ر�����Դ
		 * ��finally������У�����try�ر����Ĳ������жϸ����Ƿ����
		 * ��ֻ���ڴ��ڵ�����£��ſ��Խ��йرղ���
		 */
		finally {
			try {
				if (null != fw) {
					fw.close();
				}
			}
			catch(IOException ioe) {
				//������
				sop("Catch:" + ioe.toString());
			}
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
