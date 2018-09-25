package Ch11_holding;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: gofocus
 * @Date: 9:28 2018/4/2 0002
 */
public class E02_SimpleCollection2 {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }

        for (Integer integer : c) {
            System.out.println("i: " + integer);
        }

    }


}
