package Chapter1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * Created by GoFoCus $on 2017/7/25.
 */
public class Ch1339先进先出队列 {

    public static void main(String[] args) throws IOException {
        Queue<String> queue = new Queue<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String br;
        while (!(br = bufferedReader.readLine()).equals("")) {
            if (!br.equals("-")) queue.enqueue(br);
            else if (queue.size() != 0) System.out.println(queue.dequeue());
            else System.out.println("队列为空，无法出列");
        }
    }
}


class Queue<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }

    boolean isEmpty() {
        return first == null;
    }

    int size() {
        return N;
    }

    void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    Item dequeue() {
        if (isEmpty()) {
            last = null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

}