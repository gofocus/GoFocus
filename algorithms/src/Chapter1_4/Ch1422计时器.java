package Chapter1_4;

/**
 * Created by GoFoCus $on 2017/8/8.
 */
public class Ch1422计时器 {
    public static void main(String[] args) {

        int i = 1234;
        StopWatch stopWatach = new StopWatch();
        String s = String.valueOf(i);
        System.out.println(s == "1234");//false
        System.out.println(stopWatach.elapsedTime());



        String s1 = i + "";
        System.out.println(s1=="1234");//false

        String s2 = "1234" + "";
        System.out.println(s2 == "1234");//true

    }


}

class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }


}
