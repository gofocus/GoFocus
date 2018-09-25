package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:33 2018/7/10 0010
 *
 * 饿汉
 */
public class SingletonDemo3 {

    private static SingletonDemo3 instance = new SingletonDemo3();

    private SingletonDemo3() {

    }

    public static SingletonDemo3 getInstance() {
        return instance;
    }




}
