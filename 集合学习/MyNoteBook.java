
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;			//布局管理器属于java.awt.*
import java.awt.event.*;
import java.io.*;
class MyNoteBook {
	public static void main(String[] args) {
		/**
		 * MyNoteBook.java文件解决问题：
		 * 创建一个类似记事本的java.jar双击可执行文件
		 * 应用程序窗口形式：
		 *					frmame名：MyNoteBook
		 *					菜单栏：|文件|菜单项
		 *							-|打开|菜单条
		 *							-|保存|菜单条
		 *							-|关闭|菜单条
		 *					默认布局
		 *					文本区域填充整个窗口
		 */
		new NoteBook();	
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
 * 使用import javax.swing.*; 创建窗口JFrame，菜单栏JMenuBar
 *								 菜单JMenu，菜单项JMenuItem
 *								 文本区域JTextArea，文本框JTextField
 * javax.swing.*的组件，在java.awt.*基础上加区分J，即可！
 *					
 */

class NoteBook {
	private JFrame f;
	private JMenuBar mb;

	private JMenu fileMenu;	
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem closeItem;

	private TextArea fullTa;
	private JScrollPane scrollPaneTa;

	private FileDialog openDialog;
	private FileDialog saveDialog;
	private FileDialog saveAsDialog;
	private JDialog closeDialog;


	public NoteBook() {
		init();
	}
	public void init() {
		/**
		 * 菜单Menu"文件"：包含二级子菜单MenuItem"打开"，"保存"，"另存为.."，"关闭"
		 */
		fileMenu = new JMenu("文件");
		openItem = new JMenuItem("打开");
		saveItem = new JMenuItem("保存");
		saveAsItem = new JMenuItem("另存为..");
		closeItem = new JMenuItem("关闭");
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(closeItem);
		/**
		 * 菜单工具栏MenuBar：包含菜单Menu"文件"
		 */
		mb = new JMenuBar();
		mb.add(fileMenu);

		fullTa = new TextArea();		//new TextArea()自带垂直、水平滚动条！！

		/**
		 * 窗口Frame：流式布局.setLayout(空参);
		 *			  包含菜单工具栏MenuBar，文本区域TextArea
		 */

		f = new JFrame("MyNoteBook");
		f.setBounds(300, 100,
					600, 500);
		f.setLayout(new BorderLayout());	//默认边界填充布局
		//f.setLayout(new FlowLayout());	//流式布局
		/*f.setLayout(new GridLayout(3, 3,
									 5, 5));*/	//网络布局，3乘3组件布局，组件间水平距离5、垂直距离5
		//f.setLayout(new CardLayout());	//卡片布局
		//f.setLayout(new GridBagLayout());	//网格包布局

		f.setJMenuBar(mb);
		f.add(fullTa);
		/**
		 * 添加窗口JFrame相关联的对话框Dialog和JDialog
		 */
		openDialog = new FileDialog(f, "打开文件", FileDialog.LOAD);
		saveDialog = new FileDialog(f, "保存文件", FileDialog.SAVE);
		saveAsDialog = new FileDialog(f, "另存为..", FileDialog.SAVE);

		myEvent();
		f.setVisible(true);
	}
	
	/**
	 * 构建组件事件监控室
	 * 监控：JButton，JTextArea，JTextField，JMenu，JMenu，JMenuItem，mouseEvent，keyEvent等
	 * 
	 */
	public void myEvent() {

		openItem.addActionListener(new ActionListener() {
			//复写actionPerformed(ActionEvent e)方法，实现ActionListener接口
			public void actionPerformed(ActionEvent ae) {
				openDialog.setVisible(true);
				String dirPath = openDialog.getDirectory();
				String fileName = openDialog.getFile();
				if (null == dirPath || null == fileName) {
					return ;
				}
				fullTa.setText("");
				File file = new File(dirPath, fileName);
				try {
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					int i = 1;
					while ((line = bufr.readLine()) != null) {
						fullTa.append("[" + i + "]  ");
						fullTa.append(line + "\r\n");
						i++;
					}
					bufr.close();
				}
				catch(IOException ioe) {
					throw new RuntimeException("文件读取失败！");
				}
			}
		});

		saveItem.addActionListener(new ActionListener() {
			//复写actionPerformed(ActionEvent e)方法，实现ActionListener接口
			public void actionPerformed(ActionEvent e) {
				saveDialog.setVisible(true);
			}
		});

		saveAsItem.addActionListener(new ActionListener() {
			//复写actionPerformed(ActionEvent e)方法，实现ActionListener接口
			public void actionPerformed(ActionEvent e) {
				saveAsDialog.setVisible(true);
			}
		});

		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出程序前检查fullTa，文本区域是否有被改动，
				//若有改动，需要弹出是否保存修改的提示信息
				System.exit(0);
			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void actionPerformed(ActionEvent e) {
				//退出程序前检查fullTa，文本区域是否有被改动，
				//若有改动，需要弹出是否保存修改的提示信息
				System.exit(0);
			}
		});
	}
}
