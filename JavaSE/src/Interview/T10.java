package Interview;

import java.util.HashMap;

/**
 * @Author: gofocus
 * @Date: 8:34 2018/7/28 0028
 */
public class T10 {


    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("1", 1);
        hashMap.put("1", 2);
        hashMap.put("1", 3);
        System.out.println(hashMap.size());

    }
}
