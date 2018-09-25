package interview;

/**
 * @Author: gofocus
 * @Date: 22:56 2018/4/13 0013
 */
public class test2 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "1234";

        s1 = s1 + s2 ;
        s2 = s1.substring(0, (s1.length() - s2.length()));
        s1 = s1.substring(s2.length(), s1.length());

        System.out.println(s1);//1234
        System.out.println(s2);//abc

    }



}
