
//package A.B;
import java.io.*;
class DirNamePrintDG {
	public static void main(String[] args) {
		/**
		 * DirNamePrintDG.java文件解决问题：
		 * 列出指定目录的全部内容
		 */
		/**
		 * fileName代表所遍历的根目录
		 */
		String fileName = "C:\\Users\\CY_XYZ\\Desktop\\D_PDD";
		//String fileName = "E:" + File.separator;
        File file = new File(fileName);
        //printName(file);
		//sop(System.getProperty("user.dir"));
		//String paraDirName = System.getProperty("user.dir") + "文件内容比较";
		//sop(paraDirName);
    }

    public static void printName(File f){
        if (null != f) {
            if (f.isDirectory()) {
				sop(">>>>文件夹" + f + "<<<<");
                File[] fileArray = f.listFiles();
                if (null != fileArray) {
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        printName(fileArray[i]);
                    }
                }
            }
            else{
                sop("\t文件--" + f);
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
