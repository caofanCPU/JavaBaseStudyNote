/**
 * ���ͣ�Ҫ�����Ķ������Ͳ���ȷ���Ѷ������ͽ��ɲ�ͬ������������ָ��
 * 1.���Ͷ���������<T>���Դ����еĳ�Ա��������ֱ��ʹ�ø÷���<T>
 * 2.���Ͷ����ڷ�����<Q>���Դˣ������еĲ����������Ϳ�ʹ�ø÷���<T>
 * 3.���Ͷ����ھ�̬������<W>�����ˣ���̬������������ֻ��ʹ�÷����ľ�̬����<W>
 * ������֪��ȷ�����ͣ�����ʹ�����ϵķ���<T>
 * ԭ�����Ϸ�����ȷ������Ķ��󣬶���̬�����ڶ������ǰ��ʼ����
 * 4.���һ���������Ա����������������ͬ�����Ͷ��������ϽϺ�(��̬�������붨��ͬ���ķ���)
 * 5.���һ�����н϶��Ա��������ͬ�����ͣ��ٲ��ֲ�ͬ�������϶��巺�ͣ��ٲ��ַ������巺��
 * 6.������Ҫ���ڴ�������Ԫ�ز���
 * 7.����Ҳ�ɶ����ڽӿ��ϣ���Ҫ��java����װ���ˣ�������ʱʹ��
 */

/**
 /*FXDemo.java���н����
 ---------------------------
 ..show..String:HAHA
 ..print..4
 ..print..String:4
 ..StaticMethod..Double:3.14
 ..StaticMethod..3.14
 ---------------------------
 �밴���������. . .
 */

class FXDemo {
    public static void main(String[] args) {
        /* FX.java�ļ�������⣺
		 * ��ϰ����<T>
		 */
        FX<String> fx = new FX<String>();
        lineSplit();
        fx.show("String:HAHA");
        //fx.show(8);  //����ʧ�ܣ�����ת������Integer�޷�ת��ΪString
        fx.print(4);
        fx.print("String:4");
        fx.staticMethod("Double:3.14");
        fx.staticMethod(3.14);
        lineSplit();
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

//������һ��ʵ�ַ���<T>�ӿ�FXInterface�ķ���<T>��FX
class FX<T> implements FXInterface<T> {
    public void show(T t) {
        sop("..show.." + t);
    }

    public <Q> void print(Q q) {
        sop("..print.." + q);
    }

    public static <W> void staticMethod(W w) {
        sop("..StaticMethod.." + w);
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}

//������һ������<T>�ӿ�
interface FXInterface<T> {
    abstract public void show(T t);
}
