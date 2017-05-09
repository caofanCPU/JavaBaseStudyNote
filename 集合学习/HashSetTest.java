
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
/*HashSetTest.java运行结果：
---------------------------
HashSet-->hs的元素个数为::4
下面模拟添加【重复】元素操作：
        重复元素(张山，15)添加成功吗：：false
        重复元素(张山，16)添加成功吗：：false
        重复元素(张山，17)添加成功吗：：false
        重复元素(张山，30)添加成功吗：：true
---------------------------
添加元素后，HashSet-->hs的元素个数为::5
---------------------------
实际保存的HashSet-->hs所有元素为：
        元素Person@be16f<name = 张山, age = 30>
        元素Person@be163<name = 张山, age = 18>
        元素Person@be162<name = 张山, age = 17>
        元素Person@be161<name = 张山, age = 16>
        元素Person@be160<name = 张山, age = 15>
---------------------------
请按任意键继续. . .
*/

import java.util.*;
class HashSetTest {
	/* 使用HashSet存储Person对象，按照(name，age)保证其唯一性
	*  本例相当于另一种ArrayListDemo2.java的替代方案
	*/

	public static void main(String[] args) {
		/* Person.class与本文件同目录，且已经复写好.hashCode()和.equals(Object obj)方法
		*  通过new Person(String name, int age)新建Person对象
		*  使用泛型<Person>限定输入只能是Person对象
		*/
		HashSet<Person> hs = new HashSet<Person>();
		/* 输入的("张山", 15/16/17)有重复
		*  期望去除此重复的输出
		*/
		hs.add(new Person("张山", 15));
		hs.add(new Person("张山", 16));
		hs.add(new Person("张山", 17));
		hs.add(new Person("张山", 18));
		lineSplit();
		sop("HashSet-->hs的元素个数为::" + hs.size());
		sop("下面模拟添加【重复】元素操作：");
		sop("\t重复元素(张山，15)添加成功吗：：" + hs.add(new Person("张山", 15)));
		sop("\t重复元素(张山，16)添加成功吗：：" + hs.add(new Person("张山", 16)));
		sop("\t重复元素(张山，17)添加成功吗：：" + hs.add(new Person("张山", 17)));
		sop("\t重复元素(张山，30)添加成功吗：：" + hs.add(new Person("张山", 30)));
		lineSplit();
		sop("添加元素后，HashSet-->hs的元素个数为::" + hs.size());
		lineSplit();
		sop("实际保存的HashSet-->hs所有元素为：");
		/* 注意到Set集合只有从Collection继承而来的Iterator迭代器
		*  因而可以考虑使用for循环输出
		*/
		for (Iterator<Person> it = hs.iterator(); it.hasNext(); ) {
		    Person p = it.next();
			sop("\t元素" + p
				+ "<name = " + p.getName()
				+ ", age = " + p.getAge() + ">");
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
