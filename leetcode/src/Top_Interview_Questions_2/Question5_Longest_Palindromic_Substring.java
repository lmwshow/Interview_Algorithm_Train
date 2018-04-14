package Top_Interview_Questions_2;

public class Question5_Longest_Palindromic_Substring {

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

    public static void main(String[] args) {

        System.out.println(longestPalindrome("bbbb"));


    }

}