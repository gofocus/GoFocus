package Ch11_holding;

import java.util.ArrayList;

/**
 * @Author: gofocus
 * @Date: 7:39 2018/4/2 0002
 */
public class E01 {

}

class Gerbil {
    private int gerbilNumber;

    public Gerbil(int gerbilNumber) {
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
        ArrayList<Gerbil> gerbilArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbilArrayList.add(new Gerbil(i));
        }

        for (int i = 0; i < gerbilArrayList.size(); i++) {
            gerbilArrayList.get(i).hop();
        }
    }
}