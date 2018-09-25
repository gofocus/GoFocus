package Ch5;

/**
 * @Author: gofocus
 * @Date: 9:51 2018/3/19 0019
 */
public class E22 {

    enum Enum {
        TEST1,TEST2,TEST3
    }

    public static void main(String[] args) {
        for (Enum anEnum : Enum.values()) {
            switch (anEnum) {
                case TEST1:
                    System.out.println("1");
                    break;
                case TEST2:
                    System.out.println("2");
                    break;
                case TEST3:
                    System.out.println("3");
                    break;
                default:
                    System.out.println("None");
            }
        }
    }
}
