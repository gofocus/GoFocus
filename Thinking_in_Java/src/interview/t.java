package interview;

import java.util.*;

/**
 * @Author: gofocus
 * @Date: 15:05 2018/4/1 0001
 */
public class t {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();

            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (char c : chars) {
                if (map.get(c)==null) map.put(c, 1);
//                if (!map.containsKey(c)) map.put(c, 1);
                else map.put(c, map.get(c) + 1);
            }

            Collection<Integer> values = map.values();
            int min = Collections.min(values);
            StringBuilder stringBuilder = new StringBuilder();

            for (char c : chars) {
                if (map.get(c)!=min) stringBuilder.append(c);
            }

            System.out.println(stringBuilder);
        }


    }


}
