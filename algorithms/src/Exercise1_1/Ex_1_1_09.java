package Exercise1_1;

/**
 * Created by GoFoCus $on 2017/8/9.
 * 不使用Integer.toBinaryString()方法，将一个正整数N用用二进制表示并转换为一个String类型的值s
 */
public class Ex_1_1_09 {
    public static void main(String[] args) {
        int N = 100;
        String s="";
        while (N != 0) {
            s = N % 2 + s;
            N = N / 2;
        }
        System.out.println(s);
    }
}
