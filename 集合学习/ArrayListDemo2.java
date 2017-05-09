
/*
集合体系：Collection：存储的是对象的引用
			|-- List：元素时有序的，元素可以重复
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
			|-- Set：元素是无序的，元素不可以重复
				|-- HashSet
				|-- TreeSet
		：Map
			|-- HashTable
			|-- HashMap
			|-- TreeMap
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
*/
//----------------------------/
/*ArrayListDemo2.java运行结果：
---------------------------
去除重复对象前，ArrayList-->as集合所有对象如下：
        ArrayList-->as集合元素[0] = Person@15db9742(name = 张三, age = 20)
        ArrayList-->as集合元素[1] = Person@6d06d69c(name = 李四, age = 22)
        ArrayList-->as集合元素[2] = Person@7852e922(name = 王五, age = 12)
        ArrayList-->as集合元素[3] = Person@4e25154f(name = 李四, age = 22)
        ArrayList-->as集合元素[4] = Person@70dea4e(name = 王五, age = 12)
        ArrayList-->as集合元素[5] = Person@5c647e05(name = 赵六, age = 20)
---------------------------
去除重复对象后，ArrayList-->as集合所有对象如下：
        ArrayList-->as集合元素[0] = Person@15db9742(name = 张三, age = 20)
        ArrayList-->as集合元素[1] = Person@6d06d69c(name = 李四, age = 22)
        ArrayList-->as集合元素[2] = Person@7852e922(name = 王五, age = 12)
        ArrayList-->as集合元素[3] = Person@5c647e05(name = 赵六, age = 20)
---------------------------
请按任意键继续. . .

//------------------------------/
本例复写hashCode()生效后，执行结果如下，注意Person对象的引用
---------------------------
去除重复对象前，ArrayList-->as集合所有对象如下：
        ArrayList-->as集合元素[0] = Person@bd2fd(name = 张三, age = 20)
        ArrayList-->as集合元素[1] = Person@cd963(name = 李四, age = 22)
        ArrayList-->as集合元素[2] = Person@e4c75(name = 王五, age = 12)
        ArrayList-->as集合元素[3] = Person@cd963(name = 李四, age = 22)
        ArrayList-->as集合元素[4] = Person@e4c75(name = 王五, age = 12)
        ArrayList-->as集合元素[5] = Person@1172ac(name = 赵六, age = 20)
---------------------------
去除重复对象后，ArrayList-->as集合所有对象如下：
        ArrayList-->as集合元素[0] = Person@bd2fd(name = 张三, age = 20)
        ArrayList-->as集合元素[1] = Person@cd963(name = 李四, age = 22)
        ArrayList-->as集合元素[2] = Person@e4c75(name = 王五, age = 12)
        ArrayList-->as集合元素[3] = Person@1172ac(name = 赵六, age = 20)
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList as = new ArrayList();
		as.add(new Person("张三", 20));
		as.add(new Person("李四", 22));
		as.add(new Person("王五", 12));
		as.add(new Person("李四", 22));
		as.add(new Person("王五", 12));
		as.add(new Person("赵六", 20));
		lineSplit();
		sop("去除重复对象前，ArrayList-->as集合所有对象如下：");
		int i = 0;		//i用于充当集合as的元素索引
		//使用List特有的ListIterator迭代器，并设定迭代的元素类型为Person
		for (ListIterator<Person> it = as.listIterator(); it.hasNext(); i++) {
			sop("\tArrayList-->as集合元素[" + i + "] = " + it.next()
				+ "(name = " + it.previous().getName() + ", "
				+ "age = " + it.next().getAge() + ")");
		}
		lineSplit();
		as = noRepeatObject(as);
		sop("去除重复对象后，ArrayList-->as集合所有对象如下：");
		i = 0;		//i用于充当集合as的元素索引
		//使用List特有的ListIterator迭代器，并设定迭代的元素类型为Person
		for (ListIterator<Person> it = as.listIterator(); it.hasNext(); i++) {
			sop("\tArrayList-->as集合元素[" + i + "] = " + it.next()
				+ "(name = " + it.previous().getName() + ", "
				+ "age = " + it.next().getAge() + ")");
		}
		lineSplit();
	}

	public static ArrayList noRepeatObject(ArrayList as) {
		ArrayList newAs = new ArrayList();
		for (ListIterator<Person> ait = as.listIterator(); ait.hasNext(); ) {
		    if (!newAs.contains(ait.next())) {
				/*查阅ArrayList的java源码，得知：
				ArrayList<Person>集合newAs.contains(Person对象ait.next())
				其在底层代码中使用for循环，循环调用
						Person对象.equals(newAs[i])
						即执行：
						Person pait = ait.next();
						for (int i = 0; i < newAs.size(); i++) {
							if (pait.equals(newAs.get(i)) 
								return i >= 0;	//只要存在Person.equals(Object obj)相等，返回真
						}
						return -1 >= 0;			//不存在Person.equals(Object obj)相等，返回假
						/* .remove(对象)同样循环调用了.equals()方法
						*  因而：本例中如果未复写equals()方法
						*        则执行.remove(new Person("张三", 20))返回 false
						*	     复写equals()方法，将判断对象相等的规则改变：name相同 && age相等
						*        则执行.remove(new Person("张三", 20))返回 true
				*/
				newAs.add(ait.previous());
				ait.next();			//还原指针指向下一个迭代元素
			}
		}
		return newAs;
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}

class Person /*extends Object*/ {
    private String name;
	private int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	/*
	* 原始Object的equals(Object obj)方法，比较的就是两个对象的引用(地址)是否相同
	*     后来一些带有内容的对象类，如String，Integer等复写equals()方法，判断的是内容是否相等
	* 复写继承自Object的.equals(Object obj)方法
	* 判断两个对象是否一样的规则：name相同 && age相等
	* 复写的equals(Object obj)方法是供迭代器对象循环调用的
	* 反而obj是新集合ArrayList中的元素
	*/
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			//不建议：return false;
			throw new RuntimeException("比较对象不是Person对象，无意义！");
		}
		//Person继承Object，因而obj可以向下转型
		//如果obj不向下转型为Person对象，则obj没有name和age属性
		Person p = (Person)obj;
		//name为字符串对象，有默认继承自Object的.equals(Object)方法
		//字符串的.equal(Object obj)方法属于：父类引用指向子类对象，向上提升对象
		return (this.name.equals(p.name))
				&& (this.age == p.age);
	}
	
	/* 此处复写hashCode方法，为后续HashSetTest.java实验使用
	*  对于List来说，最多需要判断元素内容是否相同(仅去重时使用)
	*  但对于Set来说，由于必须保证元素的唯一性，因而必须先判断hashCode，再判断内容
	*  复写规则：以name和age为参数，进行运算：name.hashCode() + age
	*/
	public int hashCode() {
		/* this.name为String对象，String.hashCode()由String对象内容唯一决定
		*  据此，Person对象的name和age也能唯一决定其hashCode()返回值
		*/
		return (this.name.hashCode() + this.age);
	}
}
