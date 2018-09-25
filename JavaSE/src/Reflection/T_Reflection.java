package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gofocus on 2017/7/8 14:02 14:43 14:43.
 */


public class T_Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "Mashibing_Concurrent.TT";
        Class c = Class.forName(str);
        Object o = c.newInstance();
        Method methods[] = c.getMethods();
        for (Method method:methods)
        {
            if (method.getName().equals("m1")) {
                method.invoke(o);}
            if (method.getName().equals("m2")) {
                method.invoke(o, 1, 2);
                for (Class paramType : method.getParameterTypes()) {
                    System.out.println(paramType.getName());
                }
            }
            if (method.getName().equals("getS")) {
                Class returnType = method.getReturnType();
                System.out.println(returnType.getName());
            }


        }
    }
}

class TT {
    private int i;
    private String s;
    static {
        System.out.println("Class T was loaded");
    }

    public TT(){
        System.out.println("This is the construction method");
    }

    public void m1(){
        System.out.println("It has just invoked the method of class T");
    }

    public int m2(int i, int j){
        System.out.println(i+j);
        return this.i = i+j;
    }

    public String getS() {
        return s;
    }

}