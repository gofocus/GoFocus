package Singleton;

/**
 * @Author: gofocus
 * @Date: 18:36 2018/7/10 0010
 *
 * 静态内部类
 */
public class SingletonDemo5 {


    private static class SingletonHolder{
        private static final SingletonDemo5 instance = new SingletonDemo5();
        //思考:为什么要加final？
        //A:类的静态属性只会在第一次加载类的时候初始化。
    }

    private SingletonDemo5(){

    }

    public static SingletonDemo5 getInstance() {
        return SingletonHolder.instance;
    }


}
