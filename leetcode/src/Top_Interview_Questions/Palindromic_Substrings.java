package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/11/27.
 * 动态规划dp
 *
 * solution2: 求回文，还有一种方式，是找中心点，然后往两边扩展判断是否相等，是否为回文。
 * 解法2：通过遍历以i为中心(奇数)或i和i+1(偶数)，回文长度为奇数和偶数，遍历所有可能的中心点，查找回文的个数
 */
public class Palindromic_Substrings {
    public static int countSubstrings(String s) {

        if (s == null || s.length() <2)
            return s.length()==1? 1: 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];


        for (int i = 0; i < n;i++)
        {
            dp[i][0] = true;
            dp[n-1][i] =true;
        }
        int count = 2;                  //字符串头尾两个单字符回文,即对角线上已经被初始化的两个

        for (int i = n - 2; i >= 0; i--)
            for (int j = 1; j < n; j++) {
                if (i > j)
                    dp[i][j] = true;
                else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    count += dp[i][j] == true ? 1 : 0;
                }
            }

        return count;
    }

   // -----------

    int count = 0;

    public int better_countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
    public static void main(String[] args){
        System.out.println(countSubstrings("aaaaa"));


    }
}
