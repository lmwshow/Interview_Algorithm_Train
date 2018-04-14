package Top_Interview_Questions_2;

public class Question238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] ans = new int[n];

        leftProduct[0] = 1;
        rightProduct[n-1] = 1;

        for (int i = 1;i < n ;i++)
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        for (int i= n-2;i>=0;i--)
            rightProduct[i] = rightProduct[i+1]*nums[i+1];

        for (int i = 0 ;i < n;i++)
            ans[i] = leftProduct[i]*rightProduct[i];

        return ans;

    }


    //不使用额外空间，上面写法的简化
    public int[] noExtraSpaceProductExceptSelf(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        ans[0] = 1;

        for (int i = 1;i < n ;i++)
            ans[i] = ans[i-1]*nums[i-1];

        int right = 1;
        for (int i= n-1;i>=0;i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;

    }
}
