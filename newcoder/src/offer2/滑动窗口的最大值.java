package offer2;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/5/24 08:15
 * @Description: https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *这里用的优先队列
 * 如果不用优先队列，滑动窗口的实质是一个双端队列
 * 队首存当前窗口最大元素的下标，后面是可能成为最大值的元素下标
 * 通过小标差距判断队首是否弹出窗口，因为队首后面是下一个可能成为最大值的元素小标
 * 遍历，如果当前值小于队尾元素，加入对尾，反之，不断将队尾小于该元素的下标移出队列，直到队尾元素大于当前元素，将当前元素加入队列
 */
public class 滑动窗口的最大值 {

    //最优解，双端队列，保存数组下标，便于超出size时，移出头元素，双端队列中是一个递减的表示窗口内当前最大值的下标次序
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || size == 0 || size > num.length)
            return ans;

        Deque<Integer> deque = new LinkedList<>();


        for (int i = 0 ; i <num.length; i++)
        {

            if (!deque.isEmpty()&& (i - deque.getFirst()) == size)               //窗口满,需要移出
                deque.removeFirst();

            while (!deque.isEmpty()&&num[i] >= num[deque.getLast()])
                deque.removeLast();

            deque.addLast(i);

            if (i >= size -1 )
                ans.add(num[deque.getFirst()]);
        }

        return ans;
    }


    public static ArrayList<Integer> Pq_maxInWindows(int [] num, int size)
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

    public static void main(String[] args){
        ArrayList<Integer> ans = new ArrayList<>();

        ans = maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);

        ans.forEach(x->System.out.println(x));

    }
}
