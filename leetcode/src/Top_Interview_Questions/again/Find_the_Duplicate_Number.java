package Top_Interview_Questions.again;

/**
 * Created by Gracecoder on 2017/10/30.
 *
 * 由于这里 元素的大小在 1~n之间  数组长度为n+1
 * 所以可以想象成有环的链表，通过找第一个环起点    Linked List Cycle II  的思想
 */
public class Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0 ; i < nums.length ; i++)
            for (int j = i +1 ; j < nums.length ; j++)
                if (nums[i] == nums[j])
                    return nums[i];

        return 0;

    }

    public int better_findDuplicate(int[] nums) {


        if (nums.length > 0)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            //相交点到环起点的距离等于 起点到环起点的距离
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }

        return -1;

    }
    
    
    public static void main(String[] args){

    
    }
}
