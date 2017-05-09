
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
/*TreeSetTest2.java运行结果：
---------------------------
后辈AK47::10......PK......先辈AK47::10
后辈AK44::16......PK......先辈AK47::10
后辈AK47::16......PK......先辈AK47::10
后辈AK47::10......PK......先辈AK47::10
集合TreeSet-->ts中实际存储的元素排序如下：
Name = AK44, Age = 16
Name = AK47, Age = 10
Name = AK47, Age = 16
---------------------------
请按任意键继续. . .

*/

import java.util.*;
class TreeSetTest2 {
	public static void main(String[] args) {
		/* TreeSetTest2.java文件解决问题：
		*  StudentTwo对象自身未设定比较规则，欲使其按照name递增排序
		*/
		TreeSet ts = new TreeSet(new StudentComparator());
		lineSplit();
		ts.add(new StudentTwo("AK47", 10));
		ts.add(new StudentTwo("AK44", 16));
		ts.add(new StudentTwo("AK47", 16));
		ts.add(new StudentTwo("AK47", 10));
		sop("集合TreeSet-->ts中实际存储的元素排序如下：");
		for(Iterator<StudentTwo> it = ts.iterator(); it.hasNext();) {
			StudentTwo stut = it.next();
			sop("Name = " + stut.getName() + ", "
				+ "Age = " + stut.getAge());
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

class StudentTwo {
	private int orderNum = 0;
	private String name;
	private int age;
	public StudentTwo() {}
	public StudentTwo(String name, int age) {
		//super();
		this.name = name;
		this.age  = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public int getOrderNum() {
		return this.orderNum ;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
}

/**
 * StudentTwo对象的比较器
 * 以name递增排序
 * 同name，以age递增排序
 */
class StudentComparator implements Comparator{
    public int compare(Object obj1, Object obj2) {
		StudentTwo stut1 = (StudentTwo) obj1;
		StudentTwo stut2 = (StudentTwo) obj2;
		System.out.println("后辈" + stut1.getName() + "::" + stut1.getAge()
						   + "......PK......"
						   + "先辈" + stut2.getName() + "::" + stut2.getAge());
		int temp = stut1.getName().compareTo(stut2.getName());
		if (0 != temp) {
		    return temp;
		} else {
			return stut1.getAge() - stut2.getAge();
		}
	}
}