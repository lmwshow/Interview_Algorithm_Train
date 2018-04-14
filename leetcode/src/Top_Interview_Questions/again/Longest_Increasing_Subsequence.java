package Top_Interview_Questions.again;

/**
 * Created by Gracecoder on 2017/11/1.
 *
 * dp: 0(n^2)
 * dp + 二分 : O(nlogn)   用tails[i]数组表示 表示长度为i的所有递增序列中尾部最小的数值，这样显然tails数组时一个有序的数组，可以用来二分
 *
 * http://blog.csdn.net/yeqiuzs/article/details/51472702
 */
public class Longest_Increasing_Subsequence {


    //O(n^2) dp
    public static int lengthOfLIS(int[] nums) {

        int max = 0;
        if (nums == null || nums.length == 0)
            return max;

        int[] lenth = new int[nums.length];
        int i = 0,j = 0;

        for (i = 0 ; i < nums.length ; i++)
        {
            for (j = i; j>=0;j--) {
                if (nums[i] > nums[j])
                {
                    if (lenth[j]+1 > lenth[i])
                        lenth[i] = lenth[j]+1;
                }
            }

            if (lenth[i] == 0)
                lenth[i] = 1;

            max = max > lenth[i]? max : lenth[i];

        }


        return max;
    }


    //dp + 二分
    public static int better_lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int[] tails = new int[nums.length + 1];
        int end = 1;
        tails[end] = nums[0];                       //初始化,最初长度为1的所有递增序列的最小尾部为nums[0]

        for (int i = 1 ; i < nums.length ; i++)
        {
            if (nums[i] > tails[end])               //当nums[i]大于，当前最长递增子序列尾部最小值时， 更新最长长度 end++,并赋值tails[end]
            {
                end++;
                tails[end] = nums[i];
            }else                                   // 否则更新tails数组
            {
                int index = binarySearch(tails,nums[i],end);
                tails[index] = nums[i];
            }
        }

        return end;

    }

    /**
     * 二分查找大于t的最小值，并返回其位置
     */

    private static int binarySearch(int[] tails, int target, int end) {

        int left = 0,right = end;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (tails[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }


    public static void main(String[] args){

        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(better_lengthOfLIS(nums));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //todo
            }
        });

        thread.start();


    }
}
