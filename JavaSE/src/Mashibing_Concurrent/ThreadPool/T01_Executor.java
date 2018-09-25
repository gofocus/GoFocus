package Mashibing_Concurrent.ThreadPool;

import java.util.concurrent.Executor;

/**
 * @Author: gofocus
 * @Date: 9:35 2018/7/11 0011
 */
public class T01_Executor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new T01_Executor().execute(()-> System.out.println("hello T01_Executor")
        );
    }

}
