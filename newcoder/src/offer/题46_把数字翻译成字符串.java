package offer;

import java.util.ArrayList;
import java.util.List;

public class 题46_把数字翻译成字符串 {

    public static int NumberofTransform(int n) {
        if (n < 0)
            return 0;
        if (n < 10)
            return 1;

        int[] res = new int[1];
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(0, n % 10);
            n /= 10;
        }

        solver(list, res, 0);

        return res[0];

    }

    //用递归的思想去分析，但由于存在重复的子问题，递归并不是解决这个问题的最佳方法
    //动态规划
    //https://www.jianshu.com/p/80e1841909b7
    //从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0

    //这是递归
    private static void solver(List<Integer> list, int[] res, int index) {

        if (index == list.size()) {
            res[0]++;
            return;
        }

        solver(list, res, index + 1);

        int tmp = list.get(index) * 10 + list.get(index + 1);

        if (index + 1 < list.size() && tmp <= 25 && tmp >= 10)          //两个数字要在10-25 之间
            solver(list, res, index + 2);

    }


    public static void main(String[] args) {


        System.out.println(NumberofTransform(-10));

    }
}
