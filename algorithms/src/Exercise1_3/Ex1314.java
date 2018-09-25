package Exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gofocus on 2017/7/29 15:25.
 *  编写一个ResizingArrayQueueOfStrings类，使用定长数组实现队列的抽象，然后拓展实现，使用调整数组的方法突破大小的限制
 *  本类为测试类
 */

public class Ex1314 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ResizingArrayQueueOfStrings resizingArrayQueueOfStrings = new ResizingArrayQueueOfStrings<String>();
        String bf;
        int i;
        while (!(bf=bufferedReader.readLine()).equals("")){
            if (!bf.equals("-")) resizingArrayQueueOfStrings.enqueue(bf);
            else System.out.println(resizingArrayQueueOfStrings.dequeue());
        }

    }

}


