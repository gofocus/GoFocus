package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: GoFocus
 * @Date: 2018-12-25
 * @Time: 11:07
 * @Description:
 */
public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void start(int port) throws IOException {
        //创建一个绑定了端口的socket
        serverSocket = new ServerSocket(port);
        //监听端口，准备接收socket
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String greeting = in.readLine();
        if (greeting.equals("hello server")) {
            out.println("hello client");
        } else {
            out.println("unrecognized greeting");
        }

    }

    private void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {

        GreetServer greetServer = new GreetServer();
        System.out.println("server start");

        greetServer.start(6666);

        System.out.println("server close");

    }



}
