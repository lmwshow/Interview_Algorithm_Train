package second0323;

import com.sun.javafx.fxml.expression.KeyPath;

import java.util.*;

/**
 * Created by Gracecoder on 2017/3/23.
 */
public class 字符串分类 {

    /*
    主要用到set元素不重合的特性
    以及 Collections自带sort方法
     */

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Character> tmp = new ArrayList<>();
        Set<List> res = new HashSet<>();
        String str = "";

        while (n-- > 0)
        {
            str = in.next();
            for (int i = 0 ; i < str.length() ; i ++)
                tmp.add(str.charAt(i));
            Collections.sort(tmp);
            res.add(tmp);
            tmp.clear();
        }

        System.out.println(res.size());


    }
}
