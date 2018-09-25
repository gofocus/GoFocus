package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/8/1.
 * 编写一个方法find()，接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域的值为key，则方法返回true，否则返回false。
 * 本类为测试类
 */
public class Ex1321 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> strings = new Queue<>();
        String s;
        while (!(s = (bufferedReader.readLine())).equals("")) {
            if (!s.equals("-")) strings.enqueue(s);
            else System.out.println(strings.dequeue());
        }

        /*Iterator<String> iterator = stringQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        for (String aStrings : strings) {
            System.out.println(aStrings);
        }

        System.out.println(strings.find(strings, "key"));
    }


}



