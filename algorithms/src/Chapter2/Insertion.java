package Chapter2;

import java.io.IOException;

/**
 * Created by GoFoCus $on 2017/8/22.
 */
public class Insertion<T extends Comparable> extends Example {


    @Override
    protected void sort(Comparable[] a) {
        for (int i = 1; i < a.length && a[i]!=null; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]) ; j--) {
                exchange(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        Example.setA();
        new Insertion().sort(a);
        System.out.println("插入排序");
        show(a);

    }

}
