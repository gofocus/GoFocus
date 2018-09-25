package Ch9;

/**
 * @Author: gofocus
 * @Date: 8:21 2018/3/29 0029
 */

interface Morning {
    void brush();

    void learn();
}

interface Afternoon {
    void have_break();

    void run();
}

interface Night {
    void fun();

    void sleep();
}

interface One_day extends Morning, Afternoon, Night {
    void cheer();
}

class Some_Class {

}

public class E14 extends Some_Class implements One_day {
    @Override
    public void brush() {
        System.out.println("brush");
    }

    @Override
    public void learn() {
        System.out.println("learning");
    }

    @Override
    public void have_break() {
        System.out.println("breaking");

    }

    @Override
    public void run() {
        System.out.println("running");

    }

    @Override
    public void fun() {
        System.out.println("fun");
    }

    @Override
    public void sleep() {
        System.out.println("sleeping");
    }

    @Override
    public void cheer() {
        System.out.println("cheer");
    }

    void fc_1(Morning morning) {
        morning.brush();
    }

    void fc_2(Afternoon afternoon) {
        afternoon.have_break();
    }

    void fc_3(Night night) {
        night.fun();
    }

    void fc_4(One_day one_day) {
        one_day.cheer();
    }

    public static void main(String[] args) {
        E14 e14 = new E14();
        e14.fc_1(e14);
        e14.fc_2(e14);
        e14.fc_3(e14);
        e14.fc_4(e14);
    }


}
