package Ch2;

/**
 * Created by GoFoCus $on 2017/8/9.
 */
public class Ch_2_3_1 {
    int i = 10;
    {
        int i = 12;
    }

    public static void main(String[] args) {
        Ch_2_3_1 test = new Ch_2_3_1();
        System.out.println(test.i);         //10
    }
}
