package 头条;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/9/6 15:26
 * @Description:
 */
public class 堆 {

    public static ArrayList<Integer> getMaxK(int k,int... nums)
    {
        ArrayList<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));

        for (int x : nums)
            pq.add(x);

        for (int i = 0 ; i < k ; i ++)
            list.add(pq.poll());

        return list;
    }

    public static void main(String[] args){

        ArrayList<Integer> ans = getMaxK(5,1,2,3,66,10,8,-1);

        System.out.println(ans);
    }
}
