package Top_Interview_Questions_2.树;

public class Question96_不同的二叉查找树个数 {

    public static int numTrees(int n) {

        if (n == 0)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i <= n ;i++)
        {
            for (int j = 0 ; j < i; j++)
                dp[i]+= dp[j]*dp[i-1-j];
        }

        return dp[n];
    }

    public static void main(String[] args){

        System.out.println(numTrees(1));

    }
}
