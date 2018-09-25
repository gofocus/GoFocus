package Ch10_InnerClass;

import Ch5.SimpleInterface;

/**
 * @Author: gofocus
 * @Date: 11:47 2018/3/30 0030
 */

//Repeat Exercise 9 but define the inner
//class within a scope within a method.

/*The inner class remains visible only if the return statement is in its scope; if
        not, the inner class definition goes out of scope.*/
public class E10_InnerClassInScope {
    public SimpleInterface get() {
        {
            class SI implements SimpleInterface{
                public void f() {
                    System.out.println("SI.f");
                }
            }
            return new SI();
        }
    }
    public static void main(String args[]) {
        SimpleInterface si =
                new E10_InnerClassInScope().get();
        si.f();
    }
}
