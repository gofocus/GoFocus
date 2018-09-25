package Ch5;

/**
 * @Author: gofocus
 * @Date: 11:06 2018/3/15 0015
 */
public class E08 {

    void func1() {
        func2();
        this.func2();
    }

    void func2() {
        System.out.println("Test");
    }

    public static void main(String[] args) {
        new E08().func1();
    }
}
