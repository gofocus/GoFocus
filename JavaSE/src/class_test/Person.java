package class_test;

/**
 * @Author: GoFocus
 * @Date: 2019-01-02
 * @Time: 14:54
 * @Description:
 */
public class Person {

    {
        name = "李四";
        age = 56;
        System.out.println("初始化age");
        address = "上海";
    }

    public String name = "张三";

    public int age = 29;

    public String address = "北京市";


    public Person() {
        name = "赵六";
        age = 23;
        address = "上海市";
    }
}