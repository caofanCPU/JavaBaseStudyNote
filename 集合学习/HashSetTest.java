
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
/*HashSetTest.java���н����
---------------------------
HashSet-->hs��Ԫ�ظ���Ϊ::4
����ģ����ӡ��ظ���Ԫ�ز�����
        �ظ�Ԫ��(��ɽ��15)��ӳɹ��𣺣�false
        �ظ�Ԫ��(��ɽ��16)��ӳɹ��𣺣�false
        �ظ�Ԫ��(��ɽ��17)��ӳɹ��𣺣�false
        �ظ�Ԫ��(��ɽ��30)��ӳɹ��𣺣�true
---------------------------
���Ԫ�غ�HashSet-->hs��Ԫ�ظ���Ϊ::5
---------------------------
ʵ�ʱ����HashSet-->hs����Ԫ��Ϊ��
        Ԫ��Person@be16f<name = ��ɽ, age = 30>
        Ԫ��Person@be163<name = ��ɽ, age = 18>
        Ԫ��Person@be162<name = ��ɽ, age = 17>
        Ԫ��Person@be161<name = ��ɽ, age = 16>
        Ԫ��Person@be160<name = ��ɽ, age = 15>
---------------------------
�밴���������. . .
*/

import java.util.*;
class HashSetTest {
	/* ʹ��HashSet�洢Person���󣬰���(name��age)��֤��Ψһ��
	*  �����൱����һ��ArrayListDemo2.java���������
	*/

	public static void main(String[] args) {
		/* Person.class�뱾�ļ�ͬĿ¼�����Ѿ���д��.hashCode()��.equals(Object obj)����
		*  ͨ��new Person(String name, int age)�½�Person����
		*  ʹ�÷���<Person>�޶�����ֻ����Person����
		*/
		HashSet<Person> hs = new HashSet<Person>();
		/* �����("��ɽ", 15/16/17)���ظ�
		*  ����ȥ�����ظ������
		*/
		hs.add(new Person("��ɽ", 15));
		hs.add(new Person("��ɽ", 16));
		hs.add(new Person("��ɽ", 17));
		hs.add(new Person("��ɽ", 18));
		lineSplit();
		sop("HashSet-->hs��Ԫ�ظ���Ϊ::" + hs.size());
		sop("����ģ����ӡ��ظ���Ԫ�ز�����");
		sop("\t�ظ�Ԫ��(��ɽ��15)��ӳɹ��𣺣�" + hs.add(new Person("��ɽ", 15)));
		sop("\t�ظ�Ԫ��(��ɽ��16)��ӳɹ��𣺣�" + hs.add(new Person("��ɽ", 16)));
		sop("\t�ظ�Ԫ��(��ɽ��17)��ӳɹ��𣺣�" + hs.add(new Person("��ɽ", 17)));
		sop("\t�ظ�Ԫ��(��ɽ��30)��ӳɹ��𣺣�" + hs.add(new Person("��ɽ", 30)));
		lineSplit();
		sop("���Ԫ�غ�HashSet-->hs��Ԫ�ظ���Ϊ::" + hs.size());
		lineSplit();
		sop("ʵ�ʱ����HashSet-->hs����Ԫ��Ϊ��");
		/* ע�⵽Set����ֻ�д�Collection�̳ж�����Iterator������
		*  ������Կ���ʹ��forѭ�����
		*/
		for (Iterator<Person> it = hs.iterator(); it.hasNext(); ) {
		    Person p = it.next();
			sop("\tԪ��" + p
				+ "<name = " + p.getName()
				+ ", age = " + p.getAge() + ">");
		}
		lineSplit();
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}
