package hihocoder.图论;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: minGW
 * @Date: 2018/6/22 12:16
 * @Description:
 */
public class Main {

    public static void main(String[] args){


        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}
