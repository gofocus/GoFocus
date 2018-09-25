package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by GoFoCus $on 2017/8/2.
 */
public class Stack<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private class Node{
        Item item;
        Node next;
    }


    //接受一个int参数k，删除链表的第k个元素（如果它存在的话）
    Item delete(int k) {
        if (k > 1) {
            Node current = first;
            while (--k > 1) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("链表长度溢出");
                return null;                        //方法要求返回一个值但实际没有可以返回的值，可以返回null
            }
            else {
                Item item = current.next.item;
                current.next = current.next.next;   //删除中间的Node（注意OGNL表示法何时表示属性，何时表示属性对应的对象）
                return item;
            }
        }
        else if (k == 1) {
            Item item = first.item;
            first.next = null;
            return item;
        }
        else {
            System.out.println("请输入大于0的参数");
            return null;
        }
    }

    Item peek() {
        if (!isEmpty())  throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    //iterator()
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current !=null;
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
