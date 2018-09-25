package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by gofocus on 2017/8/5 14:56.
 */
public class foreach {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("iPhone");
        list.add("Windows Mobile");

        for(String language: list){
            System.out.println(language);
//            list.iterator().remove();//会报错
        }
        System.out.println(list.isEmpty());


    }
}
