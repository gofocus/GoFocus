package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/8/3.
 * 编写一个方法remove(),接受一条链表和一个字符串key作为参数，删除链表中所有item域为key的结点。
 */
public class Ex1326 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> strings = new Queue<>();
        String readLine;
        while (!((readLine = bufferedReader.readLine()).equals(""))) {
            strings.enqueue(readLine);
        }
//        strings.remove(strings, "test");
        strings.remove2(strings,"test");
        for (String string : strings) {
            System.out.println(string);
        }
        if (strings.isEmpty())
            System.out.println("链表为空");
    }
}
