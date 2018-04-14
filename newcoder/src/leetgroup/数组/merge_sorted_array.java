package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/17.
 */
public class merge_sorted_array {

    public void merge(int A[], int m, int B[], int n) {

        int endA = m -1;
        int endB = n -1;

        for (int i = m + n -1 ; i >=0 ;i --)
        {
            if (endA < 0)
            {
                while (endB>=0)
                    A[i--] = B[endB--];

                break;
            }

            if (endB < 0)
                break;


            if (A[endA] < B[endB])
            {
                A[i] = B[endB--];
            }
            else
            {
                A[i] = A[endA--];
            }

        }


    }
}
