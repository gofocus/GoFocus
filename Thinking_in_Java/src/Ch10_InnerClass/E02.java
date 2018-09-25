package Ch10_InnerClass;


/**
 * @Author: gofocus
 * @Date: 7:24 2018/3/30 0030
 */
public class E02 {
    public static void main(String[] args) {
        Ch10_InnerClass.Sequence sequence = new Ch10_InnerClass.Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new StringHolder(Integer.toString(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }

    }

}

class StringHolder {
    private String data;

    StringHolder(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}