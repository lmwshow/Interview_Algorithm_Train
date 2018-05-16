package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/15 14:32
 * @Description https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * http://blog.csdn.net/yi_afly/article/details/52012593
 * 分析：算从1到n整数中1出现的 次数：O(logn)算法
 *
 * 可以通过累加每位上1出现的次来，来求得最终解
 * 每次将整数分为个位 和 高位两部分
 * 比如：  534  round:53 weight:4  此时base为1
 *        此时个位从0->9 变化了round次  所以个位上1的次数出现了  round*base次
 *        再根据weight的大小，计算第round+1次周期里，1出现的个数。
 *        当weight == 1时， 1出现的个数为低位的大小  n%base+1 ,  (0到n%base)
 *        当weight > 1时， 1出现的次数就是 base基数大小(一个周期)
 *
 *
 */
public class 从1到n整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;                       //base表示基数
        int round = n;

        while (round > 0)
        {
            int weight = round%10;           //获取当前的个位
            round /= 10;                    //round 表示当前高位数字

            count += round * base;          //round表示高位，
            if (weight == 1)
                count += n%base + 1;
            else if (weight > 1)
                count += base;

            base *= 10;

        }

        return count;

    }
}
