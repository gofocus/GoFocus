/**
 * @Author: GoFocus
 * @Date: 2019-12-20
 * @Time: 14:30
 * @Description:
 */


class Parent {

    private int var1 = 10;

    public void parentFoo() {
        var1++;
    }

    public void print() {
        System.out.println(var1 + "parent");

    }
}


class Child extends Parent {
//    private int var1 = 20;

    public void childFoo(){
//        var1++;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.parentFoo();
        child.childFoo();
        child.print();
    }
}
