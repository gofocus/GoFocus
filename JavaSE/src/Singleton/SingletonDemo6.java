package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:36 2018/7/10 0010
 *
 * 双重校验锁
 */
public class SingletonDemo6 {

    private static SingletonDemo6 instance;

    private SingletonDemo6(){

    }

    public static SingletonDemo6 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo6.class) {
                if (instance == null)
                    instance = new SingletonDemo6();
            }
        }

        return instance;

    }


}
