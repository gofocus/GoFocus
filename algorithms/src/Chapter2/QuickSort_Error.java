package Chapter2;

/**
 * @Author: gofocus
 * @Date: 22:49 2018/4/4 0004
 */


public class QuickSort_Error {

    public static void sort(int[] a) {
        sort(a, 0, a.length );
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j );
        sort(a, j, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int storeIndex = lo + 1;
        for (int i = lo + 1; i < hi; i++) {
            if (a[i] <= pivot) {
                exchange(a, storeIndex, i);
                storeIndex++;
            }
        }
        exchange(a, lo, --storeIndex);
        return storeIndex;
    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {6, 4, 2, 21, 7, 8 , 1, 3,};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
