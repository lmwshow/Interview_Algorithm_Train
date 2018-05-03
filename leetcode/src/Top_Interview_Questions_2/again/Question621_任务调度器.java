package Top_Interview_Questions_2.again;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/5/3 08:58
 * @Description: https://leetcode-cn.com/problems/task-scheduler/description/
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

 * 你需要计算完成所有任务所需要的最短时间。
 */
public class Question621_任务调度器 {

    //一个周期一个周期来,通过优先队列维护任务，从队列中获取消费后，重新加入队列

    public static int leastInterval(char[] tasks, int n) {
        if (n < 1)
            return tasks.length;
        Map<Character,Integer> map = new HashMap<>();
        for (char c : tasks)
            map.put(c,map.getOrDefault(c,0)+1);


        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry<Character,Integer> entry : map.entrySet())
            pq.offer(entry.getValue());

        int cycle = n + 1;
        int alltime = 0;

        while (!pq.isEmpty())
        {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0 ; i < cycle ; i++)
            {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll() - 1);
                    worktime++;
                }
            }

            for (int cnt : tmp)
                if (cnt > 0)
                    pq.offer(cnt);

            alltime += !pq.isEmpty()? cycle : worktime;

        }

        return alltime;
    }


    public static int minGW_leastInterval(char[] tasks, int n) {

        Map<Character,Integer> map = new HashMap<>();

        for (char c : tasks)
            map.put(c,map.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Map.Entry<Character,Integer>> tmp = new ArrayList<>();

        for(Map.Entry entry: map.entrySet())
            pq.offer(entry);

        Map.Entry<Character,Integer> entry = null;

        int cycle = 0;
        int rest = 0;
        while (!pq.isEmpty())
        {
            for (int i = 0 ; i <= n ;i++)
            {
                if (pq.isEmpty()) {
                    rest = n + 1 - i;
                    break;
                }
                entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                tmp.add(entry);
            }

            for (int i = 0 ; i < tmp.size() ; i++)
            {
                if (tmp.get(i).getValue() == 0)
                    continue;
                pq.offer(tmp.get(i));
            }

            tmp.clear();
            cycle++;
        }


        return (cycle-1)*(n+1)+(n+1-rest);

    }
    
    
    public static void main(String[] args){
        
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}
