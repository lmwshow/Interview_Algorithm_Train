package pingduoduo0801.pingduoduo_4_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        long[] bigs = maxSlidingWindow(nums, k);
        long[] smalls = minSlidingWindow(nums, k);
        for (int i = 0; i < bigs.length; i++) {
            {
                if (i == 0)
                    System.out.print(bigs[i] - smalls[i]);
                else
                    System.out.print(" " + (bigs[i] - smalls[i]));

            }
        }

    }

    public static long[] maxSlidingWindow(long[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new long[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        long[] res = new long[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            deque.offerLast(i);
            if ((i + 1) >= k)
                res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    public static long[] minSlidingWindow(long[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new long[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        long[] res = new long[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i])
                deque.removeLast();
            deque.offerLast(i);
            if ((i + 1) >= k)
                res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
}