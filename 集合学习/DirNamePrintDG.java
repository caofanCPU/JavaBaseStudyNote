
//package A.B;
import java.io.*;
class DirNamePrintDG {
	public static void main(String[] args) {
		/**
		 * DirNamePrintDG.java�ļ�������⣺
		 * �г�ָ��Ŀ¼��ȫ������
		 */
		/**
		 * fileName�����������ĸ�Ŀ¼
		 */
		String fileName = "C:\\Users\\CY_XYZ\\Desktop\\D_PDD";
		//String fileName = "E:" + File.separator;
        File file = new File(fileName);
        //printName(file);
		//sop(System.getProperty("user.dir"));
		//String paraDirName = System.getProperty("user.dir") + "�ļ����ݱȽ�";
		//sop(paraDirName);
    }

    public static void printName(File f){
        if (null != f) {
            if (f.isDirectory()) {
				sop(">>>>�ļ���" + f + "<<<<");
                File[] fileArray = f.listFiles();
                if (null != fileArray) {
                    for (int i = 0; i < fileArray.length; i++) {
                        //�ݹ����
                        printName(fileArray[i]);
                    }
                }
            }
            else{
                sop("\t�ļ�--" + f);
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
