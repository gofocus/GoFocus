package Reflection;

/**
 * Created by gofocus on 2017/7/8 11:56.
 */

/*
测试classloader的类加载机制
    classloader 采用运行时动态加载，需要用到时才加载类
    static语句块在加载后只执行一次
*/

public class T_ClassLoader {

    public static void main(String[] args) {
        new A();
        System.out.println("--------");
        new B();
        new C();
        new C();
    }

}

class A {

}

class B {

}

class C{
    static {
        System.out.println("this is a static code");
    }
}

class D{}
