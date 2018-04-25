package Top_Interview_Questions_2;

/**
 * @Auther: minGW
 * @Date: 2018/4/25 08:42
 * @Description:
 */
public class Question338_Bit位计数 {

    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    public static int[] best_countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    //将2的幂次，初始化为1。其他的为ans[i] = ans[base] + ans[index++];
    public static int[] countBits(int num) {

        int[] ans = new int[num + 1];
        int base = 1;
        while (base < ans.length)
        {
            ans[base] = 1;
            base = base << 1;
        }

        if (num <= 2)
            return ans;

        base = 2;
        int index = 1;

        for (int i = 3 ; i <= num ; i++)
        {
            if (ans[i] == 1)
            {
                base = i;
                index = 1;
                continue;
            }

            ans[i] = ans[base] + ans[index++];
        }

        return ans;
    }

    public static void main(String[] args){

        int[] ans = countBits(5);

        for (int x : ans)
            System.out.println(x);

    }
}
