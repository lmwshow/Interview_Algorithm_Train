package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


//这里有的优先队列
//如果不用优先队列，滑动窗口的实质是一个双端队列
//队首存当前窗口最大元素的下标，后面是可能成为最大值的元素下标
//通过小标差距判断队首是否弹出窗口
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

    public static void main(String[] args){

        ArrayList<Integer> res = new ArrayList<>();

        res = maxInWindows(new int[]{1,2,3,1},0);
        
        for (int x : res)
            System.out.println(x);
            

    }
}
