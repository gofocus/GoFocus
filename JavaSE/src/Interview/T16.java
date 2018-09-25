package Interview;

/**
 * @Author: gofocus
 * @Date: 15:57 2018/8/4 0004
 */
public class T16 {

    private int a = 1;
    private int b = 2;

    private void exchange(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    private void exchange2(int a, int b) {
//        int tmp = a;
//        this.a = b;
//        this.b = tmp;
        this.a = b;
        this.b = a;
    }

    public static void main(String[] args) {
        T16 t = new T16();

        t.exchange(t.a, t.b);
        System.out.println(" " + t.a + t.b);//  12

        t.exchange2(t.a, t.b);
        System.out.println(" " + t.a + t.b);//  21

    }

}
