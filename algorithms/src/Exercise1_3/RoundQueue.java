package Exercise1_3;

/**
 * Created by GoFoCus $on 2017/8/7.
 * 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点链接为空，且只要链表非空则last.next的值就为first。只能使用一个Node类型的实例变量（last）。
 */
public class RoundQueue<Item> {
    private int N;
    private Node first;
    private Node last;
    public class Node{
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
        if (isEmpty()){ first = last;}
        else {
            oldLast.next = oldLast;
            last.next = first;}
        N++;
    }

    Item dequeue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        return item;
    }

}
