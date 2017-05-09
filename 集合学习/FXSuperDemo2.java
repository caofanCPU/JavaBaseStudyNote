/**
 * ���ͣ�Ҫ�����Ķ������Ͳ���ȷ���Ѷ������ͽ��ɲ�ͬ������������ָ��
 *		 1.���Ͷ���������<T>���Դ����еĳ�Ա��������ֱ��ʹ�ø÷���<T>
 *		 2.���Ͷ����ڷ�����<Q>���Դˣ������еĲ����������Ϳ�ʹ�ø÷���<T>
 *		 3.���Ͷ����ھ�̬������<W>�����ˣ���̬������������ֻ��ʹ�÷����ľ�̬����<W>
 *							        ������֪��ȷ�����ͣ�����ʹ�����ϵķ���<T>
 *							ԭ�����Ϸ�����ȷ������Ķ��󣬶���̬�����ڶ������ǰ��ʼ����
 *		 4.���һ���������Ա����������������ͬ�����Ͷ��������ϽϺ�(��̬�������붨��ͬ���ķ���)
 *		 5.���һ�����н϶��Ա��������ͬ�����ͣ��ٲ��ֲ�ͬ�������϶��巺�ͣ��ٲ��ַ������巺��
 *		 6.������Ҫ���ڴ�������Ԫ�ز���
 *		 7.����Ҳ�ɶ����ڽӿ��ϣ���Ҫ��java����װ���ˣ�������ʱʹ��
 *		 8.���϶����˷���<T1>�����Ա�������ֶ����˷���<T2>����ô��Ա�������Է���<T2>Ϊ�������Է���<T1>
 */

/**
/*FXSuperDemo.java���н����
---------------------------
�����о�����ʾ��Ϣ��
---------- ���� ----------
ע: FXSuperDemo.javaʹ����δ�����򲻰�ȫ�Ĳ�����
ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣
---------------------------
����TreeSet-->tsHumanԪ��Ψһ���й������£�
Ԫ��<name = ��ɽ, ID = 18>..PK..Ԫ��<name = ��ɽ, ID = 18>
Ԫ��<name = ����, ID = 69138951>..PK..Ԫ��<name = ��ɽ, ID = 18>
Ԫ��<name = Fake, ID = 300063655>..PK..Ԫ��<name = ��ɽ, ID = 18>
---------------------------
����TreeSet-->tsHuman����nameΨһ�������������£�
��1��Ԫ��:<name = Fake, id = 3.14>
��2��Ԫ��:<name = ��ɽ, id = 18>
��3��Ԫ��:<name = ����, id = HW666>
---------------------------
����TreeSet-->tsManԪ��Ψһ���й������£�
Ԫ��<name = abc, ID = 18>..PK..Ԫ��<name = abc, ID = 18>
Ԫ��<name = cba, ID = 17>..PK..Ԫ��<name = abc, ID = 18>
Ԫ��<name = cab, ID = 19>..PK..Ԫ��<name = abc, ID = 18>
Ԫ��<name = cab, ID = 19>..PK..Ԫ��<name = cba, ID = 17>
Ԫ��<name = abc, ID = 18>..PK..Ԫ��<name = cab, ID = 19>
Ԫ��<name = abc, ID = 18>..PK..Ԫ��<name = abc, ID = 18>
Ԫ��<name = cba, ID = 17>..PK..Ԫ��<name = cab, ID = 19>
Ԫ��<name = cba, ID = 17>..PK..Ԫ��<name = cba, ID = 17>
Ԫ��<name = cab, ID = 19>..PK..Ԫ��<name = cab, ID = 19>
---------------------------
����TreeSet-->tsMan����nameΨһ�������������£�
��1��Ԫ��:<name = abc, id = 18>
��2��Ԫ��:<name = cab, id = 19>
��3��Ԫ��:<name = cba, id = 17>
---------------------------
�밴���������. . .
*/
import java.util.*;
class FXSuperDemo2 {
	public static void main(String[] args) {
		/* FXSuperDemo2.java�ļ�������⣺
		 * ��FXSuperDemo.java�ļ����ƣ����Ƕ���������
		 * ���ڸ��ࡢ��ͬ�����࣬���ø������ıȽ������ɴ�ͨ��������
		 */
		//������Ҫ���Ը��༰���࣬���дһ���Ƚ�����������ڲ���Ҫ�õĶ�
		//�����ڲ���ʹ�ã�ֻʹ��һ�Σ�ֻ��Ҫ��дһ������
		TreeSet<Human> tsHuman = new TreeSet<Human>(new HumanComparator());
		lineSplit();
		sop("�����о�����ʾ��Ϣ��\n---------- ���� ----------\n"
			+ "ע: FXSuperDemo.javaʹ����δ�����򲻰�ȫ�Ĳ�����\n"
			+ "ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣");
		lineSplit();
		sop("����TreeSet-->tsHumanԪ��Ψһ���й������£�");
		//Human���Ա����idΪ���ͱ�������������趨Ϊ�����׼ʱ�������⴦��
		tsHuman.add(new Human("��ɽ", 18));
		tsHuman.add(new Human("����", "HW666"));
		tsHuman.add(new Human("Fake", 3.14));
		lineSplit();
		sop("����TreeSet-->tsHuman����nameΨһ�������������£�");
		treeSetOut(tsHuman);
		lineSplit();
		TreeSet<Man> tsMan = new TreeSet<Man> (new HumanComparator());
		sop("����TreeSet-->tsManԪ��Ψһ���й������£�");
		//Human���Ա����idΪ���ͱ�������������趨Ϊ�����׼ʱ�������⴦��
		tsMan.add(new Man("abc", 18));
		tsMan.add(new Man("cba", 17));
		tsMan.add(new Man("cab", 19));
		tsMan.add(new Man("abc", 18));
		tsMan.add(new Man("cba", 17));
		tsMan.add(new Man("cab", 19));
		lineSplit();
		sop("����TreeSet-->tsMan����nameΨһ�������������£�");
		treeSetOut(tsMan);
		lineSplit();
	}

	public static void treeSetOut(TreeSet<? extends Human> ts) {
		int i = 1;
		for (Iterator<? extends Human> ih = ts.iterator(); ih.hasNext(); i++) {
		    Human h = ih.next();		//��������Ϊ����
			sop("��" + i + "��Ԫ��:<name = " + h.getName()
				+ ", id = " + h.getId() + ">");
		}
	}
	
	public static void sop(Object obj) {
		/* ��ӡ�ַ���
		*  
		*/
		System.out.println(obj);
	}

	public static void lineSplit() {
		/* ��ӡ�ָ���
		*  
		*/
		sop("---------------------------");
	}
}

class HumanComparator implements Comparator<Human>{
    public int compare(Human h1, Human h2) {
		String str1 = h1.getName();
		String str2 = h2.getName();
		//����id���Է������ͣ���ͬ����֮����бȽϣ���Ҫӳ�䵽ͬһ����
		//����ʹ��idֵ��hashCodeֵ��Ϊ��Ҫ��������
		int id1 = ((Object)h1.getId()).hashCode();
		int id2 = ((Object)h2.getId()).hashCode();
		sop("Ԫ��<name = " + str1 + ", ID = " + id1 + ">"
			+ "..PK.."
			+ "Ԫ��<name = " + str2 + ", ID = " + id2 + ">");
		int temp = str1.compareTo(str2);
		if (0 != temp) {
			return temp;
		} else {
			return id1 - id2;
		}
	}
	public void sop(Object obj) {
		System.out.println(obj);
	}
}