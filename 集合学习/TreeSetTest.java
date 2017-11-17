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
/*TreeSetTest.java运行结果：
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
a::10......PK......a::10
b::11......PK......a::10
b::12......PK......a::10
b::12......PK......b::11
a::13......PK......b::11
a::13......PK......a::10
d::14......PK......b::11
d::14......PK......b::12
---------------------------
排序编号：0-->name递增排序
集合TreeSet-->ts实际保存的Student 元素如下：
        [1]号：<Student.name = a, Student.age10>
        [2]号：<Student.name = a, Student.age13>
        [3]号：<Student.name = b, Student.age11>
        [4]号：<Student.name = b, Student.age12>
        [5]号：<Student.name = d, Student.age14>
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
a::10......PK......b::11
a::10......PK......a::10
b::11......PK......b::11
b::12......PK......b::11
b::12......PK......b::12
a::13......PK......b::11
a::13......PK......b::12
a::13......PK......d::14
d::14......PK......b::11
d::14......PK......a::13
d::14......PK......d::14
---------------------------
排序编号：1-->age递增排序
集合TreeSet-->ts实际保存的Student元素如下：
        [1]号：<Student.name = a, Student.age10>
        [2]号：<Student.name = a, Student.age13>
        [3]号：<Student.name = b, Student.age11>
        [4]号：<Student.name = b, Student.age12>
        [5]号：<Student.name = a, Student.age13>
        [6]号：<Student.name = d, Student.age14>
---------------------------
集合TreeSet-->ts添加元素过程详情如下：
a::10......PK......b::11
a::10......PK......a::10
b::11......PK......b::11
b::12......PK......b::11
b::12......PK......a::13
a::13......PK......b::11
a::13......PK......a::13
d::14......PK......b::11
d::14......PK......a::13
d::14......PK......d::14
---------------------------
排序编号：2-->默认hashCode递增排序
集合TreeSet-->ts实际保存的Student元素如下：
        [1]号：<Student.name = a, Student.age10>
        [2]号：<Student.name = a, Student.age13>
        [3]号：<Student.name = b, Student.age11>
        [4]号：<Student.name = b, Student.age12>
        [5]号：<Student.name = a, Student.age13>
        [6]号：<Student.name = d, Student.age14>
---------------------------
请按任意键继续. . .
*/

import java.util.Iterator;
import java.util.TreeSet;

class TreeSetTest {
    public static void main(String[] args) {
        /* TreeSetTest.java文件解决问题：
		*  往TreeSet中存储学生对象：
		*		自动滤掉相同name和age学生
		*		并按照年龄排序
		*/

        //测试代码块/////////////////////////////////////////
        int ORDER_NUM = 0;
        String ORDER_STR = "默认hashCode递增排序";
        TreeSet ts = new TreeSet();
        while ((ORDER_NUM++) != 3) {
            ORDER_STR = orderModel(ORDER_NUM);
            lineSplit();
            sop("集合TreeSet-->ts添加元素过程详情如下：");
            ts.add(new Student("a", 10, ORDER_NUM));
            ts.add(new Student("b", 11, ORDER_NUM));
            ts.add(new Student("b", 12, ORDER_NUM));
            ts.add(new Student("a", 13, ORDER_NUM));
            ts.add(new Student("d", 14, ORDER_NUM));
            lineSplit();
            sop("排序编号：" + (ORDER_NUM - 1) + "-->" + ORDER_STR
                    + "\n集合TreeSet-->ts实际保存的Student元素如下：");
            int i = 1;
            for (Iterator<Student> it = ts.iterator(); it.hasNext(); i++) {
                Student stu = it.next();
                sop("\t[" + i + "]号："
                        + "<Student.name = " + stu.getName() + ", "
                        + "Student.age" + stu.getAge() + ">");
            }
        }
        lineSplit();
        //////////////////////////////////////////////////////

/*		TreeSet ts = new TreeSet();
		//final int ORDER_NUM = 0;
		ts.add(new Student("a", 10, ORDER_NUM));
		ts.add(new Student("b", 11, ORDER_NUM));
		ts.add(new Student("b", 12, ORDER_NUM));
		ts.add(new Student("a", 13, ORDER_NUM));
		ts.add(new Student("d", 14, ORDER_NUM));
		lineSplit();
		sop("排序编号：" + ORDER_NUM + "-->" + ORDER_STR 
			+ "集合TreeSet-->ts实际保存的Student元素如下：");
		int i = 1;
		for (Iterator<Student> it = ts.iterator(); it.hasNext(); i++) {
		    Student stu = it.next();
			sop("\t[" + i + "]号："
			    + "<Student.name = " + stu.getName() + ", "
				+ "Student.age" + stu.getAge() + ">");
		}
		lineSplit();*/
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
}

/**
 * Student实现Comparable接口，使得具备比较性
 */
class Student implements Comparable {
    private int orderNum = 0;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age, int orderNum) {
        //super();
        this.name = name;
        this.age = age;
		/* 强制限制排序模式的代表值
		*  1.name自然(递增)排序
		*  2.age自然(递增)排序
		*  0.默认(父类Person，hashCode值)排序
		*/
        if ((1 != orderNum) &&
                (2 != orderNum)) {
            this.orderNum = 0;
        } else {
            this.orderNum = orderNum;
        }
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
        return this.orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /* 实现Comparable接口
    *  必须进行抽象public int compareTo()的具体实现
    *  排序方式：ordernum :[0，1，2]
    *  1.name递增排序
    *  2.age递增排序
    *  0.默认hashCode值递增排序
    */
    public int compareTo(Object obj) {
		/*if (!(obj instanceof Student)) {
		    throw new RuntimeException("不是Student对象，无法比较!");
		}
		Student stu = (Student)obj;
		System.out.println(this.getName() + "::" + this.getAge()
						   + "......PK......"
						   + stu.getName() + "::" + stu.getAge());
		if (this.getAge() != stu.getAge()) {
		    return this.getAge() - stu.getAge();
		} else {
			if (this.getName() != stu.getName()) {
				return this.getName().equals(stu.getName()) ? 1:-1;
			} else {
				return 0;
			}
		}*/

        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是Student对象，无法比较!");
        }
        Student stu = (Student) obj;
        switch (orderNum) {
            case 1:
                return compareToName(stu);
            //break;
            case 2:
                return compareToAge(stu);
            //break;
            default:
                return compareToDefault(stu);
        }
    }

    public int compareToName(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是Student对象，无法比较!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        int temp = this.getName().compareTo(stu.getName());
        if (0 != temp) {
            return temp;
        } else {
            return this.getAge() - stu.getAge();
        }
    }

    public int compareToAge(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是Student对象，无法比较!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        int temp = this.getAge() - stu.getAge();
        if (0 != temp) {
            return temp;
        } else {
            return this.getName().compareTo(stu.getName());
        }
    }

    public int compareToDefault(Object obj) {
        if (!(obj instanceof Student)) {
            throw new RuntimeException("不是Student对象，无法比较!");
        }
        Student stu = (Student) obj;
        System.out.println(this.getName() + "::" + this.getAge()
                + "......PK......"
                + stu.getName() + "::" + stu.getAge());
        return this.hashCode() - stu.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            //不建议：return false;
            throw new RuntimeException("比较对象不是Student对象，无意义！");
        }
        //Person继承Object，因而obj可以向下转型
        //如果obj不向下转型为Person对象，则obj没有name和age属性
        Student stu = (Student) obj;
        //name为字符串对象，有默认继承自Object的.equals(Object)方法
        //字符串的.equal(Object obj)方法属于：父类引用指向子类对象，向上提升对象
        return (this.name.equals(stu.name))
                && (this.age == stu.age);
    }

    public int hashCode() {
		/* this.name为String对象，String.hashCode()由String对象内容唯一决定
		*  据此，Person对象的name和age也能唯一决定其hashCode()返回值
		*/
        return (this.name.hashCode() + age);
    }

}