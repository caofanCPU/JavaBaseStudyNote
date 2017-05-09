
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
����ArrayList-->ah����Human�������£�
����[0]:<name = ��ɽ, id = 18>
����[1]:<name = ����, id = HW666>
����[2]:<name = Fake, id = 3.14>
---------------------------
����ArrayList-->am����Man�������£�
����[0]:<name = NB007, id = 16>
����[1]:<name = NB009, id = 14>
����[2]:<name = NB010, id = 12>
����[3]:<name = NB011, id = 13>
---------------------------
�밴���������. . .
 */

 import java.util.*;
class FXSuperDemo {
	public static void main(String[] args) {
		/* FXSuperDemo.java�ļ�������⣺
		 * �����޶��ĸ߼�Ӧ�ã�
		 * <?>Ϊͨ������൱��<T>������ͬ���ǣ�T���Ա���ȷ����?ʼ�ղ���ȷ
		 * <? extends E>��EΪ�����࣬����E��E�����࣬���Ƿ��������޶�
		 * <? super E>��EΪ�����࣬����E��E�ĸ��࣬���Ƿ��������޶�
		 * ��Ҫע����ǣ����õ�ֻ���Ƿ��������޶�����Ϊ���ࡢ���඼��֪
		 * ��ʹ�÷��������޶�ʱ������Object��������������ޣ�
		 &						 ��ʹ��һЩ���෽��ʱ����û�У����Ա���
		 */
		ArrayList<Human> ah = new ArrayList<Human>();
		ah.add(new Human("��ɽ", 18));
		ah.add(new Human("����", "HW666"));
		ah.add(new Human("Fake", 3.14));
		lineSplit();
		sop("�����о�����ʾ��Ϣ��\n---------- ���� ----------\n"
			+ "ע: FXSuperDemo.javaʹ����δ�����򲻰�ȫ�Ĳ�����\n"
			+ "ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣");
		lineSplit();
		sop("����ArrayList-->ah����Human�������£�");
		arrayListOut(ah);
		lineSplit();

		ArrayList<Man> am = new ArrayList<Man>();
		am.add(new Man("NB007", 16));
		am.add(new Man("NB009", 14));
		am.add(new Man("NB010", 12));
		am.add(new Man("NB011", 13));
		sop("����ArrayList-->am����Man�������£�");
		arrayListOut(am);
		lineSplit();
	}
	
	public static void arrayListOut(ArrayList<? extends Human> as) {
		int i = 0;
		for (ListIterator<? extends Human> ai = as.listIterator(); ai.hasNext(); i++) {
		    sop("����[" + i + "]:<name = " + ai.next().getName()
				+ ", id = " + ai.previous().getId() + ">");
			/**
			 * ListIterator.next()��ȡ��һ��Ԫ�أ�ָ����next�ƶ�һ��
			 * ListIterator.previous()��ȡǰһ��Ԫ�أ�ָ����ǰ�ƶ�һ��
			 * �Ӷ���һ��ListIterator.next()��һ��ListIterator.previous()�����������ָ��ԭ��δ��
			 */
			ai.next();		//��ָ��������һ��Ԫ��
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

class Human<T>{
    private String name;
	private T id;
	public Human() {}
	public Human(String name, T id) {
		this.name = name;
		this.id = id;
	}

	public T getId() {
		return this.id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Man extends Human {
//����̳и��࣬���಻���Դ����ͣ�����ʾ����
//clas  Man extends Human<T>
	/**
	 * ���಻�ܴӸ���̳�ֱ�ӵõ������˽������
	 * ���������ͨ���̳еõ�����ķ�˽�з�����ȡ����ĳ�Ա����
	 * �������ڶ�̬�еģ������˽�����Զ���������˵����ʽ��
	 */
	public Man() {}
	public Man(String name, int id) {
		super(name, id);
	}
}
