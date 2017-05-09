
/*
集合体系：Collection：存储的是对象的引用
			|-- List：元素时有序的(存入顺序和取出顺序应该一致)，元素可以重复
					  List集合体系有索引
				|-- ArrayList：底层的数据结构是数组，特点：查询速度快，增删稍慢，线程不同步
				|-- LinkedList：底层的数据结构是链表，特点：查询速度稍慢，增删很快，线程不同步
						LinkedList特有方法：
							【boolean】.offerFirst(element)：在表头添加元素
							【boolean】.offerLast(element)：在表末添加元素
							【E】.peekFirst(空参)：仅获取表头元素，不改变LinkedList
							【E】.peekLast(空参)：仅获取表末元素，不改变LinkedList
							【E】.pollFirst(空参)：获取并移除表头元素，改变LinkedList
							【E】.pollLast(空参)：获取并移除表尾元素，改变LinkedList
							【E】.pop(空参)：弹出并返回一个栈顶元素
							【void】.push(element)：压入一个元素至栈顶
				|-- Vector：底层的数据结构是数组，线程同步，已被ArrayList替代
			|-- Set：元素是无序的(存入和取出的顺序不一定一致)，元素不可以重复
				|-- HashSet：底层数据结构是哈希表
							 保证元素唯一的方式：.hashCode()-->equals.(Object obj)
							 判断元素是否存在、删除元素，都是依据上述方式
				|-- TreeSet：底层数据结构是二叉树(红黑树)
							 可以对TreeSet中的元素排序，默认排序规则是元素的自然顺序
							 保证元素唯一性的依据：compareTo方法：满足"相同"的规则return 0;
							 TreeSet排序的第一种方式：元素自身需要实现"可比较的规则"，
										  即元素实现Comparable接口，覆盖compareTo方法
							 TreeSet排序的第二种方式：元素自身不需要具有"可比较的规则"，后者元素不具备比较性
										   那就在TreeSet()构造时，传入一个Comparator比较器参数
										   即TreeSet ts = new TreeSet(new XXXComparator())
					TreeSet练习中：TreeSetTest.java使用对象自身设定比较规则，完成了name、age、hashCode值3种递增排序
								   TreeSetComparator.java，对象自身未设定比较规则，包括其默认hashCode值都是不符合常规的
List：特有方法，凡是可以针对索引操作的方法
	--增：
		【void】add(index, element):在指定索引插入指定元素
		【boolean】addAll(index, Collection)：在指定索引插入指定集合所有元素
	--删：
		【E】remove(index)：移除并返回指定元素
	--改：
		【E】set(index, element)：在指定位置替换并返回原有元素
	--查：
		【E】get(index)：获取并返回指定元素
		【int】indexOf(element)：获取并返回指定元素的index
		【List<E>】subList(fromIndex, toIndex)：获取并返回[fromIndex，toIndex)的子列表
		【ListIterator<E>】listInterator()：获取并返回该List的相等元素类型<E>的迭代器对象														   通过创建一个比较器类，完成了name、age、hashCode值3种递增排序
											(值得注意的是，比较器中静态变量ORDER_NUM和静态getOrderName方法)
set：其方法与Collection一致
		->>Map：存储<K,V>键值对，保证键的唯一性，并且一个键只能有一个值
				其子类HashTable不允许键为null，也不允许值为null；
				而子类HashMap、TreeMap允许键为空(null)，也允许值为空(null)
			Map集合共性方法：
			1.添加
				  【V】    .put(K key, V value)：返回以前键key的值value，第一次添加返回的是null
				  【void】 .putAll(Map<? extends K, ? extends V> m)
			2.删除
				  【void】 .clear(空参)
				  【V】    .remove(Object key)：返回移除键key的值
			3.判断
				  【boolean】  .containsValue(Object Value)
				  【boolean】  .containsKey(Object key)
				  【boolean】  .isEmpty()
			4.获取
				  【V】            .get(Object key)：获取键key的值value
				  【int】          .size()：获取Map集合的长度
				  【Collection<V>】.values()：获取Map集合所有的值(构成的集合)
			重要方法【Set<Map.Entry<K, V>>】.entrySet()：返回Map的【映射关系】
			重要方法【Set<K>】              .keySet()：返回键key的Set集合
			.entrySet() <==> .keySet() + 循环：.get(Object key)
			|-- HashTable：底层数据结构是哈希表，不可以存入空键，不可以存入空值
						   HashTable是线程同步的，效率低
			|-- HashMap：底层数据结构是哈希表，替代HashTable使用
						 HashMap是线程不同步的，效率高
			|-- TreeMap：底层数据结构是二叉树(红黑树)
						 TreeMap可以进行排序
				TreeMap遍历元素的两种方式：.keySet()，使用其迭代器<Key>获取键key
										    这个键会与TreeMap集合中的键逐一进行compare，直到满足或null
										  而.entry()，使用其迭代器<Map.Entry<K, V>>获取键key，值value
										    这个键、值都不会与TreeMap集合中元素进行比较，实现方式暂不详细

*/
//----------------------------/
/*MapTest.java运行结果：
---------------------------
HashSet--hs集合存储元素过程如下：
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈(name = B, id = 18)....PK....先辈(name = B, id = 18)
---------------------------
HashSet-->hs集合存储元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[1]个元素：元素哈希值hashCode = 2227, 属性(name = CF, id = 16)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[2]个元素：元素哈希值hashCode = 2202, 属性(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[3]个元素：元素哈希值hashCode = 155, 属性(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[4]个元素：元素哈希值hashCode = 156, 属性(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[5]个元素：元素哈希值hashCode = 172, 属性(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[6]个元素：元素哈希值hashCode = 2175, 属性(name = AA, id = 19)
---------------------------
TreeSet-->ts集合自然排序存储元素的过程如下：
TreeSet-->ts集合自然排序元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[1]个元素：元素哈希值hashCode = 2227, 属性(name = CF, id = 16)
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[2]个元素：元素哈希值hashCode = 155, 属性(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[3]个元素：元素哈希值hashCode = 156, 属性(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[4]个元素：元素哈希值hashCode = 2202, 属性(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[5]个元素：元素哈希值hashCode = 2175, 属性(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[6]个元素：元素哈希值hashCode = 172, 属性(name = C, id = 21)
---------------------------
TreeSet-->ts0集合哈希值排序存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
TreeSet-->ts0集合哈希值排序元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：元素哈希值hashCode = 155, 属性(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：元素哈希值hashCode = 156, 属性(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：元素哈希值hashCode = 172, 属性(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：元素哈希值hashCode = 2175, 属性(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：元素哈希值hashCode = 2202, 属性(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：元素哈希值hashCode = 2227, 属性(name = CF, id = 16)
---------------------------
TreeSet-->ts1集合name排序存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
TreeSet-->ts1集合name排序元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：元素哈希值hashCode = 155, 属性(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：元素哈希值hashCode = 156, 属性(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：元素哈希值hashCode = 172, 属性(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：元素哈希值hashCode = 2175, 属性(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：元素哈希值hashCode = 2202, 属性(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：元素哈希值hashCode = 2227, 属性(name = CF, id = 16)
---------------------------
TreeSet-->ts2集合存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值 ：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值 ：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值 ：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值 ：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希 值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希 值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希 值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希 值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希 值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值 ：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
TreeSet-->ts2集合id排序元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：元素哈希值hashCode = 155, 属性(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：元素哈希值hashCode = 156, 属性(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：元素哈希值hashCode = 172, 属性(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：元素哈希值hashCode = 2175, 属性(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：元素哈希值hashCode = 2202, 属性(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：元素哈希值hashCode = 2227, 属性(name = CF, id = 16)
---------------------------
HashMap--hm集合存储元素过程如下：
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈(name = B, id = 18)....PK....先辈(name = B, id = 18)
---------------------------
使用Map.keySet()方式获取HashMap存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
第[1]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
第[3]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
第[4]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
(name = C, id = 21)前来计算哈希值
第[5]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
第[6]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
---------------------------
使用Map.EntrySet()方式获取HashMap存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[1]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[3]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[4]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[5]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[6]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
---------------------------
TreeMap-->tm集合存储元素的过程如下：
---------------------------
使用Map.Entry<K, V>方式输出TreeMap集合中的元素
TreeMap:自然排序存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[1]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[3]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[4]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[5]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[6]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
---------------------------
TreeMap-->tm0集合存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
使用Map.Entry<K, V>方式输出TreeMap集合中的元素
TreeMap:哈希值排序存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
---------------------------
TreeMap-->tm1集合存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
使用Map.keySet()方式输出TreeMap集合中的元素
TreeMap:name递增排序存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈B::18：：哈希值：：156
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
第[1]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈AA::19：：哈希值：：2175
(name = C, id = 21)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈C::21：：哈希值：：172
(name = C, id = 21)前来计算哈希值
(name = C, id = 21)前来计算哈希值
第[3]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈AA::19：：哈希值：：2175
(name = AA, id = 19)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
第[4]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈BB::18：：哈希值：：2202
(name = BB, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
第[5]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈CF::16：：哈希值：：2227
(name = CF, id = 16)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
第[6]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
---------------------------
使用Map.Entry<K,V>方式输出TreeMap集合中的元素
TreeMap:name递增排序存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
---------------------------
TreeMap-->tm2集合存储元素的过程如下：
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈A::18：：哈希值：：155......PK......先辈A::18：：哈希值：：155
(name = A, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈A::18：：哈希值：：155
(name = B, id = 18)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈A::18：：哈希值：：155
(name = C, id = 21)前来计算哈希值
(name = A, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈C::21：：哈希值：：172......PK......先辈B::18：：哈希值：：156
(name = C, id = 21)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈B::18：：哈希值：：156
(name = AA, id = 19)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈AA::19：：哈希值：：2175......PK......先辈C::21：：哈希值：：172
(name = AA, id = 19)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈B::18：：哈希值：：156
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈C::21：：哈希值：：172
(name = BB, id = 18)前来计算哈希值
(name = C, id = 21)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈BB::18：：哈希值：：2202......PK......先辈AA::19：：哈希值：：2175
(name = BB, id = 18)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈B::18：：哈希值：：156
(name = CF, id = 16)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈AA::19：：哈希值：：2175
(name = CF, id = 16)前来计算哈希值
(name = AA, id = 19)前来计算哈希值
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
后辈CF::16：：哈希值：：2227......PK......先辈BB::18：：哈希值：：2202
(name = CF, id = 16)前来计算哈希值
(name = BB, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
后辈B::18：：哈希值：：156......PK......先辈B::18：：哈希值：：156
(name = B, id = 18)前来计算哈希值
(name = B, id = 18)前来计算哈希值
---------------------------
使用Map.Entry<K,V>方式输出集合元素
TreeMap:id递增排序存储的6个元素如下：
(非自动调用)在输出元素时for循环主动调用：(name = A, id = 18)前来计算哈希值
第[1]个元素：<键 hashCode = 155, 值 addressString = 北京>
        键(name = A, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = B, id = 18)前来计算哈希值
第[2]个元素：<键 hashCode = 156, 值 addressString = NO武汉>
        键(name = B, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = C, id = 21)前来计算哈希值
第[3]个元素：<键 hashCode = 172, 值 addressString = 深圳>
        键(name = C, id = 21)
(非自动调用)在输出元素时for循环主动调用：(name = AA, id = 19)前来计算哈希值
第[4]个元素：<键 hashCode = 2175, 值 addressString = 广州>
        键(name = AA, id = 19)
(非自动调用)在输出元素时for循环主动调用：(name = BB, id = 18)前来计算哈希值
第[5]个元素：<键 hashCode = 2202, 值 addressString = 杭州>
        键(name = BB, id = 18)
(非自动调用)在输出元素时for循环主动调用：(name = CF, id = 16)前来计算哈希值
第[6]个元素：<键 hashCode = 2227, 值 addressString = 成都>
        键(name = CF, id = 16)
---------------------------
请按任意键继续. . .
*/

import java.util.*;
class MapTest {
	public static void main(String[] args) {
		/* MapTest.java文件解决问题：
		 * 创建标准的对象类StandardStudent，name 和 id作为内容属性
		 * 构建可自然排序、name排序、id排序和哈希值唯一排序的方式
		 * 使用HashSet、TreeSet集合存储：StandardStudent对象(name, id)
		 * 使用HashMap、TreeMap存储：<键 StandardStudent对象(name, id), 值 String>
		 */
		int i = 1;		//标识元素顺序或编号的循环变量		
		lineSplit();

		/**
		 * 使用HashSet集合存储StandardStudent对象(name, id)
		 * 显示HashSet集合存储元素，保证元素唯一性的过程，首先根据元素的.hashCode()计算哈希值
		 * 元素对象默认.hashCode()方法计算的是元素对象的地址，因而忽略新建元素对象的内容属性
		 * 若哈希值不同，根据元素的.equals()方法进行判断，内容相同则判定为重复，丢弃
		 * 使用泛型迭代器：Iterator<StandardStudent> it = Set.iterator()迭代输出集合元素
		 */
		HashSet<StandardStudent> hs = new HashSet<StandardStudent>();
		sop("HashSet--hs集合存储元素过程如下：");
		hs.add(new StandardStudent("A", 18));
		hs.add(new StandardStudent("B", 18));
		hs.add(new StandardStudent("C", 21));
		hs.add(new StandardStudent("AA", 19));
		hs.add(new StandardStudent("BB", 18));
		hs.add(new StandardStudent("CF", 16));
		hs.add(new StandardStudent("B", 18));
		lineSplit();
		sop("HashSet-->hs集合存储元素如下：");
		i = 1;
		for (Iterator<StandardStudent> it = hs.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "元素哈希值hashCode = " + hashCode + ", "
				+ "属性(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		
		/**
		 * 使用TreeSet集合存储StandardStudent对象(name, id)
		 * 显示TreeSet集合存储元素，保证元素唯一性的过程
		 *		第一种：TreeSet不使用比较器的默认自然排序
		 *				它的排序基准根本不会计算哈希值，而是使用底层compare方法：选择主因id，次因name
		 *		第二种：TreeSet使用StandardStudent对象特有比较器StandardStudentComparator<StandardStudent>
		 *				可选择的排序方式：[0:哈希值排序]	[1:name排序]	[2:id排序]
		 *				与TreeMap默认自然排序方式所不同的是，比较器排序都会进行对象的.hashCode()方法计算哈希值
		 * TreeSet通过迭代器输出时，属于直接输出(与TreeMap的Map.keySet()重复计算、判断输出有区别)
		 * 使用泛型迭代器：Iterator<StandardStudent> it = Set.iterator()迭代输出集合元素
		 */
		TreeSet<StandardStudent> ts = new TreeSet<StandardStudent>();
		sop("TreeSet-->ts集合自然排序存储元素的过程如下：");
		ts.add(new StandardStudent("A", 18));
		ts.add(new StandardStudent("B", 18));
		ts.add(new StandardStudent("C", 21));
		ts.add(new StandardStudent("AA", 19));
		ts.add(new StandardStudent("BB", 18));
		ts.add(new StandardStudent("CF", 16));
		ts.add(new StandardStudent("B", 18));
		sop("TreeSet-->ts集合自然排序元素如下：");
		i = 1;
		for (Iterator<StandardStudent> it = ts.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "元素哈希值hashCode = " + hashCode + ", "
				+ "属性(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeSet<StandardStudent> ts0 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(0));
		sop("TreeSet-->ts0集合哈希值排序存储元素的过程如下：");
		ts0.add(new StandardStudent("A", 18));
		ts0.add(new StandardStudent("B", 18));
		ts0.add(new StandardStudent("C", 21));
		ts0.add(new StandardStudent("AA", 19));
		ts0.add(new StandardStudent("BB", 18));
		ts0.add(new StandardStudent("CF", 16));
		ts0.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts0集合哈希值排序元素如下：");
		i = 1;
		for (Iterator<StandardStudent> it = ts0.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "元素哈希值hashCode = " + hashCode + ", "
				+ "属性(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();

		TreeSet<StandardStudent> ts1 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(1));
		sop("TreeSet-->ts1集合name排序存储元素的过程如下：");
		ts1.add(new StandardStudent("A", 18));
		ts1.add(new StandardStudent("B", 18));
		ts1.add(new StandardStudent("C", 21));
		ts1.add(new StandardStudent("AA", 19));
		ts1.add(new StandardStudent("BB", 18));
		ts1.add(new StandardStudent("CF", 16));
		ts1.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts1集合name排序元素如下：");
		i = 1;
		for (Iterator<StandardStudent> it = ts1.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "元素哈希值hashCode = " + hashCode + ", "
				+ "属性(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeSet<StandardStudent> ts2 = new TreeSet<StandardStudent>(
												 new StandardStudentComparator(2));
		sop("TreeSet-->ts2集合存储元素的过程如下：");
		ts2.add(new StandardStudent("A", 18));
		ts2.add(new StandardStudent("B", 18));
		ts2.add(new StandardStudent("C", 21));
		ts2.add(new StandardStudent("AA", 19));
		ts2.add(new StandardStudent("BB", 18));
		ts2.add(new StandardStudent("CF", 16));
		ts2.add(new StandardStudent("B", 18));
		lineSplit();
		sop("TreeSet-->ts2集合id排序元素如下：");
		i = 1;
		for (Iterator<StandardStudent> it = ts2.iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "元素哈希值hashCode = " + hashCode + ", "
				+ "属性(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		
		/**
		 * 使用HashMap存储<StandardStudent, String>关系对象，StandardStudent有name和id两个属性
		 * 使用Map.put()方法添加关系对象元素，并验证了[键相同时]，后进来的元素会覆盖旧元素的[值]
		 *	   同时，Map.put()方法会返回元素被覆盖的[值]，如未被覆盖，返回null
		 * 使用Iterator<StandardStudent> it = Map.keySet().iterator()，方式获取Map集合[键的序列]迭代器
		 *		 在输出时，由于键是StandardStudent对象，使用该对象的hashCode()成员方法获取哈希值
		 *		 用StandardStudent对象的哈希值代表键
		 * 使用Iterator<Map.Entry<StandardStudent, String>> entry = Map.entry().iterator()，方式获取Map集合[关系]的迭代器
		 *		 在输出时同上
		 * 显示HashMap存储关系元素时的过程，首先根据键(StandardStudent对象)调用.hashCode()方法计算哈希值
		 * 若哈希值相同，再调用.equals()方法判定元素是否重复
		 *
		 * HashMap与HashSet的联系与区别：HashSet是用HashMap实现的，HashMap只取键即为HashSet
		 * 因而HashMap与HashSet的特性基本相似，但是HashMap有其独特特点：
		 * 遍历HashMap有Map.keySet()和Map.entry()两种方式，二者的区别是：
		 *				Map.keySet()根据键会计算再次调用.hashCode()方法计算哈希值
		 *			  而Map.entry()不会再次计算哈希值，因而要高效和实用些
		 */
		HashMap<StandardStudent, String> hm = new HashMap<StandardStudent, String>();
		sop("HashMap--hm集合存储元素过程如下：");
		hm.put(new StandardStudent("A", 18), "北京");
		hm.put(new StandardStudent("B", 18), "武汉");
		hm.put(new StandardStudent("C", 21), "深圳");
		hm.put(new StandardStudent("AA", 19), "广州");
		hm.put(new StandardStudent("BB", 18), "杭州");
		hm.put(new StandardStudent("CF", 16), "成都");
		hm.put(new StandardStudent("B", 18), "NO武汉");		//与第二个键重复
		lineSplit();
		sop("使用Map.keySet()方式获取HashMap存储的" + hm.size() + "个元素如下：");
		i = 1;
		for(Iterator<StandardStudent> it = hm.keySet().iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + hm.get(stdStu) + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		sop("使用Map.EntrySet()方式获取HashMap存储的" + hm.size() + "个元素如下：");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = hm.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + me.getValue() + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();

		/**
		 * 使用TreeMap存储<StandardStudent, String>关系对象，StandardStudent有name和id两个属性
		 * TreeMap有默认自然排序和比较器排序，默认自然排序根本不会计算哈希值，而比较器排序都会计算哈希值
		 * TreeMap与TreeSet的联系和区别：
		 *			TreeSet底层由TreeMap实现，TreeMap只取键即为TreeSet
		 *		  而遍历TreeMap有Map.keySet()和Map.entry()两种方式
		 *						 Map.keySet()根据键会再次计算哈希值，并逐一调用compare方法进行比较
		 *					   而Map.entry()则不会再次计算哈希值，也不会调用compare方法逐一比较
		 * 并且使用StandardStudentComparator比较器，设定：
		 *		   [0:哈希值排序]		[1:name排序]		[2.id排序]
		 * 分别创建TreeMpa集合：tm0，tm1，tm2完成3种排序方式的测试
		 * 此外，对于tm1的测试，在输出时采用Map.keySet()和Map.entry()方式输出
		 *	     发现：Map.keySet()获取键key的值value时，会逐一比较TreeMap集合中的键，即会自动调用compare(T t1, T t2)方法
		 *		     而Map.entrySet()则不会进行比较，其实现方式暂不详
		 * 使用Iterator<StandardStudent> it = Map.keySet().iterator()，方式获取Map集合[键的序列]迭代器
		 *		 在输出时，由于键是StandardStudent对象，使用该对象的hashCode()成员方法获取哈希值
		 *		 用StandardStudent对象的哈希值代表键
		 * 使用Iterator<Map.Entry<StandardStudent, String>> entry = Map.entry().iterator()，方式获取Map集合[关系]的迭代器
		 *		 在输出时同上
		 */
		TreeMap<StandardStudent, String> tm = new TreeMap<StandardStudent, String>();
		sop("TreeMap-->tm集合存储元素的过程如下：");
		tm.put(new StandardStudent("A", 18), "北京");
		tm.put(new StandardStudent("B", 18), "武汉");
		tm.put(new StandardStudent("C", 21), "深圳");
		tm.put(new StandardStudent("AA", 19), "广州");
		tm.put(new StandardStudent("BB", 18), "杭州");
		tm.put(new StandardStudent("CF", 16), "成都");
		tm.put(new StandardStudent("B", 18), "NO武汉");		//与第二个键重复
		lineSplit();
		sop("使用Map.Entry<K, V>方式输出TreeMap集合中的元素\n"
			+ "TreeMap:自然排序存储的" + tm.size() + "个元素如下：");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + me.getValue() + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm0 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(0));
		sop("TreeMap-->tm0集合存储元素的过程如下：");
		tm0.put(new StandardStudent("A", 18), "北京");
		tm0.put(new StandardStudent("B", 18), "武汉");
		tm0.put(new StandardStudent("C", 21), "深圳");
		tm0.put(new StandardStudent("AA", 19), "广州");
		tm0.put(new StandardStudent("BB", 18), "杭州");
		tm0.put(new StandardStudent("CF", 16), "成都");
		tm0.put(new StandardStudent("B", 18), "NO武汉");		//与第二个键重复
		lineSplit();
		sop("使用Map.Entry<K, V>方式输出TreeMap集合中的元素\n"
			+ "TreeMap:哈希值排序存储的" + tm0.size() + "个元素如下：");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm0.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + me.getValue() + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm1 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(1));
		sop("TreeMap-->tm1集合存储元素的过程如下：");
		tm1.put(new StandardStudent("A", 18), "北京");
		tm1.put(new StandardStudent("B", 18), "武汉");
		tm1.put(new StandardStudent("C", 21), "深圳");
		tm1.put(new StandardStudent("AA", 19), "广州");
		tm1.put(new StandardStudent("BB", 18), "杭州");
		tm1.put(new StandardStudent("CF", 16), "成都");
		tm1.put(new StandardStudent("B", 18), "NO武汉");		//与第二个键重复
		lineSplit();
		sop("使用Map.keySet()方式输出TreeMap集合中的元素\n"
			+ "TreeMap:name递增排序存储的" + tm1.size() + "个元素如下：");
		i = 1;
		for(Iterator<StandardStudent> it = tm1.keySet().iterator(); it.hasNext(); i++) {
			StandardStudent stdStu = it.next();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + tm1.get(stdStu) + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		sop("使用Map.Entry<K,V>方式输出TreeMap集合中的元素\n"
			+ "TreeMap:name递增排序存储的" + tm1.size() + "个元素如下：");
		i = 1;
		for(Iterator<Map.Entry<StandardStudent, String>> entry = tm1.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + me.getValue() + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
		TreeMap<StandardStudent, String> tm2 = new TreeMap<StandardStudent, String>
													     (new StandardStudentComparator(2));
		sop("TreeMap-->tm2集合存储元素的过程如下：");
		tm2.put(new StandardStudent("A", 18), "北京");
		tm2.put(new StandardStudent("B", 18), "武汉");
		tm2.put(new StandardStudent("C", 21), "深圳");
		tm2.put(new StandardStudent("AA", 19), "广州");
		tm2.put(new StandardStudent("BB", 18), "杭州");
		tm2.put(new StandardStudent("CF", 16), "成都");
		tm2.put(new StandardStudent("B", 18), "NO武汉");		//与第二个键重复
		lineSplit();
		sop("使用Map.Entry<K,V>方式输出集合元素\n"
			+ "TreeMap:id递增排序存储的" + tm2.size() + "个元素如下：");
		i = 1;
		for (Iterator<Map.Entry<StandardStudent, String>> entry = tm2.entrySet().iterator(); entry.hasNext(); i++) {
			Map.Entry<StandardStudent, String> me = entry.next();
			StandardStudent stdStu = me.getKey();
			sopt("(非自动调用)在输出元素时for循环主动调用：");
			int hashCode = stdStu.hashCode();
			sop("第[" + i + "]个元素：" + "<键 hashCode = " + hashCode
				+ ", 值 addressString = " + me.getValue() + ">"
				+ "\n\t键(name = " + stdStu.getName() + ", id = " + stdStu.getId() + ")");
		}
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* 打印字符串
		 * 带换行
		 */
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* 打印字符串
		 * 不带换行
		 */
		System.out.print(obj);
	}

	public static void lineSplit() {
		/* 打印分隔符
		 * 
		 */
		sop("---------------------------");
	}
}

/**
 * StandardStudent类，自身需要具备比较性，即实现Comparable<StandardStudent>接口
 * StandardStudent类按照特定规则进行排序，需要一个本类父类级别的比较器Comparator<Father>实现
 * 同时，因为需要存储很多此类对象，可能用HashSet存储，也可能用TreeSet存储
 * 用HashSet存储，需要复写.equals()和hashCode()方法
 * 用TreeSet存储，需要类自身具备可比较性及排序规则，或者加比较器
 * 考虑到HashSet和TreeSet方式，或者HashMap和TreeMap
 * StandardStudent类需要具备哈希表和二叉树底层数据结构需要的方法
 * 简记为：两个实现，两个复写
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
	 * 实现Comparable<T t>接口，需要覆盖public int compareTo(T t)抽象方法
	 * 返回值是：this.get排序主因子() - t.get排序主因子()，是个int型数据
	 * 排序主因子相同，比较次因子，以此类推，直到所有因子的内容都相同，判定对象相同
	 * return 0;自动过滤重复对象
	 *
	 * 与某个比较器类实现比较器Comparator<T t>的区别，需要覆盖public int compare(T t1, T t2)
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
	 * 本类对象的hashCode值由对象的内容属性决定
	 * 具体计算方法为：name.hashCode() + id * 50;
	 */
	public int hashCode() {
		System.out.println("(name = " + this.getName() + ", "
						   + "id = " +this.getId() + ")前来计算哈希值");
		return this.getName().hashCode() + this.getId() * 5;
	}

	/**
	 * 当新的本类对象与先前的本类对象hashCode值相同
	 *		举例：name = "A" id = 40 -->hashCode值 = 65 + 40 * 5
	 *			  name = "F" id = 39 -->hashCode值 = (65+5) + (40-1) * 5 = 65 + 40 * 5
	 * 此时，应加强判断，判断两对象的内容属性，是否完全一样，如果完全一样，返回false自动过滤
	 * 如果不同，返回true
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof StandardStudent)) {
			throw new RuntimeException("不是StandardStudent对象，无法比较！");
		}
		StandardStudent stdStu = (StandardStudent)obj;
		/**
		 * 编程易犯错误：字符串比较str1.compareTo(str2)
		 *						   返回的int型数据：为1代表后来的比先来的大
		 *											为-1代表后来的比先来的小
		 *											为0代表后来的与先来的"字符串"同名，即字符串内容相同
		 *				而字符串判断str1.equals(str2)
		 *						   返回的是boolean型数据，为true代表后来的和先来的"字符串"同名，即字符串内容相同
		 *												  为false代表后来的和先来的"字符串"内容不相同
		 */
		 System.out.println("后辈(name = " + this.getName() + ", " + "id = " + this.getId() + ")"
							+ "....PK...." 
							+ "先辈(name = " + stdStu.getName() + ", " + "id = " + stdStu.getId() + ")");
		return (this.getName().equals(stdStu.getName())) && (this.getId() == stdStu.getId());
	}
}

/**
 * 为StandardStudent设置的一个比较器类StandardStudentComparator，完成指定规则的排序方式
 * 若StandardStudent继承父类StandardStudentFather，则比较器操作类型改为<StandardStudentFather>
 * StandardStudentComparator构造函数接受一个int型参数，作为私有静态变量ORDER_NUM的值，代表排序模式
 * ORDER_NUM = 1;代表name递增排序，自动过滤内容重复的对象
 * ORDER_NUM = 2;代表id递增排序，自动过滤内容重复的对象
 * ORDER_NUM = 0(或者其他非1非2的整型数值);代表hashCode值唯一排序，只要hashCode值相同，就按照id递增排序
 */

class StandardStudentComparator implements Comparator<StandardStudent> {
    private static int ORDER_NUM = 0;	//最终设计为static final int
	public StandardStudentComparator() {}
	public StandardStudentComparator(int order_num) {
		//super();
		//构造函数执行时，确定排序模式值：ORDER_NUM
		StandardStudentComparator.ORDER_NUM = order_num;		//因为ORDER_NUM为静态变量，因而不要使用this
	}
	public static int getOrderNum() {
		return StandardStudentComparator.ORDER_NUM;				//因为ORDER_NUM为静态变量，因而不要使用this
	}
	public void setOrderNum(int order_num) {
		StandardStudentComparator.ORDER_NUM = order_num;
	}
	
    public int compare(StandardStudent stdStu1, StandardStudent stdStu2) {
		/**
		 * ORDER_NUM = 1;代表name递增排序，自动过滤内容重复的对象
		 * ORDER_NUM = 2;代表id递增排序，自动过滤内容重复的对象
		 * ORDER_NUM = 0(或者其他非1非2的整型数值);
		 *				代表hashCode值唯一排序，只要hashCode值相同，就按照id递增排序
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
		sop("后辈" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "......PK......"
			+ "先辈" + stdStu2.getName() + "::" + stdStu2.getId());
		int temp = stdStu1.getName().compareTo(stdStu2.getName());
		if (0 != temp) {
		    return temp;
		} else {
			return stdStu1.getId() - stdStu2.getId();
		}
	}

	public int compareToId(StandardStudent stdStu1, StandardStudent stdStu2) {
		sop("后辈" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "......PK......"
			+ "先辈" + stdStu2.getName() + "::" + stdStu2.getId());
		int temp = stdStu1.getId() - stdStu2.getId();
		if (0 != temp) {
		    return temp;
		} else {
			return stdStu1.getName().compareTo(stdStu2.getName());
		}
	}

	public int compareToDefault(StandardStudent stdStu1, StandardStudent stdStu2) {
		/**
		 * StandardStudent类已经复写.hashCode()方法和.equals()方法
		 * 此处按照哈希值唯一进行递增排序
		 * 即如果StandardStudent对象不使用比较器，那么它能进行hashCode值排序
		 *						hashCode值相同，判断内容是否相等，相等判定重复，自动过滤，否则保存
		 * 如果使用了本比较器的hashCode值排序，起到一样的效果
		 */
		sop("后辈" + stdStu1.getName() + "::" + stdStu1.getId()
			+ "：：哈希值：：" + stdStu1.hashCode()
			+ "......PK......"
			+ "先辈" + stdStu2.getName() + "::" + stdStu2.getId()
			+ "：：哈希值：：" + stdStu2.hashCode());
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
