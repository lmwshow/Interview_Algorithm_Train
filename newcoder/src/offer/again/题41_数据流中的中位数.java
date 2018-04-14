package offer.again;

//可以看看书上对各个方法的比较

import java.util.Comparator;
import java.util.PriorityQueue;

public class 题41_数据流中的中位数 {

    //使用一个最大推表示 左边一半数，  一个最小堆表示右边一半数
    //使得左半边的所有数小于右半边

    private static PriorityQueue<Integer> leftpq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private static PriorityQueue<Integer> rightpq = new PriorityQueue<>();

    private static int length = 0;

    public static void Insert(Integer num) {

        length ++;
        if ((length & 1) == 0)
        {
            //偶数放右边,如果当前值比左半边的最大值小的话， 就将左边的最大值防止右边堆，当前值放到左边。满足右边堆始终都大于左边
            if (!leftpq.isEmpty() && leftpq.peek() > num) {
                rightpq.offer(leftpq.poll());
                leftpq.offer(num);
            }
            else
                rightpq.offer(num);
        }else
        {
            if (!rightpq.isEmpty() && rightpq.peek() < num)
            {
                leftpq.offer(rightpq.poll());
                rightpq.offer(num);
            }
            else
                leftpq.offer(num);
        }
    }

    public static Double GetMedian() {
        if ((length & 1) == 0)
            return Double.valueOf(leftpq.peek()+rightpq.peek()) / 2;
        else
            return Double.valueOf(leftpq.peek());
    }


    public static void main(String[] args){

        Insert(2);
        Insert(1);

        System.out.println(GetMedian());


    }
}
