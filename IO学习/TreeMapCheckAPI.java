//package A.B;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class TreeMapCheckAPI {
    public static void main(String[] args) {
        /**
         * TreeMapCheckAPI.java文件解决问题：
         *
         */
        TreeMap<String, String> tmA = new TreeMap<String, String>();
        TreeMap<String, String> tmB = new TreeMap<String, String>();
/*		tmA.put("A", "10");
        tmA.put("B", "10");
		tmA.put("C", "10");
		tmA.put("D", "11");
		tmA.put("E", "11");
		tmA.put("F", "11");
		tmA.put("G", "12");
		tmA.put("H", "12");
		tmA.put("I", "12");
		//
		tmB.put("A", "10");
		tmB.put("B", "10");
		tmB.put("C", "10");
		tmB.put("D", "19");
		tmB.put("E", "19");
		tmB.put("F", "19");
		tmB.put("X", "16");
		tmB.put("Y", "14");
		tmB.put("Z", "12");*/

        tmA.put("赵灵儿", "30");
        tmA.put("张柏芝", "30");
        tmA.put("刘亦菲", "30");
        tmA.put("黄晓明", "40");
        tmA.put("周伯通", "40");
        tmA.put("黄  容", "40");
        tmA.put("于东升", "10");
        tmA.put("刘懿凡", "10");
        tmA.put("哈  哈", "10");

        tmB.put("赵灵儿", "30");
        tmB.put("张柏芝", "30");
        tmB.put("刘亦菲", "30");
        tmB.put("黄晓明", "22");
        tmB.put("周伯通", "22");
        tmB.put("黄  容", "22");
        tmB.put("皇太极", "10");
        tmB.put("康  熙", "10");
        tmB.put("嘿  嘿", "10");
        keyValueCompare(tmA, tmB);
        sop(Integer.MAX_VALUE);
    }

    public static void keyValueCompare(TreeMap<String, String> tmA, TreeMap<String, String> tmB) {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> entryA = tmA.entrySet().iterator();
             entryA.hasNext(); ) {
            Map.Entry<String, String> meA = entryA.next();
            String aKey = meA.getKey();
            String aValue = meA.getValue();
            if (tmB.containsKey(aKey)) {
                String bValue = tmB.get(aKey);
                if (0 == aValue.compareTo(bValue)) {
                    sb0.append("键值相同：" + "<键 = " + aKey + ", 值 = " + aValue + ">\r\n");
                } else {
                    sb1.append("键同值不同：" + "<键 = " + aKey
                            + ", 文件A值 = " + aValue + "    |文件B值 = " + bValue + ">\r\n");
                }

            } else {
                sb2.append("键值都不同：" + "文件A<键 = " + aKey + ", 值 = " + aValue + ">\r\n");
            }
        }
        sop(sb0.toString());
        lineSplit();
        sop(sb1.toString());
        lineSplit();
        sop(sb2.toString());
        lineSplit();
    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }

    public static void lineSplit() {
        /**
         * 打印分隔符
         *
         */
        sop("---------------------------");
    }
}
