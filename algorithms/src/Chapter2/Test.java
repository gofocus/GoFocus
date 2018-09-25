package Chapter2;


/**
 * Created by GoFoCus $on 2017/8/22.
 */
public class Test extends Example {


    @Override
    protected void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);

    }

    private int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int storeIndex = lo + 1;
        int i = storeIndex;
        while (i <= hi) {
            if (less(a[i], pivot))
                exchange(a, i, storeIndex++);
            i++;

        }

        exchange(a, lo, --storeIndex);

        return storeIndex;

    }

    public static void main(String[] args) {
        new Test().sort(a);
        show(a);
    }

}
