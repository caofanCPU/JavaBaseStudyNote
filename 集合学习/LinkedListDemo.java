
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
//---------------------------/
/*LinkedListDemo运行结果：
---------------------------
---------------------------
LinkedList-->ass测试链表，10在前12在后::表头元素->10，表末元素<-12
---------------------------
LinkedList-->ass测试链表，移除表头后::表头元素->12，表末元素<-12
---------------------------
LinkedList-->ass测试链表，再移除表头后::表头元素->null，表末元素<-null
---------------------------
---------------------------
LinkedList-->ass原始链表::表头元素->6，表末元素<-4
---------------------------
LinkedList-->ass原始链表入【队列】顺序：[4, 5, 3, 6]
LinkedList-->ass原始链表出【队列】顺序：[4, 5, 3, 6]
LinkedList-->ass原始链表出【队列】后为空::true
---------------------------
使用压栈方法恢复LinkedList-->ass原始链表::表头元素->6，表末 元素<-4
---------------------------
LinkedList-->ass原始链表入【栈】顺序：[4, 5, 3, 6]
LinkedList-->ass原始链表出【栈】顺序：[6, 3, 5, 4]
LinkedList-->ass原始链表出【栈】后为空::true
---------------------------
请按任意键继续. . .
*/
import java.util.*;
class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList ass = new LinkedList();
		//1.添加元素，表头指向：【boolean】.offerFirst()
		//  添加元素，表末指向：【boolean】.offerLast()
		//使用继承Collection的add()方法添加元素，最先添加的为表头元素
		//										 最后添加的为表末元素
		lineSplit();
		lineSplit();
		ass.add(10);
		ass.add(12);
		sop("LinkedList-->ass测试链表，10在前12在后::"
			+ "表头元素->" + ass.peekFirst()
			+ "，表末元素<-" + ass.peekLast());
		lineSplit();
		ass.remove();	//移除表头
		sop("LinkedList-->ass测试链表，移除表头后::"
			+ "表头元素->" + ass.peekFirst()
			+ "，表末元素<-" + ass.peekLast());
		lineSplit();
		ass.remove();	//再移除表头
		sop("LinkedList-->ass测试链表，再移除表头后::"
			+ "表头元素->" + ass.peekFirst()
			+ "，表末元素<-" + ass.peekLast());
		lineSplit();
		ass.offerFirst(4);
		ass.offerFirst(new Integer(5));
		ass.offerFirst(3);
		ass.offerFirst(6);
		lineSplit();
		//2.获取表头元素，不改变LinkedList：【E】.peekFirst()
		//  获取表末元素，不改变LinkedList：【E】.peekLast()
		sop("LinkedList-->ass原始链表::"
			+ "表头元素->" + ass.peekFirst()
			+ "，表末元素<-" + ass.peekLast());
		//执行队列输自定义API操作
		duiLie(ass);
		//3.判断LinkedList是否为空，这是继承自Colletion的方法
		sop("LinkedList-->ass原始链表出【队列】后为空::" + ass.isEmpty());
		lineSplit();
		//4.压栈添加元素，
		ass.push(4);	//栈顶为表末
		ass.push(5);
		ass.push(3);
		ass.push(6);	//栈底为表头
		sop("使用压栈方法恢复LinkedList-->ass原始链表::"
			+ "表头元素->" + ass.peekFirst()
			+ "，表末元素<-" + ass.peekLast());
		zhan(ass);
		sop("LinkedList-->ass原始链表出【栈】后为空::" + ass.isEmpty());
		lineSplit();
	}
	public static void duiLie(LinkedList ass) {
		lineSplit();
		//入队列的顺序应该是4,5,3,6，但是LinkedList-->ass存储的顺序是6,3,4,5
		//使用Collections.reverse(ass)进行反转，输出后再反转ass还原为存储顺序
		Collections.reverse(ass);
		sop("LinkedList-->ass原始链表入【队列】顺序：" + ass);
		Collections.reverse(ass);
		System.out.print("LinkedList-->ass原始链表出【队列】顺序：[");
		while(!ass.isEmpty()) {
			System.out.print(ass.pollLast());
			if(0 != ass.size()) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
		//lineSplit();
	}

	public static void zhan(LinkedList ass) {
		lineSplit();
		Collections.reverse(ass);
		sop("LinkedList-->ass原始链表入【栈】顺序：" + ass);
		Collections.reverse(ass);
		System.out.print("LinkedList-->ass原始链表出【栈】顺序：[");
		while(!ass.isEmpty()) {
			System.out.print(ass.pop());
			if(0 != ass.size()) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
		//lineSplit();
	}


	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}
