package Mashibing_Concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Author: gofocus
 * @Date: 15:02 2018/7/10 0010
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tl.set(new Person());

        }).start();

    }

    static class Person {
        String name = "name";
    }

}


