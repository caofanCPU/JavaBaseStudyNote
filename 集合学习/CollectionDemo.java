/*
������ϵ��Collection���洢���Ƕ��������
			|-- List��Ԫ��ʱ����ģ�Ԫ�ؿ����ظ�
					  List������ϵ������
				|-- ArrayList
				|-- LinkedList
				|-- Vector
			|-- Set��Ԫ��������ģ�Ԫ�ز������ظ�
				|-- HashSet
				|-- TreeSet
		��Map
			|-- HashTable
			|-- HashMap
			|-- TreeMap


*/
//--------------------------//
/*CollectionDemo.java���н�����£�
---------------------------
����ad��hashCode::1
����ad2��hashCode::1
---------------------------
δ����κ�Ԫ��ʱ������ad����Ԫ��::[]
���Ԫ��qq01�󣬼���ad����Ԫ��::[qq01]
���Ԫ�غ󣬼���ad����Ԫ��::[qq01, qq02, qq04, qq03]
����ad��hashCode::-352281631
����ad2��hashCode::1
---------------------------
����ArrayList-->ad.size :4
����ArrayList-->ad2.size :0
---------------------------
qq03�Ƿ������ArrayList-->ad��:true
---------------------------
Ԫ��qq01�Ƴ��ɹ�::true
qq01�Ƿ������ArrayList-->ad��:false
---------------------------
����adִ����ղ�����ArrayList-->adΪ��::true
---------------------------
ִ��[��Ӽ���]ǰ::::
        ����ad����Ԫ��:[]
        ����ad2����Ԫ��:[QQ02, QQ04, QQ03, QQ01]
�ռ���ArrayList-->ad��Ӽ���ad2�ɹ�::true
��Ӽ���ad2��ArrayList-->ad����Ԫ��::[QQ02, QQ04, QQ03, QQ01]
---------------------------
����ad����ad2����Ԫ��::true
---------------------------
ȥ������ad�뼯��ad2�Ľ���Ԫ�سɹ�::true
ִ��ȥ������Ԫ�غ�::::
        ����ad����Ԫ��:[]
        ����ad2����Ԫ��[QQ02, QQ04, QQ03, QQ01]
---------------------------
ִ��[��������]ǰ::::
        ����ad����Ԫ��:[QQ03, QQ02, qq05]
        ����ad2����Ԫ��:[QQ02, QQ04, QQ03, QQ01]
��������ad�뼯��ad2�Ľ���Ԫ�سɹ�:true
ֻ��������ad�뼯��ad2�Ľ����󣬼���ad����Ԫ��[QQ03, QQ02]
---------------------------
����ad��hashCode::79759392
����ad2��hashCode::-580905055
---------------------------
����adԪ��::QQ03
����adԪ��::QQ02
---------------------------
����ad2Ԫ��::QQ02
����ad2Ԫ��::QQ04
����ad2Ԫ��::QQ03
����ad2Ԫ��::QQ01
---------------------------
�밴���������. . .
*/

import java.util.ArrayList;
import java.util.Iterator;

class CollectionDemo {
    public static void main(String[] args) {
        //����һ������������ʹ��Collection�ӿ��е�����ArrayList
        ArrayList ad = new ArrayList();
        ArrayList ad2 = new ArrayList();
        lineSplit();
        sop("����ad��hashCode::" + ad.hashCode()
                + "\n����ad2��hashCode::" + ad2.hashCode());
        lineSplit();
        //1.���Ԫ�أ���boolean��.add(Ԫ�ض���)
        sop("δ����κ�Ԫ��ʱ������ad����Ԫ��::" + ad);
        ad.add("qq01");
        sop("���Ԫ��qq01�󣬼���ad����Ԫ��::" + ad);
        ad.add("qq02");
        ad.add("qq04");
        ad.add("qq03");
        sop("���Ԫ�غ󣬼���ad����Ԫ��::" + ad);
        sop("����ad��hashCode::" + ad.hashCode()
                + "\n����ad2��hashCode::" + ad2.hashCode());
        lineSplit();
        //2.��ȡ���϶���Ԫ�س��ȣ���int��.size(�ղ�)
        sop("����ArrayList-->ad.size :" + ad.size()
                + "\n����ArrayList-->ad2.size :" + ad2.size());
        lineSplit();
        //3.�жϼ����Ƿ����ĳԪ�أ���boolean��.contains(Ԫ�ض���)
        sop("qq03�Ƿ������ArrayList-->ad��:" + ad.contains("qq03"));
        lineSplit();
        //4.�Ƴ�ĳ��Ԫ�أ���boolean��.remove()
        sop("Ԫ��qq01�Ƴ��ɹ�::" + ad.remove("qq01"));
        sop("qq01�Ƿ������ArrayList-->ad��:" + ad.contains("qq01"));
        lineSplit();
        //5.��ռ��ϣ���void��.clear(�ղ�)
        ad.clear();
        //6.�жϼ���Ϊ�գ���boolean��.isEmpty(�ղ�)
        sop("����adִ����ղ�����ArrayList-->adΪ��::" + ad.isEmpty());
        lineSplit();
        //7.�����һ����������Ԫ�ص������ϣ���boolean��.addAll(����)
        ad2.add("QQ02");
        ad2.add("QQ04");
        ad2.add("QQ03");
        ad2.add("QQ01");
        sop("ִ��[��Ӽ���]ǰ::::\n\t����ad����Ԫ��:" + ad
                + "\n\t����ad2����Ԫ��:" + ad2);
        sop("�ռ���ArrayList-->ad��Ӽ���ad2�ɹ�::" + ad.addAll(ad2));
        sop("��Ӽ���ad2��ArrayList-->ad����Ԫ��::" + ad);
        lineSplit();
        //8.�жϼ����Ƿ������һ����������Ԫ�أ���boolean��.containsAll(����)
        sop("����ad����ad2����Ԫ��::" + ad.containsAll(ad2));
        lineSplit();
        //9.�ڼ���ad��ȥ������ad�뼯��ad2�Ľ�������boolean��.removeAll(����)
        sop("ȥ������ad�뼯��ad2�Ľ���Ԫ�سɹ�::" + ad.removeAll(ad2));
        sop("ִ��ȥ������Ԫ�غ�::::\n\t����ad����Ԫ��:" + ad
                + "\n\t����ad2����Ԫ��" + ad2);
        lineSplit();
        //10.�ڼ���ad�б�������ad�ͼ���ad2�Ľ�������boolean��.retainAll(����)
        ad.add("QQ03");
        ad.add("QQ02");
        ad.add("qq05");
        sop("ִ��[��������]ǰ::::\n\t����ad����Ԫ��:" + ad
                + "\n\t����ad2����Ԫ��:" + ad2);
        sop("��������ad�뼯��ad2�Ľ���Ԫ�سɹ�:" + ad.retainAll(ad2));
        sop("ֻ��������ad�뼯��ad2�Ľ����󣬼���ad����Ԫ��" + ad);
        lineSplit();
        //11.���ؼ��ϵĹ�ϣ��ֵ(�뼯����Ԫ�ض�̬���)
        sop("����ad��hashCode::" + ad.hashCode()
                + "\n����ad2��hashCode::" + ad2.hashCode());
        lineSplit();
        //12.ʹ��Iterator�����������ȡ����Ԫ�أ���Iterator��.iterator()
        //��ȡ����ad�ĵ���������iterator��Iterator����
        Iterator iterator = ad.iterator();
        while (iterator.hasNext()) {    //������������һ��Ԫ��:true
            sop("����adԪ��::" + iterator.next());        //�����ǰԪ�ض���
        }
        lineSplit();
        for (iterator = ad2.iterator(); iterator.hasNext(); ) {
            //forѭ���ڲ�������ĵ���������ʹ�����ᱻ����
            //ʵ�ʿ���ʹ��forѭ������whileѭ��
            //����ֱ��ʹ��ǰ�������iterator�������
            sop("����ad2Ԫ��::" + iterator.next());
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
