package offer2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/5/14 18:21
 * @Description https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (input == null || k > input.length)
            return ans;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(x-y));

        for (int num:input)
            pq.add(num);

        for (int i = 0 ; i < k ; i++)
            ans.add(pq.poll());

        return ans;

    }
}
