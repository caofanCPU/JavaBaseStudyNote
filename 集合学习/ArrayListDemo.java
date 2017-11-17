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
//----------------------------/
/*ArrayListDemo.java���н����
---------------------------
10���������������ɵ�ArrayList-->af��ʼ��Ϊ::
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
�����¡��ArrayList-->af������Ԫ��Ϊ:
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8, 5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
---------------------------
ȥ��ǰArrayList-->af������Ԫ��Ϊ:
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8, 5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
ȥ�غ�ArrayList-->af������Ԫ��Ϊ:
	[5, 2, 1, 6, 10, 4, 8]
�밴���������. . .
*/

/*ȥ��ArrayList�е��ظ�Ԫ��*/

import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList af = new ArrayList();
        //���Ԫ�أ�ʹ��Math.random()����[0.0��1.0)�ľ��ȷֲ������
        //			��af�����10��Integer����
        for (int i = 10; i > 0; i--) {
            //ʹ�ü̳���Collection��.add(element)�������Ԫ��
            af.add((int) (Math.random() * 10) + 1);
        }
        lineSplit();
        sop("10���������������ɵ�ArrayList-->af��ʼ��Ϊ::\n\t" + af);
        //ʹ�ü̳���Coletion��.addAll(����)�������������
        af.addAll(af);
        sop("�����¡��ArrayList-->af������Ԫ��Ϊ:\n\t" + af);
        lineSplit();
        af = noRepeatElement(af);
        sop("ȥ�غ�ArrayList-->af������Ԫ��Ϊ:\n\t" + af);
    }

    public static ArrayList noRepeatElement(ArrayList af) {
        ArrayList newAf = new ArrayList();
        sop("ȥ��ǰArrayList-->af������Ԫ��Ϊ:\n\t" + af);
        //forѭ���ڲ�����ListIterator������ait
        //			 ait.hasNext()�ж��Ƿ�ǰ����Ԫ���Ƿ�Ϊ��ĩ��һ��Ԫ��null
        for (ListIterator ait = af.listIterator(); ait.hasNext(); ) {
            //ʹ�ü̳���Collection��.contains()�����ж��Ƿ����Ԫ��
            //			ListIterator������ait.next()��������ȡ��ǰԪ�أ�����ָ�������һ����������
            if (!newAf.contains(ait.next())) {
                //ʹ��ListIterator������ait.previous()���з�����ָ������ǰҪ��ȡ�Ķ���
                newAf.add(ait.previous());
                //��Ӻ󣬽�ָ�뻹ԭ����һ��Ҫ�����Ķ���
                ait.next();
            }
        }
        return newAf;
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }

    public static void sopt(Object obj) {
        System.out.print(obj);
    }

    public static void lineSplit() {
        sop("---------------------------");
    }
}
