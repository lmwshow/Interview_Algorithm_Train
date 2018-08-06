package offer.again;

//动态规划 ： f(n,s) = f(n-1,s-1) + f(n-1,s-2) + f(n-1,s-3) + f(n-1,s-4) + f(n-1,s-5) + f(n-1,s-6)

public class 题60_n个骰子的点数 {


    //动态规划可以使用两个数组来回记录

    /*
    number: 代表筛子的个数
    g_maxValue： 代表每个筛子的最大点数
     */
    public static void printProbability(int number, int g_maxValue) {
        if (number < 1)
            return;

        int[][] pProbabilities = new int[2][g_maxValue * number + 1];

        int flag = 0;

        //初始化
        for (int i = 1; i <= g_maxValue; i++)
            pProbabilities[flag][i] = 1;

        for (int k = 2; k <= number; k++) {
            //将上一个数组先清空
            for (int i = 0; i < k; i++)
                pProbabilities[1 - flag][i] = 0;

            for (int i = k; i <= k * g_maxValue; i++) {
                pProbabilities[1 - flag][i] = 0;

                for (int j = 1 ; j <= i && j <= g_maxValue ; j++)
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
            }

            //切换
            flag = 1 - flag;
        }

        double total = Math.pow(g_maxValue,number);
        for (int i = number ; i <= g_maxValue * number ; i++)
        {
            double ratio = pProbabilities[flag][i] / total;
            System.out.println(ratio);
        }
    }



    //递归方法
    //那就是将骰子分为两堆：第一堆只有1个，另一堆有n-1个。我们需要计算1~6的每一种点数和剩下的n-1个骰子来计算点数和
    public static void recursionSolver(int number,int g_maxValue)
    {
        if (number < 1)
            return;

        int maxSum = number * g_maxValue;
        //和为s的点数出现的次数保存在 第s-number个元素中， 因为点数的范围是number ~ number*g_maxValue
        int[] pProbabilities = new int[maxSum - number + 1];

        for (int i = 1 ; i <= g_maxValue ; i++)
            probability(number,number,i,pProbabilities,g_maxValue);


        double total = Math.pow(g_maxValue,number);
        for (int i = 0 ; i <= maxSum - number ; i++)
        {
            double ratio = pProbabilities[i] / total;
            System.out.println(ratio);
        }
    }

    private static void probability(int origin, int current, int sum, int[] pProbabilities,int g_maxValue) {

        if (current == 1)
        {
            pProbabilities[sum - origin]++;
        }
        else
        {
            for (int i = 1; i <= g_maxValue ; i++)
                probability(origin,current - 1,sum +i , pProbabilities,g_maxValue);
        }
    }


    public static void main(String[] args){

//        printProbability(2,6);

        recursionSolver(1,6);
    }
}
