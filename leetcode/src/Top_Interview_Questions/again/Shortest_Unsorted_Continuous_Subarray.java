package Top_Interview_Questions.again;

import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/11/18.
 *
 * Solution 2:

 * 从左向右扫描数组，一直更新max，找到最后（数组右侧）一个小于max的数，其下标记为end；

 * 从右向左扫描数组，一直更新min，找到最后（数组左侧）一个大于min的数，其下标记为start；

 * 返回end－start＋1.
 *
 * 如果数组已是ascending状态，需返回0. 为了重用 return end－start＋1，在设置end和start的初始值时应注意相对大小。
 */
public class Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length < 2)
            return 0;

        int[] cp = new int[nums.length];
        cp = Arrays.copyOf(nums,nums.length);

        Arrays.sort(cp);

        int left = 0;
        int right = nums.length - 1;

        for (;left <= right ; left++)
            if (cp[left] != nums[left])
                break;

        for (;right >= left ; right--)
            if (cp[right]!= nums[right])
                break;

        return right - left +1;

    }

    public int better_findUnsortedSubarray(int[] nums) {

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

    }
}
