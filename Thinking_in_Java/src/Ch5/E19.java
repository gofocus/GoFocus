package Ch5;

/**
 * @Author: gofocus
 * @Date: 8:57 2018/3/19 0019
 */
public class E19 {

    static void printString(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void main(String[] args) {
        printString("1","2","3");
        printString(new String[]{"4","5","6"});
    }
}
