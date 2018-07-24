package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/24 11:13
 * @Description:
 */
public class 整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 0)
            return 0;

        int base = 1;
        int ans = 0;
        int round = n;

        while (round > 0)
        {
            int weight = round % 10;        //获取当前的个位
            round = round / 10;                 //round 表示当前高位数字
            ans+= base * round;

            if (weight == 1)                // 包括 0.1.2，...n%base
                ans += (n % base) + 1;
            else if (weight > 1)
                ans += base;

            base *= 10;
        }

        return ans;

    }
}
