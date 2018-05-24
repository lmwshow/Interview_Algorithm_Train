package offer.again;

import java.util.*;


//这里用的优先队列
//如果不用优先队列，滑动窗口的实质是一个双端队列
//队首存当前窗口最大元素的下标，后面是可能成为最大值的元素下标
//通过小标差距判断队首是否弹出窗口，因为队首后面是下一个可能成为最大值的元素小标
//遍历，如果当前值小于队尾元素，加入对尾，反之，不断将队尾小于该元素的下标移出队列，直到队尾元素大于当前元素，将当前元素加入队列
public class 题59_滑动窗口的最大值 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size ==0)
            return res;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int left = 0;
        int right = 0;
        while (right < num.length)
        {
            while (right - left < size)
                pq.offer(num[right++]);

            res.add(pq.peek());
            pq.remove(num[left]);
            left ++;

        }


        return res;
    }


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

        ArrayList<Integer> res = new ArrayList<>();

        res = maxInWindows(new int[]{1,2,3,1},0);
        
        for (int x : res)
            System.out.println(x);
            

    }
}
