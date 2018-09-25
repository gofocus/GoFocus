package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by GoFoCus $on 2017/8/2.
 * 编写一个方法insertAfter()，接受两个链表结点作为参数，将第二结点插入链表并使之成为第一个结点的后续结点（如果两个参数为空则什么也不做）
 */
public class Ex1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> strings = new Queue<>();
        String s;
        while (!(s = bufferedReader.readLine()).equals("")) {
            if (!s.equals("-")) strings.enqueue(s);
            else strings.dequeue();
        }

        Queue<String>.Node node = strings.getNode();
        node.item = "test";

        strings.insertAfter(strings.getFirst(), node);

        for (String string : strings) {
            System.out.println(string);
        }



    }

}

