package Ch11_holding;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: gofocus
 * @Date: 20:23 2018/4/6 0006
 */
public class E08 {

    private int gerbilNumber;

    public E08(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    void hop() {
        System.out.println(this + " is hopping");
    }

    @Override
    public String toString() {
        return "gerbilNumber " + gerbilNumber ;
    }

    public static void main(String[] args) {
        ArrayList<E08> e08s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            e08s.add(new E08(i));
        }

        for (Iterator<E08> it = e08s.iterator(); it.hasNext();it.next().hop()) {

        }
/*        Iterator<E08> iterator = e08s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

    }


}
