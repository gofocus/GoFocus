package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:33 2018/7/10 0010
 *
 * 饿汉,类初始化时即实例化instance
 */
public class SingletonDemo4 {

    private static SingletonDemo4 instance;

    private SingletonDemo4() {

    }

    static{
        instance = new SingletonDemo4();
    }

    public static SingletonDemo4 getInstance() {
        return instance;
    }




}
