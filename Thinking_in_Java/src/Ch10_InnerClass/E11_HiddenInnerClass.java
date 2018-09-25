package Ch10_InnerClass;

import Ch5.SimpleInterface;

/**
 * @Author: gofocus
 * @Date: 11:50 2018/3/30 0030
 */

/*
 * Create a private inner class that implements a
 * public interface. Write a method that returns
        * a reference to an instance of the private
 * inner class, upcast to the interface. Show
        * that the inner class is completely hidden by
 * trying to downcast to it.*/

public class E11_HiddenInnerClass {
    public static void main(String[] args) {
        Outer5 outer5 = new Outer5();
        SimpleInterface si = outer5.get();
        si = outer5.get2();
        // Won't compile -- 'Inner' not visible:
        //! Inner i1 = outer5.get2();
        //! Inner i2 = (Inner)si;

    }

}

class Outer5 {

    private class Inner implements SimpleInterface {

        @Override
        public void f() {
            System.out.println("Outer5.Inner.f");
        }
    }

    public SimpleInterface get() {
        return new Inner();
    }

    public Inner get2() {
        return new Inner();
    }

}
