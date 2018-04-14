package Top_Interview_Questions_2;

public class Question287_寻找重复数 {


    //数组包含1+n个数，这些整数在范围[1,n]之间，且只有一个数是重复的
    //数组不可变，常量级空间复杂度，时间复杂度小于O(n^2)
    //从整数的大小在index范围内，可以很容易将数组联想成链表，那么就转化成求链表的环的初始点（做过）
    //使用快慢指针,先找到像相遇点，然后相遇点和头结点一起往前直到相遇，那就是环起点
    public int findDuplicate(int[] nums) {

        if (nums.length > 0)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow!= fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;

            while (slow!=fast)
            {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;

        }

        return -1;


    }

}
