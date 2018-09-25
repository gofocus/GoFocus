package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: gofocus
 * @Date: 16:27 2018/8/6 0006
 */
public class T17 {

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 4};
        int[] a2 = {1, 2, 3, 4, 4};

        ArrayList arrayList1 = new ArrayList(Arrays.asList(a));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(a2));
        HashSet hashSet = new HashSet(Arrays.asList(a));

        System.out.println(arrayList1);     //[1, 2, 3, 4, 4]
        System.out.println(arrayList2);     //[[I@1540e19d]
        System.out.println(hashSet);        //[1, 2, 3, 4]

        for (Object o : arrayList1) {
            System.out.println(o);
        }
        //1
        //2
        //3
        //4
        //4



        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i, i);
        }

        System.out.println(arrayList);      //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    }

}
