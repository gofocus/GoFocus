package Chapter1_3;

/**
 * Created by GoFoCus $on 2017/7/18.
 * 调整栈中数组的大小
 */

public class Ch1323<Item> extends FixedCapacityStack {
    private Item[] a;
    private int N;

    public Ch1323(int cap) {
        super(cap);
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        /*for (int i = 0; i < N; i++) {   //手动复制数组
            temp[i] = a[i];
        }
        a = temp;*/
        System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    @Override
    public void push(Object o) {
        if (N == a.length) resize(a.length * 2);
        a[N++] = (Item) o;
    }

    @Override
    public Object pop() {
        Object o = a[--N];
        a[N] = null;
        if (N > 0 && N < a.length / 4)
            resize(a.length / 2);
        return o;
    }
}

