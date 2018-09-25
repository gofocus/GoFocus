package Interview;


/**
 * 多态练习题
 * Created by guojia on 2017/5/25.
 */


public class Polymorphic {

    static class A {
        public String show(D obj){
            return ("Interview.A and Interview.D");
        }
        public String show(Interview.A obj){
            return ("Interview.A and Interview.A");
        }
    }
    static class B extends Interview.A {
        public String show(B obj){
            return ("Interview.B and Interview.B");
        }
        public String show(Interview.A obj){
            return ("Interview.B and Interview.A");
        }
    }
    static class C extends B{}
    static class D extends B{}

    public static void main(String[] args) {
        A a1 = new A();
//        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a1.show(b)); //AA
        System.out.println(a1.show(c)); //AA
        System.out.println(a1.show(d)); //AD
//        System.out.println(a2.show(b)); //BA
//        System.out.println(a2.show(c)); //BA
//        System.out.println(a2.show(d)); //AD
        System.out.println(b.show(b));  //BB
        System.out.println(b.show(c));  //BB
        System.out.println(b.show(d));  //AD
    }
}



