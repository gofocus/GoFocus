package Exercise1_3;

/**
 * Created by GoFoCus $on 2017/8/2.
 * 编写一个ResizingArrayQueueOfStrings类，使用定长数组实现队列的抽象，然后拓展实现，使用调整数组的方法突破大小的限制
 */
public class ResizingArrayQueueOfStrings<Item> {
    private Item[] a = (Item[]) new Object[3];  // ***
    private int N;

    void enqueue(Item item){
        if (a.length == N) resize(N * 2);
        a[N++] = item;
    }

    private void resize(int i) {
        Item[] temp = (Item[]) new Object[i];
        System.arraycopy(a,0,temp,0,N);
        a = temp;
    }

    Item dequeue(){
        Item item = a[0];
        a[0] = null;
        for (int i = 0; i < N-1; i++) {         // ***
            a[i] = a[i + 1];
        }
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }


}
