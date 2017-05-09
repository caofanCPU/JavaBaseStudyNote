
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


*/
//----------------------------/
/*MapDemo.java运行结果：
---------------------------
集合Map全部共性方法练习代码MapDemp.java
-------编译全部OK--------
---------------------------
第一次存入键GG的值(对象)value = null
再次存入键GG的值(对象)value = 555
---------------------------
键key为A存在吗：true
键key为D存在吗：false
值value为23存在吗：false
值value为20存在吗：true
---------------------------
未扩容前map集合的长度为：7
自身克隆增殖后map集合的长度为：7
---------------------------
map集合的值(对象)的集合为：[24, 20, 666, 8, 22, 20, 7]
---------------------------
键null在map集合中的值：24
键A666在map集合中的值：null
---------------------------
遍历时map集合的长度为：7
使用Map.keySet()->Set迭代器，迭代获取键的对象
再使用Map.get(Object key)方法->循环遍历map集合：
第[1]对:  <键key = null, 值value = 24>
第[2]对:  <键key = Dd, 值value = 20>
第[3]对:  <键key = GG, 值value = 666>
第[4]对:  <键key = 李四, 值value = 8>
第[5]对:  <键key = A, 值value = 22>
第[6]对:  <键key = B, 值value = 20>
第[7]对:  <键key = 张山, 值value = 7>
---------------------------
遍历时map集合的长度为：7
使用Map.entrySet()->Map.Entry<String, Integer>迭代器，迭代获取键值关系的对象
再使用关系对象的特有方法.getKey() + .getValue()->循环遍历map集合：
第[1]对:  <键key = null, 值value = 24>
第[2]对:  <键key = Dd, 值value = 20>
第[3]对:  <键key = GG, 值value = 666>
第[4]对:  <键key = 李四, 值value = 8>
第[5]对:  <键key = A, 值value = 22>
第[6]对:  <键key = B, 值value = 20>
第[7]对:  <键key = 张山, 值value = 7>
---------------------------
将要被删除的键key张山的值value = 7
进行clear操作后map集合为空：true
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class MapDemo {
	public static void main(String[] args) {
		/* MapDemo.java文件解决问题：
		 * 练习Map的共性方法
		 */
		lineSplit();
		sop("集合Map全部共性方法练习代码MapDemp.java"
			+ "\n-------编译全部OK--------");
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> mapTwo = new HashMap<String, Integer>();
		//1.添加元素.put(K key,V value)，返回以前键key的值(对象)value
		mapTwo.put("张山", 7);
		mapTwo.put("李四", 8);
		//1.添加map集合
		map.putAll(mapTwo);
		map.put("A", 22);
		map.put("B", 20);
		map.put(null, 24);
		map.put("Dd", 20);
		lineSplit();
		//sop("ssss..." + (new Integer(5)));
		sop("第一次存入键GG的值(对象)value = " + map.put("GG", new Integer(555)));
		sop("再次存入键GG的值(对象)value = " + map.put("GG", 666));
		lineSplit();
		//3.判断键是否存在.containsKey(Object key)
		sop("键key为A存在吗：" + map.containsKey("A")
			+ "\n键key为D存在吗：" + map.containsKey("D"));
		//3.判断值是否存在.containsValue(V value)
		sop("值value为23存在吗：" + map.containsValue(23)
			+ "\n值value为20存在吗：" + map.containsValue(20));
		lineSplit();
		//4.获取Map集合的长度.size()
		sop("未扩容前map集合的长度为：" + map.size());
		//1.添加map集合
		map.putAll(map);	//由于Map集合必须保证键的唯一性，因而自我增殖得到的结果等价于空操作
		sop("自身克隆增殖后map集合的长度为：" + map.size());
		lineSplit();
		//4.获取map集合的值的集合.values()
		Collection mapVc = map.values();
		sop("map集合的值(对象)的集合为：" + mapVc);
		lineSplit();
		//4.获取键key在map集合中的值.get(Object key)：返回键的值value
		sop("键null在map集合中的值：" + map.get(null)
			 + "\n键A666在map集合中的值：" + map.get("A666"));
		lineSplit();
		sop("遍历时map集合的长度为：" + map.size());
		sop("使用Map.keySet()->Set迭代器，迭代获取键的对象"
			+ "\n再使用Map.get(Object key)方法->循环遍历map集合：");
		int i = 1;
		/**
		 * map.keySet()返回的是键key的一个集合序列Set  
		 * Set是接口，其子类hashSet、TreeSet都有迭代器Iterator
		 * HashSet s = map.keySet();
		 */
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); i++) {
		    String str = it.next();
			sop("第[" + i +"]对:  " + "<键key = " + str + ", "
			    + "值value = " + map.get(str) + ">");
		}
		lineSplit();
		sop("遍历时map集合的长度为：" + map.size());
		sop("使用Map.entrySet()->Map.Entry<String, Integer>迭代器，迭代获取键值关系的对象"
			+ "\n再使用关系对象的特有方法.getKey() + .getValue()->循环遍历map集合：");
		i = 1;
		/**
		 * Map.entrySet()返回是Set<Map.Entry<K, V>>，一个保存了键值关系的序列
		 * Set是接口，其子类HashSet、TreeSet都有迭代器Iterator
		 * HashSet<String, Integer> = Map.keySet()
		 */
		/**
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Iterator<Map.Entry<String, Integer>> it = entrySet.iterator(); it.hasNext(); i++) {
		    Map.Entry<String, Integer> me = it.next();	//获取关系对象
			sop("第[" + i +"]对:  " + "<键key = " + me.getKey() + ", "
			    + "值value = " + me.getValue() + ">");
		}
		 */
		//简化加强版
		for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); i++) {
			Map.Entry<String, Integer> me = it.next();		//迭代获取关系对象
			sop("第[" + i +"]对:  " + "<键key = " + me.getKey() + ", "
			    + "值value = " + me.getValue() + ">");
		}
		lineSplit();
		//2.删除键key以及键的值value
		sop("将要被删除的键key张山的值value = " + map.remove("张山"));
		//2.清空map集合.clear()
		map.clear();
		//3.判断map集合是否为空
		sop("进行clear操作后map集合为空：" +map.isEmpty());
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* 打印字符串
		*  
		*/
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* 打印字符串
		*  
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
 * 关于Map.Entry<String, Integer>的内部实现原理
嵌套接口：
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
外部类CA实现外部接口IA，内部类CB实现内部公共静态接口IB
内部类：CA.CB		内部类文件形式CA$CB
内部接口：IA.IB		内部接口文件形式IA$IB
为何要在Map内部定义Map.Entry接口？
因为现有Map集合，再有Map.Entry关系，所以Map.Entry是Map的内部事物；
此外，内部接口可以直接访问外部接口，定义为static；
反过来，因为可以加static修饰符，所以Map.Entry是Map的内部成员
 */