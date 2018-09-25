package Ch5;

/**
 * @Author: gofocus
 * @Date: 10:50 2018/3/15 0015
 */
public class E03_04 {

    E03_04() {
        System.out.println("这是一条消息");
    }

    E03_04(String s) {
        System.out.println("显示："+ s);
    }


    public static void main(String[] args) {
        new E03_04();
        new E03_04("^_^");
    }

}
