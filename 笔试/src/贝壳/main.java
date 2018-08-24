package 贝壳;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/18 20:35
 * @Description:
 */
public class main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList);

        arrayList.add(1, 2);
        System.out.println(arrayList);



        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "ab";
        String str4 = "c";
        String str5 = str3 + str4;

//        String str = "hello";
        //这样子,堆中只有一个str6对象， 表达式中的hell 和 o 在字符串常量池中，堆中并没有引用
        String str6 = new String("hell") + new String("o");
        str6.intern();
        String str7 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1 == str5);

        System.out.println(str6 == str7);
    }
}
