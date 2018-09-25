package Interview;


import java.math.BigDecimal;

/**
 * @Author: gofocus
 * @Date: 15:08 2018/7/12 0012
 */
public class T02 {

    public static void main(String[] args) {

//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            double amount1=2.0;
            double amount2=1.1;
            double amount3=0.9;
            System.out.println(amount1-amount2==amount3);

            BigDecimal damount1=new BigDecimal("2.0");
            BigDecimal damount2=new BigDecimal("1.1");
            BigDecimal damount3=new BigDecimal("0.9");
            System.out.println(damount1.subtract(damount2).equals(damount3));

        }

    }


