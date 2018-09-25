package Interview;

/**
 * @Author: gofocus
 * @Date: 11:58 2018/8/11 0011
 */

public class A {
    int count = 20;


static class B extends A {
    int count = 200;

    static class Test {
        public static void main(String[] args) {
            A a = new A();
//            System.out.println(a.count);
            B b = new B();
            System.out.println(b.count);
            A ab = b;   //向上转型
//            System.out.println(ab.count);
        }
    }

}
}