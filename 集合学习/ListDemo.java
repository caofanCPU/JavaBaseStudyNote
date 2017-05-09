
/*
������ϵ��Collection���洢���Ƕ��������
			|-- List��Ԫ��ʱ����ģ�Ԫ�ؿ����ظ�
					  List������ϵ������
				|-- ArrayList���ײ�����ݽṹ�����飬�ص㣺��ѯ�ٶȿ죬��ɾ�������̲߳�ͬ��
				|-- LinkedList���ײ�����ݽṹ�������ص㣺��ѯ�ٶ���������ɾ�ܿ죬�̲߳�ͬ��
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
/*ListDemo.java�������н����
---------------------------
ԭ����ArrayList-->as����Ԫ��::[cy05, cy02, cy00, cy05]
---------------------------
����β������һ��Ԫ�غ󣬼���ArrayList-->as����Ԫ��::[520, cy05, cy02, cy00, cy05, 1314]
---------------------------
����ArrayList-->as������2��Ԫ��cy02�޸�ΪA
����ArrayList-->as�޸ĺ������Ԫ��::[520, cy05, A, cy00, cy05, 1314]
---------------------------
ɾ���������һ��Ԫ��:1314
ɾ����ArrayList-->as����Ԫ��::[520, cy05, A, cy00, cy05]
---------------------------
ͨ��������������ArrayList-->as������£�
        ����[0] = 520
        ����[1] = cy05
        ����[2] = A
        ����[3] = cy00
        ����[4] = cy05
---------------------------
ͨ��Iterator������ȥ��������ArrayList-->as������£�
        ����[0] = 520
        ����[1] = cy05
        ����[2] = A
        ����[3] = cy00
        ����[4] = cy05
---------------------------
ʹ��List�Դ���ListIterator��������������as������£�
        520
        cy05
        A
        cy00
        cy05
---------------------------
����as��Ԫ��cy05������Ϊ��1
---------------------------
����as��1(��)����4(����)�Ӽ�����Ԫ��Ϊ��[cy05, A, cy00]
---------------------------
�Լ���ArrayList-->���б���[ɾ��|�޸�]cy05Ԫ��������£�
        ��cy05Ԫ��::520
        ��cy05Ԫ��::cy05
        ��cy05Ԫ��::A
        ��cy05Ԫ��::cy00
        ��cy05Ԫ��::cy05
��cy08�����滻cy05�󣬼���as����Ԫ��[520, cy08, A, cy00, cy08]
---------------------------
�Լ���ArrayList-->���б���[ɾ��|�޸�]cy05Ԫ��������£�
        ��cy05Ԫ��::520
        ��cy05Ԫ��::cy08
        ��cy05Ԫ��::A
        ��cy05Ԫ��::cy00
        ��cy05Ԫ��::cy08
��cy08�����滻cy05�󣬼���as����Ԫ��[520, cy08, A, cy00, cy08]
---------------------------
�밴���������. . .
*/
import java.util.*;
class ListDemo {
	public static void main(String[] args) {
		//����ArrayList����
		ArrayList as = new ArrayList();
		//���Ԫ�ء�boolean��.add(element)
		lineSplit();
		as.add("cy05");
		as.add("cy02");
		as.add("cy00");
		as.add("cy05");
		sop("ԭ����ArrayList-->as����Ԫ��::" + as);
		lineSplit();
		//1.��ָ�����������Ԫ�أ�ע�⣺�ò��붼��"ǰ�����"
		//��List�ײ����룬����Ϊ0����Listβ�����룬����ΪList.size()
		//����void��.add(index, element)
		as.add(0, new Integer(520));
		as.add(as.size(), 1314);
		sop("����β������һ��Ԫ�غ󣬼���ArrayList-->as����Ԫ��::" + as);
		lineSplit();
		//2.�޸�ָ��������Ԫ�أ���E��.set(index, element)
		sop("����ArrayList-->as������2��Ԫ��" + as.set(2, 'A') + "�޸�ΪA");
		sop("����ArrayList-->as�޸ĺ������Ԫ��::" + as);
		lineSplit();
		//3.ɾ��ָ��������������Ԫ�أ���E��.remove(index)
		sop("ɾ���������һ��Ԫ��:" + as.remove(as.size() - 1));
		sop("ɾ����ArrayList-->as����Ԫ��::" + as);
		lineSplit();
		//4.ͨ��������ȡԪ�ء�E��.get(index)
		sop("ͨ��������������ArrayList-->as������£�");
		for(int i = 0; i < as.size(); i++) {
			sop("\t����[" + i + "] = " + as.get(i));
		}
		lineSplit();
		//5.ͨ���̳�Colletion������Iterator��������ȡԪ��
		//��Iterator<E>��.iterator()
		//��boolean��.hasNext()
		//��E��.next()
		sop("ͨ��Iterator������ȥ��������ArrayList-->as������£�");
		int i = 0;
		for(Iterator ai = as.iterator(); ai.hasNext(); i++) {
			sop("\t����[" + i + "] = " + ai.next());
		}
		lineSplit();
		//6.ʹ��List�Դ���ListIterator��������������as
		//��ListIterator<E>��.listIterator()
		//��boolean��.hasNext()
		//��E��.next()
		sop("ʹ��List�Դ���ListIterator��������������as������£�");
		for(ListIterator<Object> ai = as.listIterator(); ai.hasNext(); ) {
			//ע�⣺����ֱ��as.listIterator()���ص���Object����
			//��������������Ҫǿת���ͣ����Կ����޶�<Object>
			sop("\t" +ai.next());
		}
		lineSplit();
		//7.��ȡָ��Ԫ�ص���������int��.indexOf()
		sop("����as��Ԫ��" + as.get(1) + "������Ϊ��" + as.indexOf(as.get(1)));
		lineSplit();
		//��ȡָ��������Χ[fromIndex, toIndex)���ұյ����б�
		//����List<E>��.subList(fromIndex, toIndex)
		sop("����as��1(��)����4(����)�Ӽ�����Ԫ��Ϊ��" + as.subList(1,4));
		lineSplit();
		//8.�ڵ��������У�ʹ��Iterator������"ɾ"����Ԫ�أ�������"��"�����Ƽ�"��"
		//��ΪIterator����������ֻ�ṩ.remove(�ղ�)����
		ArrayList as2 = as;		//����as
		iteratorTest(as);
		sop("��cy08�����滻cy05�󣬼���as����Ԫ��" + as);
		lineSplit();
		//9.�ڵ��������У���Ҫ"������"������ʹ��List���е�����ListIterator
		listIteratorTest(as2);
		sop("��cy08�����滻cy05�󣬼���as����Ԫ��" + as);
		lineSplit();
	}

	public static void iteratorTest(ArrayList as) {
		/*
		��ʾList��Collection�̳ж�����Iterator�������ľ�����
		�ڵ��������У������Ǳ�����������ɾ�Ĳ飬���Ƽ�ʹ��ListIterator������
		*/
		Iterator it = as.iterator();
		sop("�Լ���ArrayList-->���б���[ɾ��|�޸�]cy05Ԫ��������£�");
		while(it.hasNext()) {
			Object obj = it.next();
			if(obj.equals("cy05")) {
				//it.remove();		//���У��Ӽ���as��ɾ�����е�"cy05"
				/*
				as.remove(obj);		//������
				//Exception in thread "main" java.util.ConcurrentModificationException
				*/
				/*
				as.add("cy08");		//������
				//Exception in thread "main" java.util.ConcurrentModificationException
				*/
				as.set(as.indexOf(obj), "cy08");		//���У�������as�����е�"cy05"�滻Ϊ"cy08"
			}
			sop("\t��cy05Ԫ��::" + obj);
		}
	}

	public static void listIteratorTest(ArrayList as) {
		/*
		��ʾList���е�ListIterator�������ı����������������Ƽ�ʹ��ListIterator������
		*/
		ListIterator ait = as.listIterator();
		sop("�Լ���ArrayList-->���б���[ɾ��|�޸�]cy05Ԫ��������£�");
		/*
		while(ait.hasNext()) {
			if(ait.next() == "cy05") {	//.next()��ָ��ָ����һ��Ҫȡ�õ�Ԫ��
				ait.set("cy08");
			}
			sop("\t��cy05Ԫ��::" + ait.previous());		//��ָ��ǰ��Ϊȡ�õĵ�ǰԪ��
			ait.next();		//ָ�뻹ԭΪ����ȡ�õ���һԪ��
		}
		*/
		while(ait.hasNext()) {
			if(ait.next() == "cy05") {
				ait.remove();
				ait.add("cy08");
			}
			sop("\t��cy05Ԫ��::" + ait.previous());
			ait.next();
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}
