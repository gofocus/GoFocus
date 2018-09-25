package Ch4;

import java.util.Random;

/**
 * Created by 
 * @Author: gofocus
 * @Date: 15:50 2018/3/13 0013  
 */


public class Ch4_3_2_2 {

    static Random random = new Random();
    static void compareRand() {
        int a = random.nextInt();
        int b = random.nextInt();
        System.out.println("a=" + a + ",b=" + b);
        if (a < b) System.out.println("a<b");
        else if (a > b) {
            System.out.println("a>b");
        } else System.out.println("a=b");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 25; i++) {
//            System.out.println((int)(Math.random()*100));
             compareRand();
        }
    }
}
