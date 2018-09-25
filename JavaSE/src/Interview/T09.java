package Interview;

/**
 * @Author: gofocus
 * @Date: 9:10 2018/7/27 0027
 */
public class T09 {


    static class A {
        private int i = 1;

        public A() {
            methodA(i);
            methodB();
        }

        public void methodA(int i) {
            System.out.println(i);
        }

        public void methodB() {
            System.out.println(i);
        }
    }

    static class B extends A {
        private int i = 2;

        public B() {
            methodA(i);
            methodB();
        }
        public void methodA(int i) {
            System.out.println(i);
        }
        public void methodB() {
            System.out.println(i);
        }
        public static void main(String[] args) {
            new B();
        }
    }






    }
