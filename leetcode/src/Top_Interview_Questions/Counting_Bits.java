package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/11/8.
 *
 * 运用二进制中，2 的幂次的表达形式，快速判断 当前i是否是2的整次幂，(val & (val-1)) == 0
 * 然后如果是整次幂，就返回1，不是的话找小于它的最大的整次幂 然后 加上 这个差值中1的个数， 而这个差值中1的个数就是res[dif],记忆化
 *
 * 那么小于当前数的最大的整次幂，我们也可以用一个tmp去存储，这样能够在0(1)中找到这个值 以及 算出dif
 *
 * 运用记忆化
 * 自己的还是垃圾了点， 没有运用到未 - -！  不过也满足 优化的要求了
 *
 * 最终：f[i] = f[i / 2] + i % 2
 *
 */
public class Counting_Bits {

    public int[] countBits(int num) {

        int[] res = new int[num + 1];

        String tmp ;
        int count = 0;

        for (int i = 0 ; i < res.length ;  i++)
        {
            tmp = Integer.toBinaryString(i);
            for (char c : tmp.toCharArray())
                if (c == '1')
                    count ++;

            res[i] = count;
            count = 0;
        }

        return res;

    }

    public int[] mybetter_countBits(int num) {

        int[] res = new int[num + 1];


        int cur = 1;

        for (int i = 1 ; i < res.length ;  i++)
        {
            if (isPowerOfTwo(i))
            {
                res[i] = 1;
                cur = i;                        //小于当前i的最大2的整次幂
            }
            else
                res[i] = 1 + res[i-cur];
        }

        return res;

    }

    public boolean isPowerOfTwo(int val)
    {
        return (val&(val - 1)) == 0;
    }

    public static void main(String[] args){


        System.out.println(Integer.toBinaryString(7));

    }
}
