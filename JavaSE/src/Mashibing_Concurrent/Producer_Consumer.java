package Mashibing_Concurrent;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: gofocus
 * @Date: 18:56 2018/7/9 0009
 */
public class Producer_Consumer<T> {

    final private LinkedList<T> linkedList = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        while (linkedList.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        linkedList.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (linkedList.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = linkedList.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        Producer_Consumer<String> producer_consumer = new Producer_Consumer<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName()+"消费了" + producer_consumer.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++)
                {
                    System.out.println(Thread.currentThread().getName() + "生产了第" + (j+1) + "个包子" );
                    producer_consumer.put(Thread.currentThread().getName() + "生产的第" + (j+1) + "个包子");}
            }, "p" + i).start();
        }


    }


}

