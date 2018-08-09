package Top_Interview_Questions_2;

public class Question5_最长回文串 {

    //Solution1: DP   dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0)
            return "";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int max = 1;
        int left = 0;
        int right = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (j <= i)
                    dp[i][j] = true;

                else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        left = i;
                        right = j;
                        max = j - i + 1;
                    }
                }

            }
        }

        return s.substring(left, right + 1);

    }



    //Solution2: O(N) Manacher算法 马拉车   again

    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking

    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0)
            return "^$";
        StringBuilder ret = new StringBuilder("^");

        for (int i = 0; i < s.length(); i++)
            ret.append("#").append(s.charAt(i));

        ret.append("#$");

        return ret.toString();

    }

    public static String BestlongestPalindrome(String s) {

        String T = preProcess(s);
        int n = T.length();

        int[] P = new int[n];

        //C表示当前中心点，R表示当前回文串达到的最远距离
        int C = 0, R = 0;

        for (int i = 1; i < n - 1; i++) {

            int i_mirror = 2 * C - i;    //equal i_mirror = C - (i-C)

            P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;

            //试图扩展以i为中心的回文，i + P[i] = R 的， 扩展的前提是 T[R + 1] == T[L - 1]
            while (T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1))
                P[i]++;

            //当回文达到的最远距离变化时，同时改变当前中心点C = i
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        //找出P中最大值

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen - 1) / 2;
        return s.substring(start, start + maxLen);

    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("bbbb"));


    }

}