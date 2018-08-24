package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/23 09:37
 * @Description:
 */
public class 寻找重复数 {


    /*
    数组包含1+n个数，这些整数在范围[1,n]之间，且只有一个数是重复的
    数组不可变，常量级空间复杂度，时间复杂度小于O(n^2)

    正因为要求数组不可变，从整数的大小在index范围内，可以很容易将数组联想成链表，那么就转化成求链表的环的初始点
    使用快慢指针,先找到像相遇点，然后相遇点和头结点一起往前直到相遇，那就是环起点
    */


    public static int findDuplicate(int... nums) {

        if (nums == null || nums.length < 2)
            return -1;

        int slow = nums[0];
        int fast = nums[0];
        boolean begin = true;

        while (slow != fast || begin)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            begin = false;
        }

        slow = nums[0];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public static void main(String[] args){

        System.out.println(findDuplicate(1,3,4,2,2));
    }
}
