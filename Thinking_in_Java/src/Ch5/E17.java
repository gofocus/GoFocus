package Ch5;

/**
 * @Author: gofocus
 * @Date: 18:40 2018/3/17 0017
 * 创建一个类，它有一个接受一个String参数的构造器。在构造阶段，打印该参数。
 * 创建一个该类的对象引用数组，但是不实际去创建对象赋值给该数组。
 * 当运行程序时，请注意来自该构造器的调用中的初始化消息是否打印了出来。
 */
public class E17 {

    Test[] a1 = new Test[5]; //未打印

    public static void main(String[] args) {
        Test[] a2 = new Test[5];  //未打印

    }
}

class Test {
    public Test(String s) {
        System.out.println("调用了接受一个String参数的构造器");
        System.out.println("参数为："+s);
    }
}
