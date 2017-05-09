
/*
������ϵ��Collection���洢���Ƕ��������
			|-- List��Ԫ��ʱ����ģ�Ԫ�ؿ����ظ�
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
			|-- Set��Ԫ��������ģ�Ԫ�ز������ظ�
				|-- HashSet
				|-- TreeSet
		��Map
			|-- HashTable
			|-- HashMap
			|-- TreeMap
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
*/
//---------------------------/
/*LinkedListDemo���н����
---------------------------
---------------------------
LinkedList-->ass��������10��ǰ12�ں�::��ͷԪ��->10����ĩԪ��<-12
---------------------------
LinkedList-->ass���������Ƴ���ͷ��::��ͷԪ��->12����ĩԪ��<-12
---------------------------
LinkedList-->ass�����������Ƴ���ͷ��::��ͷԪ��->null����ĩԪ��<-null
---------------------------
---------------------------
LinkedList-->assԭʼ����::��ͷԪ��->6����ĩԪ��<-4
---------------------------
LinkedList-->assԭʼ�����롾���С�˳��[4, 5, 3, 6]
LinkedList-->assԭʼ����������С�˳��[4, 5, 3, 6]
LinkedList-->assԭʼ����������С���Ϊ��::true
---------------------------
ʹ��ѹջ�����ָ�LinkedList-->assԭʼ����::��ͷԪ��->6����ĩ Ԫ��<-4
---------------------------
LinkedList-->assԭʼ�����롾ջ��˳��[4, 5, 3, 6]
LinkedList-->assԭʼ�������ջ��˳��[6, 3, 5, 4]
LinkedList-->assԭʼ�������ջ����Ϊ��::true
---------------------------
�밴���������. . .
*/
import java.util.*;
class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList ass = new LinkedList();
		//1.���Ԫ�أ���ͷָ�򣺡�boolean��.offerFirst()
		//  ���Ԫ�أ���ĩָ�򣺡�boolean��.offerLast()
		//ʹ�ü̳�Collection��add()�������Ԫ�أ�������ӵ�Ϊ��ͷԪ��
		//										 �����ӵ�Ϊ��ĩԪ��
		lineSplit();
		lineSplit();
		ass.add(10);
		ass.add(12);
		sop("LinkedList-->ass��������10��ǰ12�ں�::"
			+ "��ͷԪ��->" + ass.peekFirst()
			+ "����ĩԪ��<-" + ass.peekLast());
		lineSplit();
		ass.remove();	//�Ƴ���ͷ
		sop("LinkedList-->ass���������Ƴ���ͷ��::"
			+ "��ͷԪ��->" + ass.peekFirst()
			+ "����ĩԪ��<-" + ass.peekLast());
		lineSplit();
		ass.remove();	//���Ƴ���ͷ
		sop("LinkedList-->ass�����������Ƴ���ͷ��::"
			+ "��ͷԪ��->" + ass.peekFirst()
			+ "����ĩԪ��<-" + ass.peekLast());
		lineSplit();
		ass.offerFirst(4);
		ass.offerFirst(new Integer(5));
		ass.offerFirst(3);
		ass.offerFirst(6);
		lineSplit();
		//2.��ȡ��ͷԪ�أ����ı�LinkedList����E��.peekFirst()
		//  ��ȡ��ĩԪ�أ����ı�LinkedList����E��.peekLast()
		sop("LinkedList-->assԭʼ����::"
			+ "��ͷԪ��->" + ass.peekFirst()
			+ "����ĩԪ��<-" + ass.peekLast());
		//ִ�ж������Զ���API����
		duiLie(ass);
		//3.�ж�LinkedList�Ƿ�Ϊ�գ����Ǽ̳���Colletion�ķ���
		sop("LinkedList-->assԭʼ����������С���Ϊ��::" + ass.isEmpty());
		lineSplit();
		//4.ѹջ���Ԫ�أ�
		ass.push(4);	//ջ��Ϊ��ĩ
		ass.push(5);
		ass.push(3);
		ass.push(6);	//ջ��Ϊ��ͷ
		sop("ʹ��ѹջ�����ָ�LinkedList-->assԭʼ����::"
			+ "��ͷԪ��->" + ass.peekFirst()
			+ "����ĩԪ��<-" + ass.peekLast());
		zhan(ass);
		sop("LinkedList-->assԭʼ�������ջ����Ϊ��::" + ass.isEmpty());
		lineSplit();
	}
	public static void duiLie(LinkedList ass) {
		lineSplit();
		//����е�˳��Ӧ����4,5,3,6������LinkedList-->ass�洢��˳����6,3,4,5
		//ʹ��Collections.reverse(ass)���з�ת��������ٷ�תass��ԭΪ�洢˳��
		Collections.reverse(ass);
		sop("LinkedList-->assԭʼ�����롾���С�˳��" + ass);
		Collections.reverse(ass);
		System.out.print("LinkedList-->assԭʼ����������С�˳��[");
		while(!ass.isEmpty()) {
			System.out.print(ass.pollLast());
			if(0 != ass.size()) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
		//lineSplit();
	}

	public static void zhan(LinkedList ass) {
		lineSplit();
		Collections.reverse(ass);
		sop("LinkedList-->assԭʼ�����롾ջ��˳��" + ass);
		Collections.reverse(ass);
		System.out.print("LinkedList-->assԭʼ�������ջ��˳��[");
		while(!ass.isEmpty()) {
			System.out.print(ass.pop());
			if(0 != ass.size()) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
		//lineSplit();
	}


	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}
