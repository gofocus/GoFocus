package Regular_Expression;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by GoFoCus $on 2017/7/17.
 */
public class IsInteger {

    public static void main(String[] args) throws IOException {
        String string = "123";
        String string1 = "-12345";
        System.out.println(isInteger(string));      //true
        System.out.println(isInteger(string1));     //true
    }

    private static boolean isInteger(String string) {
        Pattern pattern = Pattern.compile("^[-]?[\\d]+$");
        return pattern.matcher(string).matches();
    }

}
