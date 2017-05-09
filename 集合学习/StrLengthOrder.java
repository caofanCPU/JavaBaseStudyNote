
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
/*StrLengthOrder.java���н����
---------------------------
��PDD1������4..PK..ǰ��PDD1������4
��PDD2������4..PK..ǰ��PDD1������4
��PDD2������4..PK..ǰ��PDD1������4
��PDD2������4..PK..ǰ��PDD2������4
��PDD3������4..PK..ǰ��PDD2������4
��PDD3������4..PK..ǰ��PDD2������4
��PDD12������5..PK..ǰ��PDD2������4
��PDD12������5..PK..ǰ��PDD2������4
��PDD12������5..PK..ǰ��PDD3������4
��PDD0000������7..PK..ǰ��PDD2������4
��PDD0000������7..PK..ǰ��PDD3������4
��PDD0000������7..PK..ǰ��PDD12������5
---------------------------
����TreeSet-->ts����Ԫ������������£�
��[1]����PDD1, ����4
��[2]����PDD2, ����4
��[3]����PDD2, ����4
��[4]����PDD3, ����4
��[5]����PDD12, ����5
��[6]����PDD0000, ����7
---------------------------
�밴���������. . .
*/
import java.util.*;
class StrLengthOrder {
	public static void main(String[] args) {
		/* StrLengthOrder.java�ļ�������⣺
		 * ��������ַ����������ַ�����������
		 * �漰�������⣬���ȿ���TreeSet�Ķ������ṹ
		 * 1.������Ҫ��ȥ�ء��ģ�����һ������趨����
		 * 2.���ڲ���ȥ�صģ�����Ϊ�����Ԫ��Ӧ���ں���
		 *		 if(����ͬ) reture 1
		 */
		//������һ��Comparator�������ڲ��࣬��Ϊʵ�ֽӿ�Comparatorֻ��Ҫ��дһ�����󷽷�
		TreeSet ts = new TreeSet(new Comparator() {
			public int compare(Object obj1, Object obj2) {
				if(!(obj1 instanceof String)
				   || !(obj2 instanceof String)) {
					throw new RuntimeException("�Ƚ϶������ַ������޷��Ƚϣ�");
				}
				String str1 = (String) obj1;
				String str2 = (String) obj2;
				System.out.println("��" + str1 + "������" + str1.length()
								   + "..PK.."
								   + "ǰ��" + str2 + "������" + str2.length());
				int temp = new Integer(str1.length()).compareTo(new Integer(str2.length()));
				if(0 != temp) {
					return temp;
				} else {
					temp = str1.compareTo(str2);
					if(0 != temp) {
						return temp;
					} else {
						return 1;
					}
				}
			}
		});

		lineSplit();
		ts.add("PDD1");
		ts.add("PDD2");
		ts.add("PDD2");
		ts.add("PDD3");
		ts.add("PDD12");
		ts.add("PDD0000");
		lineSplit();
		sop("����TreeSet-->ts����Ԫ������������£�");
		int i = 0;
		for(Iterator<String> it = ts.iterator(); it.hasNext(); i++) {
			String str = it.next();
			sop("��[" + (i+1) + "]����" + str + ", "
				+ "����" + str.length());
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

/**
class StrLengthComparator implements Comparator {
    public int compare(Object obj1, Object obj2) {
		if(!(obj1 instanceof String)
		   || !(obj2 instanceof String)) {
			throw new RuntimeException("�Ƚ϶������ַ������޷��Ƚϣ�");
		}
		String str1 = (String) obj1;
		String str2 = (String) obj2;
		System.out.println("��" + str1 + "������" + str1.length()
						   + "..PK.."
						   + "ǰ��" + str2 + "������" + str2.length());
		int temp = new Integer(str1.length()).compareTo(new Integer(str2.length()));
		if(0 != temp) {
			return temp;
		} else {
			temp = str1.compareTo(str2);
			if(0 != temp) {
				return temp;
			} else {
				return 1;
			}
		}
	}
}
*/