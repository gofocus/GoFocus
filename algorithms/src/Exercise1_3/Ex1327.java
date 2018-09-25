package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/8/7.
 * 编写一个方法max()，接受一个链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。
 */
public class Ex1327 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> ints = new Queue<>();
        String s;
        while (!(s = bufferedReader.readLine()).equals("")) {
            ints.enqueue(Integer.valueOf(s));
        }
        System.out.println(ints.max(ints.getFirst()));

    }
}
