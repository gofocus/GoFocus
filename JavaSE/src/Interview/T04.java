package Interview;

/**
 * @Author: gofocus
 * @Date: 21:14 2018/7/12 0012
 */
public class T04 {

    static int test() {
        int x = 1;
        try {
            return  ++x ;
        } finally {
            if (x > 1) {
                x += 10;
            }
        }
    }

    public static void main(String args[]){
        System.out.print(test());
    }
}
