package hihocoder.编程练习赛62;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Auther: minGW
 * @Date: 2018/6/3 12:34
 * @Description
 */
public class 被遗忘的整数 {

    static int ans;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        ans = 0;
        int a = in.nextInt();
        int h = in.nextInt();

        for (int i = 1 ;; i++)
        {
            findDivisor(i,list);
            if (a == average(list) && h == tAverage(list))
            {
                System.out.println(i);
                return;
            }
            list.clear();
        }

    }

    private static int tAverage(List<Integer> list) {

        int size = list.size();
        double sum = 0;
        for (int x : list)
            sum += 1.0/x;

        return (int) (size/sum);

    }

    private static int average(List<Integer> list) {

        int size = list.size();
        int sum = 0;

        for (int x : list)
            sum += x;


        return sum/size;
    }

    private static void findDivisor(int n, List<Integer> list) {

        for (int i = 1; i <= n ; i++)
            if (n % i == 0)
                list.add(i);

    }
}
