package Network;

import java.io.IOException;

/**
 * @Author: GoFocus
 * @Date: 2018-12-25
 * @Time: 14:12
 * @Description:
 */
public class GreetMain {

    public static void main(String[] args) throws IOException {

        GreetClient greetClient = new GreetClient();
        greetClient.startConnection("127.0.0.1", 6666);
        String resp = greetClient.sendMsg("hello server");
        System.out.println(resp);
        greetClient.stopConneciton();

    }
}
