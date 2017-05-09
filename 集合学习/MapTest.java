
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
				TreeMap����Ԫ�ص����ַ�ʽ��.keySet()��ʹ���������<Key>��ȡ��key
										    ���������TreeMap�����еļ���һ����compare��ֱ�������null
										  ��.entry()��ʹ���������<Map.Entry<K, V>>��ȡ��key��ֵvalue
										    �������ֵ��������TreeMap������Ԫ�ؽ��бȽϣ�ʵ�ַ�ʽ�ݲ���ϸ

*/
//----------------------------/
/*MapTest.java���н����
---------------------------
HashSet--hs���ϴ洢Ԫ�ع������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��(name = B, id = 18)....PK....�ȱ�(name = B, id = 18)
---------------------------
HashSet-->hs���ϴ洢Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[1]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2227, ����(name = CF, id = 16)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2202, ����(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[3]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 155, ����(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[4]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 156, ����(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[5]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 172, ����(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[6]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2175, ����(name = AA, id = 19)
---------------------------
TreeSet-->ts������Ȼ����洢Ԫ�صĹ������£�
TreeSet-->ts������Ȼ����Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[1]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2227, ����(name = CF, id = 16)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 155, ����(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[3]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 156, ����(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[4]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2202, ����(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[5]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2175, ����(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[6]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 172, ����(name = C, id = 21)
---------------------------
TreeSet-->ts0���Ϲ�ϣֵ����洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
TreeSet-->ts0���Ϲ�ϣֵ����Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 155, ����(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 156, ����(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 172, ����(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2175, ����(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2202, ����(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2227, ����(name = CF, id = 16)
---------------------------
TreeSet-->ts1����name����洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
TreeSet-->ts1����name����Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 155, ����(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 156, ����(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 172, ����(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2175, ����(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2202, ����(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2227, ����(name = CF, id = 16)
---------------------------
TreeSet-->ts2���ϴ洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣ ֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣ ֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣ ֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣ ֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣ ֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
TreeSet-->ts2����id����Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 155, ����(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 156, ����(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 172, ����(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2175, ����(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2202, ����(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�Ԫ�ع�ϣֵhashCode = 2227, ����(name = CF, id = 16)
---------------------------
HashMap--hm���ϴ洢Ԫ�ع������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��(name = B, id = 18)....PK....�ȱ�(name = B, id = 18)
---------------------------
ʹ��Map.keySet()��ʽ��ȡHashMap�洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
---------------------------
ʹ��Map.EntrySet()��ʽ��ȡHashMap�洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
---------------------------
TreeMap-->tm���ϴ洢Ԫ�صĹ������£�
---------------------------
ʹ��Map.Entry<K, V>��ʽ���TreeMap�����е�Ԫ��
TreeMap:��Ȼ����洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
---------------------------
TreeMap-->tm0���ϴ洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
ʹ��Map.Entry<K, V>��ʽ���TreeMap�����е�Ԫ��
TreeMap:��ϣֵ����洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
---------------------------
TreeMap-->tm1���ϴ洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
ʹ��Map.keySet()��ʽ���TreeMap�����е�Ԫ��
TreeMap:name��������洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�B::18������ϣֵ����156
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�AA::19������ϣֵ����2175
(name = C, id = 21)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�C::21������ϣֵ����172
(name = C, id = 21)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�AA::19������ϣֵ����2175
(name = AA, id = 19)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�BB::18������ϣֵ����2202
(name = BB, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�CF::16������ϣֵ����2227
(name = CF, id = 16)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
---------------------------
ʹ��Map.Entry<K,V>��ʽ���TreeMap�����е�Ԫ��
TreeMap:name��������洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
---------------------------
TreeMap-->tm2���ϴ洢Ԫ�صĹ������£�
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��A::18������ϣֵ����155......PK......�ȱ�A::18������ϣֵ����155
(name = A, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�A::18������ϣֵ����155
(name = B, id = 18)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�A::18������ϣֵ����155
(name = C, id = 21)ǰ�������ϣֵ
(name = A, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��C::21������ϣֵ����172......PK......�ȱ�B::18������ϣֵ����156
(name = C, id = 21)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�B::18������ϣֵ����156
(name = AA, id = 19)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��AA::19������ϣֵ����2175......PK......�ȱ�C::21������ϣֵ����172
(name = AA, id = 19)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�B::18������ϣֵ����156
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�C::21������ϣֵ����172
(name = BB, id = 18)ǰ�������ϣֵ
(name = C, id = 21)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��BB::18������ϣֵ����2202......PK......�ȱ�AA::19������ϣֵ����2175
(name = BB, id = 18)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�B::18������ϣֵ����156
(name = CF, id = 16)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�AA::19������ϣֵ����2175
(name = CF, id = 16)ǰ�������ϣֵ
(name = AA, id = 19)ǰ�������ϣֵ
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
��CF::16������ϣֵ����2227......PK......�ȱ�BB::18������ϣֵ����2202
(name = CF, id = 16)ǰ�������ϣֵ
(name = BB, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
��B::18������ϣֵ����156......PK......�ȱ�B::18������ϣֵ����156
(name = B, id = 18)ǰ�������ϣֵ
(name = B, id = 18)ǰ�������ϣֵ
---------------------------
ʹ��Map.Entry<K,V>��ʽ�������Ԫ��
TreeMap:id��������洢��6��Ԫ�����£�
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = A, id = 18)ǰ�������ϣֵ
��[1]��Ԫ�أ�<�� hashCode = 155, ֵ addressString = ����>
        ��(name = A, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = B, id = 18)ǰ�������ϣֵ
��[2]��Ԫ�أ�<�� hashCode = 156, ֵ addressString = NO�人>
        ��(name = B, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = C, id = 21)ǰ�������ϣֵ
��[3]��Ԫ�أ�<�� hashCode = 172, ֵ addressString = ����>
        ��(name = C, id = 21)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = AA, id = 19)ǰ�������ϣֵ
��[4]��Ԫ�أ�<�� hashCode = 2175, ֵ addressString = ����>
        ��(name = AA, id = 19)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = BB, id = 18)ǰ�������ϣֵ
��[5]��Ԫ�أ�<�� hashCode = 2202, ֵ addressString = ����>
        ��(name = BB, id = 18)
(���Զ�����)�����Ԫ��ʱforѭ���������ã�(name = CF, id = 16)ǰ�������ϣֵ
��[6]��Ԫ�أ�<�� hashCode = 2227, ֵ addressString = �ɶ�>
        ��(name = CF, id = 16)
---------------------------
�밴���������. . .
*/

import java.util.*;
class MapTest {
	public static void main(String[] args) {
		/* MapTest.java�ļ�������⣺
		 * ������׼�Ķ�����StandardStudent��name �� id��Ϊ��������
		 * ��������Ȼ����name����id����͹�ϣֵΨһ����ķ�ʽ
		 * ʹ��HashSet��TreeSet���ϴ洢��StandardStudent����(name, id)
		 * ʹ��HashMap��TreeMap�洢��<�� StandardStudent����(name, id), ֵ String>
		 */
		int i = 1;		//��ʶԪ��˳����ŵ�ѭ������		
		lineSplit();

		/**
		 * ʹ��HashSet���ϴ洢StandardStudent����(name, id)
		 * ��ʾHashSet���ϴ洢Ԫ�أ���֤Ԫ��Ψһ�ԵĹ��̣����ȸ���Ԫ�ص�.hashCode()�����ϣֵ
		 * Ԫ�ض���Ĭ��.hashCode()�����������Ԫ�ض���ĵ�ַ����������½�Ԫ�ض������������
		 * ����ϣֵ��ͬ������Ԫ�ص�.equals()���������жϣ�������ͬ���ж�Ϊ�ظ�������
		 * ʹ�÷��͵�������Iterator<StandardStudent> it = Set.iterator()�����������Ԫ��
		 */
		HashSet<StandardStudent> hs = new HashSet<StandardStudent>();
		sop("HashSet--hs���ϴ洢Ԫ�ع������£�");
		hs.add(new StandardStudent("A", 18));
		hs.add(new StandardStudent("B", 18));
		hs.add(new StandardStudent("C", 21));
		hs.add(new StandardStudent("AA", 19));
		hs.add(new StandardStudent("BB", 18));
		hs.add(new StandardStudent("CF", 16));
		hs.add(new StandardStudent("B", 18));
		lineSplit();
		sop("HashSet-->hs���ϴ洢Ԫ�����£�");
		i = 1;
		for (Iterator<StandardStudent> it = hs.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "Ԫ�ع�ϣֵhashCode = " + hashCode + ", "
				+ "����(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		
		/**
		 * ʹ��TreeSet���ϴ洢StandardStudent����(name, id)
		 * ��ʾTreeSet���ϴ洢Ԫ�أ���֤Ԫ��Ψһ�ԵĹ���
		 *		��һ�֣�TreeSet��ʹ�ñȽ�����Ĭ����Ȼ����
		 *				���������׼������������ϣֵ������ʹ�õײ�compare������ѡ������id������name
		 *		�ڶ��֣�TreeSetʹ��StandardStudent�������бȽ���StandardStudentComparator<StandardStudent>
		 *				��ѡ�������ʽ��[0:��ϣֵ����]	[1:name����]	[2:id����]
		 *				��TreeMapĬ����Ȼ����ʽ����ͬ���ǣ��Ƚ������򶼻���ж����.hashCode()���������ϣֵ
		 * TreeSetͨ�����������ʱ������ֱ�����(��TreeMap��Map.keySet()�ظ����㡢�ж����������)
		 * ʹ�÷��͵�������Iterator<StandardStudent> it = Set.iterator()�����������Ԫ��
		 */
		TreeSet<StandardStudent> ts = new TreeSet<StandardStudent>();
		sop("TreeSet-->ts������Ȼ����洢Ԫ�صĹ������£�");
		ts.add(new StandardStudent("A", 18));
		ts.add(new StandardStudent("B", 18));
		ts.add(new StandardStudent("C", 21));
		ts.add(new StandardStudent("AA", 19));
		ts.add(new StandardStudent("BB", 18));
		ts.add(new StandardStudent("CF", 16));
		ts.add(new StandardStudent("B", 18));
		sop("TreeSet-->ts������Ȼ����Ԫ�����£�");
		i = 1;
		for (Iterator<StandardStudent> it = ts.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "Ԫ�ع�ϣֵhashCode = " + hashCode + ", "
				+ "����(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeSet<StandardStudent> ts0 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(0));
		sop("TreeSet-->ts0���Ϲ�ϣֵ����洢Ԫ�صĹ������£�");
		ts0.add(new StandardStudent("A", 18));
		ts0.add(new StandardStudent("B", 18));
		ts0.add(new StandardStudent("C", 21));
		ts0.add(new StandardStudent("AA", 19));
		ts0.add(new StandardStudent("BB", 18));
		ts0.add(new StandardStudent("CF", 16));
		ts0.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts0���Ϲ�ϣֵ����Ԫ�����£�");
		i = 1;
		for (Iterator<StandardStudent> it = ts0.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "Ԫ�ع�ϣֵhashCode = " + hashCode + ", "
				+ "����(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();

		TreeSet<StandardStudent> ts1 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(1));
		sop("TreeSet-->ts1����name����洢Ԫ�صĹ������£�");
		ts1.add(new StandardStudent("A", 18));
		ts1.add(new StandardStudent("B", 18));
		ts1.add(new StandardStudent("C", 21));
		ts1.add(new StandardStudent("AA", 19));
		ts1.add(new StandardStudent("BB", 18));
		ts1.add(new StandardStudent("CF", 16));
		ts1.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts1����name����Ԫ�����£�");
		i = 1;
		for (Iterator<StandardStudent> it = ts1.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "Ԫ�ع�ϣֵhashCode = " + hashCode + ", "
				+ "����(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeSet<StandardStudent> ts2 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(2));
		sop("TreeSet-->ts2���ϴ洢Ԫ�صĹ������£�");
		ts2.add(new StandardStudent("A", 18));
		ts2.add(new StandardStudent("B", 18));
		ts2.add(new StandardStudent("C", 21));
		ts2.add(new StandardStudent("AA", 19));
		ts2.add(new StandardStudent("BB", 18));
		ts2.add(new StandardStudent("CF", 16));
		ts2.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts2����id����Ԫ�����£�");
		i = 1;
		for (Iterator<StandardStudent> it = ts2.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "Ԫ�ع�ϣֵhashCode = " + hashCode + ", "
				+ "����(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		
		/**
		 * ʹ��HashMap�洢<StandardStudent, String>��ϵ����StandardStudent��name��id��������
		 * ʹ��Map.put()������ӹ�ϵ����Ԫ�أ�����֤��[����ͬʱ]���������Ԫ�ػḲ�Ǿ�Ԫ�ص�[ֵ]
		 *	   ͬʱ��Map.put()�����᷵��Ԫ�ر����ǵ�[ֵ]����δ�����ǣ�����null
		 * ʹ��Iterator<StandardStudent> it = Map.keySet().iterator()����ʽ��ȡMap����[��������]������
		 *		 �����ʱ�����ڼ���StandardStudent����ʹ�øö����hashCode()��Ա������ȡ��ϣֵ
		 *		 ��StandardStudent����Ĺ�ϣֵ�����
		 * ʹ��Iterator<Map.Entry<StandardStudent, String>> entry = Map.entry().iterator()����ʽ��ȡMap����[��ϵ]�ĵ�����
		 *		 �����ʱͬ��
		 * ��ʾHashMap�洢��ϵԪ��ʱ�Ĺ��̣����ȸ��ݼ�(StandardStudent����)����.hashCode()���������ϣֵ
		 * ����ϣֵ��ͬ���ٵ���.equals()�����ж�Ԫ���Ƿ��ظ�
		 *
		 * HashMap��HashSet����ϵ������HashSet����HashMapʵ�ֵģ�HashMapֻȡ����ΪHashSet
		 * ���HashMap��HashSet�����Ի������ƣ�����HashMap��������ص㣺
		 * ����HashMap��Map.keySet()��Map.entry()���ַ�ʽ�����ߵ������ǣ�
		 *				Map.keySet()���ݼ�������ٴε���.hashCode()���������ϣֵ
		 *			  ��Map.entry()�����ٴμ����ϣֵ�����Ҫ��Ч��ʵ��Щ
		 */
		HashMap<StandardStudent, String> hm = new HashMap<StandardStudent, String>();
		sop("HashMap--hm���ϴ洢Ԫ�ع������£�");
		hm.put(new StandardStudent("A", 18), "����");
		hm.put(new StandardStudent("B", 18), "�人");
		hm.put(new StandardStudent("C", 21), "����");
		hm.put(new StandardStudent("AA", 19), "����");
		hm.put(new StandardStudent("BB", 18), "����");
		hm.put(new StandardStudent("CF", 16), "�ɶ�");
		hm.put(new StandardStudent("B", 18), "NO�人");		//��ڶ������ظ�
		lineSplit();
		sop("ʹ��Map.keySet()��ʽ��ȡHashMap�洢��" + hm.size() + "��Ԫ�����£�");
		i = 1;
		for(Iterator<StandardStudent> it = hm.keySet().iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + hm.get(stdStu) + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		sop("ʹ��Map.EntrySet()��ʽ��ȡHashMap�洢��" + hm.size() + "��Ԫ�����£�");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = hm.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + me.getValue() + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();

		/**
		 * ʹ��TreeMap�洢<StandardStudent, String>��ϵ����StandardStudent��name��id��������
		 * TreeMap��Ĭ����Ȼ����ͱȽ�������Ĭ����Ȼ���������������ϣֵ�����Ƚ������򶼻�����ϣֵ
		 * TreeMap��TreeSet����ϵ������
		 *			TreeSet�ײ���TreeMapʵ�֣�TreeMapֻȡ����ΪTreeSet
		 *		  ������TreeMap��Map.keySet()��Map.entry()���ַ�ʽ
		 *						 Map.keySet()���ݼ����ٴμ����ϣֵ������һ����compare�������бȽ�
		 *					   ��Map.entry()�򲻻��ٴμ����ϣֵ��Ҳ�������compare������һ�Ƚ�
		 * ����ʹ��StandardStudentComparator�Ƚ������趨��
		 *		   [0:��ϣֵ����]		[1:name����]		[2.id����]
		 * �ֱ𴴽�TreeMpa���ϣ�tm0��tm1��tm2���3������ʽ�Ĳ���
		 * ���⣬����tm1�Ĳ��ԣ������ʱ����Map.keySet()��Map.entry()��ʽ���
		 *	     ���֣�Map.keySet()��ȡ��key��ֵvalueʱ������һ�Ƚ�TreeMap�����еļ��������Զ�����compare(T t1, T t2)����
		 *		     ��Map.entrySet()�򲻻���бȽϣ���ʵ�ַ�ʽ�ݲ���
		 * ʹ��Iterator<StandardStudent> it = Map.keySet().iterator()����ʽ��ȡMap����[��������]������
		 *		 �����ʱ�����ڼ���StandardStudent����ʹ�øö����hashCode()��Ա������ȡ��ϣֵ
		 *		 ��StandardStudent����Ĺ�ϣֵ�����
		 * ʹ��Iterator<Map.Entry<StandardStudent, String>> entry = Map.entry().iterator()����ʽ��ȡMap����[��ϵ]�ĵ�����
		 *		 �����ʱͬ��
		 */
		TreeMap<StandardStudent, String> tm = new TreeMap<StandardStudent, String>();
		sop("TreeMap-->tm���ϴ洢Ԫ�صĹ������£�");
		tm.put(new StandardStudent("A", 18), "����");
		tm.put(new StandardStudent("B", 18), "�人");
		tm.put(new StandardStudent("C", 21), "����");
		tm.put(new StandardStudent("AA", 19), "����");
		tm.put(new StandardStudent("BB", 18), "����");
		tm.put(new StandardStudent("CF", 16), "�ɶ�");
		tm.put(new StandardStudent("B", 18), "NO�人");		//��ڶ������ظ�
		lineSplit();
		sop("ʹ��Map.Entry<K, V>��ʽ���TreeMap�����е�Ԫ��\n"
			+ "TreeMap:��Ȼ����洢��" + tm.size() + "��Ԫ�����£�");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + me.getValue() + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm0 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(0));
		sop("TreeMap-->tm0���ϴ洢Ԫ�صĹ������£�");
		tm0.put(new StandardStudent("A", 18), "����");
		tm0.put(new StandardStudent("B", 18), "�人");
		tm0.put(new StandardStudent("C", 21), "����");
		tm0.put(new StandardStudent("AA", 19), "����");
		tm0.put(new StandardStudent("BB", 18), "����");
		tm0.put(new StandardStudent("CF", 16), "�ɶ�");
		tm0.put(new StandardStudent("B", 18), "NO�人");		//��ڶ������ظ�
		lineSplit();
		sop("ʹ��Map.Entry<K, V>��ʽ���TreeMap�����е�Ԫ��\n"
			+ "TreeMap:��ϣֵ����洢��" + tm0.size() + "��Ԫ�����£�");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm0.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + me.getValue() + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm1 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(1));
		sop("TreeMap-->tm1���ϴ洢Ԫ�صĹ������£�");
		tm1.put(new StandardStudent("A", 18), "����");
		tm1.put(new StandardStudent("B", 18), "�人");
		tm1.put(new StandardStudent("C", 21), "����");
		tm1.put(new StandardStudent("AA", 19), "����");
		tm1.put(new StandardStudent("BB", 18), "����");
		tm1.put(new StandardStudent("CF", 16), "�ɶ�");
		tm1.put(new StandardStudent("B", 18), "NO�人");		//��ڶ������ظ�
		lineSplit();
		sop("ʹ��Map.keySet()��ʽ���TreeMap�����е�Ԫ��\n"
			+ "TreeMap:name��������洢��" + tm1.size() + "��Ԫ�����£�");
		i = 1;
		for(Iterator<StandardStudent> it = tm1.keySet().iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + tm1.get(stdStu) + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		sop("ʹ��Map.Entry<K,V>��ʽ���TreeMap�����е�Ԫ��\n"
			+ "TreeMap:name��������洢��" + tm1.size() + "��Ԫ�����£�");
		i = 1;
		for(Iterator<Map.Entry<StandardStudent, String>> entry = tm1.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + me.getValue() + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm2 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(2));
		sop("TreeMap-->tm2���ϴ洢Ԫ�صĹ������£�");
		tm2.put(new StandardStudent("A", 18), "����");
		tm2.put(new StandardStudent("B", 18), "�人");
		tm2.put(new StandardStudent("C", 21), "����");
		tm2.put(new StandardStudent("AA", 19), "����");
		tm2.put(new StandardStudent("BB", 18), "����");
		tm2.put(new StandardStudent("CF", 16), "�ɶ�");
		tm2.put(new StandardStudent("B", 18), "NO�人");		//��ڶ������ظ�
		lineSplit();
		sop("ʹ��Map.Entry<K,V>��ʽ�������Ԫ��\n"
			+ "TreeMap:id��������洢��" + tm2.size() + "��Ԫ�����£�");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm2.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(���Զ�����)�����Ԫ��ʱforѭ���������ã�");
			int hashCode = stdStu.hashCode();
			sop("��[" + i + "]��Ԫ�أ�" + "<�� hashCode = " + hashCode
				+ ", ֵ addressString = " + me.getValue() + ">"
				+ "\n\t��(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* ��ӡ�ַ���
		 * ������
		 */
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* ��ӡ�ַ���
		 * ��������
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
 * StandardStudent�࣬������Ҫ�߱��Ƚ��ԣ���ʵ��Comparable<StandardStudent>�ӿ�
 * StandardStudent�ఴ���ض��������������Ҫһ�����ุ�༶��ıȽ���Comparator<Father>ʵ��
 * ͬʱ����Ϊ��Ҫ�洢�ܶ������󣬿�����HashSet�洢��Ҳ������TreeSet�洢
 * ��HashSet�洢����Ҫ��д.equals()��hashCode()����
 * ��TreeSet�洢����Ҫ������߱��ɱȽ��Լ�������򣬻��߼ӱȽ���
 * ���ǵ�HashSet��TreeSet��ʽ������HashMap��TreeMap
 * StandardStudent����Ҫ�߱���ϣ��Ͷ������ײ����ݽṹ��Ҫ�ķ���
 * ���Ϊ������ʵ�֣�������д
 */
class StandardStudent implements Comparable<StandardStudent> {
    private String name;
	private int id;
	public StandardStudent() {}
	public StandardStudent(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	/**
	 * ʵ��Comparable<T t>�ӿڣ���Ҫ����public int compareTo(T t)���󷽷�
	 * ����ֵ�ǣ�this.get����������() - t.get����������()���Ǹ�int������
	 * ������������ͬ���Ƚϴ����ӣ��Դ����ƣ�ֱ���������ӵ����ݶ���ͬ���ж�������ͬ
	 * return 0;�Զ������ظ�����
	 *
	 * ��ĳ���Ƚ�����ʵ�ֱȽ���Comparator<T t>��������Ҫ����public int compare(T t1, T t2)
	 */
	public int compareTo(StandardStudent stdStu) {
		int temp = this.getId() - stdStu.getId();
		if (0 != temp) {
		    return temp;
		} else {
			return this.getName().compareTo(stdStu.getName());
		}
	}

	/**
	 * ��������hashCodeֵ�ɶ�����������Ծ���
	 * ������㷽��Ϊ��name.hashCode() + id * 50;
	 */
	public int hashCode() {
		System.out.println("(name = " + this.getName() + ", "
						   + "id = " +this.getId() + ")ǰ�������ϣֵ");
		return this.getName().hashCode() + this.getId() * 5;
	}

	/**
	 * ���µı����������ǰ�ı������hashCodeֵ��ͬ
	 *		������name = "A" id = 40 -->hashCodeֵ = 65 + 40 * 5
	 *			  name = "F" id = 39 -->hashCodeֵ = (65+5) + (40-1) * 5 = 65 + 40 * 5
	 * ��ʱ��Ӧ��ǿ�жϣ��ж���������������ԣ��Ƿ���ȫһ���������ȫһ��������false�Զ�����
	 * �����ͬ������true
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof StandardStudent)) {
			throw new RuntimeException("����StandardStudent�����޷��Ƚϣ�");
		}
		StandardStudent stdStu = (StandardStudent)obj;
		/**
		 * ����׷������ַ����Ƚ�str1.compareTo(str2)
		 *						   ���ص�int�����ݣ�Ϊ1��������ı������Ĵ�
		 *											Ϊ-1��������ı�������С
		 *											Ϊ0�����������������"�ַ���"ͬ�������ַ���������ͬ
		 *				���ַ����ж�str1.equals(str2)
		 *						   ���ص���boolean�����ݣ�Ϊtrue��������ĺ�������"�ַ���"ͬ�������ַ���������ͬ
		 *												  Ϊfalse��������ĺ�������"�ַ���"���ݲ���ͬ
		 */
		 System.out.println("��(name = " + this.getName() + ", " + "id = " + this.getId() + ")"
							+ "....PK...." 
							+ "�ȱ�(name = " + stdStu.getName() + ", " + "id = " + stdStu.getId() + ")");
		return (this.getName().equals(stdStu.getName())) && (this.getId() == stdStu.getId());
	}
}

/**
 * ΪStandardStudent���õ�һ���Ƚ�����StandardStudentComparator�����ָ�����������ʽ
 * ��StandardStudent�̳и���StandardStudentFather����Ƚ����������͸�Ϊ<StandardStudentFather>
 * StandardStudentComparator���캯������һ��int�Ͳ�������Ϊ˽�о�̬����ORDER_NUM��ֵ����������ģʽ
 * ORDER_NUM = 1;����name���������Զ����������ظ��Ķ���
 * ORDER_NUM = 2;����id���������Զ����������ظ��Ķ���
 * ORDER_NUM = 0(����������1��2��������ֵ);����hashCodeֵΨһ����ֻҪhashCodeֵ��ͬ���Ͱ���id��������
 */

class StandardStudentComparator implements Comparator<StandardStudent> {
    private static int ORDER_NUM = 0;	//�������Ϊstatic final int
	public StandardStudentComparator() {}
	public StandardStudentComparator(int order_num) {
		//super();
		//���캯��ִ��ʱ��ȷ������ģʽֵ��ORDER_NUM
		StandardStudentComparator.ORDER_NUM = order_num;		//��ΪORDER_NUMΪ��̬�����������Ҫʹ��this
	}
	public static int getOrderNum() {
		return StandardStudentComparator.ORDER_NUM;				//��ΪORDER_NUMΪ��̬�����������Ҫʹ��this
	}
	public void setOrderNum(int order_num) {
		StandardStudentComparator.ORDER_NUM = order_num;
	}
	
    public int compare(StandardStudent stdStu1, StandardStudent stdStu2) {
		/**
		 * ORDER_NUM = 1;����name���������Զ����������ظ��Ķ���
		 * ORDER_NUM = 2;����id���������Զ����������ظ��Ķ���
		 * ORDER_NUM = 0(����������1��2��������ֵ);
		 *				����hashCodeֵΨһ����ֻҪhashCodeֵ��ͬ���Ͱ���id��������
		 */

		switch (StandardStudentComparator.getOrderNum()) {
		case 1:
		    return compareToName(stdStu1, stdStu2);
		case 2:
			return compareToId(stdStu1, stdStu2);
		default:
			return compareToDefault(stdStu1, stdStu2);
		}
	}

	public int compareToName(StandardStudent stdStu1, StandardStudent stdStu2) {
		sop("��" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "......PK......"
			+ "�ȱ�" + stdStu2.getName() + "::" + stdStu2.getId());
		int temp = stdStu1.getName().compareTo(stdStu2.getName());
		if (0 != temp) {
		    return temp;
		} else {
			return stdStu1.getId() - stdStu2.getId();
		}
	}

	public int compareToId(StandardStudent stdStu1, StandardStudent stdStu2) {
		sop("��" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "......PK......"
			+ "�ȱ�" + stdStu2.getName() + "::" + stdStu2.getId());
		int temp = stdStu1.getId() - stdStu2.getId();
		if (0 != temp) {
		    return temp;
		} else {
			return stdStu1.getName().compareTo(stdStu2.getName());
		}
	}

	public int compareToDefault(StandardStudent stdStu1, StandardStudent stdStu2) {
		/**
		 * StandardStudent���Ѿ���д.hashCode()������.equals()����
		 * �˴����չ�ϣֵΨһ���е�������
		 * �����StandardStudent����ʹ�ñȽ�������ô���ܽ���hashCodeֵ����
		 *						hashCodeֵ��ͬ���ж������Ƿ���ȣ�����ж��ظ����Զ����ˣ����򱣴�
		 * ���ʹ���˱��Ƚ�����hashCodeֵ������һ����Ч��
		 */
		sop("��" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "������ϣֵ����" + stdStu1.hashCode()
			+ "......PK......"
			+ "�ȱ�" + stdStu2.getName() + "::" + stdStu2.getId()
			+ "������ϣֵ����" + stdStu2.hashCode());
		int temp = stdStu1.hashCode() - stdStu2.hashCode();
		if (0 != temp) {
		    return temp;
		} else {
			return stdStu1.getId() - stdStu2.getId();
		}
	}
	
	public void sop(Object obj) {
		System.out.println(obj);
	}
}
