package Interview;

/**
 * @Author: gofocus
 * @Date: 8:34 2018/7/28 0028
 */
public class T12 {
    static int a = 10;

    static void func() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        T12 t = new T12();
        t.func();
        T12.func();
        System.out.println(t.a);
        System.out.println(T12.a);
    }
}
