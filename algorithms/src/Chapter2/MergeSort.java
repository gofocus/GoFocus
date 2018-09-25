package Chapter2;

/**
 * @Author: gofocus
 * @Date: 12:18 2018/4/14 0014
 */
public class MergeSort extends Example {
    private static Comparable[] aux;

    @Override
    protected void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private  void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, hi, mid);
    }

    private  void merge(Comparable[] a, int lo, int hi, int mid) {
        int m = lo, n = mid + 1;
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        for (int i = lo; i <= hi ; i++) {
            if (m > mid) a[i] = aux[n++];
            else if (n > hi) a[i] = aux[m++];
            else if (less(aux[m],aux[n])) a[i] = aux[m++];
            else a[i] = aux[n++];
        }

    }

    public static void main(String[] args) {
        new MergeSort().sort(a);
        show(a);
    }

    public MergeSort() {
        System.out.println("Merge Sort");
    }
}
