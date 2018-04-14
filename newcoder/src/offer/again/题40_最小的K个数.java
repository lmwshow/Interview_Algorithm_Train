package offer.again;

import java.util.*;

//同样的使用Patation 会修改数组，同时不适用于海量数据的处理

//当在某个数据容器中频繁查找和替换最大值时，可以考虑使用堆和红黑树这些特殊的二叉树结构爱
public class 题40_最小的K个数 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k)
            return res;

        if(input.length == k)
        {
            Arrays.sort(input);
            for(int x: input)
                res.add(x);
            return res;
        }

        int left = 0;
        int right = input.length - 1;
        int index = Patition(input,left,right);

        while (index != k )
        {
            if (index < k)
                index = Patition(input,index+1,right);
            else
                index = Patition(input,left,index-1);
        }

        for (int i = 0 ; i < k ; i++)
            res.add(input[i]);
        Collections.sort(res);
        return res;
    }

    private static int Patition(int[] input, int left, int right) {


        int key = input[left];

        while (left < right)
        {
            while (left < right && input[right] >= key)
                right -- ;
            input[left] = input[right];
            while (left < right && input[left] <= key)
                left ++;
            input[right] = input[left];
        }

        input[left] = key;
        return left;

    }



    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k || k==0)
            return res;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0 ; i < k ; i++)
            pq.offer(input[i]);

        for (int i = k ; i < input.length ; i++)
        {
            if (input[i] >= pq.peek())
                continue;
            else
            {
                pq.poll();
                pq.offer(input[i]);
            }
        }

        while (!pq.isEmpty())
            res.add(0,pq.poll());


        return res;
    }

    public static void main(String[] args){


        ArrayList<Integer> res = new ArrayList<>();

        res = GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8},0);

        for (int x : res)
            System.out.println(x);

    }
}
