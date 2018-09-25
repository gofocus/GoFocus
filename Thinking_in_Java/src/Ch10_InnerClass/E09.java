package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 11:39 2018/3/30 0030
 */

/****************** Exercise 9 *****************
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 ***********************************************/

public class E09 {

    Inter test() {
        class InterClass implements Inter{

            @Override
            public void func() {
                System.out.println("func");
            }
        }
        return new InterClass();
    }

    public static void main(String[] args) {
        new E09().test().func();
    }

}


interface Inter {
    void func();
}