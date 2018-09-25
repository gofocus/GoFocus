package Chapter1_3;

import java.util.Iterator;

/**
 * Created by GoFoCus $on 2017/7/19.
 * 下压(LIFO)栈
 */
public class Ch1325<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] a = (Item[]) new Object[1];

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length)
            resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;


        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }


}
