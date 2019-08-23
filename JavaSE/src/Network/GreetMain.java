package Network;

import java.io.IOException;

/**
 * @Author: GoFocus
 * @Date: 2018-12-25
 * @Time: 14:12
 * @Description:
 */
public class GreetMain {
/*
    private  int[]a;
    a = new int[]{1,2,3};
    private int[] b = new int[]{1, 2, 3};

    private int c;
    c =123;
    private int d = 456;
*/


    public static void main(String[] args) throws IOException {
/*        int[]a;
        a = new int[]{1, 2, 3};*/
//        System.out.println(a);
        GreetClient greetClient = new GreetClient();
        greetClient.startConnection("127.0.0.1", 6666);
        String resp = greetClient.sendMsg("hello server");
        System.out.println(resp);
        greetClient.stopConneciton();

    }
}
