/**
 * 泛型：要操作的对象类型不明确，把对象类型交由不同的需求者自行指定
 * 1.泛型定义在类上<T>，以此类中的成员变量可以直接使用该泛型<T>
 * 2.泛型定义在方法上<Q>，以此，方法中的参数变量类型可使用该泛型<T>
 * 3.泛型定义在静态方法上<W>，若此，静态方法参数类型只能使用方法的静态泛型<W>
 * 或者已知的确定类型，不能使用类上的泛型<T>
 * 原因：类上泛型明确依托类的对象，而静态方法在对象产生前开始动作
 * 4.如果一个类中其成员方法操作的类型相同，则泛型定义在类上较好(静态方法必须定义同样的泛型)
 * 5.如果一个类中较多成员方法操作同样类型，少部分不同，则类上定义泛型，少部分方法定义泛型
 * 6.泛型主要用于处理集合中元素操作
 * 7.泛型也可定义在接口上，主要由java包封装好了，供开发时使用
 */

/**
 /*FXDemo.java运行结果：
 ---------------------------
 ..show..String:HAHA
 ..print..4
 ..print..String:4
 ..StaticMethod..Double:3.14
 ..StaticMethod..3.14
 ---------------------------
 请按任意键继续. . .
 */

class FXDemo {
    public static void main(String[] args) {
        /* FX.java文件解决问题：
		 * 练习泛型<T>
		 */
        FX<String> fx = new FX<String>();
        lineSplit();
        fx.show("String:HAHA");
        //fx.show(8);  //编译失败，类型转换错误：Integer无法转换为String
        fx.print(4);
        fx.print("String:4");
        fx.staticMethod("Double:3.14");
        fx.staticMethod(3.14);
        lineSplit();
    }

    public static void sop(Object obj) {
		/* 打印字符串
		*  
		*/
        System.out.println(obj);
    }

    public static void lineSplit() {
		/* 打印分隔符
		*  
		*/
        sop("---------------------------");
    }
}

//定义了一个实现泛型<T>接口FXInterface的泛型<T>类FX
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

//定义了一个泛型<T>接口
interface FXInterface<T> {
    abstract public void show(T t);
}
