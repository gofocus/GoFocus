package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 7:19 2018/3/30 0030
 */
public class E01 {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.getInner();
    }

}

class Outer {

    class Inner {
        {
            System.out.println("inner class created");
        }
    }

    Inner getInner() {
        return new Inner();
    }

}