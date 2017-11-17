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
/*TreeSetDemo.java运行结果：
---------------------------
加入TreeSet-->ts的元素依次为::
        [1号] = 5,  [2号] = 10,  [3号] = 7,  [4号] = 1,  [5 号] = 7,
		[6号] = 1,  [7号] = 9,  [8号] = 9,  [9号] = 5,  [10号] = 2
---------------------------
实际存入TreeSet-->ts的所有元素::
        {1,  2,  5,  7,  9,  10}
---------------------------
请按任意键继续. . .
*/

import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo {
    public static void main(String[] args) {
        /* TreeSetDemo.java文件解决问题：
		*  自动滤掉内容重复对象，并按照自然排序存储以及输出元素
		*/
        TreeSet ts = new TreeSet();
		/* 产生1(含)~10(含)的10个随机整数
		*  int[LENGTH]保存加入TreeSet-->ts的顺序
		*/
        final int LENGTH = 10;
        int[] num = new int[LENGTH];
        lineSplit();
        sopt("加入TreeSet-->ts的元素依次为::\n\t");
        for (int i = 0; i < LENGTH; i++) {
            num[i] = (int) (Math.random() * 10 + 1);
            sopt("[" + (i + 1) + "号] = " + num[i]);
            if ((LENGTH - 1) != i) {
                sopt(",  ");
            } else {
                sopt("\n");
            }
            ts.add(num[i]);        //利用基本数据类型的自动装箱特性
        }
        lineSplit();
        sopt("实际存入TreeSet-->ts的所有元素::\n\t{");
        if (!ts.isEmpty()) {    //如果TreeSet非空，那么一定可以先使用.next()再使用.hasNext()
            for (Iterator<Integer> it = ts.iterator(); ; ) {
                sopt(it.next());
                if (it.hasNext()) {
                    sopt(",  ");
                } else {
                    sopt("}\n");
                    break;    //遍历完毕，结束for循环
                }
            }
        }

        lineSplit();
    }

    public static void sop(Object obj) {
		/* 打印字符串
		*  带换行
		*/
        System.out.println(obj);
    }

    public static void sopt(Object obj) {
		/* 打印字符串
		*  不带换行
		*/
        System.out.print(obj);
    }

    public static void lineSplit() {
		/* 打印分隔符
		*  
		*/
        sop("---------------------------");
    }

}
