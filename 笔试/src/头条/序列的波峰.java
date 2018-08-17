package 头条;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/16 16:48
 * @Description:
 */
public class 序列的波峰 {

    /*
    一些无序的数，比如1,4,5,3,7,6 ，其中5和7就是波峰。
    用小于O(n)实现，分治
     */

    public static List<Integer> find(int... nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return ans;


        findCore(nums, 0, nums.length - 1, ans);


        return ans;
    }

    private static void findCore(int[] nums, int left, int right, List<Integer> ans) {

        if (left > right)
            return;

        int step = 0;
        int mid = ((right - left) >> 1) + left;

        if (mid != 0 && mid != nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
            ans.add(nums[mid]);
            step = 1;
        }

        findCore(nums, left, mid - 1 - step, ans);
        findCore(nums, mid + 1 + step, right, ans);




    }

    public static void main(String[] args) {

        System.out.println(find(1, 8, 4, 7, 5, 6, 2, 10, 3));
        
        System.out.println(find(0,0,0,0));


    }

}
