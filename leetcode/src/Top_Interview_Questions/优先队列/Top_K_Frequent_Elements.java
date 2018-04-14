package Top_Interview_Questions.优先队列;

import java.util.*;

/**
 * Created by Gracecoder on 2017/11/8.
 */
public class Top_K_Frequent_Elements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if (k == 0)
            return res;

        Map<Integer,Integer> map = new HashMap<>();

        for (int x : nums)
        {
            if (map.containsKey(x))
                map.put(x,map.get(x)+1);
            else
                map.put(x,1);
        }

        Queue<Map.Entry> pq = new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {

                return (Integer) o2.getValue() - (Integer) o1.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        for (int i = 0 ; i < k ;i++)
            res.add((Integer) pq.poll().getKey());

        return res;

    }
}
