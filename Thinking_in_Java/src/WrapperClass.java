import java.util.List;

/**
 * Created by guojia on 2017/6/9.
 */
public class WrapperClass {

    public static void main(String[] args) {
        Integer i = 100;
        Double d = new Double("123.456");
        int j = i + d.intValue();
        System.out.println(j);
        System.out.printf(String.valueOf(j)+'\n');
        float f = i.floatValue() + d.floatValue();
        System.out.println(f);
        System.out.printf(String.valueOf(f)+"\n");

    }


}
