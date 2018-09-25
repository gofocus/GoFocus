package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:31 2018/7/10 0010
 * 懒汉（线程安全）
 */
public class SingletonDemo2 {

    private static SingletonDemo2 instance;

    private SingletonDemo2() {

    }

    public static synchronized SingletonDemo2 getInstance() {
        if (instance == null)
            instance = new SingletonDemo2();
        return instance;
    }

}
