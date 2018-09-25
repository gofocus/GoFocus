package Chapter2;

/**
 * @Author: gofocus
 * @Date: 22:49 2018/4/4 0004
 */
public class QuickSort_Basic extends Example{

    public QuickSort_Basic() {
        System.out.print("快速排序");
        show(a);
    }

    @Override
    protected void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1 );// -1 和下一行的 +1 是关键
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int storeIndex = lo + 1;
        Comparable pivot = a[lo];
        int i = storeIndex;
        while (i <= hi) {      // “=”不可少,因为lo和hi都是实际下标值。
            if (less(a[i], pivot)) {
                exchange(a, i, storeIndex++);
            }
            i++;
        }
        exchange(a,lo,--storeIndex);
        return storeIndex;

/*
        int storeIndex = lo + 1;
        Comparable pivot = a[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i],pivot)) {
                exchange(a, storeIndex, i);
                storeIndex++;
            }
        }
        exchange(a, lo, --storeIndex);
        return storeIndex;
*/
    }

    public static void main(String[] args) {
        new QuickSort_Basic().sort(a);
        show(a);
    }

}
