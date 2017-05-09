
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
集合ArrayList-->ah所有Human对象如下：
索引[0]:<name = 张山, id = 18>
索引[1]:<name = 李四, id = HW666>
索引[2]:<name = Fake, id = 3.14>
---------------------------
集合ArrayList-->am所有Man对象如下：
索引[0]:<name = NB007, id = 16>
索引[1]:<name = NB009, id = 14>
索引[2]:<name = NB010, id = 12>
索引[3]:<name = NB011, id = 13>
---------------------------
请按任意键继续. . .
 */

 import java.util.*;
class FXSuperDemo {
	public static void main(String[] args) {
		/* FXSuperDemo.java文件解决问题：
		 * 泛型限定的高级应用：
		 * <?>为通配符，相当于<T>，所不同的是，T可以被明确，而?始终不明确
		 * <? extends E>，E为具体类，代表E和E的子类，这是泛型上限限定
		 * <? super E>，E为具体类，代表E和E的父类，这是泛型下限限定
		 * 需要注意的是，常用的只能是泛型下限限定，因为父类、子类都已知
		 * 而使用泛型下限限定时，由于Object是所有类的最上限，
		 &						 而使用一些子类方法时父类没有，所以报错
		 */
		ArrayList<Human> ah = new ArrayList<Human>();
		ah.add(new Human("张山", 18));
		ah.add(new Human("李四", "HW666"));
		ah.add(new Human("Fake", 3.14));
		lineSplit();
		sop("编译有警告提示信息：\n---------- 编译 ----------\n"
			+ "注: FXSuperDemo.java使用了未经检查或不安全的操作。\n"
			+ "注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。");
		lineSplit();
		sop("集合ArrayList-->ah所有Human对象如下：");
		arrayListOut(ah);
		lineSplit();

		ArrayList<Man> am = new ArrayList<Man>();
		am.add(new Man("NB007", 16));
		am.add(new Man("NB009", 14));
		am.add(new Man("NB010", 12));
		am.add(new Man("NB011", 13));
		sop("集合ArrayList-->am所有Man对象如下：");
		arrayListOut(am);
		lineSplit();
	}
	
	public static void arrayListOut(ArrayList<? extends Human> as) {
		int i = 0;
		for (ListIterator<? extends Human> ai = as.listIterator(); ai.hasNext(); i++) {
		    sop("索引[" + i + "]:<name = " + ai.next().getName()
				+ ", id = " + ai.previous().getId() + ">");
			/**
			 * ListIterator.next()：取下一个元素，指针向next移动一个
			 * ListIterator.previous()：取前一个元素，指针向前移动一个
			 * 从而，一次ListIterator.next()与一次ListIterator.previous()操作相抵消，指针原地未动
			 */
			ai.next();		//将指针移向下一个元素
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

class Human<T>{
    private String name;
	private T id;
	public Human() {}
	public Human(String name, T id) {
		this.name = name;
		this.id = id;
	}

	public T getId() {
		return this.id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Man extends Human {
//子类继承父类，父类不可以带泛型，错误示例：
//clas  Man extends Human<T>
	/**
	 * 子类不能从父类继承直接得到父类的私有属性
	 * 但子类可以通过继承得到父类的菲私有方法获取父类的成员属性
	 * 这类似于多态中的，父类的私有属性对于子类来说是隐式的
	 */
	public Man() {}
	public Man(String name, int id) {
		super(name, id);
	}
}
