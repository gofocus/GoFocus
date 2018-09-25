package Chapter2;

/**
 * @Author: gofocus
 * @Date: 23:00 2018/4/13 0013
 */
public class Test2 extends Example {

    @Override
    protected void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            Comparable tmp = a[i];
            int j = i;
            while (j > 0 && less(tmp, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }

    }


    public static void main(String[] args) {
        new Test2().sort(a);
        show(a);
    }
}
