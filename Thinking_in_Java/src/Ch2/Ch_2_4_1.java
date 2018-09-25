package Ch2;

/**
 * Created by GoFoCus $on 2017/8/9.
 */
class Ch_2_4_1 {
     String s;
    char aChar;
}


class Test {
    public static void main(String[] args) {
        Ch_2_4_1 ch_2_4_1 = new Ch_2_4_1();
        ch_2_4_1.s = ch_2_4_1.s + "12";
        System.out.println(ch_2_4_1.s);//null12
        System.out.println(ch_2_4_1.aChar);
    }
}