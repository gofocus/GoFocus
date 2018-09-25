package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 9:43 2018/3/31 0031
 */

import Ch5.SimpleInterface;

/****************** Exercise 13 *****************
 * Repeat Exercise 9 using an anonymous inner
 * class.
 ***********************************************/

public class E13_AnonymousInnerClassInMethod {

    public SimpleInterface get() {
        return new SimpleInterface() {

            @Override
            public void f() {
                System.out.println("f()");
            }
        };
    }

    public static void main(String[] args) {
        E13_AnonymousInnerClassInMethod e13_anonymousInnerClassInMethod = new E13_AnonymousInnerClassInMethod();
        e13_anonymousInnerClassInMethod.get().f();
    }


}
