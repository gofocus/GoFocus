package Ch5;


/**
 * @Author: gofocus
 * @Date: 9:47 2018/3/19 0019
 */
public class E21 {

    enum Enum {
        TEST1,TEST2,TEST3
    }

    public static void main(String[] args) {
        for (Enum anEnum : Enum.values()) {
            System.out.println(anEnum + " ordinal:" + anEnum.ordinal());
        }
    }

}
