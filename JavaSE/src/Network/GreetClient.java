package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: GoFocus
 * @Date: 2018-12-25
 * @Time: 13:57
 * @Description:
 */
public class GreetClient {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void startConnection(String ip, int port) throws IOException {
        //创建socket并且建立连接
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }

    public String sendMsg(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConneciton() throws IOException {
        in.close();
        out.close();
        clientSocket.close();





    }

}
