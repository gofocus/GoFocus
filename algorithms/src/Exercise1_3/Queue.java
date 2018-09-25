package Exercise1_3;

import java.util.Iterator;

/**
 * Created by GoFoCus $on 2017/8/2.
 */
public class Queue<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

//    private class Node {
    public class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    int size() {
        return N;
    }


    // 编写一个方法max()，接受一个链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。
    int max(Node first) {
        int max;
        if (first == null) return 0;
        for (max = (Integer) first.item;first.next!=null;) {
            first = first.next;
            if ((Integer)first.item > max) {
                max = (Integer)first.item;
            }
        }
        return max;

    }

//    编写一个方法remove(),接受一条链表和一个字符串key作为参数，删除链表中所有item域为key的结点。
    void remove(Queue<Item> queue, String key) {
        for (Node current=queue.first;current!=null&&current.next!=null;current=current.next) {
            while (first.item.equals("test")) {
                first = first.next;
            }
            while (current.next!=null && current.next.item.equals(key)) {
                Node temp = current.next;
                if (temp.next == null){
                    current.next = null;
                    break; //这里会跳出while(上级的while),而不是跳出if()
                }

                while (temp.next.item.equals(key)) {
                    temp = temp.next;
                    if (temp.next==null) break;
                }
                current.next = temp.next;
            }
        }
    }

    void remove2(Queue<Item> queue, String key) {
        while (first.item.equals("test")) {
            first = first.next;
            if (first == null) break;
        }
        if (first == null) return;//终止方法，直接return，后面什么都不用加
        Node current = first;
        Node temp = first;
        while (current.next != null) {
            while (current.next.item.equals("test")) {
                current = current.next;
                if (current.next==null) break;
            }
            temp.next = current.next;
            if (temp.next == null) break;
            temp = current.next;
            current = temp;
        }
    }


    //    编写一个方法insertAfter()，接受两个链表结点作为参数，将第二结点插入链表并使之成为第一个结点的后续结点（如果两个参数为空则什么也不做）
    void insertAfter(Node node1, Node node2) {
        Node temp = node1.next;
        node1.next = node2;
        node2.next = temp;
    }

    public Node getNode() {
        return new Node();
    }

    //    编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参数结点或参数结点的后续结点为空则什么也不做）。
    void removeAfter(Node node) {
        if (node.next != null) {
            node.next = node.next.next;
        }
    }

    //    编写一个find()方法,接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域的值为key，则方法返回true，否则返回false。
    boolean find(Queue<Item> queue, String key) {
        for (Item aQueue : queue) {
            if (aQueue.equals(key)) return true;
        }
        return false;
    }

    //注意队列初始状态下首指针和尾指针的处理
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
        if (!isEmpty()) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        } else {
            System.out.println("队列为空");
            return null;
        }
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

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }



}
