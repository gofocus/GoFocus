package Ch10_InnerClass;

/**
 * @Author: gofocus
 * @Date: 10:16 2018/3/30 0030
 */
public class E05 {

    public static void main(String[] args) {
        Outer3 outer3 = new Outer3();
        Outer3.Inner inner = outer3.new Inner();
    }

}


class Outer3 {
    class Inner{
        {
            System.out.println("Inner  created");
        }
    }
}