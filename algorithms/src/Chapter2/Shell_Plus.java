package Chapter2;

/**
 * @Author: gofocus
 * @Date: 12:05 2018/4/11 0011
 */
public class Shell_Plus extends Example {


    @Override
    protected void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N/3) h = h * 3 + 1;
        while (h >=1) {                     // =1 不可缺
            for (int i = h; i < N; i++) {   // i = h
                int j;
                Comparable tmp = a[i];
                for (j = i; j >=h && less(tmp,a[j-h]) ; j-=h) {     // j>=h  =不可少
                    a[j] = a[j - h];
                }
                a[j] = tmp;
            }
            h = h / 3;
        }

/*        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h != 0) {
            for (int i = h; i < N; i++) {       //!
                int j = i ;
                Comparable tmp = a[i];
                while (j >=h && less(tmp, a[j-h])) {    //!
                    a[j] = a[j - h];
                    j -= h;
                }
                a[j] = tmp;
            }

            h = h / 3;

        }*/

    }

    public static void main(String[] args) {

        new Shell_Plus().sort(a);
        show(a);
    }


}
