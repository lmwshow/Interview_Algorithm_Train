package leetgroup.回文;

/**
 * Created by Gracecoder on 2017/9/14.
 * <p>
 * solution1:DP
 * 表达式dp[i][j] 表示s[i-1...j-1]是否为回文串
 * 状态转移方程： dp[i][j] = (s[i-1]==s[j-1]&&dp[i+1][j-1])
 * 画个矩阵可以看出 (i+1,j-1)在(i,j)的左下方  要想知道dp[i][j]得先知道dp[i+1][j-1]  所以需要改变dp的顺序 i从下往上 j从左到右 ，即左下往右上
 * <p>
 * solution2:KMP匹配  有问题
 * <p>
 * solution3:
 */
public class Longest_Palindromic_Substring {


    //DP
    public static String longestPalindrome(String s) {


        if (s.length() == 0 || s.length() == 1)
            return s;

        int max = 1, left = 0, right = 0;
        int len = s.length();

        boolean[][] dp = new boolean[len + 1][len + 1];
        dp[0][0] = true;


        for (int i = len; i > 0; i--)
            for (int j = 0; j <= len; j++) {
                if (i >= j)
                    dp[i][j] = true;         //当i比j大时，表示空串 是回文
                else {
                    dp[i][j] = (s.charAt(i - 1) == s.charAt(j - 1)) && dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (j - i + 1 >= max) {
                            max = j - i + 1;
                            left = i - 1;
                            right = j - 1;
                        }
                    }
                }

            }

        return s.substring(left, right + 1);
    }


    private static int[] next;

    private static void getNext(String s) //KMP 求next数组
    {
        int k = -1, j = 0;   //k表示前缀,j表示后缀
        next[0] = -1;

        while (j < s.length()) {
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                next[j] = k;       //相当于next[j+1] = next[j] + 1 = k + 1;
            } else
                k = next[k];        //不断递归前缀索引
        }
    }

    private static int compare(String pattern, String s) //用KMP算法做求出最长的前缀匹配
    {
        int i = 0, j = 0;

        int maxLen = 0;

        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];

            if (j > maxLen)
                maxLen = j;
            if (j == pattern.length())
                return maxLen;
        }

        return maxLen;
    }

    //KMP看毛片
    public static String KMPlongestPalindrome(String s) {

        String reverString = new StringBuilder(s).reverse().toString(); //求得逆序String

        next = new int[s.length() + 1];

        String maxPal = "";
        int maxLen = 0;
        int len;
        for (int i = 0; i < s.length(); i++) //枚举所有后缀
        {
            String suffix = reverString.substring(i);
            if (suffix.length() < maxLen)           //如果后缀长度已经小于maxLen了，就可以break了 因为已经没用可行解了
                break;

            getNext(suffix);
            len = compare(suffix, s);
            if (len > maxLen) {
                if (isPalindrome(suffix.substring(0, len))) {
                    maxPal = suffix.substring(0, len);
                    maxLen = len;
                }
            }
        }

        return maxPal;


    }


    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 1)
            return true;

        int start = 0;
        int end = len - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }


    // Transform S into T.
// For example, S = "abba", T = "^#a#b#b#a#$".
// ^ and $ signs are sentinels appended to each end to avoid bounds checking

    public static String preProcess(String s)
    {
        int n = s.length();
        if (n == 0) return "^$";
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0 ; i < n ; i++)
        {
            ret.append("#"+s.charAt(i));
        }

        ret.append("#$");
        return ret.toString();
    }

    public static String ManacherlongestPalindrome(String s)
    {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0,R = 0;

        for (int i = 1; i < n-1;i++)
        {
            int i_mirror = 2*C-i;   //equals to i'= C - (i - C)

            P[i] = (R > i)?Math.min(R-i,P[i_mirror]):0;

            //试图扩展以i为中心的回文，i + P[i] = R 的， 扩展的前提是 T[R + 1] == T[L - 1]
            while (T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1))
                P[i]++;

            if (i + P[i] > R)
            {
                C = i;
                R = i + P[i];
            }
        }

        //找出P中最大值

        int maxLen = 0 ;
        int centerIndex = 0;
        for (int i = 1 ; i < n-1 ; i++)
        {
            if (P[i] > maxLen)
            {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen - 1)/2 ;
        return s.substring(start,start + maxLen);
    }

    public static void main(String[] args) {

        String s = "abba";

        System.out.println(ManacherlongestPalindrome(s));


    }

}
