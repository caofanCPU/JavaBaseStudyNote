
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
														   通过创建一个比较器类，完成了name、age、hashCode值3种递增排序
														   (值得注意的是，比较器中静态变量ORDER_NUM和静态getOrderName方法)
		：Map
			|-- HashTable：底层数据结构是哈希表
			|-- HashMap：底层数据结构是哈希表
			|-- TreeMap：底层数据结构是二叉树(红黑树)
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
		【ListIterator<E>】listInterator()：获取并返回该List的相等元素类型<E>的迭代器对象
set：其方法与Collection一致
*/
//----------------------------/
/*StrLengthOrder.java运行结果：
---------------------------
后辈PDD1：长度4..PK..前辈PDD1：长度4
后辈PDD2：长度4..PK..前辈PDD1：长度4
后辈PDD2：长度4..PK..前辈PDD1：长度4
后辈PDD2：长度4..PK..前辈PDD2：长度4
后辈PDD3：长度4..PK..前辈PDD2：长度4
后辈PDD3：长度4..PK..前辈PDD2：长度4
后辈PDD12：长度5..PK..前辈PDD2：长度4
后辈PDD12：长度5..PK..前辈PDD2：长度4
后辈PDD12：长度5..PK..前辈PDD3：长度4
后辈PDD0000：长度7..PK..前辈PDD2：长度4
后辈PDD0000：长度7..PK..前辈PDD3：长度4
后辈PDD0000：长度7..PK..前辈PDD12：长度5
---------------------------
集合TreeSet-->ts所有元素排列情况如下：
第[1]名：PDD1, 长度4
第[2]名：PDD2, 长度4
第[3]名：PDD2, 长度4
第[4]名：PDD3, 长度4
第[5]名：PDD12, 长度5
第[6]名：PDD0000, 长度7
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class StrLengthOrder {
	public static void main(String[] args) {
		/* StrLengthOrder.java文件解决问题：
		 * 给定多个字符串，按照字符串长度排序
		 * 涉及排序问题，优先考虑TreeSet的二叉树结构
		 * 1.对于需要【去重】的，按照一般规则设定即可
		 * 2.对于不许去重的，可认为后进的元素应排在后面
		 *		 if(内容同) reture 1
		 */
		//构建了一个Comparator的匿名内部类，因为实现接口Comparator只需要复写一个抽象方法
		TreeSet ts = new TreeSet(new Comparator() {
			public int compare(Object obj1, Object obj2) {
				if(!(obj1 instanceof String)
				   || !(obj2 instanceof String)) {
					throw new RuntimeException("比较对象不是字符串，无法比较！");
				}
				String str1 = (String) obj1;
				String str2 = (String) obj2;
				System.out.println("后辈" + str1 + "：长度" + str1.length()
								   + "..PK.."
								   + "前辈" + str2 + "：长度" + str2.length());
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
		sop("集合TreeSet-->ts所有元素排列情况如下：");
		int i = 0;
		for(Iterator<String> it = ts.iterator(); it.hasNext(); i++) {
			String str = it.next();
			sop("第[" + (i+1) + "]名：" + str + ", "
				+ "长度" + str.length());
		}
		lineSplit();
	}
	
	public static void sop(Object obj) {
		/* 打印字符串
		*  
		*/
		System.out.println(obj);
	}

	public static void lineSplit() {
		/* 打印分隔符
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
			throw new RuntimeException("比较对象不是字符串，无法比较！");
		}
		String str1 = (String) obj1;
		String str2 = (String) obj2;
		System.out.println("后辈" + str1 + "：长度" + str1.length()
						   + "..PK.."
						   + "前辈" + str2 + "：长度" + str2.length());
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