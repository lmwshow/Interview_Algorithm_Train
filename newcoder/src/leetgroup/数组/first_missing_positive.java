package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/18.
 *
 * 这道题目说使用O(n)的时间复杂度以及常数级的空间。
 * 那么自然不能排序，也不能申请额外非常数级的空间， 那就只能在原数组上操作了
 *
 * 一开始的想法时，遍历的时候，将Num[i]放在其正确的位置上，放完之后再去遍历一次，查到第一个不对应的下标，即是答案。
 * 但是思路有问题：
 *
 * 1.每次遍历就把 nums[i] 和 nums[num[i]] 互换， 非正数 和 超过数组长度的 不处理。
 *   然而这样子，后面的数被换到前面之后，就不会再被遍历到，造成缺漏的情况，卡住了。
 *
 *
 * 2.每次遍历的时候，把nums[i]放在nums[nums[i]]的位置，将nums[nums[i]]先取出到tmp，然后直接对tmp进行重复操作放在正确的位置。
 */
public class first_missing_positive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int swap = 0;

        //之所以对于元素i的正确位置为 index = i-1. 是因为如果一个数组都是正数，那最长只能到i-1.
        for (int i = 0 ; i < len ; i++)
        {
            //如果当前nums[i]和其正确位置下的元素相等，那么也略过 不然会陷入死循环。
            //如果使用nums[i] != i-1
            while (nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i]-1])
            {
                swap = nums[nums[i]-1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = swap;

            }
        }

        for (int i = 0 ; i < len ; i++)
            if (nums[i]!=i+1)
                return i+1;

        return len+1;

    }
}
