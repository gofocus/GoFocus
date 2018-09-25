package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by GoFoCus $on 2017/7/28.
 * 从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入： 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * 程序应该输出：( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Ex139 {

    private static boolean isData(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static void main(String[] args) throws IOException {
        Stack<String> operStack = new Stack<String>();
        Stack<String> dataStack = new Stack<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int b;
        String bf,data1,data2,opt,string;
        while ((b=bufferedReader.read())!=10) {
            bf = String.valueOf((char) b);
            if (isData(bf)) dataStack.push(bf);
            else if (isOperator(bf)) operStack.push(bf);
            else if (bf.equals(")")) {
                opt = operStack.pop();
                data2 = dataStack.pop();
                data1 = dataStack.pop();
                string = "(" + data1 + opt + data2 + ")";
                dataStack.push(string);
            }
        }
        System.out.println(dataStack.pop());
    }

}
