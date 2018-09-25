package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/7/31.
 * 编写一个方法delete(),接受一个int参数k，删除链表的第k个元素（如果它存在的话）
 * 本类为测试类
 */
public class Ex1320 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> s = new Stack<>();
        String br;
        while (!(br = bufferedReader.readLine()).equals("")) {
            if (!br.equals("-"))
                s.push(br);
            else if (!s.isEmpty())
                System.out.println(s.pop());
        }

        int i = bufferedReader.read();
        int k = Character.digit(i, 10);//把用ascll码表示的数字转换为真正的数字
        System.out.println(s.delete(k));
    }
}


