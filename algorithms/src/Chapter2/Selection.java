package Chapter2;

import java.io.IOException;

/**
 * Created by GoFoCus $on 2017/8/18.
 */
public class Selection extends Example {


    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            if (min != i) exchange(a, min, i);
//            a[i] = a[min];        错误写法!!
        }

    }

    public static void main(String[] args) throws IOException {
        new Insertion().sort(a);
        System.out.println("选择排序:");
        show(a);
    }
}
