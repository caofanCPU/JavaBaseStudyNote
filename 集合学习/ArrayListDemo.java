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
/*ArrayListDemo.java运行结果：
---------------------------
10个随机整数对象组成的ArrayList-->af初始化为::
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
自身克隆后ArrayList-->af的所有元素为:
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8, 5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
---------------------------
去重前ArrayList-->af的所有元素为:
	[5, 2, 1, 6, 2, 10, 4, 1, 5, 8, 5, 2, 1, 6, 2, 10, 4, 1, 5, 8]
去重后ArrayList-->af的所有元素为:
	[5, 2, 1, 6, 10, 4, 8]
请按任意键继续. . .
*/

/*去除ArrayList中的重复元素*/

import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList af = new ArrayList();
        //添加元素，使用Math.random()产生[0.0，1.0)的均匀分布随机数
        //			往af中添加10个Integer对象
        for (int i = 10; i > 0; i--) {
            //使用继承自Collection的.add(element)方法添加元素
            af.add((int) (Math.random() * 10) + 1);
        }
        lineSplit();
        sop("10个随机整数对象组成的ArrayList-->af初始化为::\n\t" + af);
        //使用继承自Coletion的.addAll(集合)方法添加自身集合
        af.addAll(af);
        sop("自身克隆后ArrayList-->af的所有元素为:\n\t" + af);
        lineSplit();
        af = noRepeatElement(af);
        sop("去重后ArrayList-->af的所有元素为:\n\t" + af);
    }

    public static ArrayList noRepeatElement(ArrayList af) {
        ArrayList newAf = new ArrayList();
        sop("去重前ArrayList-->af的所有元素为:\n\t" + af);
        //for循环内部建立ListIterator迭代器ait
        //			 ait.hasNext()判断是否当前操作元素是否为表末后一个元素null
        for (ListIterator ait = af.listIterator(); ait.hasNext(); ) {
            //使用继承自Collection的.contains()方法判断是否包含元素
            //			ListIterator迭代器ait.next()方法，获取当前元素，并将指针移向后一个迭代对象
            if (!newAf.contains(ait.next())) {
                //使用ListIterator迭代器ait.previous()特有方法将指针移向当前要获取的对象
                newAf.add(ait.previous());
                //添加后，将指针还原至下一个要迭代的对象
                ait.next();
            }
        }
        return newAf;
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }

    public static void sopt(Object obj) {
        System.out.print(obj);
    }

    public static void lineSplit() {
        sop("---------------------------");
    }
}
