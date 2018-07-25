package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/25 09:38
 * @Description: 0-a,1-b,....25-z 对数字进行翻译，求不同翻译的总数
 *
 * 如果使用递归或者dfs，会存在重复的子问题，所以递归并不是解决这个问题的最佳方法。
 * f(i) = f(i+1) + g(i,i+1)*f(i+2)  当第i位和第i+1位两位数字拼接起来在10-25之间时，g(i,i+1)=1
 *
 * 递归从最大的问题开始自上而下解决问题。我们也可以从最小的子问题开始自下而上解决问题，这样就可以消除重复的子问题
 *
 */
public class 把数字翻译成字符串 {

    public static int NumberofTransform(int n) {

        int ans = 0 ;
        if (n < 0)
            return ans;

        String numstr = String.valueOf(n);

        //自下而上解决
        ans = getTranslationCount(numstr);

        return ans;
    }

    private static int getTranslationCount(String numstr) {

        int length = numstr.length();
        int[] counts = new int[length];
        int count = 0;

        for (int i = length - 1; i >= 0 ; i --)
        {
            count = 0;
            if (i <length - 1)
                count = counts[i+1];
            else
                count = 1;

            if (i <length - 1)
            {
                int digit1 = numstr.charAt(i) - '0';
                int digit2 = numstr.charAt(i+1) - '0';
                int converted = digit1 * 10 + digit2;

                if (converted >= 10 && converted <= 25)
                {
                    if (i < length - 2)
                        count += counts[i+2];
                    else
                        count += 1;
                }
            }

            counts[i] = count;
        }


        return counts[0];

    }


    public static void main(String[] args){

        System.out.println(NumberofTransform(12258));

    }
}