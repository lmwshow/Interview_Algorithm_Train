package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/16 10:19
 * @Description https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */

/* 暴力解法：首先最容易想到的方法就是暴力破解，思路非常简单，首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
         最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。
   效率不高在，对于非丑数，也要进行循环除法判断，如果只对丑数处理呢？


   直接寻找丑数，由丑数的定义可知，任何一个丑数都是2^i * 3^j * 5^m这种形式的，因此不断寻找丑数，将他们按从小到大的顺序进行排列，直到第n个即为结果。

   首先定义一个数组存放丑数，认为1是丑数，则初始化数组num[0] = 1，然后从2,3,5这三个种子中挑选，
   选择num[0]*2，num[0]*3，num[0]*5中最小的数为新的丑数，显然应该选择2，即num[1] = 2，
   然后在从2,3,5中选择，这时应该是从num[1]*2，num[0]*3，num[0]*5中进行选择，显然选择3，即num[2] = 3，
   然后再从num[1]*2，num[1]*3，num[0]*5中选择最小的，选择2，即num[3] = 4，依次进行如下操作，得到最终的结果。

   http://blog.csdn.net/lhanchao/article/details/52079323
         */


public class 丑数 {



    public static int GetUglyNumber_Solution(int index) {

        if (index == 0)
            return 0;
        int[] res = new int[index+1];

        res[1] = 1;
        int num2_idnex = 1;         //最后一个因子为2时，当前丑数的下标
        int num3_idnex = 1;
        int num5_idnex = 1;

        //下一个丑数，等于当前值 * 3个种子其中 最小的丑数
        for (int i = 2 ; i <= index ; i++)
        {
            res[i] = Math.min(Math.min(res[num2_idnex]*2,res[num3_idnex]*3),res[num5_idnex]*5);

            //更新种子下标，找出到底是2,3,5中哪个种子计算出的res[i]，当然，有可能有多个种子，所以使用while
            while (res[num2_idnex]*2 <= res[i])
                num2_idnex++;

            while (res[num3_idnex]*3 <= res[i])
                num3_idnex++;

            while (res[num5_idnex]* 5 <= res[i])
                num5_idnex++;
        }

        return res[index];

    }

        //dp暴力，最后一个例子栈空间大小超出范围
    public static int DP_GetUglyNumber_Solution(int index) {


        int n = 10000;

        boolean[] dp = new boolean[n];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        dp[5] = true;

        int i = 1;

        while (true)
        {
            if (i%2==0)
                dp[i] |= dp[i/2];
            if (i%3==0)
                dp[i]|=dp[i/3];
            if (i%5==0)
                dp[i]|=dp[i/5];
            if (dp[i])
                index--;

            if (index == 0)
                return i;

            i++;
        }


    }


    public static void main(String[] args){

        System.out.println(GetUglyNumber_Solution(0));


    }
}
