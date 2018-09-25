package Ch4;

import java.util.Random;

/**
 * Created by GoFoCus $on 2017/8/18.
 */
public class Ch4_3_2 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextFloat());
        int i = new Random().nextInt();
        System.out.println(i);
        int min = 1;
        int max = 10;
        int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
        System.out.println(intBounded);

    }
}
