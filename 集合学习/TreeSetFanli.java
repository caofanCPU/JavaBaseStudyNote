

/**
 * 代码运行结果如下：
 * ---------------------------
   AK47::10......PK......AK47::10
   AK44::16......PK......AK47::10
   AK47::16......PK......AK47::10
   AK47::16......PK......AK44::16
   AK47::10......PK......AK44::16
   AK47::10......PK......AK47::10
   集合TreeSet-->ts中实际存储的元素排序如下：
   Name = AK47, Age = 10
   Name = AK44, Age = 16
   Name = AK47, Age = 16
   ---------------------------
   请按任意键继续. . .
 */
import java.util.*;
class TreeSetFanli {
	public static void main(String[] args) {
		/* TreeSetFanli.java文件解决问题：
		*  
		*/
		TreeSet ts = new TreeSet();
		lineSplit();
		ts.add(new StudentFanli("AK47", 10));
		ts.add(new StudentFanli("AK44", 16));
		ts.add(new StudentFanli("AK47", 16));
		ts.add(new StudentFanli("AK47", 10));
		sop("集合TreeSet-->ts中实际存储的元素排序如下：");
		for(Iterator<StudentFanli> it = ts.iterator(); it.hasNext();) {
			StudentFanli stuf = it.next();
			sop("Name = " + stuf.getName() + ", "
				+ "Age = " + stuf.getAge());
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

class StudentFanli implements Comparable {
    private String name;
	private int age;
	public StudentFanli() {}
	public StudentFanli(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	/**
	 * 实现Comparable的public int compareTo(Object obj)方法
	 * 使得对象自身设定了比较规则
	 * 说明：comepareTo方法是由新进来的对象与集合中对象循环调用比较的
	 *		 因而如果新进来对象比已有对象大，则返回值为正整数
	 *		 凡是涉及到"需要判断两个对象是否相同的操作"，底层都在调用compareTo方法
	 * 特殊情况：TreeSet模拟队列：怎么输入的就怎么输出(不可以去重)
	 *			 return 1;
	 *			 TreeSet模拟栈  ：怎么输入的就怎么逆序输出(不可以去重)
	 *			 return -1;
	 *			 如果需要去重，就判断非重复：return 1 | -1;
	 */
	public int compareTo(Object obj) {
		if (!(obj instanceof StudentFanli)) {
		    throw new RuntimeException("比较对象不是StudentFanli，无法比较！");
		}
		StudentFanli stuf = (StudentFanli) obj;
		System.out.println(this.getName() + "::" + this.getAge()
						   + "......PK......"
						   + stuf.getName() + "::" + stuf.getAge());
		/**
		 * age递增排序
		 * 同age，按name递增排序
		 * 同age同name，视为重复，自动过滤
		 */
		int temp = this.getAge() - stuf.getAge();
		if (0 != temp) {
			return temp;
		} else {
			return this.getName().compareTo(stuf.getName());
		}
	}
}
