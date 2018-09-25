package Mashibing_Concurrent;

/**
 * @Author: gofocus
 * @Date: 14:33 2018/7/9 0009
 */
public class TT implements Runnable{
    private int b = 100;

    private synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(3000);
        System.out.println("b=" + b);
    }

    private void  m2() {
        System.out.println("b=" + b); //输出1000， 但也可能输出100。因为没有用volatile修饰变量b，其线程间可见性不一定。
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        Thread thread = new Thread(tt);
        thread.start();

//        Thread.sleep(1000);
        Thread.sleep(1);
        tt.m2();
    }

}
