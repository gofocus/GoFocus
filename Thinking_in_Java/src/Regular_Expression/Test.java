package Regular_Expression;

import java.util.regex.Pattern;

/**
 * Created by gofocus on 2017/8/12 13:02.
 */


public class Test {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abc";
        String s3 = "abcbc";
        String s4 = "aEbc";

        Pattern pattern = Pattern.compile("ab?c");
        System.out.println(pattern.matcher(s1).matches());
        System.out.println(pattern.matcher(s2).matches());//true
        System.out.println(pattern.matcher(s3).matches());
        System.out.println(pattern.matcher(s4).matches());

        System.out.println(s1.replaceAll("ab?c","1"));//1d
        System.out.println(s3.replaceAll("ab?c", "2"));//2bc

    }
}

