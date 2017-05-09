
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
/*TreeSetComparator.java运行结果：
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
后辈AK47::10：：哈希值：：2010167......PK......先辈AK47::10：：哈希值：：2010167
后辈AK44::16：：哈希值：：2010170......PK......先辈AK47::10：：哈希值：：2010167
后辈AK47::16：：哈希值：：2010173......PK......先辈AK47::10：：哈希值：：2010167
后辈AK47::16：：哈希值：：2010173......PK......先辈AK44::16：：哈希值：：2010170
后辈AK47::10：：哈希值：：2010167......PK......先辈AK44::16：：哈希值：：2010170
后辈AK47::10：：哈希值：：2010167......PK......先辈AK47::10：：哈希值：：2010167
---------------------------
排序编号：0-->默认hashCode递增排序
集合TreeSet-->ts实际保存的Student元素如下：
        [1]号：<Student.name = AK47, Student.age10>
        [2]号：<Student.name = AK44, Student.age16>
        [3]号：<Student.name = AK47, Student.age16>
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
后辈AK47::10......PK......先辈AK47::10
后辈AK44::16......PK......先辈AK47::10
后辈AK47::16......PK......先辈AK47::10
后辈AK47::10......PK......先辈AK47::10
---------------------------
排序编号：1-->name递增排序
集合TreeSet-->ts实际保存的Student元素如下：
        [1]号：<Student.name = AK44, Student.age16>
        [2]号：<Student.name = AK47, Student.age10>
        [3]号：<Student.name = AK47, Student.age16>
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
后辈AK47::10......PK......先辈AK47::10
后辈AK44::16......PK......先辈AK47::10
后辈AK47::16......PK......先辈AK47::10
后辈AK47::16......PK......先辈AK44::16
后辈AK47::10......PK......先辈AK44::16
后辈AK47::10......PK......先辈AK47::10
---------------------------
排序编号：2-->age递增排序
集合TreeSet-->ts实际保存的Student元素如下：
        [1]号：<Student.name = AK47, Student.age10>
        [2]号：<Student.name = AK44, Student.age16>
        [3]号：<Student.name = AK47, Student.age16>
---------------------------
请按任意键继续. . .
*/

import java.util.*;
class TreeSetTestComparator {
	public static void main(String[] args) {
		/* TreeSetComparator.java文件解决问题：
		 * StudentTwo对象自身未设定比较规则
		 * 1.以name递增排序
		 *		   同name，以age递增排序
		 * 2.以age递增排序
		 *		   同age，以name递增排序
		 * 3.以name和age计算的hashCode值递增排序
		 *		   计算方法：name.hashCode() + age;
		 */
		int ORDER_NUM = 0;
		String ORDER_STR = "默认hashCode递增排序";
		TreeSet ts;
		while((ORDER_NUM++) < 3) {
			ts = new TreeSet(new StudentComparator(ORDER_NUM-1));
			ORDER_STR = orderModel(ORDER_NUM-1);
			lineSplit();
			sop("集合TreeSet-->ts添加元素过程详情如下：");
			ts.add(new StudentTwo("AK47", 10));
			ts.add(new StudentTwo("AK44", 16));
			ts.add(new StudentTwo("AK47", 16));
			ts.add(new StudentTwo("AK47", 10));
			lineSplit();
			sop("排序编号：" + (ORDER_NUM-1) + "-->" + ORDER_STR 
				+ "\n集合TreeSet-->ts实际保存的Student元素如下：");
			int i = 1;
			for (Iterator<StudentTwo> it = ts.iterator(); it.hasNext(); i++) {
				StudentTwo stut = it.next();
				sop("\t[" + i + "]号："
					+ "<Student.name = " + stut.getName() + ", "
					+ "Student.age" + stut.getAge() + ">");
			}
		}
		lineSplit();
	}

	public static String orderModel(int orderNum) {
		switch (orderNum) {
		case 1:
		    return "name递增排序";
		    //break;
		case 2:
			return "age递增排序";
		default:
			return "默认hashCode递增排序";
		}
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
 * StudentTwo.class文件与本主类文件TreeSetComparator.class在同一目录
 * 因而无须再重复定义
 * 如遇StudentTwo.class未定义或找不到，去除此处注释，即可
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
} */

/**
 * StudentTwo对象的比较器：比较方式[1，2，0]
 * 1.以name递增排序
 *		   同name，以age递增排序
 * 2.以age递增排序
 *		   同age，以name递增排序
 * 3.以name和age计算的hashCode值递增排序
 *		   计算方法：name.hashCode() + age;
 */
class StudentComparator implements Comparator{
//泛型加强版：class StudentComparator implements Comparator<StudentTwo>
	private static int ORDER_NUM = 0;	//最终设计为static final int
	public StudentComparator() {}
	public StudentComparator(int order_num) {
		//super();
		//构造函数执行时，确定排序模式值：ORDER_NUM
		StudentComparator.ORDER_NUM = order_num;		//因为ORDER_NUM为静态变量，因而不要使用this
	}
	public static int getOrderNum() {
		return StudentComparator.ORDER_NUM;				//因为ORDER_NUM为静态变量，因而不要使用this
	}
	public void setOrderNum(int order_num) {
		StudentComparator.ORDER_NUM = order_num;
	}
	
    public int compare(Object obj1, Object obj2) {
//泛型加强版：oublic int compare(StudentTwo stut1, StudentTwo stut2)
		if(!(obj1 instanceof StudentTwo)
			|| !(obj2 instanceof StudentTwo)) {
			throw new RuntimeException("比较对象不是StudentTwo，无法比较！");
		}
		StudentTwo stut1 = (StudentTwo) obj1;
		StudentTwo stut2 = (StudentTwo) obj2;
		switch (StudentComparator.getOrderNum()) {
		case 1:
		    return compareToName(stut1, stut2);
		case 2:
			return compareToAge(stut1, stut2);
		default:
			return compareToDefault(stut1, stut2);
		}
	}

	public int compareToName(StudentTwo stut1, StudentTwo stut2) {
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

	public int compareToAge(StudentTwo stut1, StudentTwo stut2) {
		System.out.println("后辈" + stut1.getName() + "::" + stut1.getAge()
						   + "......PK......"
						   + "先辈" + stut2.getName() + "::" + stut2.getAge());
		int temp = stut1.getAge() - stut2.getAge();
		if (0 != temp) {
		    return temp;
		} else {
			return stut1.getName().compareTo(stut2.getName());
		}
	}

	public int compareToDefault(StudentTwo stut1, StudentTwo stut2) {
		/**
		 * StudentTwo类并未复写hashCode()方法
		 * 在比较器中根据name和age生成hashCode值
		 */
		int hashCode1 = hashCode(stut1.getName(), stut1.getAge());
		int hashCode2 = hashCode(stut2.getName(), stut2.getAge());
		System.out.println("后辈" + stut1.getName() + "::" + stut1.getAge()
								  + "：：哈希值：：" + hashCode1
						   + "......PK......"
						   + "先辈" + stut2.getName() + "::" + stut2.getAge()
							      + "：：哈希值：：" + hashCode2);
		return hashCode1 - hashCode2;
	}
	
	public int hashCode(String name, int age) {
		return name.hashCode() + age;
	}
}