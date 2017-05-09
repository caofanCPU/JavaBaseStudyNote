
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;			//���ֹ���������java.awt.*
import java.awt.event.*;
import java.io.*;
class MyNoteBook {
	public static void main(String[] args) {
		/**
		 * MyNoteBook.java�ļ�������⣺
		 * ����һ�����Ƽ��±���java.jar˫����ִ���ļ�
		 * Ӧ�ó��򴰿���ʽ��
		 *					frmame����MyNoteBook
		 *					�˵�����|�ļ�|�˵���
		 *							-|��|�˵���
		 *							-|����|�˵���
		 *							-|�ر�|�˵���
		 *					Ĭ�ϲ���
		 *					�ı����������������
		 */
		new NoteBook();	
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
 * ʹ��import javax.swing.*; ��������JFrame���˵���JMenuBar
 *								 �˵�JMenu���˵���JMenuItem
 *								 �ı�����JTextArea���ı���JTextField
 * javax.swing.*���������java.awt.*�����ϼ�����J�����ɣ�
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
		 * �˵�Menu"�ļ�"�����������Ӳ˵�MenuItem"��"��"����"��"���Ϊ.."��"�ر�"
		 */
		fileMenu = new JMenu("�ļ�");
		openItem = new JMenuItem("��");
		saveItem = new JMenuItem("����");
		saveAsItem = new JMenuItem("���Ϊ..");
		closeItem = new JMenuItem("�ر�");
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(closeItem);
		/**
		 * �˵�������MenuBar�������˵�Menu"�ļ�"
		 */
		mb = new JMenuBar();
		mb.add(fileMenu);

		fullTa = new TextArea();		//new TextArea()�Դ���ֱ��ˮƽ����������

		/**
		 * ����Frame����ʽ����.setLayout(�ղ�);
		 *			  �����˵�������MenuBar���ı�����TextArea
		 */

		f = new JFrame("MyNoteBook");
		f.setBounds(300, 100,
					600, 500);
		f.setLayout(new BorderLayout());	//Ĭ�ϱ߽���䲼��
		//f.setLayout(new FlowLayout());	//��ʽ����
		/*f.setLayout(new GridLayout(3, 3,
									 5, 5));*/	//���粼�֣�3��3������֣������ˮƽ����5����ֱ����5
		//f.setLayout(new CardLayout());	//��Ƭ����
		//f.setLayout(new GridBagLayout());	//���������

		f.setJMenuBar(mb);
		f.add(fullTa);
		/**
		 * ��Ӵ���JFrame������ĶԻ���Dialog��JDialog
		 */
		openDialog = new FileDialog(f, "���ļ�", FileDialog.LOAD);
		saveDialog = new FileDialog(f, "�����ļ�", FileDialog.SAVE);
		saveAsDialog = new FileDialog(f, "���Ϊ..", FileDialog.SAVE);

		myEvent();
		f.setVisible(true);
	}
	
	/**
	 * ��������¼������
	 * ��أ�JButton��JTextArea��JTextField��JMenu��JMenu��JMenuItem��mouseEvent��keyEvent��
	 * 
	 */
	public void myEvent() {

		openItem.addActionListener(new ActionListener() {
			//��дactionPerformed(ActionEvent e)������ʵ��ActionListener�ӿ�
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
					throw new RuntimeException("�ļ���ȡʧ�ܣ�");
				}
			}
		});

		saveItem.addActionListener(new ActionListener() {
			//��дactionPerformed(ActionEvent e)������ʵ��ActionListener�ӿ�
			public void actionPerformed(ActionEvent e) {
				saveDialog.setVisible(true);
			}
		});

		saveAsItem.addActionListener(new ActionListener() {
			//��дactionPerformed(ActionEvent e)������ʵ��ActionListener�ӿ�
			public void actionPerformed(ActionEvent e) {
				saveAsDialog.setVisible(true);
			}
		});

		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�˳�����ǰ���fullTa���ı������Ƿ��б��Ķ���
				//���иĶ�����Ҫ�����Ƿ񱣴��޸ĵ���ʾ��Ϣ
				System.exit(0);
			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void actionPerformed(ActionEvent e) {
				//�˳�����ǰ���fullTa���ı������Ƿ��б��Ķ���
				//���иĶ�����Ҫ�����Ƿ񱣴��޸ĵ���ʾ��Ϣ
				System.exit(0);
			}
		});
	}
}
