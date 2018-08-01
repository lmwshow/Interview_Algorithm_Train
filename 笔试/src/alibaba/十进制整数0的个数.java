package alibaba;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Auther: minGW
 * @Date: 2018/7/31 17:06
 * @Description:
 */
public class 十进制整数0的个数 {

    public static int getZeroCount(int num)
    {
        int ans = 0;

        while (num != 0)
        {
            if (num % 10 == 0)
                ans++;

            num /= 10;

        }
        return ans;


    }
    public static void main(String[] args){

        System.out.println(getZeroCount(-1000000000));
    }
}
