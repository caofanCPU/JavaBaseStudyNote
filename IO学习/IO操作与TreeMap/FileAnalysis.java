
import java.io.*;
/**
 * FileAnalysis�࣬�Դ�����ı��ļ���������ƥ������
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
