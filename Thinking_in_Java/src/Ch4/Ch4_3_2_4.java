package Ch4;

/**
 * Created by
 * @Author: gofocus
 * @Date: 7:38 2018/3/14 0014
 * 寻找质数
 */

public class Ch4_3_2_4 {

    private static void findPrime() {
        int j;

        outer:
        for (int i = 3; i < 100; i++) { // 不输出1,2这两个质数
            for (j = 2; j < i ; j++) {
                if (i % j == 0) {
                    continue outer;  // 仔细体会和break的区别！！！
                }
            }
            System.out.println(j);

        }/*for (int i = 1; i < 100; i++) {
            for (j = 2; j < i ; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i) {
                System.out.println(i);
            }
        }*/

    }

    public static void main(String[] args) {
        findPrime();
    }


}
