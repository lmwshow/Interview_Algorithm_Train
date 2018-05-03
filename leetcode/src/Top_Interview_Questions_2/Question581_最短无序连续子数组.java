package Top_Interview_Questions_2;

import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/5/3 08:09
 * @Description: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class Question581_最短无序连续子数组 {



    public static int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length < 2)
            return 0;

        int end = -2,start = -1,n = nums.length,max=nums[0],min=nums[n-1];
        //为了nums本来就有序时,返回0

        for (int i = 1 ; i < n ; i++)
        {
            max = Math.max(max,nums[i]);
            if (max > nums[i]) end = i;

            min = Math.min(min,nums[n-1-i]);
            if (min < nums[n-1-i]) start = n-i-1;
        }

        return end - start +1;



//        int[] cp = Arrays.copyOf(nums,nums.length);
//
//        Arrays.sort(cp);
//
//        int left = 0 ,right = nums.length - 1;
//        while (left <= right && nums[left] == cp[left])         //越界检查
//            left ++;
//        while (left <= right && nums[right] == cp[right])
//            right --;
//
//        ans = right - left + 1;
//        return ans;
    }

    public static void main(String[] args){

        findUnsortedSubarray(new int[]{2,1});
    }
}
