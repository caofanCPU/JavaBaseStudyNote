
/*
������ϵ��Collection���洢���Ƕ��������
			|-- List��Ԫ��ʱ����ģ�Ԫ�ؿ����ظ�
					  List������ϵ������
				|-- ArrayList���ײ�����ݽṹ�����飬�ص㣺��ѯ�ٶȿ죬��ɾ�������̲߳�ͬ��
				|-- LinkedList���ײ�����ݽṹ�������ص㣺��ѯ�ٶ���������ɾ�ܿ죬�̲߳�ͬ��
						LinkedList���з�����
							��boolean��.offerFirst(element)���ڱ�ͷ���Ԫ��
							��boolean��.offerLast(element)���ڱ�ĩ���Ԫ��
							��E��.peekFirst(�ղ�)������ȡ��ͷԪ�أ����ı�LinkedList
							��E��.peekLast(�ղ�)������ȡ��ĩԪ�أ����ı�LinkedList
							��E��.pollFirst(�ղ�)����ȡ���Ƴ���ͷԪ�أ��ı�LinkedList
							��E��.pollLast(�ղ�)����ȡ���Ƴ���βԪ�أ��ı�LinkedList
							��E��.pop(�ղ�)������������һ��ջ��Ԫ��
							��void��.push(element)��ѹ��һ��Ԫ����ջ��
				|-- Vector���ײ�����ݽṹ�����飬�߳�ͬ�����ѱ�ArrayList���
			|-- Set��Ԫ��������ģ�Ԫ�ز������ظ�
				|-- HashSet
				|-- TreeSet
		��Map
			|-- HashTable
			|-- HashMap
			|-- TreeMap
List�����з��������ǿ���������������ķ���
	--����
		��void��add(index, element):��ָ����������ָ��Ԫ��
		��boolean��addAll(index, Collection)����ָ����������ָ����������Ԫ��
	--ɾ��
		��E��remove(index)���Ƴ�������ָ��Ԫ��
	--�ģ�
		��E��set(index, element)����ָ��λ���滻������ԭ��Ԫ��
	--�飺
		��E��get(index)����ȡ������ָ��Ԫ��
		��int��indexOf(element)����ȡ������ָ��Ԫ�ص�index
		��List<E>��subList(fromIndex, toIndex)����ȡ������[fromIndex��toIndex)�����б�
		��ListIterator<E>��listInterator()����ȡ�����ظ�List�����Ԫ������<E>�ĵ���������
*/
//----------------------------/
/*ArrayListDemo2.java���н����
---------------------------
ȥ���ظ�����ǰ��ArrayList-->as�������ж������£�
        ArrayList-->as����Ԫ��[0] = Person@15db9742(name = ����, age = 20)
        ArrayList-->as����Ԫ��[1] = Person@6d06d69c(name = ����, age = 22)
        ArrayList-->as����Ԫ��[2] = Person@7852e922(name = ����, age = 12)
        ArrayList-->as����Ԫ��[3] = Person@4e25154f(name = ����, age = 22)
        ArrayList-->as����Ԫ��[4] = Person@70dea4e(name = ����, age = 12)
        ArrayList-->as����Ԫ��[5] = Person@5c647e05(name = ����, age = 20)
---------------------------
ȥ���ظ������ArrayList-->as�������ж������£�
        ArrayList-->as����Ԫ��[0] = Person@15db9742(name = ����, age = 20)
        ArrayList-->as����Ԫ��[1] = Person@6d06d69c(name = ����, age = 22)
        ArrayList-->as����Ԫ��[2] = Person@7852e922(name = ����, age = 12)
        ArrayList-->as����Ԫ��[3] = Person@5c647e05(name = ����, age = 20)
---------------------------
�밴���������. . .

//------------------------------/
������дhashCode()��Ч��ִ�н�����£�ע��Person���������
---------------------------
ȥ���ظ�����ǰ��ArrayList-->as�������ж������£�
        ArrayList-->as����Ԫ��[0] = Person@bd2fd(name = ����, age = 20)
        ArrayList-->as����Ԫ��[1] = Person@cd963(name = ����, age = 22)
        ArrayList-->as����Ԫ��[2] = Person@e4c75(name = ����, age = 12)
        ArrayList-->as����Ԫ��[3] = Person@cd963(name = ����, age = 22)
        ArrayList-->as����Ԫ��[4] = Person@e4c75(name = ����, age = 12)
        ArrayList-->as����Ԫ��[5] = Person@1172ac(name = ����, age = 20)
---------------------------
ȥ���ظ������ArrayList-->as�������ж������£�
        ArrayList-->as����Ԫ��[0] = Person@bd2fd(name = ����, age = 20)
        ArrayList-->as����Ԫ��[1] = Person@cd963(name = ����, age = 22)
        ArrayList-->as����Ԫ��[2] = Person@e4c75(name = ����, age = 12)
        ArrayList-->as����Ԫ��[3] = Person@1172ac(name = ����, age = 20)
---------------------------
�밴���������. . .
*/
import java.util.*;
class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList as = new ArrayList();
		as.add(new Person("����", 20));
		as.add(new Person("����", 22));
		as.add(new Person("����", 12));
		as.add(new Person("����", 22));
		as.add(new Person("����", 12));
		as.add(new Person("����", 20));
		lineSplit();
		sop("ȥ���ظ�����ǰ��ArrayList-->as�������ж������£�");
		int i = 0;		//i���ڳ䵱����as��Ԫ������
		//ʹ��List���е�ListIterator�����������趨������Ԫ������ΪPerson
		for (ListIterator<Person> it = as.listIterator(); it.hasNext(); i++) {
			sop("\tArrayList-->as����Ԫ��[" + i + "] = " + it.next()
				+ "(name = " + it.previous().getName() + ", "
				+ "age = " + it.next().getAge() + ")");
		}
		lineSplit();
		as = noRepeatObject(as);
		sop("ȥ���ظ������ArrayList-->as�������ж������£�");
		i = 0;		//i���ڳ䵱����as��Ԫ������
		//ʹ��List���е�ListIterator�����������趨������Ԫ������ΪPerson
		for (ListIterator<Person> it = as.listIterator(); it.hasNext(); i++) {
			sop("\tArrayList-->as����Ԫ��[" + i + "] = " + it.next()
				+ "(name = " + it.previous().getName() + ", "
				+ "age = " + it.next().getAge() + ")");
		}
		lineSplit();
	}

	public static ArrayList noRepeatObject(ArrayList as) {
		ArrayList newAs = new ArrayList();
		for (ListIterator<Person> ait = as.listIterator(); ait.hasNext(); ) {
		    if (!newAs.contains(ait.next())) {
				/*����ArrayList��javaԴ�룬��֪��
				ArrayList<Person>����newAs.contains(Person����ait.next())
				���ڵײ������ʹ��forѭ����ѭ������
						Person����.equals(newAs[i])
						��ִ�У�
						Person pait = ait.next();
						for (int i = 0; i < newAs.size(); i++) {
							if (pait.equals(newAs.get(i)) 
								return i >= 0;	//ֻҪ����Person.equals(Object obj)��ȣ�������
						}
						return -1 >= 0;			//������Person.equals(Object obj)��ȣ����ؼ�
						/* .remove(����)ͬ��ѭ��������.equals()����
						*  ��������������δ��дequals()����
						*        ��ִ��.remove(new Person("����", 20))���� false
						*	     ��дequals()���������ж϶�����ȵĹ���ı䣺name��ͬ && age���
						*        ��ִ��.remove(new Person("����", 20))���� true
				*/
				newAs.add(ait.previous());
				ait.next();			//��ԭָ��ָ����һ������Ԫ��
			}
		}
		return newAs;
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void lineSplit() {
		sop("---------------------------");
	}
}

class Person /*extends Object*/ {
    private String name;
	private int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}

	/*
	* ԭʼObject��equals(Object obj)�������Ƚϵľ����������������(��ַ)�Ƿ���ͬ
	*     ����һЩ�������ݵĶ����࣬��String��Integer�ȸ�дequals()�������жϵ��������Ƿ����
	* ��д�̳���Object��.equals(Object obj)����
	* �ж����������Ƿ�һ���Ĺ���name��ͬ && age���
	* ��д��equals(Object obj)�����ǹ�����������ѭ�����õ�
	* ����obj���¼���ArrayList�е�Ԫ��
	*/
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			//�����飺return false;
			throw new RuntimeException("�Ƚ϶�����Person���������壡");
		}
		//Person�̳�Object�����obj��������ת��
		//���obj������ת��ΪPerson������objû��name��age����
		Person p = (Person)obj;
		//nameΪ�ַ���������Ĭ�ϼ̳���Object��.equals(Object)����
		//�ַ�����.equal(Object obj)�������ڣ���������ָ���������������������
		return (this.name.equals(p.name))
				&& (this.age == p.age);
	}
	
	/* �˴���дhashCode������Ϊ����HashSetTest.javaʵ��ʹ��
	*  ����List��˵�������Ҫ�ж�Ԫ�������Ƿ���ͬ(��ȥ��ʱʹ��)
	*  ������Set��˵�����ڱ��뱣֤Ԫ�ص�Ψһ�ԣ�����������ж�hashCode�����ж�����
	*  ��д������name��ageΪ�������������㣺name.hashCode() + age
	*/
	public int hashCode() {
		/* this.nameΪString����String.hashCode()��String��������Ψһ����
		*  �ݴˣ�Person�����name��ageҲ��Ψһ������hashCode()����ֵ
		*/
		return (this.name.hashCode() + this.age);
	}
}
