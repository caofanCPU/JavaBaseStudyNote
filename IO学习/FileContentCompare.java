
import java.util.*;
import java.io.*;
import java.lang.Math;
class FileContentCompare {
	public static void main(String[] args) {
		/**
		 * FileContentCompare.java解决问题
		 *
		 */
		
		//保证本程序操作的文件A、文件B所在父目录唯一存在
		String paraDirName = "C:" + File.separator
							 + "Users" + File.separator
							 + "CY_XYZ" + File.separator
							 + "Desktop" + File.separator
							 + "D_PDD" + File.separator
							 + "文件内容比较";
		//保存结果的文件名
		String[] fileNameArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							      "key_value_BothNot.txt"};

		File paraDir = new File(paraDirName);
/*
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
*/
		File fileARegular = new File(paraDir, "文件A_正则匹配处理后.txt");
		File fileBRegular = new File(paraDir, "文件B_正则匹配处理后.txt");
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

/**
 * MakeKeyValueFile类，用于给指定文件覆盖添加指定行数的字符串文本
 * 每行文本具有如下模式：[编号]若干干扰字符[K字符串1，v字符串2]若干干扰字符回车换行符
 * 其中字符串1前后有唯一标记'K'和'，'限定，该部分代表键，姓名
 *	   字符串2前有唯一字符'v'限定，字符串2全数字字符串，其后的非数字字符充当了限定符
 * java数组声明的3种方式：int[] a = new int[] {1,2,3};
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
	 * MakeKeyValueFile构造函数，参数file为需要创建内容的文件对象
	 *							 参数fileLines为该文件的创建内容行数
	 * 获取文件对象、文件行数后：
	 * 根据firstName选取姓，sencondName、lastName获取名字，执行随机获取姓名.keyName()
	 *													   执行随机获取ID值.valueNumber()
	 * noiseString为干扰字符串，目的：在键[Kk]姓名，值[Vv]ID两端插入
	 *
	 */
	public MakeKeyValueFile(File file, int fileLines) {
		if (null == file) {
			throw new RuntimeException("文件引用为空，操作失败");
		}
		if (!file.exists()) {
			throw new RuntimeException("文件不存在，操作失败");
		}
		if (!file.isFile()) {
			throw new RuntimeException("写入操作对象应该是文件，而非目录！");
		}
		this.file = file;
		if (fileLines > 0) {	//若传入的内容行数值小于0，按照默认50行执行
			this.FILE_LINES = fileLines;
		}
		//名字的组合可能：20 * 20 * 20 = 8000种
		firstName =  new char[] {'赵', '钱', '孙', '李',
								 '周', '吴', '郑', '王',
								 '刘', '崔', '谢', '唐',
								 '丘', '张', '汪', '许',
								 '舒', '杨', '范', '黄'};
		secondName = new char[] {  32, '紫', '梓',   32,
								 '萧', '雨', '承', '文',
								 '筱', '景', '哲', '羽',
							       32, '凯', '胜', '兰',
								 '利', '彬', '斌', '品'};
		lastName =   new char[] {'震', '峰', '锋', '然',
								 '武', '茜', '谦', '嫣',
								 '晶', '娟', '薇', '冰',
								 '华', '富', '波', '弈',
								 '强', '明', '杰', '瑞'};
		this.keyName();
		this.valueNumber();
		this.noiseString();
		this.addKeyValue();
		
	}

	public File getFile() {
		return this.file;
	}
	
	/**
	 * 创建随机模式下的：键[Kk]姓名，字符串
	 */
	public void keyName() {
		String key = "";
		char[] ch = new char[]{'A', 32, 'G'};
		int[] num = {0, 0, 0};
		for (int j = 0; j < FILE_LINES; j++) {
			for (int i = 0; i < 3; i++) {
				num[i] = (int)(Math.random() * 20);		//产生随机数后，再使用(int)强制转型
			}
			ch[0] = this.firstName[num[0]];
			ch[1] = this.secondName[num[1]];
			ch[2] = this.lastName[num[2]];
			key = "键K" + String.valueOf(ch).replaceAll(" ", "  ");		//将单个空格替换为两个空格
			this.keyList.add(key);						  //使用ArrayList获取了FILE_LINES  键K姓名
		}
	}

	/**
	 * 创建随机模式下：值[Vv]ID，字符串
	 * 假定ID为8位数字，且以20开始
	 */

	public void valueNumber() {
		int[] id = {2, 0, 1, 7,
					0, 0, 0, 0};

		//int[] id = {2, 0, 0};		//作为键，有1000种可能
		String value = null;
		for (int i = 0; i < FILE_LINES; i++) {
			//每次初始化value = "" + id[0]
			value = "" + id[0] + id[1];
			for (int j = 2; j < id.length; j++) {
				id[j] = (int)(Math.random() * 10);
				value += id[j];
			}
			//注意：中文字符'值'的Unicode编码为\u503C，在进行正则匹配时会用到
			this.valueList.add("值v" + value);
		}
	}

	/**
	 * 创建随机模式下：干扰字符，范围为：可见ASCII字符(剔除K、k、V、v)和汉字字符
	 * 可用ASCII字符：33-126(剔除'k' 'K' 'v' 'V')，注意数字
	 * 可考虑使用StringBulider、集合(List、Set、Map)提升性能
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
				//将关键字符k或K或v或V替换为空格
				if ('k' == chAsc[j] || 'K' == chAsc[j] || 'v' == chAsc[j] || 'V' == chAsc[j]) {
					chAsc[j] = ' ';
				}
			}
			//必须保证汉字在前，英文字符在后，以免对ID值的解析产生偏差
			noiseStr = String.valueOf(chChinese) + String.valueOf(chAsc);
			this.noiseList.add(noiseStr);
		}
		
	}

	public void addKeyValue() {
		if (null == this.file) {
			throw new RuntimeException("文件引用为空，操作失败");
		}
		if (!this.file.exists()) {
			throw new RuntimeException("文件不存在，操作失败");
		}
		if (!this.file.isFile()) {
			throw new RuntimeException("写入操作对象应该是文件，而非目录！");
		}
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(this.file));
			int i = 0;
			while (i < FILE_LINES) {
				bufw.write("[" + (i+1) + "]"				//行号
						   + this.noiseList.get(2*i)		//干扰字符串
						   + this.keyList.get(i)			//带键标识的姓名字符串
						   + "，"							//键与值间唯一分隔符中文"，"
						   + this.valueList.get(i)			//带值标识的ID数字串	
						   + this.noiseList.get(2*i+1)		//干扰字符串
						   + "\r\n");						//换行回车
				bufw.flush();
				i++;
			}
			
		}
		catch(IOException ioe) {
			throw new RuntimeException(ioe.toString() + "\n文件：\""
									   +this.file.getAbsolutePath() + "\"写入失败！");
		}
		finally {
			try {
				if(null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException(ioe.toString() + "\n文件：\""
									   +this.file.getAbsolutePath() + "\"写入关闭失败！");
			}
		}
		System.out.println("Successful!文件：\"" + this.file.getAbsolutePath() + "\"内容创建成功");
	}	
}

/**
 * FileAnalysis类，对传入的文本类文件进行正则匹配清理
 */
class FileAnalysis {
	private File analysisFile = null;
	private File resultFile = null;
	//private String[] keyValue = null;
	public FileAnalysis() {}
	public FileAnalysis(File file) {
		if (!file.exists()) {
			throw new RuntimeException("文件：\"" + file.getAbsolutePath() + "\"不存在");
		}
		if (!file.isFile()) {
			throw new RuntimeException("\"" + file.getAbsolutePath() + "不是文件，而是目录！");
		}
		if (0 == file.length()) {
			throw new RuntimeException("文件\"" + file.getAbsolutePath() + "\"内容为空！");
		}
		this.analysisFile = file;
		this.createResultFile();
		this.analysis();
	}

	public File getResultFile() {
		return this.resultFile;
	}

	/**
	 * 在需要正则匹配分析的文件同目录下，创建一个基本同名的新文件
	 * 考虑到最终目的：输出文件A与文件B相同的键值，键同值不同，值同键不同，键值都不同
	 * 因而在此处一并创建这四个文件key_value_AllSame.txt，keySame_valueNot.txt
	 *							   valueSame_keyNot.txt，key_value_BothNot.txt
	 */
	public void createResultFile() {
		//获取源文件的父目录和源文件名
		File paraDir = this.analysisFile.getParentFile();
		String newFileName = this.analysisFile.getName();
		//使用正则表达式按照字符'.'分割文件名(带后缀名)，注意：字符'.'的正则表达式为"\\."
		String[] nameStr = newFileName.split("\\.");
		//sop(nameStr.length);
		//分割后，最后一个字符串代表文件后缀名，那么在倒数第二个字符串末尾添加标记字符串
		//同时注意：按照字符'.'分割字符串后，文件后缀名前面的'.'已被去掉，因而标记字符串末尾要加上"."
		nameStr[nameStr.length - 2] += "_正则匹配处理后.";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nameStr.length; i++) {
			sb.append(nameStr[i]);
		}
		File newFile = new File(paraDir, sb.toString());
		//如果文件不存在，那么创建文件，并保存该文件对象的引用
		//如果文件已经存在，那么也要将文件的引用保存到this.resultFile
		if (!newFile.exists()) {
			try {
				newFile.createNewFile();
			}
			catch(IOException ioe) {
				//待处理
				sop(ioe.toString() + "\n\"" + newFile.getAbsolutePath() + "\"文件创建失败");
			}
		}
		this.resultFile = newFile;
		sop("Successful！文件：\"" + newFile.getAbsolutePath() + "\"创建成功");

		String[] fileArray = {"key_value_AllSame.txt", "keySame_valueNot.txt",
							  "key_value_BothNot.txt"};
		File keyValue = null;
		for (int i = 0; i < fileArray.length; i++) {
			keyValue = new File(paraDir, fileArray[i]);
			//如果文件不存在，那么创建文件，并保存该文件对象的引用
			//如果文件已经存在，那么也要将文件的引用保存到this.resultFile
			if (!keyValue.exists()) {
				try {
					keyValue.createNewFile();
				}
				catch(IOException ioe) {
					//待处理
					sop(ioe.toString() + "\n\"" + keyValue.getAbsolutePath() + "\"文件创建失败");
				}
			}
			sop("Successful！文件：\"" + keyValue.getAbsolutePath() + "\"创建成功");
		}
		
	}

	public void analysis() {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try {
			bufr = new BufferedReader(new FileReader(this.analysisFile));
			bufw = new BufferedWriter(new FileWriter(this.resultFile));
			String line = null;
			while (null != (line = bufr.readLine())) {	//注意：.readLine()方法不会返回"换行"
				line = line.replaceAll("^.*?[Kk]", "").replaceAll("\u503C[Vv](\\d*?)[\\D].*?$", "$1");
				//正则匹配处理后，每行为：姓名，ID
				//没有换行回车符
				bufw.write(line + "\r\n");
				bufw.flush();
			}
		}
		catch(IOException ioe) {
			throw new RuntimeException("文件读写失败");
		}
		finally {
			try {
				if(null != bufr) {
					bufr.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("源文件：" + this.analysisFile.getAbsolutePath()
										   + "读取关闭失败！");
			}
			try {
				if(null != bufw) {
					bufw.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("目的文件：" + this.resultFile.getAbsolutePath()
										   + "写入关闭失败！");
			}
		}
		sop("Successful!--源文件：\"" + this.analysisFile.getAbsolutePath() + "\"\n[处理结果存放至]"
			+ "目的文件：\"" + this.resultFile.getAbsolutePath() + "\"");
	}

	public void sop(Object obj) {
		System.out.println(obj);
	}	
}

/**
 * 对键值规范文本文件，每一行内容模式：<键，值>进行TreeMap排序存储
 * 由于键、值均为String对象，而String对象默认实现了比较及排序
 * 
 */

class KeyValue {
	private File sourceFile = null;
	private TreeMap<String, String> tm = new TreeMap<String, String>();
	public KeyValue() {}
	public KeyValue(File file) {
		/**
		 * 此处，假设传入的文件引用，已经是按照指定规则存储的键值内容
		 * 如果不是，可采取的方案就是，对于不满足的行，丢弃
		 * 最好反复校验FileAnalysis类的analysis()方法，对于使用的正则表达式进行多次实验
		 * 确保此处拿到的是键值规范文件
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
				//中文'，'的Unicode编码为\uFF0C
				keyValueStr = line.split("\uFF0C");
				//为测试方便，以ID数字串作为ID，姓名字符串作为值
				//这样方便查看排序结果
				if (2 != keyValueStr.length) {
					//为安全起见，对于文件每行分割结果不是2个子串的，丢弃
					//尤其是只有一个字串，影响后续运行
					continue;
				}
				//tm.put(keyValueStr[0], keyValueStr[1]);
				tm.put(keyValueStr[1], keyValueStr[0]);
			}
		}
		catch(IOException ioe) {
				throw new RuntimeException("源文件：" + this.sourceFile.getAbsolutePath()
										   + "读取失败！");
			}
		finally {
			try {
				if(null != bufr) {
					bufr.close();
				}
			}
			catch(IOException ioe) {
				throw new RuntimeException("源文件：" + this.sourceFile.getAbsolutePath()
										   + "写入关闭失败！");
			}
		}
		sop("Successful!--源文件：\"" + this.sourceFile.getAbsolutePath()
			+ "\"\n使用TreeMap存储成功！");
	}

	public TreeMap<String, String> getTreeMap() {
		return this.tm;
	}

	public void sop(Object obj) {
		System.out.println(obj);
	}
}
