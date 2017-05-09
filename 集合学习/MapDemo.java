
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
		��ListIterator<E>��listInterator()����ȡ�����ظ�List�����Ԫ������<E>�ĵ���������														   ͨ������һ���Ƚ����࣬�����name��age��hashCodeֵ3�ֵ�������
											(ֵ��ע����ǣ��Ƚ����о�̬����ORDER_NUM�;�̬getOrderName����)
set���䷽����Collectionһ��
		->>Map���洢<K,V>��ֵ�ԣ���֤����Ψһ�ԣ�����һ����ֻ����һ��ֵ
				������HashTable�������Ϊnull��Ҳ������ֵΪnull��
				������HashMap��TreeMap�����Ϊ��(null)��Ҳ����ֵΪ��(null)
			Map���Ϲ��Է�����
			1.���
				  ��V��    .put(K key, V value)��������ǰ��key��ֵvalue����һ����ӷ��ص���null
				  ��void�� .putAll(Map<? extends K, ? extends V> m)
			2.ɾ��
				  ��void�� .clear(�ղ�)
				  ��V��    .remove(Object key)�������Ƴ���key��ֵ
			3.�ж�
				  ��boolean��  .containsValue(Object Value)
				  ��boolean��  .containsKey(Object key)
				  ��boolean��  .isEmpty()
			4.��ȡ
				  ��V��            .get(Object key)����ȡ��key��ֵvalue
				  ��int��          .size()����ȡMap���ϵĳ���
				  ��Collection<V>��.values()����ȡMap�������е�ֵ(���ɵļ���)
			��Ҫ������Set<Map.Entry<K, V>>��.entrySet()������Map�ġ�ӳ���ϵ��
			��Ҫ������Set<K>��              .keySet()�����ؼ�key��Set����
			.entrySet() <==> .keySet() + ѭ����.get(Object key)
			|-- HashTable���ײ����ݽṹ�ǹ�ϣ�������Դ���ռ��������Դ����ֵ
						   HashTable���߳�ͬ���ģ�Ч�ʵ�
			|-- HashMap���ײ����ݽṹ�ǹ�ϣ�����HashTableʹ��
						 HashMap���̲߳�ͬ���ģ�Ч�ʸ�
			|-- TreeMap���ײ����ݽṹ�Ƕ�����(�����)
						 TreeMap���Խ�������


*/
//----------------------------/
/*MapDemo.java���н����
---------------------------
����Mapȫ�����Է�����ϰ����MapDemp.java
-------����ȫ��OK--------
---------------------------
��һ�δ����GG��ֵ(����)value = null
�ٴδ����GG��ֵ(����)value = 555
---------------------------
��keyΪA������true
��keyΪD������false
ֵvalueΪ23������false
ֵvalueΪ20������true
---------------------------
δ����ǰmap���ϵĳ���Ϊ��7
�����¡��ֳ��map���ϵĳ���Ϊ��7
---------------------------
map���ϵ�ֵ(����)�ļ���Ϊ��[24, 20, 666, 8, 22, 20, 7]
---------------------------
��null��map�����е�ֵ��24
��A666��map�����е�ֵ��null
---------------------------
����ʱmap���ϵĳ���Ϊ��7
ʹ��Map.keySet()->Set��������������ȡ���Ķ���
��ʹ��Map.get(Object key)����->ѭ������map���ϣ�
��[1]��:  <��key = null, ֵvalue = 24>
��[2]��:  <��key = Dd, ֵvalue = 20>
��[3]��:  <��key = GG, ֵvalue = 666>
��[4]��:  <��key = ����, ֵvalue = 8>
��[5]��:  <��key = A, ֵvalue = 22>
��[6]��:  <��key = B, ֵvalue = 20>
��[7]��:  <��key = ��ɽ, ֵvalue = 7>
---------------------------
����ʱmap���ϵĳ���Ϊ��7
ʹ��Map.entrySet()->Map.Entry<String, Integer>��������������ȡ��ֵ��ϵ�Ķ���
��ʹ�ù�ϵ��������з���.getKey() + .getValue()->ѭ������map���ϣ�
��[1]��:  <��key = null, ֵvalue = 24>
��[2]��:  <��key = Dd, ֵvalue = 20>
��[3]��:  <��key = GG, ֵvalue = 666>
��[4]��:  <��key = ����, ֵvalue = 8>
��[5]��:  <��key = A, ֵvalue = 22>
��[6]��:  <��key = B, ֵvalue = 20>
��[7]��:  <��key = ��ɽ, ֵvalue = 7>
---------------------------
��Ҫ��ɾ���ļ�key��ɽ��ֵvalue = 7
����clear������map����Ϊ�գ�true
---------------------------
�밴���������. . .
*/
import java.util.*;
class MapDemo {
	public static void main(String[] args) {
		/* MapDemo.java�ļ�������⣺
		 * ��ϰMap�Ĺ��Է���
		 */
		lineSplit();
		sop("����Mapȫ�����Է�����ϰ����MapDemp.java"
			+ "\n-------����ȫ��OK--------");
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> mapTwo = new HashMap<String, Integer>();
		//1.���Ԫ��.put(K key,V value)��������ǰ��key��ֵ(����)value
		mapTwo.put("��ɽ", 7);
		mapTwo.put("����", 8);
		//1.���map����
		map.putAll(mapTwo);
		map.put("A", 22);
		map.put("B", 20);
		map.put(null, 24);
		map.put("Dd", 20);
		lineSplit();
		//sop("ssss..." + (new Integer(5)));
		sop("��һ�δ����GG��ֵ(����)value = " + map.put("GG", new Integer(555)));
		sop("�ٴδ����GG��ֵ(����)value = " + map.put("GG", 666));
		lineSplit();
		//3.�жϼ��Ƿ����.containsKey(Object key)
		sop("��keyΪA������" + map.containsKey("A")
			+ "\n��keyΪD������" + map.containsKey("D"));
		//3.�ж�ֵ�Ƿ����.containsValue(V value)
		sop("ֵvalueΪ23������" + map.containsValue(23)
			+ "\nֵvalueΪ20������" + map.containsValue(20));
		lineSplit();
		//4.��ȡMap���ϵĳ���.size()
		sop("δ����ǰmap���ϵĳ���Ϊ��" + map.size());
		//1.���map����
		map.putAll(map);	//����Map���ϱ��뱣֤����Ψһ�ԣ����������ֳ�õ��Ľ���ȼ��ڿղ���
		sop("�����¡��ֳ��map���ϵĳ���Ϊ��" + map.size());
		lineSplit();
		//4.��ȡmap���ϵ�ֵ�ļ���.values()
		Collection mapVc = map.values();
		sop("map���ϵ�ֵ(����)�ļ���Ϊ��" + mapVc);
		lineSplit();
		//4.��ȡ��key��map�����е�ֵ.get(Object key)�����ؼ���ֵvalue
		sop("��null��map�����е�ֵ��" + map.get(null)
			 + "\n��A666��map�����е�ֵ��" + map.get("A666"));
		lineSplit();
		sop("����ʱmap���ϵĳ���Ϊ��" + map.size());
		sop("ʹ��Map.keySet()->Set��������������ȡ���Ķ���"
			+ "\n��ʹ��Map.get(Object key)����->ѭ������map���ϣ�");
		int i = 1;
		/**
		 * map.keySet()���ص��Ǽ�key��һ����������Set  
		 * Set�ǽӿڣ�������hashSet��TreeSet���е�����Iterator
		 * HashSet s = map.keySet();
		 */
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); i++) {
		    String str = it.next();
			sop("��[" + i +"]��:  " + "<��key = " + str + ", "
			    + "ֵvalue = " + map.get(str) + ">");
		}
		lineSplit();
		sop("����ʱmap���ϵĳ���Ϊ��" + map.size());
		sop("ʹ��Map.entrySet()->Map.Entry<String, Integer>��������������ȡ��ֵ��ϵ�Ķ���"
			+ "\n��ʹ�ù�ϵ��������з���.getKey() + .getValue()->ѭ������map���ϣ�");
		i = 1;
		/**
		 * Map.entrySet()������Set<Map.Entry<K, V>>��һ�������˼�ֵ��ϵ������
		 * Set�ǽӿڣ�������HashSet��TreeSet���е�����Iterator
		 * HashSet<String, Integer> = Map.keySet()
		 */
		/**
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = entrySet.iterator(); it.hasNext(); i++) {
		    Map.Entry<String, Integer> me = it.next();	//��ȡ��ϵ����
			sop("��[" + i +"]��:  " + "<��key = " + me.getKey() + ", "
			    + "ֵvalue = " + me.getValue() + ">");
		}
		 */
		//�򻯼�ǿ��
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); i++) {
			Map.Entry<String, Integer> me = it.next();		//������ȡ��ϵ����
			sop("��[" + i +"]��:  " + "<��key = " + me.getKey() + ", "
			    + "ֵvalue = " + me.getValue() + ">");
		}
		lineSplit();
		//2.ɾ����key�Լ�����ֵvalue
		sop("��Ҫ��ɾ���ļ�key��ɽ��ֵvalue = " + map.remove("��ɽ"));
		//2.���map����.clear()
		map.clear();
		//3.�ж�map�����Ƿ�Ϊ��
		sop("����clear������map����Ϊ�գ�" +map.isEmpty());
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* ��ӡ�ַ���
		*  
		*/
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* ��ӡ�ַ���
		*  
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

/**
 * ����Map.Entry<String, Integer>���ڲ�ʵ��ԭ��
Ƕ�׽ӿڣ�
	interface Map {
		public static interface Entry {
			public abstract Object getKey();
			public abstract Object getValue();
		}
	}

	class HashMap implements Map {
		class HashMapEntry implements Map.Entry {
			public Object getKey() {
				
			}
			public Object getValue() {
			
			}
		}

	}
�ⲿ��CAʵ���ⲿ�ӿ�IA���ڲ���CBʵ���ڲ�������̬�ӿ�IB
�ڲ��ࣺCA.CB		�ڲ����ļ���ʽCA$CB
�ڲ��ӿڣ�IA.IB		�ڲ��ӿ��ļ���ʽIA$IB
Ϊ��Ҫ��Map�ڲ�����Map.Entry�ӿڣ�
��Ϊ����Map���ϣ�����Map.Entry��ϵ������Map.Entry��Map���ڲ����
���⣬�ڲ��ӿڿ���ֱ�ӷ����ⲿ�ӿڣ�����Ϊstatic��
����������Ϊ���Լ�static���η�������Map.Entry��Map���ڲ���Ա
 */