package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/17.
 */
public class remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] A) {

        int len = A.length;
        if (len == 0)
            return len;

        int realLen = 1;
        int cur = A[0];
        for (int i = 1 ; i < len ; i++)
        {
            if (A[i] == cur)
                continue;

            cur = A[i];
            A[realLen ++] = A[i];

        }

        return realLen;
    }

}
