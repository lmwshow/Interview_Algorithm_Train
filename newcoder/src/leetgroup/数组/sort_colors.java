package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/17.
 */
public class sort_colors {


    /*

            The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.


            void sortColors(int A[], int n) {
            int second=n-1, zero=0;
            for (int i=0; i<=second; i++) {
                while (A[i]==2 && i<second) swap(A[i], A[second--]);
                while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
            }
        }
     */

    public void sortColors(int[] nums) {

        int len = nums.length;
        if (len == 0)
            return;

        int num0= 0,num1=0,num2=0;

        for (int x : nums)
        {
            if (x == 0)
                num0 ++;
            else if (x == 1)
                num1 ++;
            else
                num2++;
        }

        int index = 0;
        while (num0-- > 0)
            nums[index++] = 0;
        while (num1-- > 0)
            nums[index++] = 1;
        while (num2-- > 0)
            nums[index++] = 2;


        return;
    }
}
