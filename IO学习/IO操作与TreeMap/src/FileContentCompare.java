
//package A.B;
import java.util.*;
import java.io.*;
class FileContentCompare {
	public static void main(String[] args) {
		/**
		 * FileContentCompare.java解决问题
		 *
		 */
		
		//在当前目录下，新建1个子目录"文件内容比较"
		//sop(System.getProperty("user.dir"));
		String paraDirName = System.getProperty("user.dir") + File.separator + "文件内容比较";
		//保存结果的文件名
		String[] fileNameArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							      "key_value_BothNot.txt"};

		File paraDir = new File(paraDirName);

		createParaDir(paraDir);
		String fileNameA = "文件A.txt";
		String fileNameB = "文件B.txt";
		File fileA = createFile(paraDir, fileNameA);
		File fileB = createFile(paraDir, fileNameB);
		//创建指定路径的文件A、文件B
		new MakeKeyValueFile(fileA, 100000);
		new MakeKeyValueFile(fileB, 100000);


		File fileARegular = new FileAnalysis(fileA).getResultFile();
		File fileBRegular = new FileAnalysis(fileB).getResultFile();

		/**
		File fileARegular = new File(paraDir, "文件A_正则匹配处理后.txt");
		File fileBRegular = new File(paraDir, "文件B_正则匹配处理后.txt");
		 */
		//获取文件A、文件B的TreeMap键值存储视图
		TreeMap<String, String> tmA = new TreeMap<String, String>();
		TreeMap<String, String> tmB = new TreeMap<String, String>();
		tmA = new KeyValue(fileARegular).getTreeMap();
		//tmB = tmA;
		tmB = new KeyValue(fileBRegular).getTreeMap();
		keyValueCompare(tmA, tmB, fileNameArray, paraDir);
		/**
		 * 测试tmA是否为指定的TreeMap排序视图*/
/*		int i = 1;
		for (Iterator<Map.Entry<String, String>> entry = tmA.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<String, String> me = entry.next();
			sop("第[" + i + "]个元素：" + "<键 = " + me.getKey() + ", 值 = " + me.getValue());
		}
*/
	}

	/**
	 * keyValueCompare方法，将对文件A、文件B中的键值进行比较，并将结果写入指定文件
	 * tmA，文件A的键值TreeMap视图；tmB，文件B的键值TreeMap视图
	 * fileNameArray为字符串数组，里面保存了4个文件的文件名(带扩展名)
	 * paraDir为文件对象，用于在指定目录下将比较结果写入上述4个文件
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
				//判断两个字符串是否相等，用if (strA.equals(strB))或者if (0 == strA.compareTo(strB))
				if (aValue.equals(bValue)) {
					sb0.append("键值相同：" + "<键 = " + aKey + ", 值 = " + aValue + ">\r\n");
				} else {
					sb1.append("键同值不同：" + "<键 = " + aKey
							   + ", 文件A值 = " + aValue + "    |文件B值 = " + bValue + ">\r\n");
				}
				
			} else {
				sb2.append("文件A与文件B键值都不同：" + "文件A<键 = " + aKey + ", 值 = " + aValue + ">\r\n");
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
				//待处理
				throw new RuntimeException("目标文件不存在且创建失败！");
			}
		}
		BufferedWriter bufw = null;
		try {
			//下面两句都可能产生异常
			bufw = new BufferedWriter(new FileWriter(resultFile));
			bufw.write(sb.toString());
		}
		catch(IOException ioe) {
			//待处理
			throw new RuntimeException("目标文件写入失败！");
		}
		finally {
			try {
				if (null != bufw) {
					bufw.close();	
				}
			}
			catch(IOException ioe) {
				//待处理
				throw new RuntimeException("目标文件写入关闭失败！");
			}
		}
		
	}

	public static void createParaDir(File paraDir) {
		if (!paraDir.exists()) {
			//如果该目录不存在，则创建该目录，需要处理IOException
			try {
				paraDir.mkdir();
			}
			catch(SecurityException se) {
				//待处理
				sop(se.toString() + "\n\"" + paraDir.getAbsolutePath() + "\"目录创建失败");
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
				//待处理
				sop(ioe.toString() + "\n\"" + newFile.getAbsolutePath() + "\"文件创建失败");
			}
		}
		return newFile;
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
