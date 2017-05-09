
/*
集合体系：Collection：存储的是对象的引用
			|-- List：元素时有序的，元素可以重复
					  List集合体系有索引
				|-- ArrayList：底层的数据结构是数组，特点：查询速度快，增删稍慢，线程不同步
				|-- LinkedList：底层的数据结构是链表，特点：查询速度稍慢，增删很快，线程不同步
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
/*ListDemo.java代码运行结果：
---------------------------
原集合ArrayList-->as所有元素::[cy05, cy02, cy00, cy05]
---------------------------
在首尾各插入一个元素后，集合ArrayList-->as所有元素::[520, cy05, cy02, cy00, cy05, 1314]
---------------------------
集合ArrayList-->as中索引2的元素cy02修改为A
集合ArrayList-->as修改后的所有元素::[520, cy05, A, cy00, cy05, 1314]
---------------------------
删除集合最后一个元素:1314
删除后ArrayList-->as所有元素::[520, cy05, A, cy00, cy05]
---------------------------
通过索引遍历集合ArrayList-->as情况如下：
        索引[0] = 520
        索引[1] = cy05
        索引[2] = A
        索引[3] = cy00
        索引[4] = cy05
---------------------------
通过Iterator迭代器去遍历集合ArrayList-->as情况如下：
        索引[0] = 520
        索引[1] = cy05
        索引[2] = A
        索引[3] = cy00
        索引[4] = cy05
---------------------------
使用List自带的ListIterator迭代器遍历集合as情况如下：
        520
        cy05
        A
        cy00
        cy05
---------------------------
集合as中元素cy05的索引为：1
---------------------------
集合as从1(含)到的4(不含)子集所有元素为：[cy05, A, cy00]
---------------------------
对集合ArrayList-->进行遍历[删除|修改]cy05元素情况如下：
        非cy05元素::520
        非cy05元素::cy05
        非cy05元素::A
        非cy05元素::cy00
        非cy05元素::cy05
用cy08迭代替换cy05后，集合as所有元素[520, cy08, A, cy00, cy08]
---------------------------
对集合ArrayList-->进行遍历[删除|修改]cy05元素情况如下：
        非cy05元素::520
        非cy05元素::cy08
        非cy05元素::A
        非cy05元素::cy00
        非cy05元素::cy08
用cy08迭代替换cy05后，集合as所有元素[520, cy08, A, cy00, cy08]
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class ListDemo {
	public static void main(String[] args) {
		//创建ArrayList对象
		ArrayList as = new ArrayList();
		//添加元素【boolean】.add(element)
		lineSplit();
		as.add("cy05");
		as.add("cy02");
		as.add("cy00");
		as.add("cy05");
		sop("原集合ArrayList-->as所有元素::" + as);
		lineSplit();
		//1.在指定索引处添加元素，注意：该插入都是"前插操作"
		//在List首部插入，索引为0；在List尾部插入，索引为List.size()
		//：【void】.add(index, element)
		as.add(0, new Integer(520));
		as.add(as.size(), 1314);
		sop("在首尾各插入一个元素后，集合ArrayList-->as所有元素::" + as);
		lineSplit();
		//2.修改指定索引处元素：【E】.set(index, element)
		sop("集合ArrayList-->as中索引2的元素" + as.set(2, 'A') + "修改为A");
		sop("集合ArrayList-->as修改后的所有元素::" + as);
		lineSplit();
		//3.删除指定索引索引处的元素：【E】.remove(index)
		sop("删除集合最后一个元素:" + as.remove(as.size() - 1));
		sop("删除后ArrayList-->as所有元素::" + as);
		lineSplit();
		//4.通过索引获取元素【E】.get(index)
		sop("通过索引遍历集合ArrayList-->as情况如下：");
		for(int i = 0; i < as.size(); i++) {
			sop("\t索引[" + i + "] = " + as.get(i));
		}
		lineSplit();
		//5.通过继承Colletion而来的Iterator迭代器获取元素
		//【Iterator<E>】.iterator()
		//【boolean】.hasNext()
		//【E】.next()
		sop("通过Iterator迭代器去遍历集合ArrayList-->as情况如下：");
		int i = 0;
		for(Iterator ai = as.iterator(); ai.hasNext(); i++) {
			sop("\t索引[" + i + "] = " + ai.next());
		}
		lineSplit();
		//6.使用List自带的ListIterator迭代器遍历集合as
		//【ListIterator<E>】.listIterator()
		//【boolean】.hasNext()
		//【E】.next()
		sop("使用List自带的ListIterator迭代器遍历集合as情况如下：");
		for(ListIterator<Object> ai = as.listIterator(); ai.hasNext(); ) {
			//注意：由于直到as.listIterator()返回的是Object类型
			//而后续操作不需要强转类型，所以可以限定<Object>
			sop("\t" +ai.next());
		}
		lineSplit();
		//7.获取指定元素的索引：【int】.indexOf()
		sop("集合as中元素" + as.get(1) + "的索引为：" + as.indexOf(as.get(1)));
		lineSplit();
		//获取指定索引范围[fromIndex, toIndex)左开右闭的子列表
		//：【List<E>】.subList(fromIndex, toIndex)
		sop("集合as从1(含)到的4(不含)子集所有元素为：" + as.subList(1,4));
		lineSplit();
		//8.在迭代过程中，使用Iterator迭代器"删"集合元素，不可以"增"，不推荐"改"
		//因为Iterator迭代器本身只提供.remove(空参)方法
		ArrayList as2 = as;		//备份as
		iteratorTest(as);
		sop("用cy08迭代替换cy05后，集合as所有元素" + as);
		lineSplit();
		//9.在迭代过程中，若要"增，改"，必须使用List特有迭代器ListIterator
		listIteratorTest(as2);
		sop("用cy08迭代替换cy05后，集合as所有元素" + as);
		lineSplit();
	}

	public static void iteratorTest(ArrayList as) {
		/*
		演示List从Collection继承而来的Iterator迭代器的局限性
		在迭代过程中，不论是遍历，还是增删改查，都推荐使用ListIterator迭代器
		*/
		Iterator it = as.iterator();
		sop("对集合ArrayList-->进行遍历[删除|修改]cy05元素情况如下：");
		while(it.hasNext()) {
			Object obj = it.next();
			if(obj.equals("cy05")) {
				//it.remove();		//可行，从集合as中删除所有的"cy05"
				/*
				as.remove(obj);		//不可行
				//Exception in thread "main" java.util.ConcurrentModificationException
				*/
				/*
				as.add("cy08");		//不可行
				//Exception in thread "main" java.util.ConcurrentModificationException
				*/
				as.set(as.indexOf(obj), "cy08");		//可行，将集合as中所有的"cy05"替换为"cy08"
			}
			sop("\t非cy05元素::" + obj);
		}
	}

	public static void listIteratorTest(ArrayList as) {
		/*
		演示List特有的ListIterator迭代器的便利方法，开发中推荐使用ListIterator迭代器
		*/
		ListIterator ait = as.listIterator();
		sop("对集合ArrayList-->进行遍历[删除|修改]cy05元素情况如下：");
		/*
		while(ait.hasNext()) {
			if(ait.next() == "cy05") {	//.next()后，指针指向下一个要取得的元素
				ait.set("cy08");
			}
			sop("\t非cy05元素::" + ait.previous());		//将指针前移为取得的当前元素
			ait.next();		//指针还原为即将取得的下一元素
		}
		*/
		while(ait.hasNext()) {
			if(ait.next() == "cy05") {
				ait.remove();
				ait.add("cy08");
			}
			sop("\t非cy05元素::" + ait.previous());
			ait.next();
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}
