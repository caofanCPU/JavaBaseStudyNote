

/**
 * �������н�����£�
 * ---------------------------
   AK47::10......PK......AK47::10
   AK44::16......PK......AK47::10
   AK47::16......PK......AK47::10
   AK47::16......PK......AK44::16
   AK47::10......PK......AK44::16
   AK47::10......PK......AK47::10
   ����TreeSet-->ts��ʵ�ʴ洢��Ԫ���������£�
   Name = AK47, Age = 10
   Name = AK44, Age = 16
   Name = AK47, Age = 16
   ---------------------------
   �밴���������. . .
 */
import java.util.*;
class TreeSetFanli {
	public static void main(String[] args) {
		/* TreeSetFanli.java�ļ�������⣺
		*  
		*/
		TreeSet ts = new TreeSet();
		lineSplit();
		ts.add(new StudentFanli("AK47", 10));
		ts.add(new StudentFanli("AK44", 16));
		ts.add(new StudentFanli("AK47", 16));
		ts.add(new StudentFanli("AK47", 10));
		sop("����TreeSet-->ts��ʵ�ʴ洢��Ԫ���������£�");
		for(Iterator<StudentFanli> it = ts.iterator(); it.hasNext();) {
			StudentFanli stuf = it.next();
			sop("Name = " + stuf.getName() + ", "
				+ "Age = " + stuf.getAge());
		}
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* ��ӡ�ַ���
		*  
		*/
		System.out.println(obj);
	}

	public static void lineSplit() {
		/* ��ӡ�ָ���
		*  
		*/
		sop("---------------------------");
	}
}

class StudentFanli implements Comparable {
    private String name;
	private int age;
	public StudentFanli() {}
	public StudentFanli(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	/**
	 * ʵ��Comparable��public int compareTo(Object obj)����
	 * ʹ�ö��������趨�˱ȽϹ���
	 * ˵����comepareTo���������½����Ķ����뼯���ж���ѭ�����ñȽϵ�
	 *		 �������½�����������ж�����򷵻�ֵΪ������
	 *		 �����漰��"��Ҫ�ж����������Ƿ���ͬ�Ĳ���"���ײ㶼�ڵ���compareTo����
	 * ���������TreeSetģ����У���ô����ľ���ô���(������ȥ��)
	 *			 return 1;
	 *			 TreeSetģ��ջ  ����ô����ľ���ô�������(������ȥ��)
	 *			 return -1;
	 *			 �����Ҫȥ�أ����жϷ��ظ���return 1 | -1;
	 */
	public int compareTo(Object obj) {
		if (!(obj instanceof StudentFanli)) {
		    throw new RuntimeException("�Ƚ϶�����StudentFanli���޷��Ƚϣ�");
		}
		StudentFanli stuf = (StudentFanli) obj;
		System.out.println(this.getName() + "::" + this.getAge()
						   + "......PK......"
						   + stuf.getName() + "::" + stuf.getAge());
		/**
		 * age��������
		 * ͬage����name��������
		 * ͬageͬname����Ϊ�ظ����Զ�����
		 */
		int temp = this.getAge() - stuf.getAge();
		if (0 != temp) {
			return temp;
		} else {
			return this.getName().compareTo(stuf.getName());
		}
	}
}
