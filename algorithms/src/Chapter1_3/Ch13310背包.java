package Chapter1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by GoFoCus $on 2017/7/25.
 */
public class Ch13310背包 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String br;
        Bag<String> bag = new Bag<String>();
        while (!(br = (bufferedReader.readLine())).equals("")) {
            if (!br.equals("-")) {
                bag.add(br);
            } else {
                Iterator<String> iterator =  bag.iterator();
//                for (int n = 0; n < bag.size(); n++) {
//                    System.out.println(s.next());
//                }
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        }
    }

}

class Bag<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    boolean isEmpty() {
        return first==null;
    }

    int size() {
        return N;
    }

    void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}