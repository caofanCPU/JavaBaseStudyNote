
import java.io.*;
class BufferedDemo {
	public static void main(String[] args) {
		/**
		 * BufferedDemo.java�ļ�������⣺
		 * ͨ��������д���ı�����
		 * ͨ�����������������ļ����Ƶ�����һ���ļ��У������к�
		 * ͨ�����������������ļ���ӡ������̨�ϣ������к�
		 */
		//bufferedWriterMain();
		bufferedReaderMain();
	}
	
	public static void bufferedWriterMain() {
		BufferedWriter bufw = null;
		try {
			/**
			 * BufferedWriter��BufferedReader��Ҫ��������������д������
			 * ������ʹ�ã�BufferedWriter bufw = new BufferedWriter(new FileWriter("�ļ���"));
			 *			   BufferedReader bufr = new BufferedReader(new FileReader("�ļ���"))
			 * ԭ�����ڣ�Buffered��д����װ��File��д�ķ������ر�Buffered��дʵ���Ͼ��ǹر�File��д
			 */
			bufw = new BufferedWriter(new FileWriter("Buf.txt"));
			bufw.write("abcde");
			bufw.newLine();
			bufw.write("ABCDE");
			//ˢ��д���������൱��"��"��
			bufw.flush();
		}
		catch(IOException ioe) {
			//������
			sop("Catch:" + ioe.toString());
		}
		finally {
			try {
				if (null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				//������
				sop("Catch:�ļ�д��ر�ʧ�ܣ�" + ioe.toString());
			}
		}
	}

	public static void bufferedReaderMain() {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try {
			bufr = new BufferedReader(new FileReader("BufferedDemo.java"));
			bufw = new BufferedWriter(new FileWriter("BUfferedDemo.txt"));
			String line = null;
			int i = 1;
			while (null != (line = bufr.readLine())) {
				bufw.write("[" + i + "]    " + line);
				bufw.newLine();
				bufw.flush();
				sop("[" + i + "]    " + line);
				i++;
			}
		}
		catch(IOException ioe) {
			//������
			sop("Catch:" + ioe.toString());
		}
		finally {
			try {
				if (null != bufr) {
					bufr.close();
				}
			}
			catch(IOException ioe) {
				//������
				sop("Catch:�ļ���ȡ�ر�ʧ�ܣ�" + ioe.toString());
			}

			try {
				if (null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				//������
				sop("Catch�ļ�д��ر�ʧ�ܣ�" + ioe.toString());
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
