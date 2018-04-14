package Top_Interview_Questions.dp.again;

/**
 * Created by Gracecoder on 2017/10/19.
 */
public class Maximal_Square {

    public static int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int max_a = 1;

        // 相当于遍历整个 以每个点为顶点 判断 符合条件的最大的边长。 加以适当剪枝
        for (int i = 0; i < m; i++) {
            if (m - i < max_a)          //已经不可能产生可行解
                break;
            for (int j = 0; j < n; j++) {
                if (n - j < max_a)       //已经不可能产生可行解
                    break;
                while (i+max_a <= m&& j+max_a <= n&&check(matrix, i, j, max_a)) {   // 以(i,j)为左顶点的正方形
                    max = max_a * max_a;
                    max_a++;
                }
            }
        }

            return max;
    }



    private static boolean check(char[][] matrix, int i_start, int j_start, int max_a) {

        for (int i = i_start; i < i_start + max_a; i++)
            for (int j = j_start; j < j_start + max_a; j++) {
                if (matrix[i][j] == '0')
                    return false;
            }

        return true;
    }

    //同样和上次的抢劫一样，想着不可能用dp，但是像这种需要遍历 记忆的， 能分成小问题的 好像都是能用dp的
    //关键是找出状态转移方程，怎么找出下一个要求的值 和 前面已求值之间的关联。 赋予dp[i][j]怎样的意义，才能达到目的就很重要了

    //这里dp[i][j] 表示以matrix[i-1][j-1]为右下角顶点的矩阵的最大面积
    //那么 matrix[i-1][j-1] 如果为'0'，那么dp[i][j]就为0
    //如果 matrix[i-1][j-1] 如果为'1'，可以加入矩阵的话， 那么我们就要看与前面值的联系了
    //最开始我是想到与dp[i-1][j-1]的联系，想到 如果dp[i-1][j] 和 dp[i][j-1] 都大于 dp[i-1][j-1] 的话 ，这一行这一列就可以加入到dp[i-1][j-1]的矩阵中
    //如果有一个不满足的话，那么就不能这样算，那就只能在三者最小值的边长上+1 再平方获得面积了

    //到头来发现，当matrix[i-1][j-1] == '1'，时dp[i][j] 无论什么情况下 边长都是等于 三者最小值的边长上+1

    //最终由于意义表示面积时，会多出很多开方 平方的运算，显得有点多余，  直接将dp[i][j] 表示以matrix[i-1][j-1]为右下角顶点的矩阵的最大边长

    public static int maximalSquare_dp(char[][] matrix) {


        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int[][] dp =new int[m+1][n+1];


        for (int i = 1 ; i <= m ; i ++)
            for (int j = 1 ; j <= n ; j++)
            {
//                if (matrix[i-1][j-1] == '0')
//                    dp[i][j] = 0;
//                else if(dp[i-1][j] < dp[i-1][j-1] || dp[i][j-1] < dp[i-1][j-1])
//                    dp[i][j] = (int) Math.pow(Math.sqrt(Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]))+1,2);
//                else
//                    dp[i][j] = (int) Math.pow(Math.sqrt(dp[i-1][j-1])+1,2);

                if (matrix[i-1][j-1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;

                max = Math.max(max,dp[i][j]);
            }

        return max*max;
    }

    public static void main(String[] args){

        System.out.println(maximalSquare_dp(new char[][]{{'1'}}));


    }
}
