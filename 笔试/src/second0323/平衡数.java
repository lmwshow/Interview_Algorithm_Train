package second0323;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/3/23.
 */
public class 平衡数 {

    public static void solution(int x)
    {
        if (x < 10)
        {
            System.out.println("NO");
            return;

        }
        Map<Integer,Integer> map = new HashMap<>();                     //map, 用于存每个位数上的数字，1代表个位，2代表十位上的数
        Map<Integer,Integer> map1 = new HashMap<>();                    //map1, 正向存储乘积，i表示后i位的乘积， 1表示个位， 2表示个位*十位， 3 表示个位*十位*百位
        Map<Integer,Integer> map2 = new HashMap<>();                    //map2, 反向存储乘积，i表示前i位的乘积， 1表示最高位，......
        map1.put(0,1);
        map2.put(0,1);
        int length = 1,tmp = x;
        while (tmp/10 != 0)
        {
            int k = tmp%10;
            map.put(length,k);
            map1.put(length,k*map1.get(length-1));
            tmp = tmp/10;
            length ++;
        }
        map.put(length,tmp);
        map1.put(length,tmp*map1.get(length-1));


        for (int i = 1 ; i <= length ; i++)
        {
            map2.put(i,map.get(length-i+1)*map2.get(i-1));
        }

        //因为map1.get(i)表示后i位的乘积， map2.get(i)表示前i位乘积，只需判断后i位 与 前length-i位 相等即可


        //Integer是一个对象，我们要比较值的时候，要使用equals方法，用==是比较是否是一个对象
        //这是由于在Integer的源码实现中，Integer 把-128-127 之间的每个值都建立了一个对应的Integer 对象放入了一个数组中，这里的数组类似于缓存，提前给你准备好这个范围内的对象。由于Integer 是不可变类，因此这些缓存的Integer 对象可以安全的重复使用。
        //所以在-128-127之间都会指向同一个对象 但是超过之后，我们用==就会出错了
        for (int i = 1 ; i <= length; i++)
        {
            if (map1.get(i).equals(map2.get(length-i))) {
                System.out.println("YES");
                return;
            }
        }

        //错误
//        for (int i = 1 ; i <= length; i++)
//        {
//            if (map1.get(i)==map2.get(length-i)) {
//                System.out.println("YES");
//                return;
//            }
//        }


        //先转化类型
//        for (int i = 1 ; i <= length; i++)
//        {
//            int a = map1.get(i);
//            int b = map2.get(length-i);
//            if (a==b) {
//                System.out.println("YES");
//                return;
//            }
//        }
        System.out.println("NO");
        return;



    }

    public static void main(String[] args){

        Scanner in =  new Scanner(System.in);
        while (in.hasNext())
        {
            int x = in.nextInt();
            solution(x);
        }
    }
}
