package again;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/8/29 20:37
 * @Description:
 */
public class 任务调度器 {

    //一个周期一个周期来,通过优先队列维护任务，从队列中获取消费后，重新加入队列

    public int leastInterval(char[] tasks, int n) {

        if (tasks == null)
            return 0;
        if (n < 1)
            return tasks.length;

        Map<Character,Integer> map = new HashMap<>();

        for (char c : tasks)
            map.put(c,map.getOrDefault(c,0)+1);

        Queue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));

        for (Map.Entry<Character,Integer> entry : map.entrySet())
            pq.offer(entry.getValue());


        int cycle = n + 1;  //间隔为n,则一个周期为n+1个任务
        int alltime = 0;

        while (!pq.isEmpty())
        {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0 ; i < cycle ; i++)
            {
                if (!pq.isEmpty())
                {
                    tmp.add(pq.poll() - 1);
                    worktime ++;
                }
            }

            for (int cnt : tmp)
                if (cnt > 0)
                    pq.offer(cnt);

            alltime += !pq.isEmpty()? cycle : worktime;

        }

        return alltime;
    }
}
