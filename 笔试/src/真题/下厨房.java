package 真题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 下厨房 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        Map<String,Boolean> map = new HashMap<>();

        //本题有一个难点，就是输入的行数不确定，也就是键盘输入几行就是几行，因此我们需要使用Scanner.class.hasNext()方法进行判断，该方法返回boolean类型的值
        while (in.hasNext())
        {
            String string = in.nextLine();
            String[] strings = string.split(" ");

            for (String str :
                    strings) {
                if (!map.getOrDefault(str,false))
                    map.put(str,true);
                else
                    continue;

            }
        }

        System.out.println(map.size());


    }
}
