
import java.util.*;
import java.io.*;
import java.lang.Math;

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
