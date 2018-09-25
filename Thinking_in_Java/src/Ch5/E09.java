package Ch5;

/**
 * @Author: gofocus
 * @Date: 13:35 2018/3/15 0015
 */
public class E09 {

    public E09(int i) {
        this("调用第二个构造器");
        System.out.println(i);
//        this('1'); recursive constructor invocation 构造器中出现了递归调用。这是不被允许的。重载的构造器之间彼此互相调用、构造器调用自身，都会出现此编译错误。
    }

    public E09(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new E09(1);
    }

}
