package Chapter2;

/**
 * @Author: gofocus
 * @Date: 22:49 2018/4/4 0004
 */
public class QuickSort_Book {

    public static void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1 );
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while(a[++i] < v) if (i == hi) break;
            while(v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a,lo,j);
        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = { 12,15,1,18,2,35,30,11 };
//        int[] a = {7, 6, 4, 2, 21, 7, 8 , 1, 3,};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
     }

}
