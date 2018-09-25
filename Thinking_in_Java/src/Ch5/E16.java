package Ch5;

import java.util.Random;

/**
 * @Author: gofocus
 * @Date: 18:16 2018/3/17 0017
 * 创建一个String对象数组，并为每一个元素都赋值一个String。用for循环来打印该数组
 */
public class E16 {
    private String[] s;

    public E16() {
        for (int i = 0; i < 20; i++) {
            s = new String[20]; // 这句别忘了，否则报错java.lang.NullPointerException
            s[i] = Integer.toString(new Random().nextInt(100));
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        new E16();
    }

}
