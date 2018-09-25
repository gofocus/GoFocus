package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 11:14 2018/3/30 0030
 */

//As you can see from the output, the accessibility goes both ways.
class Outer4 {
    class Inner {
        private int j;

        private void h() {
            System.out.println("Inner.h called");
            System.out.println("Inner.j = " + j);
        }
    }

    public void testInnerAccess() {
        Inner i = new Inner();
        i.j = 47;
        i.h();
    }
}

public class E08_OuterAccessingInner {
    public static void main(String args[]) {
        Outer4 o = new Outer4();
        o.testInnerAccess();
    }
}