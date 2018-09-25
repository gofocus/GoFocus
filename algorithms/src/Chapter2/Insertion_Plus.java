package Chapter2;

/**
 * @Author: gofocus
 * @Date: 14:44 2018/4/10 0010
 */
public class Insertion_Plus extends Insertion {

    @Override
    protected  void sort(Comparable[] a) {
        for (int i = 1; i < a.length ; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i; j > 0 && less(tmp,a[j-1]); j--) {
                a[j] = a[j-1];
            }

            a[j] = tmp;
        }
/*        for (int i = 1; i < a.length; i++) {
            Comparable tmp = a[i];
            int j = i;
            while (j > 0 && less(tmp, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }*/

/*        for (int i = 1; i < a.length; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && less(tmp, a[j]); j--) {
                a[j + 1] = a[j];
            }

            a[j + 1] = tmp;

        }*/

    }

    public static void main(String[] args) {

//        Example.setA();
        new Insertion_Plus().sort(a);
        System.out.println("插入排序Plus:");
        show(a);
    }


}
