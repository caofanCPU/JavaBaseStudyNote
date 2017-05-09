
import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionLogInfo {
	public static void main(String[] args) {
		/**
		 * ExceptionLogInfo.java�ļ�������⣺
		 * ���������е��쳣��Ϣ���浽ָ���ļ��У������������쳣ʱ��ʱ��
		 */
		//�ı�Ĭ�����������JVM����ʱ��ϵͳ��Ϣд��ָ���ļ���
		
		try {
			Properties prop = System.getProperties();
			prop.list(new PrintStream("SystemInfo.txt"));
		}
		catch(IOException ioe) {
			//������
			sop("Catch:" + ioe.toString());
		}
		

		//�����쳣�����쳣��Ϣд��ָ���ļ�
		try {
			int[] arr = new int[2];
			sop(arr[3]);
		}
		catch(Exception e) {
			//������
			try {
				String dateFormat1 = "yyyy-MM-dd hh:mm:ss";
				String dateFormat2 = "yyyy-mm-dd hh:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat1);
				//��ȡָ��ʱ���ʽ���쳣����ʱ��
				String timeStr = sdf.format(new Date());
				//ͨ������Ŀ���������ָ����־�ļ�
				PrintStream ps = new PrintStream("Exception.log");
				//���쳣����ʱ��д����־�ļ�
				ps.println(timeStr);
				//�������ڿ���̨���쳣��Ϣд��ָ���ļ���������ض���
				System.setOut(ps);
			}
			catch(IOException ioe) {
				//������
				throw new RuntimeException("��־�ļ�����ʧ�ܣ�");
			}
			e.printStackTrace(System.out);
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
