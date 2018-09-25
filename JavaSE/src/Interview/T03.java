package Interview;

/**
 * @Author: gofocus
 * @Date: 20:35 2018/7/12 0012
 */
public class T03 {

    public static int test() {
        int a = 10;
        try {
            System.out.println("try...");
            return a = 20;
        } catch (Exception e) {

        } finally {
            if (a == 20) {
                System.out.println("到了 try 的return了");
            }
            System.out.println("finally...");
            return a = 30;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
