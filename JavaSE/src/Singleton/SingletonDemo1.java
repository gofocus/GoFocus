package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:28 2018/7/10 0010
 * 懒汉（线程不安全）
 */
public class SingletonDemo1 {

    private static SingletonDemo1 instance;

    private SingletonDemo1() {

    }

    public SingletonDemo1 getInstance() {
        if (instance == null) instance = new SingletonDemo1();
        return instance;
    }


}
