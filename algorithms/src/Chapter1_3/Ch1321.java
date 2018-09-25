package Chapter1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by GoFoCus $on 2017/7/17.
 * 定容字符串栈
 */
public class Ch1321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("text in");
        FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(100);
        String b;
        while ((b=br.readLine())!=null ) {
            if (b.equals(""))
                break;
            if (!b.equals("-")) {
                f.push(b);
            }
            else
                System.out.println(f.pop());
        }
        br.close();
        System.out.println(f.size());

    }
}


class FixedCapacityStackOfStrings{
    private String a[];
    private int N;

    FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    boolean isFull() {
        return N == a.length;
    }

    int size() {
        return N;
    }

    void push(String item){
        a[N++] = item;
    }

    String pop() {
        return a[--N];
    }
}
