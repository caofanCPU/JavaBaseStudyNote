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
/*TreeSetDemo.java���н����
---------------------------
����TreeSet-->ts��Ԫ������Ϊ::
        [1��] = 5,  [2��] = 10,  [3��] = 7,  [4��] = 1,  [5 ��] = 7,
		[6��] = 1,  [7��] = 9,  [8��] = 9,  [9��] = 5,  [10��] = 2
---------------------------
ʵ�ʴ���TreeSet-->ts������Ԫ��::
        {1,  2,  5,  7,  9,  10}
---------------------------
�밴���������. . .
*/

import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo {
    public static void main(String[] args) {
        /* TreeSetDemo.java�ļ�������⣺
		*  �Զ��˵������ظ����󣬲�������Ȼ����洢�Լ����Ԫ��
		*/
        TreeSet ts = new TreeSet();
		/* ����1(��)~10(��)��10���������
		*  int[LENGTH]�������TreeSet-->ts��˳��
		*/
        final int LENGTH = 10;
        int[] num = new int[LENGTH];
        lineSplit();
        sopt("����TreeSet-->ts��Ԫ������Ϊ::\n\t");
        for (int i = 0; i < LENGTH; i++) {
            num[i] = (int) (Math.random() * 10 + 1);
            sopt("[" + (i + 1) + "��] = " + num[i]);
            if ((LENGTH - 1) != i) {
                sopt(",  ");
            } else {
                sopt("\n");
            }
            ts.add(num[i]);        //���û����������͵��Զ�װ������
        }
        lineSplit();
        sopt("ʵ�ʴ���TreeSet-->ts������Ԫ��::\n\t{");
        if (!ts.isEmpty()) {    //���TreeSet�ǿգ���ôһ��������ʹ��.next()��ʹ��.hasNext()
            for (Iterator<Integer> it = ts.iterator(); ; ) {
                sopt(it.next());
                if (it.hasNext()) {
                    sopt(",  ");
                } else {
                    sopt("}\n");
                    break;    //������ϣ�����forѭ��
                }
            }
        }

        lineSplit();
    }

    public static void sop(Object obj) {
		/* ��ӡ�ַ���
		*  ������
		*/
        System.out.println(obj);
    }

    public static void sopt(Object obj) {
		/* ��ӡ�ַ���
		*  ��������
		*/
        System.out.print(obj);
    }

    public static void lineSplit() {
		/* ��ӡ�ָ���
		*  
		*/
        sop("---------------------------");
    }

}
