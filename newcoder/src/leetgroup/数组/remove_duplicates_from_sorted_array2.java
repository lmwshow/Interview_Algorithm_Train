package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/17.
 */
public class remove_duplicates_from_sorted_array2 {

    public int removeDuplicates(int[] A) {

        int len = A.length;
        if (len == 0)
            return len;

        int time = 1;
        int realLen = 1;
        int cur = A[0];
        for (int i = 1 ; i < len ; i++)
        {
              if (A[i] == cur)
              {
                  time ++;
                  if (time>2)
                      continue;
              }else
                  time = 1;

              cur = A[i];
              A[realLen ++] = A[i];

        }

        return realLen;
    }
}
