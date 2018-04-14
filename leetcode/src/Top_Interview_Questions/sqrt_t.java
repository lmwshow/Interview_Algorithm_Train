package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/10/9.
 */
public class sqrt_t {

    public static int mySqrt(int x) {

        if (x < 2)
            return x;

        int left = 0;
        int right = x;

        int mid = 0;
        int tar = 0;
        while (left <= right)
        {
            mid = (left + right)/2;
            mid = left + (right - left)/2;                                          //避免越界的写法
            tar = mid*mid;


            if (Integer.MAX_VALUE/mid < mid || tar > x)                            //避免越界，用除法才合理
                right = mid - 1;
            else if (tar == x)
                return mid;
            else
                left = mid +1;
        }

        return right;

    }


    public static void main(String[] args){

        System.out.println(mySqrt(3));

    }
}
