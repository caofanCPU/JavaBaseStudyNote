/**
 * 泛型：要操作的对象类型不明确，把对象类型交由不同的需求者自行指定
 *		 1.泛型定义在类上<T>，以此类中的成员变量可以直接使用该泛型<T>
 *		 2.泛型定义在方法上<Q>，以此，方法中的参数变量类型可使用该泛型<T>
 *		 3.泛型定义在静态方法上<W>，若此，静态方法参数类型只能使用方法的静态泛型<W>
 *							        或者已知的确定类型，不能使用类上的泛型<T>
 *							原因：类上泛型明确依托类的对象，而静态方法在对象产生前开始动作
 *		 4.如果一个类中其成员方法操作的类型相同，则泛型定义在类上较好(静态方法必须定义同样的泛型)
 *		 5.如果一个类中较多成员方法操作同样类型，少部分不同，则类上定义泛型，少部分方法定义泛型
 *		 6.泛型主要用于处理集合中元素操作
 *		 7.泛型也可定义在接口上，主要由java包封装好了，供开发时使用
 *		 8.类上定义了泛型<T1>，其成员方法上又定义了泛型<T2>，那么成员方法将以泛型<T2>为主，忽略泛型<T1>
 */

/**
/*FXSuperDemo.java运行结果：
---------------------------
编译有警告提示信息：
---------- 编译 ----------
注: FXSuperDemo.java使用了未经检查或不安全的操作。
注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
---------------------------
集合TreeSet-->tsHuman元素唯一排列过程如下：
元素<name = 张山, ID = 18>..PK..元素<name = 张山, ID = 18>
元素<name = 李四, ID = 69138951>..PK..元素<name = 张山, ID = 18>
元素<name = Fake, ID = 300063655>..PK..元素<name = 张山, ID = 18>
---------------------------
集合TreeSet-->tsHuman按照name唯一递增排序结果如下：
第1个元素:<name = Fake, id = 3.14>
第2个元素:<name = 张山, id = 18>
第3个元素:<name = 李四, id = HW666>
---------------------------
集合TreeSet-->tsMan元素唯一排列过程如下：
元素<name = abc, ID = 18>..PK..元素<name = abc, ID = 18>
元素<name = cba, ID = 17>..PK..元素<name = abc, ID = 18>
元素<name = cab, ID = 19>..PK..元素<name = abc, ID = 18>
元素<name = cab, ID = 19>..PK..元素<name = cba, ID = 17>
元素<name = abc, ID = 18>..PK..元素<name = cab, ID = 19>
元素<name = abc, ID = 18>..PK..元素<name = abc, ID = 18>
元素<name = cba, ID = 17>..PK..元素<name = cab, ID = 19>
元素<name = cba, ID = 17>..PK..元素<name = cba, ID = 17>
元素<name = cab, ID = 19>..PK..元素<name = cab, ID = 19>
---------------------------
集合TreeSet-->tsMan按照name唯一递增排序结果如下：
第1个元素:<name = abc, id = 18>
第2个元素:<name = cab, id = 19>
第3个元素:<name = cba, id = 17>
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class FXSuperDemo2 {
	public static void main(String[] args) {
		/* FXSuperDemo2.java文件解决问题：
		 * 与FXSuperDemo.java文件类似，但是多了排序功能
		 * 对于父类、不同的子类，设置父类对象的比较器，由此通用于子类
		 */
		//由于需要测试父类及子类，因而写一个比较器类比匿名内部类要好的多
		//匿名内部类使用：只使用一次，只需要复写一个方法
		TreeSet<Human> tsHuman = new TreeSet<Human>(new HumanComparator());
		lineSplit();
		sop("编译有警告提示信息：\n---------- 编译 ----------\n"
			+ "注: FXSuperDemo.java使用了未经检查或不安全的操作。\n"
			+ "注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。");
		lineSplit();
		sop("集合TreeSet-->tsHuman元素唯一排列过程如下：");
		//Human类成员属性id为泛型变量，因而将其设定为排序标准时需作特殊处理
		tsHuman.add(new Human("张山", 18));
		tsHuman.add(new Human("李四", "HW666"));
		tsHuman.add(new Human("Fake", 3.14));
		lineSplit();
		sop("集合TreeSet-->tsHuman按照name唯一递增排序结果如下：");
		treeSetOut(tsHuman);
		lineSplit();
		TreeSet<Man> tsMan = new TreeSet<Man> (new HumanComparator());
		sop("集合TreeSet-->tsMan元素唯一排列过程如下：");
		//Human类成员属性id为泛型变量，因而将其设定为排序标准时需作特殊处理
		tsMan.add(new Man("abc", 18));
		tsMan.add(new Man("cba", 17));
		tsMan.add(new Man("cab", 19));
		tsMan.add(new Man("abc", 18));
		tsMan.add(new Man("cba", 17));
		tsMan.add(new Man("cab", 19));
		lineSplit();
		sop("集合TreeSet-->tsMan按照name唯一递增排序结果如下：");
		treeSetOut(tsMan);
		lineSplit();
	}

	public static void treeSetOut(TreeSet<? extends Human> ts) {
		int i = 1;
		for (Iterator<? extends Human> ih = ts.iterator(); ih.hasNext(); i++) {
		    Human h = ih.next();		//泛型上限为父类
			sop("第" + i + "个元素:<name = " + h.getName()
				+ ", id = " + h.getId() + ">");
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

class HumanComparator implements Comparator<Human>{
    public int compare(Human h1, Human h2) {
		String str1 = h1.getName();
		String str2 = h2.getName();
		//由于id属性泛型类型，不同类型之间进行比较，需要映射到同一类型
		//这里使用id值的hashCode值作为次要排序依据
		int id1 = ((Object)h1.getId()).hashCode();
		int id2 = ((Object)h2.getId()).hashCode();
		sop("元素<name = " + str1 + ", ID = " + id1 + ">"
			+ "..PK.."
			+ "元素<name = " + str2 + ", ID = " + id2 + ">");
		int temp = str1.compareTo(str2);
		if (0 != temp) {
			return temp;
		} else {
			return id1 - id2;
		}
	}
	public void sop(Object obj) {
		System.out.println(obj);
	}
}