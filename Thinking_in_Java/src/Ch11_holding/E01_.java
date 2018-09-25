package Ch11_holding;

import java.util.ArrayList;

/**
 * @Author: gofocus
 * @Date: 17:12 2018/5/22 0022
 */
public class E01_ {
    public static void main(String[] args) {
        ArrayList<Gerbil_> gerbil_s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbil_s.add(new Gerbil_(i));
        }
        for (int i = 0; i < 10; i++) {
            Gerbil_ gerbil_ = gerbil_s.get(i);
            gerbil_.hop();
        }
    }

}

class Gerbil_ {
    private int gerbilNumber;

    public Gerbil_(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public  void hop() {
        System.out.println("gerbilNumber:" + gerbilNumber + " is hopping");
    }

}
