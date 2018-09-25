package Interview;

/**
 * Created by gofocus on 2017/6/2616:16.
 */

//用递归方法算出斐波那契额数列第40个数的值
//    102334155

public class Test_Recursion {
    public static void main(String[] args) {
        System.out.println(m(40));
    }

    public static int m(int i){
        if (i<=2)
            return 1;
        return m(i-1)+m(i-2);
    }
}
