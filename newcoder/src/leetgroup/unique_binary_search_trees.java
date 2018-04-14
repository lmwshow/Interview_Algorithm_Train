package leetgroup;

/**
 * Created by Gracecoder on 2017/6/22.
 */
public class unique_binary_search_trees {

    public int numTrees(int n) {

        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i < num.length ; i++)
        {
            for (int j = 0 ; j < i/2 ; j ++)
                num[i]+=num[j]*num[i-1-j];

            num[i] *= 2;
            if (i%2 == 1)
                num[i] += num[i/2]*num[i/2];
        }

        return num[n];
    }
}
