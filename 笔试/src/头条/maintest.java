package 头条;

import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/8/13 20:38
 * @Description:
 */
public class maintest {

    public static void main(String[] args){

        PriorityQueue<Integer> pq = new PriorityQueue<>(3);

        pq.add(2);
        pq.add(1);
        pq.add(3);

        pq.add(0);

        while (!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }

    }
}
