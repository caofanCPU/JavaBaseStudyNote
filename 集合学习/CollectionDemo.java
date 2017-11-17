/*
集合体系：Collection：存储的是对象的引用
			|-- List：元素时有序的，元素可以重复
					  List集合体系有索引
				|-- ArrayList
				|-- LinkedList
				|-- Vector
			|-- Set：元素是无序的，元素不可以重复
				|-- HashSet
				|-- TreeSet
		：Map
			|-- HashTable
			|-- HashMap
			|-- TreeMap


*/
//--------------------------//
/*CollectionDemo.java运行结果如下：
---------------------------
集合ad的hashCode::1
集合ad2的hashCode::1
---------------------------
未添加任何元素时，集合ad所有元素::[]
添加元素qq01后，集合ad所有元素::[qq01]
添加元素后，集合ad所有元素::[qq01, qq02, qq04, qq03]
集合ad的hashCode::-352281631
集合ad2的hashCode::1
---------------------------
集合ArrayList-->ad.size :4
集合ArrayList-->ad2.size :0
---------------------------
qq03是否存在于ArrayList-->ad中:true
---------------------------
元素qq01移除成功::true
qq01是否存在于ArrayList-->ad中:false
---------------------------
集合ad执行清空操作后，ArrayList-->ad为空::true
---------------------------
执行[添加集合]前::::
        集合ad所有元素:[]
        集合ad2所有元素:[QQ02, QQ04, QQ03, QQ01]
空集合ArrayList-->ad添加集合ad2成功::true
添加集合ad2后ArrayList-->ad集合元素::[QQ02, QQ04, QQ03, QQ01]
---------------------------
集合ad包含ad2所有元素::true
---------------------------
去除集合ad与集合ad2的交集元素成功::true
执行去除交集元素后::::
        集合ad所有元素:[]
        集合ad2所有元素[QQ02, QQ04, QQ03, QQ01]
---------------------------
执行[保留交集]前::::
        集合ad所有元素:[QQ03, QQ02, qq05]
        集合ad2所有元素:[QQ02, QQ04, QQ03, QQ01]
保留集合ad与集合ad2的交集元素成功:true
只保留集合ad与集合ad2的交集后，集合ad所有元素[QQ03, QQ02]
---------------------------
集合ad的hashCode::79759392
集合ad2的hashCode::-580905055
---------------------------
集合ad元素::QQ03
集合ad元素::QQ02
---------------------------
集合ad2元素::QQ02
集合ad2元素::QQ04
集合ad2元素::QQ03
集合ad2元素::QQ01
---------------------------
请按任意键继续. . .
*/

import java.util.ArrayList;
import java.util.Iterator;

class CollectionDemo {
    public static void main(String[] args) {
        //创建一个集合容器，使用Collection接口中的子类ArrayList
        ArrayList ad = new ArrayList();
        ArrayList ad2 = new ArrayList();
        lineSplit();
        sop("集合ad的hashCode::" + ad.hashCode()
                + "\n集合ad2的hashCode::" + ad2.hashCode());
        lineSplit();
        //1.添加元素：【boolean】.add(元素对象)
        sop("未添加任何元素时，集合ad所有元素::" + ad);
        ad.add("qq01");
        sop("添加元素qq01后，集合ad所有元素::" + ad);
        ad.add("qq02");
        ad.add("qq04");
        ad.add("qq03");
        sop("添加元素后，集合ad所有元素::" + ad);
        sop("集合ad的hashCode::" + ad.hashCode()
                + "\n集合ad2的hashCode::" + ad2.hashCode());
        lineSplit();
        //2.获取集合对象元素长度：【int】.size(空参)
        sop("集合ArrayList-->ad.size :" + ad.size()
                + "\n集合ArrayList-->ad2.size :" + ad2.size());
        lineSplit();
        //3.判断集合是否包含某元素：【boolean】.contains(元素对象)
        sop("qq03是否存在于ArrayList-->ad中:" + ad.contains("qq03"));
        lineSplit();
        //4.移除某个元素：【boolean】.remove()
        sop("元素qq01移除成功::" + ad.remove("qq01"));
        sop("qq01是否存在于ArrayList-->ad中:" + ad.contains("qq01"));
        lineSplit();
        //5.清空集合：【void】.clear(空参)
        ad.clear();
        //6.判断集合为空：【boolean】.isEmpty(空参)
        sop("集合ad执行清空操作后，ArrayList-->ad为空::" + ad.isEmpty());
        lineSplit();
        //7.添加另一个集合所有元素到本集合：【boolean】.addAll(集合)
        ad2.add("QQ02");
        ad2.add("QQ04");
        ad2.add("QQ03");
        ad2.add("QQ01");
        sop("执行[添加集合]前::::\n\t集合ad所有元素:" + ad
                + "\n\t集合ad2所有元素:" + ad2);
        sop("空集合ArrayList-->ad添加集合ad2成功::" + ad.addAll(ad2));
        sop("添加集合ad2后ArrayList-->ad集合元素::" + ad);
        lineSplit();
        //8.判断集合是否包含另一个集合所有元素：【boolean】.containsAll(集合)
        sop("集合ad包含ad2所有元素::" + ad.containsAll(ad2));
        lineSplit();
        //9.在集合ad中去除集合ad与集合ad2的交集：【boolean】.removeAll(集合)
        sop("去除集合ad与集合ad2的交集元素成功::" + ad.removeAll(ad2));
        sop("执行去除交集元素后::::\n\t集合ad所有元素:" + ad
                + "\n\t集合ad2所有元素" + ad2);
        lineSplit();
        //10.在集合ad中保留集合ad和集合ad2的交集：【boolean】.retainAll(集合)
        ad.add("QQ03");
        ad.add("QQ02");
        ad.add("qq05");
        sop("执行[保留交集]前::::\n\t集合ad所有元素:" + ad
                + "\n\t集合ad2所有元素:" + ad2);
        sop("保留集合ad与集合ad2的交集元素成功:" + ad.retainAll(ad2));
        sop("只保留集合ad与集合ad2的交集后，集合ad所有元素" + ad);
        lineSplit();
        //11.返回集合的哈希码值(与集合内元素动态相关)
        sop("集合ad的hashCode::" + ad.hashCode()
                + "\n集合ad2的hashCode::" + ad2.hashCode());
        lineSplit();
        //12.使用Iterator迭代器对象获取集合元素：【Iterator】.iterator()
        //获取集合ad的迭代器对象iterator，Iterator类型
        Iterator iterator = ad.iterator();
        while (iterator.hasNext()) {    //迭代器还有下一个元素:true
            sop("集合ad元素::" + iterator.next());        //输出当前元素对象
        }
        lineSplit();
        for (iterator = ad2.iterator(); iterator.hasNext(); ) {
            //for循环内部，定义的迭代器对象，使用完后会被回收
            //实际开发使用for循环而非while循环
            //本例直接使用前述定义的iterator对象变量
            sop("集合ad2元素::" + iterator.next());
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
