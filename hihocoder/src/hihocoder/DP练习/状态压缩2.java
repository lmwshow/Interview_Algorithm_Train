package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/31 08:43
 * @Description: http://hihocoder.com/problemset/problem/1048
 *
 * 题解： https://blog.csdn.net/octopusflying/article/details/51329699
 *
 * 分析遍历从上到下，左到右递归分析，解题使用自底向上,状态方程还是按分析的来
 */
public class 状态压缩2 {

    static int MOD = 1000000007;
    static int M;
    static int N;
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        //3<=M<=5
        N = in.nextInt();
        M = in.nextInt();
        //压缩为2M位表示，总的状态数,前M位表示当前行的状态，后M位表示下一行的状态，因为在计算(i,j)时，只需要保存两行的状态就够了
        int state_cnt = (int) Math.pow(2,M*2);

        int[][][] dp = new int[N][M][state_cnt];

        //自底向上，状态转移还是根据分析时递归的方程
        for (int i = N - 1; i >= 0 ; i--){
            for (int j = M - 1; j >= 0 ; j--){
                for (int k = state_cnt - 1; k >= 0 ; k--){

                    //获取当前行，第j位的状态，看是否已经覆盖，tag=0表示扫描高位(即当前行)
                    int cur_state = get_bit(k,j,0);

                    //如果当前位置已经被覆盖
                    if (cur_state == 1){
                        //如果j不是当前行最后一个位置，当前sum值就等于下一枚举位置对应的sum值。dp[i][j][k] = dp[i][j+1][k],否则等于上一行第一个
                        if (j < M - 1)
                            dp[i][j][k] = dp[i][j+1][k];
                        //sum(i, j; p1, p2, ... pm；q1, q2, ... qm) = sum(i+1, 1; q1, q2, ... qm；0, 0, ... 0)
                        else {
                            if (i == N - 1)
                                dp[i][j][k] = 1;
                            else
                                dp[i][j][k] = dp[i + 1][0][(k << M) % state_cnt];
                        }
                    }
                    else {
                        //当前位置未覆盖

                        dp[i][j][k] = 0;

                        //越界判断
                        if (j < M - 1)
                        {
                            //或许 j+1 位置的状态，判断是否可以横放
                            int next_state = get_bit(k,j+1,0);
                            if (next_state == 0)
                            {
                                int state = put_cake(k,j,0);
                                dp[i][j][k] += dp[i][j][state];
                            }

                        }

                        if (i < N - 1)
                        {
                            int next_state = get_bit(k,j,1);

                            if (next_state == 0)
                            {
                                int state = put_cake(k,j,1);
                                dp[i][j][k] += dp[i][j][state];
                                dp[i][j][k] %= MOD;
                            }
                        }
                    }

                }
            }
        }


        System.out.println(dp[0][0][0]);

        return;


    }

    /*
     * This function puts a piece of cake in the given postion.
     * Parameters:
     *      @state: The original state.
     *      @y: The position to put (only y coordinate value).
     *      @tag: If tag = 1, put the cake in horizontical way, or in vertical way.
     * Returns:
     *      The new status value after putting.
     */

    private static int put_cake(int state, int y, int tag) {

        //获取第y位为1，其他为0的状态
        int r = 1;
        for(int i = 0; i < M - y - 1; i++) {
            r = r << 1;
        }

        //tag == 0 表示横放，通过或运算，计算放置后的状态
        if(tag == 0) {
            r = r << M;
            state = state | r;
            r = r >> 1;
            state = state | r;
        } else {
            state = state | r;
            r = r << M;
            state = state | r;
        }

        return state;
    }

    /*
     * This function gets the bit from the state according to the given position.
     * Parameters:
     *      @state: The state value.
     *      @position: The position to get.
     *      @tag: If tag = 0, get bit from p1, p2 ... pm; if tag = 1, get bit from
     *          q1, q2 ... qm.
     * Returns:
     *      The result bit;
     */
    static int get_bit(int state, int position, int tag) {
        if(tag == 0) {
            state = state >> M;
        }

        int r = 0;
        for(int i = 0; i < M - position; i++) {
            r = state % 2;
            state /= 2;
        }

        return r;
    }

}
