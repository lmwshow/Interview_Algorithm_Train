/**
 * Created by Gracecoder on 2017/8/2.
 */
public class leetcode43大数相乘 {

    int MAX =111*111;                       //这里m,n的长度小于110
    int[] a = new int[MAX];
    int[] b = new int[MAX];
    int[] r = new int[MAX];
    int k;                                  //进位

    public String multiply(String num1, String num2) {


        StringBuilder sb = new StringBuilder();
        //先把num1 和 num2 初始化成数组
        //为了方便计算， 初始化成数组时，用逆序，即个位在a[0]

        int length1 = num1.length();
        int length2 = num2.length();

        for (int i = 0 ; i < length1 ; i ++)
            a[i] = num1.charAt(length1 - i -1) -'0';

        for (int i = 0 ; i < length2 ; i ++)
            b[i] = num2.charAt(length2 - i -1)-'0';

        //计算乘积
        solve(a,b,length1,length2,sb);

        return String.valueOf(sb);
    }

    private void solve(int[] a, int[] b, int length1, int length2, StringBuilder sb) {

        for (int i = 0 ; i < length1 ; i++)
            for (int j = 0 ; j < length2 ; j++)
            {
                k = i + j;                  //对a的第i位 与 b的第j为相乘的结果 在 r的 i+j 位
                r[k] += a[i]*b[j];
                while (r[k] > 9)
                {
                    r[k+1] += r[k]/10;       //进位,要用+
                    r[k] %= 10;
                }
            }

        int high = length1 + length2 - 1;   //最高位 看是否有进位
        while (r[high] == 0 && high > 0) high --;

        for (int i = high ; i>=0; i --)
            sb.append(r[i]);

        return;

    }
}
