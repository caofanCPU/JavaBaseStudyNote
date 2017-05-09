
import java.util.Scanner;
import java.util.*;
class StrCount {
	public static void main(String[] args) {
		/* StrCount.java文件解决问题：
		 * 对于给定字符串str，统计每个字母出现的次数times
		 * 例如：输入：audbbhjka
		 *		 输出：a(2)->b(2)->d(1)->h(1)->j(1)->k(1)
		 */
		//String inputStr= "audbbhjka";
		Scanner sc = new Scanner(System.in);
		while (true) {
			sop("请输入需要进行字母统计的字符串：");
			charCount(sc.nextLine());		//调用本类charCount()方法，处理字符串字母统计并输出结果
		}
	}

	/**
	 * 对输入的字符串参数进行字母统计
	 */

	public static boolean charCount(String inputStr) {
		sop("你输入的字符串为：" + inputStr);
		/**
		 * 对用户输入的字符串进行正则替换处理，去除非字母字符
		 */
		String chStr = inputStr.replaceAll("[^a-zA-z]", "");				//剔除非字母的字符
		sop("你输入的有效字母字符串为：" + chStr);
		if (chStr.isEmpty()) {
		    sop("未输入有效字符(a-z || A-Z)，字母统计结果为null(null)");
			return false;
		}
		char[] ch= chStr.toCharArray();	
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		Integer value;
		for (int i = 0; i < ch.length; i++) {
/*			//由于前面使用正则处理过字符串，保证到达此处的字符数组元素都是字母
			if (!((ch[i] >= 'a' && ch[i] <= 'z')
				|| (ch[i] >= 'A' && ch[i] <= 'Z'))) {
				continue;
			}
*/
			/**
			 * 对于第一次出现的字母，通过Map.get(键)返回的值为null，而null只能参与 == 的逻辑判断
			 * 因而使用if判断，如果Map.get(键)返回的值为null，则value置为Integer 0
			 */
			value = tm.get(ch[i]);
			if (null == value) {
				value = 0;
			}
			//加入TreeMap时，若键存在，新的值(++value)会替代旧值
			//	             若键不存在，由于前述已将null处理为0，(++value)仍能完成计数功能
			tm.put(ch[i],++value);
		}
		sop("字母统计结果如下:");
		int i = 1;
		for (Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator(); it.hasNext(); i++) {
			Map.Entry<Character, Integer> me = it.next();
			if (i != tm.size()) {
				sopt("第[" + i + "]个字母：" + me.getKey() + "(" + me.getValue() + ")->" );
			} else {
				sopt("第[" + i + "]个字母：" + me.getKey() + "(" + me.getValue() + ")" );
			}
			
			if(5 == i) {
				sop("");
			}
		}
		sop("");
		lineSplit();
		return true;
	}
	
	public static void sop(Object obj) {
		/* 打印字符串
		*  
		*/
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* 打印字符串
		*  
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
