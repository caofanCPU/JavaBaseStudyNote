
import java.util.*;
import java.io.*;
import java.lang.Math;

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
