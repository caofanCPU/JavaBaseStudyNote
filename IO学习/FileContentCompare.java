
import java.util.*;
import java.io.*;
import java.lang.Math;
class FileContentCompare {
	public static void main(String[] args) {
		/**
		 * FileContentCompare.java�������
		 *
		 */
		
		//��֤������������ļ�A���ļ�B���ڸ�Ŀ¼Ψһ����
		String paraDirName = "C:" + File.separator
							 + "Users" + File.separator
							 + "CY_XYZ" + File.separator
							 + "Desktop" + File.separator
							 + "D_PDD" + File.separator
							 + "�ļ����ݱȽ�";
		//���������ļ���
		String[] fileNameArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							      "key_value_BothNot.txt"};

		File paraDir = new File(paraDirName);
/*
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
*/
		File fileARegular = new File(paraDir, "�ļ�A_����ƥ�䴦���.txt");
		File fileBRegular = new File(paraDir, "�ļ�B_����ƥ�䴦���.txt");
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

/**
 * MakeKeyValueFile�࣬���ڸ�ָ���ļ��������ָ���������ַ����ı�
 * ÿ���ı���������ģʽ��[���]���ɸ����ַ�[K�ַ���1��v�ַ���2]���ɸ����ַ��س����з�
 * �����ַ���1ǰ����Ψһ���'K'��'��'�޶����ò��ִ����������
 *	   �ַ���2ǰ��Ψһ�ַ�'v'�޶����ַ���2ȫ�����ַ��������ķ������ַ��䵱���޶���
 * java����������3�ַ�ʽ��int[] a = new int[] {1,2,3};
 *						  int[] a = new int[5];
 *						  int[] a = {1, -3, 0, 2};
 */

class MakeKeyValueFile {
	private File file = null;
	private int FILE_LINES = 50;
	private char[] firstName = null;
	private char[] secondName = null;
	private char[] lastName = null;
	private ArrayList<String> keyList = new ArrayList<String>();
	private ArrayList<String> valueList = new ArrayList<String>();
	private ArrayList<String> noiseList = new ArrayList<String>();
	public MakeKeyValueFile() {}
	/**
	 * MakeKeyValueFile���캯��������fileΪ��Ҫ�������ݵ��ļ�����
	 *							 ����fileLinesΪ���ļ��Ĵ�����������
	 * ��ȡ�ļ������ļ�������
	 * ����firstNameѡȡ�գ�sencondName��lastName��ȡ���֣�ִ�������ȡ����.keyName()
	 *													   ִ�������ȡIDֵ.valueNumber()
	 * noiseStringΪ�����ַ�����Ŀ�ģ��ڼ�[Kk]������ֵ[Vv]ID���˲���
	 *
	 */
	public MakeKeyValueFile(File file, int fileLines) {
		if (null == file) {
			throw new RuntimeException("�ļ�����Ϊ�գ�����ʧ��");
		}
		if (!file.exists()) {
			throw new RuntimeException("�ļ������ڣ�����ʧ��");
		}
		if (!file.isFile()) {
			throw new RuntimeException("д���������Ӧ�����ļ�������Ŀ¼��");
		}
		this.file = file;
		if (fileLines > 0) {	//���������������ֵС��0������Ĭ��50��ִ��
			this.FILE_LINES = fileLines;
		}
		//���ֵ���Ͽ��ܣ�20 * 20 * 20 = 8000��
		firstName =  new char[] {'��', 'Ǯ', '��', '��',
								 '��', '��', '֣', '��',
								 '��', '��', 'л', '��',
								 '��', '��', '��', '��',
								 '��', '��', '��', '��'};
		secondName = new char[] {  32, '��', '��',   32,
								 '��', '��', '��', '��',
								 '��', '��', '��', '��',
							       32, '��', 'ʤ', '��',
								 '��', '��', '��', 'Ʒ'};
		lastName =   new char[] {'��', '��', '��', 'Ȼ',
								 '��', '��', 'ǫ', '��',
								 '��', '��', 'ޱ', '��',
								 '��', '��', '��', '��',
								 'ǿ', '��', '��', '��'};
		this.keyName();
		this.valueNumber();
		this.noiseString();
		this.addKeyValue();
		
	}

	public File getFile() {
		return this.file;
	}
	
	/**
	 * �������ģʽ�µģ���[Kk]�������ַ���
	 */
	public void keyName() {
		String key = "";
		char[] ch = new char[]{'A', 32, 'G'};
		int[] num = {0, 0, 0};
		for (int j = 0; j < FILE_LINES; j++) {
			for (int i = 0; i < 3; i++) {
				num[i] = (int)(Math.random() * 20);		//�������������ʹ��(int)ǿ��ת��
			}
			ch[0] = this.firstName[num[0]];
			ch[1] = this.secondName[num[1]];
			ch[2] = this.lastName[num[2]];
			key = "��K" + String.valueOf(ch).replaceAll(" ", "  ");		//�������ո��滻Ϊ�����ո�
			this.keyList.add(key);						  //ʹ��ArrayList��ȡ��FILE_LINES  ��K����
		}
	}

	/**
	 * �������ģʽ�£�ֵ[Vv]ID���ַ���
	 * �ٶ�IDΪ8λ���֣�����20��ʼ
	 */

	public void valueNumber() {
		int[] id = {2, 0, 1, 7,
					0, 0, 0, 0};

		//int[] id = {2, 0, 0};		//��Ϊ������1000�ֿ���
		String value = null;
		for (int i = 0; i < FILE_LINES; i++) {
			//ÿ�γ�ʼ��value = "" + id[0]
			value = "" + id[0] + id[1];
			for (int j = 2; j < id.length; j++) {
				id[j] = (int)(Math.random() * 10);
				value += id[j];
			}
			//ע�⣺�����ַ�'ֵ'��Unicode����Ϊ\u503C���ڽ�������ƥ��ʱ���õ�
			this.valueList.add("ֵv" + value);
		}
	}

	/**
	 * �������ģʽ�£������ַ�����ΧΪ���ɼ�ASCII�ַ�(�޳�K��k��V��v)�ͺ����ַ�
	 * ����ASCII�ַ���33-126(�޳�'k' 'K' 'v' 'V')��ע������
	 * �ɿ���ʹ��StringBulider������(List��Set��Map)��������
	 */
	
	public void noiseString() {
		String noiseStr = "";
		char[] chAsc = new char[8];
		char[] chChinese = new char[8];
		for (int i = 0; i < FILE_LINES * 2; i++) {
			for (int k = 0; k < chChinese.length; k++) {
				chChinese[k] = (char)(0x4e00+(int)(Math.random()*(0x9fa5-0x4e00+1)));
			}
			for (int j = 0; j < chAsc.length; j++) {
				chAsc[j] = (char)(0x21 + (int)(Math.random() * (0x7E-0x20)));
				//���ؼ��ַ�k��K��v��V�滻Ϊ�ո�
				if ('k' == chAsc[j] || 'K' == chAsc[j] || 'v' == chAsc[j] || 'V' == chAsc[j]) {
					chAsc[j] = ' ';
				}
			}
			//���뱣֤������ǰ��Ӣ���ַ��ں������IDֵ�Ľ�������ƫ��
			noiseStr = String.valueOf(chChinese) + String.valueOf(chAsc);
			this.noiseList.add(noiseStr);
		}
		
	}

	public void addKeyValue() {
		if (null == this.file) {
			throw new RuntimeException("�ļ�����Ϊ�գ�����ʧ��");
		}
		if (!this.file.exists()) {
			throw new RuntimeException("�ļ������ڣ�����ʧ��");
		}
		if (!this.file.isFile()) {
			throw new RuntimeException("д���������Ӧ�����ļ�������Ŀ¼��");
		}
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(this.file));
			int i = 0;
			while (i < FILE_LINES) {
				bufw.write("[" + (i+1) + "]"				//�к�
						   + this.noiseList.get(2*i)		//�����ַ���
						   + this.keyList.get(i)			//������ʶ�������ַ���
						   + "��"							//����ֵ��Ψһ�ָ�������"��"
						   + this.valueList.get(i)			//��ֵ��ʶ��ID���ִ�	
						   + this.noiseList.get(2*i+1)		//�����ַ���
						   + "\r\n");						//���лس�
				bufw.flush();
				i++;
			}
			
		}
		catch(IOException ioe) {
			throw new RuntimeException(ioe.toString() + "\n�ļ���\""
									   +this.file.getAbsolutePath() + "\"д��ʧ�ܣ�");
		}
		finally {
			try {
				if(null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException(ioe.toString() + "\n�ļ���\""
									   +this.file.getAbsolutePath() + "\"д��ر�ʧ�ܣ�");
			}
		}
		System.out.println("Successful!�ļ���\"" + this.file.getAbsolutePath() + "\"���ݴ����ɹ�");
	}	
}

/**
 * FileAnalysis�࣬�Դ�����ı����ļ���������ƥ������
 */
class FileAnalysis {
	private File analysisFile = null;
	private File resultFile = null;
	//private String[] keyValue = null;
	public FileAnalysis() {}
	public FileAnalysis(File file) {
		if (!file.exists()) {
			throw new RuntimeException("�ļ���\"" + file.getAbsolutePath() + "\"������");
		}
		if (!file.isFile()) {
			throw new RuntimeException("\"" + file.getAbsolutePath() + "�����ļ�������Ŀ¼��");
		}
		if (0 == file.length()) {
			throw new RuntimeException("�ļ�\"" + file.getAbsolutePath() + "\"����Ϊ�գ�");
		}
		this.analysisFile = file;
		this.createResultFile();
		this.analysis();
	}

	public File getResultFile() {
		return this.resultFile;
	}

	/**
	 * ����Ҫ����ƥ��������ļ�ͬĿ¼�£�����һ������ͬ�������ļ�
	 * ���ǵ�����Ŀ�ģ�����ļ�A���ļ�B��ͬ�ļ�ֵ����ֵͬ��ͬ��ֵͬ����ͬ����ֵ����ͬ
	 * ����ڴ˴�һ���������ĸ��ļ�key_value_AllSame.txt��keySame_valueNot.txt
	 *							   valueSame_keyNot.txt��key_value_BothNot.txt
	 */
	public void createResultFile() {
		//��ȡԴ�ļ��ĸ�Ŀ¼��Դ�ļ���
		File paraDir = this.analysisFile.getParentFile();
		String newFileName = this.analysisFile.getName();
		//ʹ��������ʽ�����ַ�'.'�ָ��ļ���(����׺��)��ע�⣺�ַ�'.'��������ʽΪ"\\."
		String[] nameStr = newFileName.split("\\.");
		//sop(nameStr.length);
		//�ָ�����һ���ַ��������ļ���׺������ô�ڵ����ڶ����ַ���ĩβ��ӱ���ַ���
		//ͬʱע�⣺�����ַ�'.'�ָ��ַ������ļ���׺��ǰ���'.'�ѱ�ȥ�����������ַ���ĩβҪ����"."
		nameStr[nameStr.length - 2] += "_����ƥ�䴦���.";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nameStr.length; i++) {
			sb.append(nameStr[i]);
		}
		File newFile = new File(paraDir, sb.toString());
		//����ļ������ڣ���ô�����ļ�����������ļ����������
		//����ļ��Ѿ����ڣ���ôҲҪ���ļ������ñ��浽this.resultFile
		if (!newFile.exists()) {
			try {
				newFile.createNewFile();
			}
			catch(IOException ioe) {
				//������
				sop(ioe.toString() + "\n\"" + newFile.getAbsolutePath() + "\"�ļ�����ʧ��");
			}
		}
		this.resultFile = newFile;
		sop("Successful���ļ���\"" + newFile.getAbsolutePath() + "\"�����ɹ�");

		String[] fileArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							  "key_value_BothNot.txt"};
		File keyValue = null;
		for (int i = 0; i < fileArray.length; i++) {
			keyValue = new File(paraDir, fileArray[i]);
			//����ļ������ڣ���ô�����ļ�����������ļ����������
			//����ļ��Ѿ����ڣ���ôҲҪ���ļ������ñ��浽this.resultFile
			if (!keyValue.exists()) {
				try {
					keyValue.createNewFile();
				}
				catch(IOException ioe) {
					//������
					sop(ioe.toString() + "\n\"" + keyValue.getAbsolutePath() + "\"�ļ�����ʧ��");
				}
			}
			sop("Successful���ļ���\"" + keyValue.getAbsolutePath() + "\"�����ɹ�");
		}
		
	}

	public void analysis() {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try {
			bufr = new BufferedReader(new FileReader(this.analysisFile));
			bufw = new BufferedWriter(new FileWriter(this.resultFile));
			String line = null;
			while (null != (line = bufr.readLine())) {	//ע�⣺.readLine()�������᷵��"����"
				line = line.replaceAll("^.*?[Kk]", "").replaceAll("\u503C[Vv](\\d*?)[\\D].*?$", "$1");
				//����ƥ�䴦���ÿ��Ϊ��������ID
				//û�л��лس���
				bufw.write(line + "\r\n");
				bufw.flush();
			}
		}
		catch(IOException ioe) {
			throw new RuntimeException("�ļ���дʧ��");
		}
		finally {
			try {
				if(null != bufr) {
					bufr.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("Դ�ļ���" + this.analysisFile.getAbsolutePath()
										   + "��ȡ�ر�ʧ�ܣ�");
			}
			try {
				if(null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("Ŀ���ļ���" + this.resultFile.getAbsolutePath()
										   + "д��ر�ʧ�ܣ�");
			}
		}
		sop("Successful!--Դ�ļ���\"" + this.analysisFile.getAbsolutePath() + "\"\n[�����������]"
			+ "Ŀ���ļ���\"" + this.resultFile.getAbsolutePath() + "\"");
	}

	public void sop(Object obj) {
		System.out.println(obj);
	}	
}

/**
 * �Լ�ֵ�淶�ı��ļ���ÿһ������ģʽ��<����ֵ>����TreeMap����洢
 * ���ڼ���ֵ��ΪString���󣬶�String����Ĭ��ʵ���˱Ƚϼ�����
 * 
 */

class KeyValue {
	private File sourceFile = null;
	private TreeMap<String, String> tm = new TreeMap<String, String>();
	public KeyValue() {}
	public KeyValue(File file) {
		/**
		 * �˴������贫����ļ����ã��Ѿ��ǰ���ָ������洢�ļ�ֵ����
		 * ������ǣ��ɲ�ȡ�ķ������ǣ����ڲ�������У�����
		 * ��÷���У��FileAnalysis���analysis()����������ʹ�õ�������ʽ���ж��ʵ��
		 * ȷ���˴��õ����Ǽ�ֵ�淶�ļ�
		 */
		this.sourceFile = file;
		this.createTreeMap();
	}

	public void createTreeMap() {
		BufferedReader bufr = null;
		try {
			bufr = new BufferedReader(new FileReader(this.sourceFile));
			String line = null;
			String[] keyValueStr = null;
			while (null != (line = bufr.readLine())) {
				//����'��'��Unicode����Ϊ\uFF0C
				keyValueStr = line.split("\uFF0C");
				//Ϊ���Է��㣬��ID���ִ���ΪID�������ַ�����Ϊֵ
				//��������鿴������
				if (2 != keyValueStr.length) {
					//Ϊ��ȫ����������ļ�ÿ�зָ�������2���Ӵ��ģ�����
					//������ֻ��һ���ִ���Ӱ���������
					continue;
				}
				//tm.put(keyValueStr[0], keyValueStr[1]);
				tm.put(keyValueStr[1], keyValueStr[0]);
			}
		}
		catch(IOException ioe) {
				throw new RuntimeException("Դ�ļ���" + this.sourceFile.getAbsolutePath()
										   + "��ȡʧ�ܣ�");
			}
		finally {
			try {
				if(null != bufr) {
					bufr.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("Դ�ļ���" + this.sourceFile.getAbsolutePath()
										   + "д��ر�ʧ�ܣ�");
			}
		}
		sop("Successful!--Դ�ļ���\"" + this.sourceFile.getAbsolutePath()
			+ "\"\nʹ��TreeMap�洢�ɹ���");
	}

	public TreeMap<String, String> getTreeMap() {
		return this.tm;
	}

	public void sop(Object obj) {
		System.out.println(obj);
	}
}
