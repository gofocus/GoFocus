package Chapter1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GoFoCus $on 2017/7/18.
 * 泛型定容栈
 */
public class Ch1322 {
    public static void main(String[] args) throws IOException {
        FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String b;
        while ((b = br.readLine()) != null) {
            if (b.equals("")) break;
            if (!b.equals("-")) {
                s.push(b);
            } else
                System.out.println(s.pop());
        }
        System.out.println(s.size());
    }

}

class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public int size() {
        return N;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

}


