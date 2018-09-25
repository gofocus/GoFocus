package Chapter1_3;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by GoFoCus $on 2017/7/20.
 * 下压栈(链表实现)
 */
public class Ch1338下压栈_链表实现 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> s = new Stack<String>();
        String br;
        while (!(br = bufferedReader.readLine()).equals("")) {
            if (!br.equals("-"))
                s.push(br); //压不进去
            else if (!s.isEmpty())
                System.out.println(s.pop());
        }
    }
}

class Stack<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private class Node{
        Item item;
        Node next;
    }


    void delete(int k) {
        if (k > 1) {
            Node current = first;
            while (--k > 1 || current.next != null) {
                current = current.next;
            }
            if (current == null) System.out.println("链表长度溢出");
            current.next = current.next.next;
        }
        else if (k == 1) first.next = null;
        else System.out.println("参数错误，请输入大于0的参数");
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
//        Node first = new Node();      //此处的first为局部变量，此方法内的后续操作只影响该局部变量，不影响全局变量first
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
