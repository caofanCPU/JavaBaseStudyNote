
import java.util.Scanner;
import java.util.*;
class StrCount {
	public static void main(String[] args) {
		/* StrCount.java�ļ�������⣺
		 * ���ڸ����ַ���str��ͳ��ÿ����ĸ���ֵĴ���times
		 * ���磺���룺audbbhjka
		 *		 �����a(2)->b(2)->d(1)->h(1)->j(1)->k(1)
		 */
		//String inputStr= "audbbhjka";
		Scanner sc = new Scanner(System.in);
		while (true) {
			sop("��������Ҫ������ĸͳ�Ƶ��ַ�����");
			charCount(sc.nextLine());		//���ñ���charCount()�����������ַ�����ĸͳ�Ʋ�������
		}
	}

	/**
	 * ��������ַ�������������ĸͳ��
	 */

	public static boolean charCount(String inputStr) {
		sop("��������ַ���Ϊ��" + inputStr);
		/**
		 * ���û�������ַ������������滻����ȥ������ĸ�ַ�
		 */
		String chStr = inputStr.replaceAll("[^a-zA-z]", "");				//�޳�����ĸ���ַ�
		sop("���������Ч��ĸ�ַ���Ϊ��" + chStr);
		if (chStr.isEmpty()) {
		    sop("δ������Ч�ַ�(a-z || A-Z)����ĸͳ�ƽ��Ϊnull(null)");
			return false;
		}
		char[] ch= chStr.toCharArray();	
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		Integer value;
		for (int i = 0; i < ch.length; i++) {
/*			//����ǰ��ʹ����������ַ�������֤����˴����ַ�����Ԫ�ض�����ĸ
			if (!((ch[i] >= 'a' && ch[i] <= 'z')
				|| (ch[i] >= 'A' && ch[i] <= 'Z'))) {
				continue;
			}
*/
			/**
			 * ���ڵ�һ�γ��ֵ���ĸ��ͨ��Map.get(��)���ص�ֵΪnull����nullֻ�ܲ��� == ���߼��ж�
			 * ���ʹ��if�жϣ����Map.get(��)���ص�ֵΪnull����value��ΪInteger 0
			 */
			value = tm.get(ch[i]);
			if (null == value) {
				value = 0;
			}
			//����TreeMapʱ���������ڣ��µ�ֵ(++value)�������ֵ
			//	             ���������ڣ�����ǰ���ѽ�null����Ϊ0��(++value)������ɼ�������
			tm.put(ch[i],++value);
		}
		sop("��ĸͳ�ƽ������:");
		int i = 1;
		for (Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator(); it.hasNext(); i++) {
			Map.Entry<Character, Integer> me = it.next();
			if (i != tm.size()) {
				sopt("��[" + i + "]����ĸ��" + me.getKey() + "(" + me.getValue() + ")->" );
			} else {
				sopt("��[" + i + "]����ĸ��" + me.getKey() + "(" + me.getValue() + ")" );
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
		/* ��ӡ�ַ���
		*  
		*/
		System.out.println(obj);
	}

	public static void sopt(Object obj) {
		/* ��ӡ�ַ���
		*  
		*/
		System.out.print(obj);
	}

	public static void lineSplit() {
		/* ��ӡ�ָ���
		*  
		*/
		sop("---------------------------");
	}
}
