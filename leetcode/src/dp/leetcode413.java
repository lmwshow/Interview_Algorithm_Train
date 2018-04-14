package dp;

/**
 * Created by Gracecoder on 2017/3/17.
 */
public class leetcode413 {

    public int numberOfArithmeticSlices(int[] A) {

        if (A.length < 3)
            return 0;
        int add = 0;
        int sum = 0;

        for (int i = 2;i < A.length ; i ++)
        {
            if (A[i-1]-A[i-2] == A[i] - A[i-1])
            {
                add ++;                 //add表示当前加的次数， 如果前面3个数已经是等差，下一个数也构成等差那增量会多一个变成2，再下一个数又连续 增量就会变成3 递增
                sum += add;
            }
            else
                add = 0;
        }
        return sum;
    }
}
