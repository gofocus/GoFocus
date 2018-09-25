package Ch9;

import Ch5.SimpleInterface;

/**
 * @Author: gofocus
 * @Date: 10:27 2018/3/30 0030
 */
public class SimpleClass {

    protected class Inner implements SimpleInterface {

        public Inner() {
//            Force Constructor to be public.

/*  In a class type, if the class is declared public, then the default constructor is implicitly given the access modifier public (§6.6);
if the class is declared protected, then the default constructor is implicitly given the access modifier protected (§6.6);
if the class is declared private, then the default constructor is implicitly given the access modifier private (§6.6);
otherwise, the default constructor has the default access implied by no access modifier.
*/
        }

        @Override
        public void f() {
            System.out.println("f()");
        }
    }


    //在这个类中，Inner构造器不用声明为public也可以被调用
    public SimpleInterface get() {
        return new Inner();
    }


}
