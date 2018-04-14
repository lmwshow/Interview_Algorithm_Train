package Top_Interview_Questions_2.滑动窗口类似求最值系列;

import java.util.Deque;
import java.util.LinkedList;

public class Question239_滑动窗口最大值 {


    //非线性方法：可以使用两个优先队列（最大堆，最小堆）来维护窗口
    //线性方法：使用双端队列，队首为当前窗口最大值，之后是一个递减队列，表示窗口中第二大，第三大的元素。
    //双端队列中存储元素下标，以方便判断当前队首是否需要滑出
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;

        int[] ans = new int[n - k +1];

        Deque<Integer> deque = new LinkedList<>();

        int right = 0;


        while (right < n)
        {
            while (!deque.isEmpty() && (right - deque.peekFirst())>=k)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right])
                deque.pollLast();

            deque.offerLast(right);

            if (right >= k - 1)
                ans[right - k +1] = nums[deque.peekFirst()];
            right++;
        }


        return ans;
    }


    public static void main(String[] args){

        int[] ans = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);

        for (int x:ans)
            System.out.println(x);

    }
}
