package Mashibing_Concurrent;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: gofocus
 * @Date: 18:56 2018/7/9 0009
 *
 * 使用ReentrantLock的Condition精确指定被唤醒的线程
 */


public class Producer_Consumer_Plus<T> {

    final private LinkedList<T> linkedList = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    private void put(T t) {
        try {
            lock.lock();
            while (linkedList.size() == MAX) {
                producer.await();
            }

            linkedList.add(t);
            ++count;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private T get() {
        T t = null;
        try {
            lock.lock();
            while (linkedList.size() == 0) {
                consumer.await();
            }

            t = linkedList.removeFirst();
            count--;
            producer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Producer_Consumer_Plus<String> producer_consumer = new Producer_Consumer_Plus<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "消费了" + producer_consumer.get());
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
                for (int j = 0; j < 25; j++) {
                    System.out.println(Thread.currentThread().getName() + "生产了第" + (j + 1) + "个包子");
                    producer_consumer.put(Thread.currentThread().getName() + "生产的第" + (j + 1) + "个包子");
                }
            }, "p" + i).start();
        }

    }


}

