package Top_Interview_Questions_2;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/4/25 09:07
 * @Description:
 */
public class Question347_前K个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return ans;

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        //Lambda表达式
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> (e2.getValue() - e1.getValue()));

//        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue()-o1.getValue();
//            }
//        });

        for (Map.Entry entry : map.entrySet())
            pq.offer(entry);

        for (int i = 0; i < k; i++)
            ans.add(pq.poll().getKey());

        return ans;

    }
}
