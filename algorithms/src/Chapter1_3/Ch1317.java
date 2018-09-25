package Chapter1_3;


import Exercise1_3.ResizingArrayQueueOfStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by GoFoCus $on 2017/7/14.
 * 双栈算术表达式求值算法
 */

public class Ch1317{

    public static void main(String[] args) throws IOException {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b;
        while((b=br.read())!=10)//换行符的ASCLL码值为10
        {
//            String s = (char)b + "";
            String s = String.valueOf((char) b);//将char转换为String类型
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")"))
            {
                String op= ops.pop();
                double v = vals.pop();
                if      (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));

            if (s.equals(""))
                break;
        }
        System.out.println(vals.pop());

    }
}
