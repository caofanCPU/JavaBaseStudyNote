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
				|-- HashSet���ײ����ݽṹ�ǹ�ϣ���ж�Ԫ��Ψһ�ķ�ʽ��.hashCode()-->equals.(Object obj)
				|-- TreeSet���ײ����ݽṹ�Ƕ�����(�����)
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
/*HashSetDemo.java���н����
---------------------------
HashSetĬ�Ͽ������������ͬԪ����::false
---------------------------
����HashSet-->hs������Ԫ��::
        java03
        java01
        java00
---------------------------
�밴���������. . .
*/

import java.util.HashSet;
import java.util.Iterator;

class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add("java00");
        hs.add("java01");
        hs.add("java01");
        hs.add("java03");
        lineSplit();
        /* ��Ϊ��ӵ���String����
		*  ��String�����ݶ����ڼ̳�Objectʱ����д��.hashCode()��.equals(Object obj)
		*  String.hashCode()��s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		*  ���(ע�⣡)��������ͬ�Ķ��󷵻ص�hashCodeֵ��ͬ��
		*  Ȼ��HashSetĬ�ϼ���ʹ��.equals(Object obj)����
		*  �����漰���ݵĶ��󣬶����ж�������ͬΪ��
		*  ���ԣ��������"java01"�ظ�����HashSet�Զ�����
		*/
        sop("HashSetĬ�Ͽ������������ͬԪ����::" + hs.add("java00"));
        lineSplit();
        sop("����HashSet-->hs������Ԫ��::");
        for (Iterator<String> it = hs.iterator();
             it.hasNext(); ) {
            sop("\t" + it.next());
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
