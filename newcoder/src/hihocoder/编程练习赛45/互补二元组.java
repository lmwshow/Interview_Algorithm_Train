package hihocoder.编程练习赛45;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 互补二元组 {

    //x1+x2 = y1 +y2  ==>  x1-y1 = -(x2-y2)
    //这样能通过遍历一次就能求解，  通过使用map
    //最大值超出int  需要有long表示

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Map<Long,Long> map = new HashMap<>();

        long x,y;
        long count = 0;

        for (int i = 0 ; i < n; i++)
        {
            x = in.nextInt();
            y = in.nextInt();

            if (map.containsKey(y - x))
                count += map.get(y-x);

            map.put((long) (x-y),map.getOrDefault(x-y,0L) + 1);

        }
//
//        System.out.println(Long.MAX_VALUE);
//
//        Long res = Long.valueOf((1L + 999999l)*1000000l0);
//        System.out.println(res);

        System.out.println(count);

        return;

    }

    public static void main1(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] num = new int[n][2];

        for (int i = 0 ; i < n ; i++)
        {
            num[i][0] = in.nextInt();
            num[i][1] = in.nextInt();
        }

        int count = 0;

        for (int i = 0 ; i < n ; i++)
            for (int j = i+1 ; j < n ;j++)
                if ((num[i][0]+num[j][0]) == (num[i][1]+num[j][1]))
                    count++;

        System.out.println(count);

        

    }
}
