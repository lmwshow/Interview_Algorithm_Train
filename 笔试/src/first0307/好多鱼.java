package first0307;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/3/14.
 */
public class 好多鱼 {

    public static int solotion(int min,int max,int n,int[] fishSize)
    {
        Arrays.sort(fishSize);
        int[] flag = new int[max+1];
        for (int size: fishSize)
        {
            int j = size/2;
            int i = (double)size/10.0==size/10?size/10:size/10 + 1;            //这里除了可能不是整数，需要微调，已保证flag正确
//            if (j < min || i > max)
//                continue;
            for (;i<=j&&i<=max;i++)
                flag[i] = 1;

            i = 2 * size;                       //这里i,j都是整数，没关系
            j = 10 * size;
//            if (i < min || j > max)
//                continue;
            for (;i<=j&&i<=max;i++)
                flag[i] = 1;
        }
        int count = 0;
        for (int i = min; i <= max ; i++)
            if (flag[i]==0)
                count++;

        return count;
    }

    public static void main(String[] args){
        int size =11;
        System.out.println((double)size/2.0);
        System.out.println(size/2);
        System.out.println((double)size/2.0==size/2?size/2:size/2);
        
        
        

        Scanner in = new Scanner(System.in);
        int min,max,n;
        min = in.nextInt();
        max = in.nextInt();
        n = in.nextInt();
        int[] fishSize = new int[n];
        for (int i = 0 ; i < n; i ++)
            fishSize[i] = in.nextInt();

        int res = solotion(min,max,n,fishSize);
        System.out.println(res);

    }
}
