package interview;

import java.util.*;

/**
 * Created by GoFoCus $on 2017/8/15.
 */


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] A = s.toCharArray();
            Map<Character, Integer> map = new LinkedHashMap<>();

            for (char c : A) {
                if (!map.containsKey(c)) map.put(c, 1);
//                if (map.get(c)==null) map.put(c, 1);  这样写也可以
                else map.put(c, map.get(c) + 1);
            }

            Collection<Integer> al = map.values();
            int index = Collections.min(al);
            StringBuffer stringBuffer = new StringBuffer("");
            for (char c : A) {
                if (map.get(c) != index) stringBuffer.append(c);
            }

            System.out.print(stringBuffer.toString());

        }

    }
}







