
//package A.B;
import java.util.*;
import java.io.*;
class FileContentCompare {
	public static void main(String[] args) {
		/**
		 * FileContentCompare.java�������
		 *
		 */
		
		//�ڵ�ǰĿ¼�£��½�1����Ŀ¼"�ļ����ݱȽ�"
		//sop(System.getProperty("user.dir"));
		String paraDirName = System.getProperty("user.dir") + File.separator + "�ļ����ݱȽ�";
		//���������ļ���
		String[] fileNameArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							      "key_value_BothNot.txt"};

		File paraDir = new File(paraDirName);

		createParaDir(paraDir);
		String fileNameA = "�ļ�A.txt";
		String fileNameB = "�ļ�B.txt";
		File fileA = createFile(paraDir, fileNameA);
		File fileB = createFile(paraDir, fileNameB);
		//����ָ��·�����ļ�A���ļ�B
		new MakeKeyValueFile(fileA, 100000);
		new MakeKeyValueFile(fileB, 100000);


		File fileARegular = new FileAnalysis(fileA).getResultFile();
		File fileBRegular = new FileAnalysis(fileB).getResultFile();

		/**
		File fileARegular = new File(paraDir, "�ļ�A_����ƥ�䴦���.txt");
		File fileBRegular = new File(paraDir, "�ļ�B_����ƥ�䴦���.txt");
		 */
		//��ȡ�ļ�A���ļ�B��TreeMap��ֵ�洢��ͼ
		TreeMap<String, String> tmA = new TreeMap<String, String>();
		TreeMap<String, String> tmB = new TreeMap<String, String>();
		tmA = new KeyValue(fileARegular).getTreeMap();
		//tmB = tmA;
		tmB = new KeyValue(fileBRegular).getTreeMap();
		keyValueCompare(tmA, tmB, fileNameArray, paraDir);
		/**
		 * ����tmA�Ƿ�Ϊָ����TreeMap������ͼ*/
/*		int i = 1;
		for (Iterator<Map.Entry<String, String>> entry = tmA.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<String, String> me = entry.next();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� = " + me.getKey() + ", ֵ = " + me.getValue());
		}
*/
	}

	/**
	 * keyValueCompare�����������ļ�A���ļ�B�еļ�ֵ���бȽϣ��������д��ָ���ļ�
	 * tmA���ļ�A�ļ�ֵTreeMap��ͼ��tmB���ļ�B�ļ�ֵTreeMap��ͼ
	 * fileNameArrayΪ�ַ������飬���汣����4���ļ����ļ���(����չ��)
	 * paraDirΪ�ļ�����������ָ��Ŀ¼�½��ȽϽ��д������4���ļ�
	 */

	public static void keyValueCompare(TreeMap<String, String> tmA, TreeMap<String, String> tmB,
									   String[] fileNameArray, File paraDir) {
		StringBuilder sb0 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> entryA = tmA.entrySet().iterator();
			 entryA.hasNext(); ) {
			Map.Entry<String, String> meA = entryA.next();
			String aKey = meA.getKey();
			String aValue = meA.getValue();
			if (tmB.containsKey(aKey)) {
				String bValue = tmB.get(aKey);
				//�ж������ַ����Ƿ���ȣ���if (strA.equals(strB))����if (0 == strA.compareTo(strB))
				if (aValue.equals(bValue)) {
					sb0.append("��ֵ��ͬ��" + "<�� = " + aKey + ", ֵ = " + aValue + ">\r\n");
				} else {
					sb1.append("��ֵͬ��ͬ��" + "<�� = " + aKey
							   + ", �ļ�Aֵ = " + aValue + "    |�ļ�Bֵ = " + bValue + ">\r\n");
				}
				
			} else {
				sb2.append("�ļ�A���ļ�B��ֵ����ͬ��" + "�ļ�A<�� = " + aKey + ", ֵ = " + aValue + ">\r\n");
			}
		}
		writeResult2File(paraDir, fileNameArray[0], sb0);
		writeResult2File(paraDir, fileNameArray[1], sb1);
		writeResult2File(paraDir, fileNameArray[2], sb2);
	}

	public static void writeResult2File(File paraDir, String fileName, StringBuilder sb) {
		File resultFile = new File(paraDir, fileName);
		if (!resultFile.exists()) {
			try {
				resultFile.createNewFile();
			}
			catch(IOException ioe) {
				//������
				throw new RuntimeException("Ŀ���ļ��������Ҵ���ʧ�ܣ�");
			}
		}
		BufferedWriter bufw = null;
		try {
			//�������䶼���ܲ����쳣
			bufw = new BufferedWriter(new FileWriter(resultFile));
			bufw.write(sb.toString());
		}
		catch(IOException ioe) {
			//������
			throw new RuntimeException("Ŀ���ļ�д��ʧ�ܣ�");
		}
		finally {
			try {
				if (null != bufw) {
					bufw.close();	
				}
			}
			catch(IOException ioe) {
				//������
				throw new RuntimeException("Ŀ���ļ�д��ر�ʧ�ܣ�");
			}
		}
		
	}

	public static void createParaDir(File paraDir) {
		if (!paraDir.exists()) {
			//�����Ŀ¼�����ڣ��򴴽���Ŀ¼����Ҫ����IOException
			try {
				paraDir.mkdir();
			}
			catch(SecurityException se) {
				//������
				sop(se.toString() + "\n\"" + paraDir.getAbsolutePath() + "\"Ŀ¼����ʧ��");
			}
		}
	}
	
	public static File createFile(File paraDir, String fileName) {
		File newFile = new File(paraDir, fileName);
		if (!newFile.exists()) {
			try {
				newFile.createNewFile();
			}
			catch(IOException ioe) {
				//������
				sop(ioe.toString() + "\n\"" + newFile.getAbsolutePath() + "\"�ļ�����ʧ��");
			}
		}
		return newFile;
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
