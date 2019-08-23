package class_test;

/**
 * @Author: GoFocus
 * @Date: 2019-01-02
 * @Time: 14:28
 * @Description:
 */
public class Child extends Parent {

    private int number = 10;

    public Child() {
        super();
        System.out.println("调用子类构造方法");
        init();
    }
    protected void init() {
        System.out.println("Child:" + number);
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
