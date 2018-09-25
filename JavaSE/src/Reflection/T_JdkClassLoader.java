package Reflection;

/**
 * Created by gofocus on 2017/7/8 13:27.
 */

/*ClassLoader的分类
    bootstrap class loader 加载jdk最核心的类
    extension class loader
    application class loader
    other class loader

*/
public class T_JdkClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader()); //核心类的classloader的名称默认隐藏不可见

    }
}
