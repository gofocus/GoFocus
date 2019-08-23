package class_test;

/**
 * @Author: GoFocus
 * @Date: 2019-01-02
 * @Time: 14:28
 * @Description:
 */
public class Parent {


    public Parent() {
        System.out.println("调用父类构造方法");
        init();
    }


    protected void init() {
        System.out.println("父类init方法");
    }
}
