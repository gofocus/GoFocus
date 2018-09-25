package Interview;

import java.math.BigDecimal;

/**
 * @Author: gofocus
 * @Date: 15:20 2018/8/1 0001
 */
public class T15 {



    public static void main(String[] args) {

        double d1 = 1.0;
        double d2 = 0.66;
        double d = d1 - d2;
        System.out.println(d);//0.33999999999999997

        BigDecimal bigDecimal_1 = new BigDecimal(d1);
        BigDecimal bigDecimal_2 = new BigDecimal(d2);
        System.out.println(bigDecimal_1.subtract(bigDecimal_2).doubleValue());//0.33999999999999997

        BigDecimal bigDecimal_3 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal_4 = new BigDecimal(Double.toString(d2));
        System.out.println(bigDecimal_3.subtract(bigDecimal_4).doubleValue());//0.34


    }


}
