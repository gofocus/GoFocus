package Chapter2;

import java.io.IOException;


/**
 * Created by GoFoCus $on 2017/8/28.
 */
public class Shell extends Example{

    public Shell() {
        System.out.println("希尔排序");
    }

    protected void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < 3 / N) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;

        }
    }


    public static void main(String[] args) throws IOException {
        new Shell().sort(a);
        show(a);

    }
}
