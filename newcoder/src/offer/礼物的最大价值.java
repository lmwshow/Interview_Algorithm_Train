package offer;

public class 礼物的最大价值 {

    public static int MaxValueOfGift(int[][] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int row = nums.length;
        int col = nums[0].length;

        int[][] dp = new int[row+1][col+1];

        for (int i = 1 ; i <= row ; i++)
            for (int j = 1 ; j <= col ; j++)
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + nums[i-1][j-1];

        return dp[row][col];
    }

    public static void main(String[] args){

        System.out.println(MaxValueOfGift(new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}}));


    }
}
