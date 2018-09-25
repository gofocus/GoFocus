package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 9:21 2018/3/31 0031
 */

import Ch5.SimpleInterface;

/****************** Exercise 12 *****************
 * Repeat Exercise 7 using an anonymous inner
 * class.
 ***********************************************/

public class E12_AnonymousInnerClassAccess {
    private int i = 0;

    private void outFunc() {
        System.out.println("E12_AnonymousInnerClassAccess.outFunc");
    }

    public SimpleInterface simpleInterface() {
        return new SimpleInterface() {
//            i++;//错误写法，注意这里的作用域是类，（必须在方法内访问成员和方法）

            @Override
            public void f() {
                i++;
                outFunc();
                System.out.println("i = " + i);
            }
        };
    }

    private void f2() {
        simpleInterface().f();
    }

    public static void main(String[] args) {
        E12_AnonymousInnerClassAccess e12_anonymousInnerClassAccess = new E12_AnonymousInnerClassAccess();
        e12_anonymousInnerClassAccess.f2();
    }


}
