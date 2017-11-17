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
				|-- HashSet：底层数据结构是哈希表，判断元素唯一的方式：.hashCode()-->equals.(Object obj)
				|-- TreeSet：底层数据结构是二叉树(红黑树)
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
/*HashSetDemo.java运行结果：
---------------------------
HashSet默认可以添加内容相同元素吗::false
---------------------------
集合HashSet-->hs的所有元素::
        java03
        java01
        java00
---------------------------
请按任意键继续. . .
*/

import java.util.HashSet;
import java.util.Iterator;

class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add("java00");
        hs.add("java01");
        hs.add("java01");
        hs.add("java03");
        lineSplit();
        /* 因为添加的是String对象
		*  而String等内容对象在继承Object时，复写了.hashCode()和.equals(Object obj)
		*  String.hashCode()：s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		*  因而(注意！)，内容相同的对象返回的hashCode值相同！
		*  然后HashSet默认继续使用.equals(Object obj)方法
		*  对于涉及内容的对象，都是判断内容相同为真
		*  所以，上述添加"java01"重复，被HashSet自动丢弃
		*/
        sop("HashSet默认可以添加内容相同元素吗::" + hs.add("java00"));
        lineSplit();
        sop("集合HashSet-->hs的所有元素::");
        for (Iterator<String> it = hs.iterator();
             it.hasNext(); ) {
            sop("\t" + it.next());
        }
        lineSplit();
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }

    public static void lineSplit() {
        sop("---------------------------");
    }
}
