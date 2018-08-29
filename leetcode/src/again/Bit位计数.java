package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/24 10:31
 * @Description:
 *
 *
 * 运用二进制中，2 的幂次的表达形式，快速判断 当前i是否是2的整次幂，(val & (val-1)) == 0
 * 然后如果是整次幂，就返回1，不是的话找小于它的最大的整次幂 然后 加上 这个差值中1的个数， 而这个差值中1的个数就是res[dif],记忆化
 *
 * 那么小于当前数的最大的整次幂，我们也可以用一个tmp去存储，这样能够在0(1)中找到这个值 以及 算出dif
 *
 * 运用记忆化
 *
 * 最终：f[i] = f[i / 2] + i % 2
 */
public class Bit位计数 {

    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    public static int[] best_countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    //记忆化
    public int[] countBits(int num) {

        int[] ans = new int[num + 1];

        int cur = 1;    //当前最小的2的幂次数

        for (int i = 1 ; i <= num ; i++)
        {
            if (isPowerOfTwo(i))
            {
                cur = i;
                ans[i] = 1;
            }
            else
                ans[i] = ans[cur] + ans[i - cur];
        }

        return ans;

    }

    private boolean isPowerOfTwo(int n) {

        return (n&(n-1)) == 0;

    }
}
