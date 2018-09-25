package Interview;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: gofocus
 * @Date: 9:54 2018/8/1 0001
 */

class T {
    private T() {
        System.out.println(2);
    }


    public static T get() {
        return new T();
    }
}

public class T14 {

    private T14() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        new T14();
        T.get();
    }


}
