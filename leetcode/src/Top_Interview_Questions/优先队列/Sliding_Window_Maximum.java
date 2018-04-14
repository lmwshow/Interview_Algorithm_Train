package Top_Interview_Questions.优先队列;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/10/24.
 *
 * 这里是用优先队列，复杂度仍不是线性
 *
 * 一定要达到线性，可以使用双向队列，Deque
 */
public class Sliding_Window_Maximum {


    public static int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0;
        int right = k-1;
        int[] res = new int[nums.length - k +1];
        if(k == 0)
            return new int[0];
        Queue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = left ; i <= right ; i++)
            pq.offer(nums[i]);

        while (right < nums.length)
        {
            res[left] = pq.peek();
            pq.remove(nums[left]);
            left++;
            right ++;
            if (right < nums.length)
                pq.offer(nums[right]);

        }

        return res;

    }


    public static void main(String[] args){

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);

        for (int x: res)
            System.out.println(x);


    }




    /*
    双向队列
    复杂度
    时间 O(N) 空间 O(K)

    思路
    我们用双向队列可以在O(N)时间内解决这题。
    当我们遇到新的数时，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾扔掉，直到该队列的末尾比新数大或者队列为空的时候才住手。
    这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，所以他们其实就是窗口内第一大，第二大，第三大...的数。
    保持队列里只有窗口内数的方法和上个解法一样，也是每来一个新的把窗口最左边的扔掉，然后把新的加进去。
    然而由于我们在加新数的时候，已经把很多没用的数给扔了，这样队列头部的数并不一定是窗口最左边的数。
    这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以直到这个数的值，也可以知道该数是不是窗口最左边的数。
    这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，
    一次是加入队列的时候，一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。
    */


    public int[] DeQuemaxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
}
