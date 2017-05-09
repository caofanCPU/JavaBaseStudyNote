
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
/*TreeSetTest2.java���н����
---------------------------
��AK47::10......PK......�ȱ�AK47::10
��AK44::16......PK......�ȱ�AK47::10
��AK47::16......PK......�ȱ�AK47::10
��AK47::10......PK......�ȱ�AK47::10
����TreeSet-->ts��ʵ�ʴ洢��Ԫ���������£�
Name = AK44, Age = 16
Name = AK47, Age = 10
Name = AK47, Age = 16
---------------------------
�밴���������. . .

*/

import java.util.*;
class TreeSetTest2 {
	public static void main(String[] args) {
		/* TreeSetTest2.java�ļ�������⣺
		*  StudentTwo��������δ�趨�ȽϹ�����ʹ�䰴��name��������
		*/
		TreeSet ts = new TreeSet(new StudentComparator());
		lineSplit();
		ts.add(new StudentTwo("AK47", 10));
		ts.add(new StudentTwo("AK44", 16));
		ts.add(new StudentTwo("AK47", 16));
		ts.add(new StudentTwo("AK47", 10));
		sop("����TreeSet-->ts��ʵ�ʴ洢��Ԫ���������£�");
		for(Iterator<StudentTwo> it = ts.iterator(); it.hasNext();) {
			StudentTwo stut = it.next();
			sop("Name = " + stut.getName() + ", "
				+ "Age = " + stut.getAge());
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
}

/**
 * StudentTwo����ıȽ���
 * ��name��������
 * ͬname����age��������
 */
class StudentComparator implements Comparator{
    public int compare(Object obj1, Object obj2) {
		StudentTwo stut1 = (StudentTwo) obj1;
		StudentTwo stut2 = (StudentTwo) obj2;
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
}