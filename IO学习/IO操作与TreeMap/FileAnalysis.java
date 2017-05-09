
import java.io.*;
/**
 * FileAnalysis类，对传入的文本文件进行正则匹配清理
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
