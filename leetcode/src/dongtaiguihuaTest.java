/**
 * Created by Gracecoder on 2016/12/21.
 */
public class dongtaiguihuaTest {

    //最长单调递增子序列， 不要求连续
    static int LISdyna(int[] a,int[] b)
    {
        int i , j , k ;
        for (i = 1,b[0]=1; i <a.length ; i ++)
        {
            for (j = 0 , k = 0 ; j < i ; j++)
                if (a[j] <= a[i] && k < b[j]) k = b[j];

            b[i] = k + 1;
        }

        return maxL(b);
    }

    static int maxL(int[] b)
    {
        int max = 0;
        for (int i = 0; i < b.length ; i ++)
        {
            if (max < b[i])
                max = b[i];
        }
        return max;
    }


    public static void main(String[] args){

        System.out.println(LISdyna(new int[]{1,2,3,2,4,5,7,1,2,5,3},new int[]{0,0,0,0,0,0,0,0,0,0,0}));

    }
}
