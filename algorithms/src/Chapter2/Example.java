package Chapter2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by GoFoCus $on 2017/8/17.
 */
public class Example {

//    public static Comparable[] a = new Comparable[]{6.1,5.1,4.1,3.1};
//    public static Comparable[] a = new Comparable[]{5,4,3,7,8,9,1,6,0,2};
    public static Comparable[] a = new Comparable[]{ 12,15,1,18,2,35,30,11 };
//    public static Comparable<Integer>[] a = new Comparable[10];

    /*public Example() {
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(i + 20);
        }
    }*/

    protected  void sort(Comparable[] a) {

    }


    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a) {
        for (Comparable anA : a) {
            if (anA!=null) System.out.print(anA + " ");
        }
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Object> objects = new ArrayList<>();
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        int i = 0 ;
        Comparable[] a = new Comparable[10];

        while (!(s = bufferedReader.readLine()).equals("")) {
            a[i++] = s;
        }

        sort(a);
        show(a);
*/
    }

}
