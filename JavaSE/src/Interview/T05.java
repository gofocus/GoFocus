package Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: gofocus
 * @Date: 21:27 2018/7/12 0012
 * 生产者消费者模式
 */
public class T05<T> {

    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        count++;
        this.notifyAll();

    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;

    }


    public static void main(String[] args) {

        T05<String> stringT05 = new T05<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "消费了" + stringT05.get());
                }
            }, "c" + i).start();
        }

      /*  try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 25; j++) {
                    stringT05.put(Thread.currentThread().getName() + "生产的第" + j + "个包子");
                    System.out.println(Thread.currentThread().getName() + "生产了第" + j + "个包子");
                }
            }, "p" + i).start();
        }


    }


}


