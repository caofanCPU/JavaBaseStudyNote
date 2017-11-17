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
/*TreeSetTest.java���н����
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
a::10......PK......a::10
b::11......PK......a::10
b::12......PK......a::10
b::12......PK......b::11
a::13......PK......b::11
a::13......PK......a::10
d::14......PK......b::11
d::14......PK......b::12
---------------------------
�����ţ�0-->name��������
����TreeSet-->tsʵ�ʱ����Student Ԫ�����£�
        [1]�ţ�<Student.name = a, Student.age10>
        [2]�ţ�<Student.name = a, Student.age13>
        [3]�ţ�<Student.name = b, Student.age11>
        [4]�ţ�<Student.name = b, Student.age12>
        [5]�ţ�<Student.name = d, Student.age14>
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
a::10......PK......b::11
a::10......PK......a::10
b::11......PK......b::11
b::12......PK......b::11
b::12......PK......b::12
a::13......PK......b::11
a::13......PK......b::12
a::13......PK......d::14
d::14......PK......b::11
d::14......PK......a::13
d::14......PK......d::14
---------------------------
�����ţ�1-->age��������
����TreeSet-->tsʵ�ʱ����StudentԪ�����£�
        [1]�ţ�<Student.name = a, Student.age10>
        [2]�ţ�<Student.name = a, Student.age13>
        [3]�ţ�<Student.name = b, Student.age11>
        [4]�ţ�<Student.name = b, Student.age12>
        [5]�ţ�<Student.name = a, Student.age13>
        [6]�ţ�<Student.name = d, Student.age14>
---------------------------
����TreeSet-->ts���Ԫ�ع����������£�
a::10......PK......b::11
a::10......PK......a::10
b::11......PK......b::11
b::12......PK......b::11
b::12......PK......a::13
a::13......PK......b::11
a::13......PK......a::13
d::14......PK......b::11
d::14......PK......a::13
d::14......PK......d::14
---------------------------
�����ţ�2-->Ĭ��hashCode��������
����TreeSet-->tsʵ�ʱ����StudentԪ�����£�
        [1]�ţ�<Student.name = a, Student.age10>
        [2]�ţ�<Student.name = a, Student.age13>
        [3]�ţ�<Student.name = b, Student.age11>
        [4]�ţ�<Student.name = b, Student.age12>
        [5]�ţ�<Student.name = a, Student.age13>
        [6]�ţ�<Student.name = d, Student.age14>
---------------------------
�밴���������. . .
*/

import java.util.Iterator;
import java.util.TreeSet;

class TreeSetTest {
    public static void main(String[] args) {
        /* TreeSetTest.java�ļ�������⣺
		*  ��TreeSet�д洢ѧ������
		*		�Զ��˵���ͬname��ageѧ��
		*		��������������
		*/

        //���Դ����/////////////////////////////////////////
        int ORDER_NUM = 0;
        String ORDER_STR = "Ĭ��hashCode��������";
        TreeSet ts = new TreeSet();
        while ((ORDER_NUM++) != 3) {
            ORDER_STR = orderModel(ORDER_NUM);
            lineSplit();
            sop("����TreeSet-->ts���Ԫ�ع����������£�");
            ts.add(new Student("a", 10, ORDER_NUM));
            ts.add(new Student("b", 11, ORDER_NUM));
            ts.add(new Student("b", 12, ORDER_NUM));
            ts.add(new Student("a", 13, ORDER_NUM));
            ts.add(new Student("d", 14, ORDER_NUM));
            lineSplit();
            sop("�����ţ�" + (ORDER_NUM - 1) + "-->" + ORDER_STR
                    + "\n����TreeSet-->tsʵ�ʱ����StudentԪ�����£�");
            int i = 1;
            for (Iterator<Student> it = ts.iterator(); it.hasNext(); i++) {
                Student stu = it.next();
                sop("\t[" + i + "]�ţ�"
                        + "<Student.name = " + stu.getName() + ", "
                        + "Student.age" + stu.getAge() + ">");
            }
        }
        lineSplit();
        //////////////////////////////////////////////////////

/*		TreeSet ts = new TreeSet();
		//final int ORDER_NUM = 0;
		ts.add(new Student("a", 10, ORDER_NUM));
		ts.add(new Student("b", 11, ORDER_NUM));
		ts.add(new Student("b", 12, ORDER_NUM));
		ts.add(new Student("a", 13, ORDER_NUM));
		ts.add(new Student("d", 14, ORDER_NUM));
		lineSplit();
		sop("�����ţ�" + ORDER_NUM + "-->" + ORDER_STR 
			+ "����TreeSet-->tsʵ�ʱ����StudentԪ�����£�");
		int i = 1;
		for (Iterator<Student> it = ts.iterator(); it.hasNext(); i++) {
		    Student stu = it.next();
			sop("\t[" + i + "]�ţ�"
			    + "<Student.name = " + stu.getName() + ", "
				+ "Student.age" + stu.getAge() + ">");
		}
		lineSplit();*/
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
}

/**
 * Studentʵ��Comparable�ӿڣ�ʹ�þ߱��Ƚ���
 */
class Student implements Comparable {
    private int orderNum = 0;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age, int orderNum) {
        //super();
        this.name = name;
        this.age = age;
		/* ǿ����������ģʽ�Ĵ���ֵ
		*  1.name��Ȼ(����)����
		*  2.age��Ȼ(����)����
		*  0.Ĭ��(����Person��hashCodeֵ)����
		*/
        if ((1 != orderNum) &&
                (2 != orderNum)) {
            this.orderNum = 0;
        } else {
            this.orderNum = orderNum;
        }
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
        return this.orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /* ʵ��Comparable�ӿ�
    *  ������г���public int compareTo()�ľ���ʵ��
    *  ����ʽ��ordernum :[0��1��2]
    *  1.name��������
    *  2.age��������
    *  0.Ĭ��hashCodeֵ��������
    */
    public int compareTo(Object obj) {
		/*if (!(obj instanceof Student)) {
		    throw new RuntimeException("����Student�����޷��Ƚ�!");
		}
		Student stu = (Student)obj;
		System.out.println(this.getName() + "::" + this.getAge()
						   + "......PK......"
						   + stu.getName() + "::" + stu.getAge());
		if (this.getAge() != stu.getAge()) {
		    return this.getAge() - stu.getAge();
		} else {
			if (this.getName() != stu.getName()) {
				return this.getName().equals(stu.getName()) ? 1:-1;
			} else {
				return 0;
			}
		}*/

        if (!(obj instanceof Student)) {
            throw new RuntimeException("����Student�����޷��Ƚ�!");
        }
        Student stu = (Student) obj;
        switch (orderNum) {
            case 1:
                return compareToName(stu);
            //break;
            case 2:
                return compareToAge(stu);
            //break;
            default:
                return compareToDefault(stu);
        }
    }

    public int compareToName(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("����Student�����޷��Ƚ�!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        int temp = this.getName().compareTo(stu.getName());
        if (0 != temp) {
            return temp;
        } else {
            return this.getAge() - stu.getAge();
        }
    }

    public int compareToAge(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("����Student�����޷��Ƚ�!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        int temp = this.getAge() - stu.getAge();
        if (0 != temp) {
            return temp;
        } else {
            return this.getName().compareTo(stu.getName());
        }
    }

    public int compareToDefault(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("����Student�����޷��Ƚ�!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        return this.hashCode() - stu.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            //�����飺return false;
            throw new RuntimeException("�Ƚ϶�����Student���������壡");
        }
        //Person�̳�Object�����obj��������ת��
        //���obj������ת��ΪPerson������objû��name��age����
        Student stu = (Student) obj;
        //nameΪ�ַ���������Ĭ�ϼ̳���Object��.equals(Object)����
        //�ַ�����.equal(Object obj)�������ڣ���������ָ���������������������
        return (this.name.equals(stu.name))
                && (this.age == stu.age);
    }

    public int hashCode() {
		/* this.nameΪString����String.hashCode()��String��������Ψһ����
		*  �ݴˣ�Person�����name��ageҲ��Ψһ������hashCode()����ֵ
		*/
        return (this.name.hashCode() + age);
    }

}