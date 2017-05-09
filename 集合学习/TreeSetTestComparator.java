
/*
������ϵ��Collection���洢���Ƕ��������
			|-- List��Ԫ��ʱ�����(����˳���ȡ��˳��Ӧ��һ��)��Ԫ�ؿ����ظ�
					  List������ϵ������
				|-- ArrayList���ײ�����ݽṹ�����飬�ص㣺��ѯ�ٶȿ죬��ɾ�������̲߳�ͬ��
				|-- LinkedList���ײ�����ݽṹ�������ص㣺��ѯ�ٶ���������ɾ�ܿ죬�̲߳�ͬ��
						LinkedList���з�����
							��boolean��.offerFirst(element)���ڱ�ͷ���Ԫ��
							��boolean��.offerLast(element)���ڱ�ĩ���Ԫ��
							��E��.peekFirst(�ղ�)������ȡ��ͷԪ�أ����ı�LinkedList
							��E��.peekLast(�ղ�)������ȡ��ĩԪ�أ����ı�LinkedList
							��E��.pollFirst(�ղ�)����ȡ���Ƴ���ͷԪ�أ��ı�LinkedList
							��E��.pollLast(�ղ�)����ȡ���Ƴ���βԪ�أ��ı�LinkedList
							��E��.pop(�ղ�)������������һ��ջ��Ԫ��
							��void��.push(element)��ѹ��һ��Ԫ����ջ��
				|-- Vector���ײ�����ݽṹ�����飬�߳�ͬ�����ѱ�ArrayList���
			|-- Set��Ԫ���������(�����ȡ����˳��һ��һ��)��Ԫ�ز������ظ�
				|-- HashSet���ײ����ݽṹ�ǹ�ϣ��
							 ��֤Ԫ��Ψһ�ķ�ʽ��.hashCode()-->equals.(Object obj)
							 �ж�Ԫ���Ƿ���ڡ�ɾ��Ԫ�أ���������������ʽ
				|-- TreeSet���ײ����ݽṹ�Ƕ�����(�����)
							 ���Զ�TreeSet�е�Ԫ������Ĭ�����������Ԫ�ص���Ȼ˳��
							 ��֤Ԫ��Ψһ�Ե����ݣ�compareTo����������"��ͬ"�Ĺ���return 0;
							 TreeSet����ĵ�һ�ַ�ʽ��Ԫ��������Ҫʵ��"�ɱȽϵĹ���"��
										  ��Ԫ��ʵ��Comparable�ӿڣ�����compareTo����
							 TreeSet����ĵڶ��ַ�ʽ��Ԫ��������Ҫ����"�ɱȽϵĹ���"������Ԫ�ز��߱��Ƚ���
										   �Ǿ���TreeSet()����ʱ������һ��Comparator�Ƚ�������
										   ��TreeSet ts = new TreeSet(new XXXComparator())
					TreeSet��ϰ�У�TreeSetTest.javaʹ�ö��������趨�ȽϹ��������name��age��hashCodeֵ3�ֵ�������
								   TreeSetComparator.java����������δ�趨�ȽϹ��򣬰�����Ĭ��hashCodeֵ���ǲ����ϳ����
														   ͨ������һ���Ƚ����࣬�����name��age��hashCodeֵ3�ֵ�������
														   (ֵ��ע����ǣ��Ƚ����о�̬����ORDER_NUM�;�̬getOrderName����)
		��Map
			|-- HashTable���ײ����ݽṹ�ǹ�ϣ��
			|-- HashMap���ײ����ݽṹ�ǹ�ϣ��
			|-- TreeMap���ײ����ݽṹ�Ƕ�����(�����)
List�����з��������ǿ���������������ķ���
	--����
		��void��add(index, element):��ָ����������ָ��Ԫ��
		��boolean��addAll(index, Collection)����ָ����������ָ����������Ԫ��
	--ɾ��
		��E��remove(index)���Ƴ�������ָ��Ԫ��
	--�ģ�
		��E��set(index, element)����ָ��λ���滻������ԭ��Ԫ��
	--�飺
		��E��get(index)����ȡ������ָ��Ԫ��
		��int��indexOf(element)����ȡ������ָ��Ԫ�ص�index
		��List<E>��subList(fromIndex, toIndex)����ȡ������[fromIndex��toIndex)�����б�
		��ListIterator<E>��listInterator()����ȡ�����ظ�List�����Ԫ������<E>�ĵ���������
set���䷽����Collectionһ��
*/
//----------------------------/
/*TreeSetComparator.java���н����
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
��AK47::10������ϣֵ����2010167......PK......�ȱ�AK47::10������ϣֵ����2010167
��AK44::16������ϣֵ����2010170......PK......�ȱ�AK47::10������ϣֵ����2010167
��AK47::16������ϣֵ����2010173......PK......�ȱ�AK47::10������ϣֵ����2010167
��AK47::16������ϣֵ����2010173......PK......�ȱ�AK44::16������ϣֵ����2010170
��AK47::10������ϣֵ����2010167......PK......�ȱ�AK44::16������ϣֵ����2010170
��AK47::10������ϣֵ����2010167......PK......�ȱ�AK47::10������ϣֵ����2010167
---------------------------
�����ţ�0-->Ĭ��hashCode��������
����TreeSet-->tsʵ�ʱ����StudentԪ�����£�
        [1]�ţ�<Student.name = AK47, Student.age10>
        [2]�ţ�<Student.name = AK44, Student.age16>
        [3]�ţ�<Student.name = AK47, Student.age16>
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
��AK47::10......PK......�ȱ�AK47::10
��AK44::16......PK......�ȱ�AK47::10
��AK47::16......PK......�ȱ�AK47::10
��AK47::10......PK......�ȱ�AK47::10
---------------------------
�����ţ�1-->name��������
����TreeSet-->tsʵ�ʱ����StudentԪ�����£�
        [1]�ţ�<Student.name = AK44, Student.age16>
        [2]�ţ�<Student.name = AK47, Student.age10>
        [3]�ţ�<Student.name = AK47, Student.age16>
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
��AK47::10......PK......�ȱ�AK47::10
��AK44::16......PK......�ȱ�AK47::10
��AK47::16......PK......�ȱ�AK47::10
��AK47::16......PK......�ȱ�AK44::16
��AK47::10......PK......�ȱ�AK44::16
��AK47::10......PK......�ȱ�AK47::10
---------------------------
�����ţ�2-->age��������
����TreeSet-->tsʵ�ʱ����StudentԪ�����£�
        [1]�ţ�<Student.name = AK47, Student.age10>
        [2]�ţ�<Student.name = AK44, Student.age16>
        [3]�ţ�<Student.name = AK47, Student.age16>
---------------------------
�밴���������. . .
*/

import java.util.*;
class TreeSetTestComparator {
	public static void main(String[] args) {
		/* TreeSetComparator.java�ļ�������⣺
		 * StudentTwo��������δ�趨�ȽϹ���
		 * 1.��name��������
		 *		   ͬname����age��������
		 * 2.��age��������
		 *		   ͬage����name��������
		 * 3.��name��age�����hashCodeֵ��������
		 *		   ���㷽����name.hashCode() + age;
		 */
		int ORDER_NUM = 0;
		String ORDER_STR = "Ĭ��hashCode��������";
		TreeSet ts;
		while((ORDER_NUM++) < 3) {
			ts = new TreeSet(new StudentComparator(ORDER_NUM-1));
			ORDER_STR = orderModel(ORDER_NUM-1);
			lineSplit();
			sop("����TreeSet-->ts���Ԫ�ع����������£�");
			ts.add(new StudentTwo("AK47", 10));
			ts.add(new StudentTwo("AK44", 16));
			ts.add(new StudentTwo("AK47", 16));
			ts.add(new StudentTwo("AK47", 10));
			lineSplit();
			sop("�����ţ�" + (ORDER_NUM-1) + "-->" + ORDER_STR 
				+ "\n����TreeSet-->tsʵ�ʱ����StudentԪ�����£�");
			int i = 1;
			for (Iterator<StudentTwo> it = ts.iterator(); it.hasNext(); i++) {
				StudentTwo stut = it.next();
				sop("\t[" + i + "]�ţ�"
					+ "<Student.name = " + stut.getName() + ", "
					+ "Student.age" + stut.getAge() + ">");
			}
		}
		lineSplit();
	}

	public static String orderModel(int orderNum) {
		switch (orderNum) {
		case 1:
		    return "name��������";
		    //break;
		case 2:
			return "age��������";
		default:
			return "Ĭ��hashCode��������";
		}
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

/**
 * StudentTwo.class�ļ��뱾�����ļ�TreeSetComparator.class��ͬһĿ¼
 * ����������ظ�����
 * ����StudentTwo.classδ������Ҳ�����ȥ���˴�ע�ͣ�����
class StudentTwo {
	private int orderNum = 0;
	private String name;
	private int age;
	public StudentTwo() {}
	public StudentTwo(String name, int age) {
		//super();
		this.name = name;
		this.age  = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public int getOrderNum() {
		return this.orderNum ;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
} */

/**
 * StudentTwo����ıȽ������ȽϷ�ʽ[1��2��0]
 * 1.��name��������
 *		   ͬname����age��������
 * 2.��age��������
 *		   ͬage����name��������
 * 3.��name��age�����hashCodeֵ��������
 *		   ���㷽����name.hashCode() + age;
 */
class StudentComparator implements Comparator{
//���ͼ�ǿ�棺class StudentComparator implements Comparator<StudentTwo>
	private static int ORDER_NUM = 0;	//�������Ϊstatic final int
	public StudentComparator() {}
	public StudentComparator(int order_num) {
		//super();
		//���캯��ִ��ʱ��ȷ������ģʽֵ��ORDER_NUM
		StudentComparator.ORDER_NUM = order_num;		//��ΪORDER_NUMΪ��̬�����������Ҫʹ��this
	}
	public static int getOrderNum() {
		return StudentComparator.ORDER_NUM;				//��ΪORDER_NUMΪ��̬�����������Ҫʹ��this
	}
	public void setOrderNum(int order_num) {
		StudentComparator.ORDER_NUM = order_num;
	}
	
    public int compare(Object obj1, Object obj2) {
//���ͼ�ǿ�棺oublic int compare(StudentTwo stut1, StudentTwo stut2)
		if(!(obj1 instanceof StudentTwo)
			|| !(obj2 instanceof StudentTwo)) {
			throw new RuntimeException("�Ƚ϶�����StudentTwo���޷��Ƚϣ�");
		}
		StudentTwo stut1 = (StudentTwo) obj1;
		StudentTwo stut2 = (StudentTwo) obj2;
		switch (StudentComparator.getOrderNum()) {
		case 1:
		    return compareToName(stut1, stut2);
		case 2:
			return compareToAge(stut1, stut2);
		default:
			return compareToDefault(stut1, stut2);
		}
	}

	public int compareToName(StudentTwo stut1, StudentTwo stut2) {
		System.out.println("��" + stut1.getName() + "::" + stut1.getAge()
						   + "......PK......"
						   + "�ȱ�" + stut2.getName() + "::" + stut2.getAge());
		int temp = stut1.getName().compareTo(stut2.getName());
		if (0 != temp) {
		    return temp;
		} else {
			return stut1.getAge() - stut2.getAge();
		}
	}

	public int compareToAge(StudentTwo stut1, StudentTwo stut2) {
		System.out.println("��" + stut1.getName() + "::" + stut1.getAge()
						   + "......PK......"
						   + "�ȱ�" + stut2.getName() + "::" + stut2.getAge());
		int temp = stut1.getAge() - stut2.getAge();
		if (0 != temp) {
		    return temp;
		} else {
			return stut1.getName().compareTo(stut2.getName());
		}
	}

	public int compareToDefault(StudentTwo stut1, StudentTwo stut2) {
		/**
		 * StudentTwo�ಢδ��дhashCode()����
		 * �ڱȽ����и���name��age����hashCodeֵ
		 */
		int hashCode1 = hashCode(stut1.getName(), stut1.getAge());
		int hashCode2 = hashCode(stut2.getName(), stut2.getAge());
		System.out.println("��" + stut1.getName() + "::" + stut1.getAge()
								  + "������ϣֵ����" + hashCode1
						   + "......PK......"
						   + "�ȱ�" + stut2.getName() + "::" + stut2.getAge()
							      + "������ϣֵ����" + hashCode2);
		return hashCode1 - hashCode2;
	}
	
	public int hashCode(String name, int age) {
		return name.hashCode() + age;
	}
}