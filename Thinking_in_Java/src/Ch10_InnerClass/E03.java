package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 7:42 2018/3/30 0030
 */
public class E03 {

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2("test");
        Outer2.Inner inner = outer2.getInner();
        System.out.println(inner.toString());
    }

}


class Outer2 {
    private String data;

    public Outer2(String data) {
        this.data = data;
    }

    class Inner {
        public String toString() {
            return data;
        }

    }

    Inner getInner() {
        return new Inner();
    }

}

