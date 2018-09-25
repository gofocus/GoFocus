package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/8/2.
 * 编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参数结点或参数结点的后续结点为空则什么也不做）。
 * 本类为测试类
 */
public class Ex1324 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> strings = new Queue<>();
        String s;
        while (!(s = bufferedReader.readLine()).equals("")) {
            if (!s.equals("-")) strings.enqueue(s);
            else strings.dequeue();
        }

        strings.removeAfter(strings.getFirst());
        for (String string : strings) {
            System.out.println(string);
        }
    }


}


