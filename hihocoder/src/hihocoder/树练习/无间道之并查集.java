package hihocoder.树练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/6/7 08:44
 * @Description:
 */
public class 无间道之并查集 {

    static Map<String,String> father = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());


        for (int i = 0 ; i < n ; i++)
        {
            String[] parts = in.readLine().split(" ");
            int op = Integer.parseInt(parts[0]);
            String name1 = parts[1];
            String name2 = parts[2];
            if (op == 0)
            {
                if (!father.containsKey(name1))
                    father.put(name1,name1);
                if (!father.containsKey(name2))
                    father.put(name2,name2);

                union(name1,name2);
            }else if (op == 1){
                System.out.println(findFather(name1).equals(findFather(name2))?"yes":"no");
            }
        }
    }

    /*
    并查集操作
     */
    private static void union(String name1, String name2) {

        name1 = findFather(name1);
        name2 = findFather(name2);

        if (name1.equals(name2))
            return;

        father.put(name2,name1);
        return;
    }

    private static String findFather(String name) {

        while (!name.equals(father.getOrDefault(name,name)))
            name = father.get(name);

        return name;
    }
}
