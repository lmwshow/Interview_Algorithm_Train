package offer2;

import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 08:22
 * @Description: https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 使用两个堆来保存整个数据流，一个大顶堆(保存顺序序列的前一半数据)，一个小顶堆(保存顺序序列的后一半数据)， 且保证小顶堆中所有值大于大顶堆
 */
public class 数据流中的中位数 {

    PriorityQueue<Integer> maxpq = new PriorityQueue<>((x,y)->(y-x));       //默认小顶堆
    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    boolean isodd = true;               //规定奇数的时候插入大顶堆

    public void Insert(Integer num) {

        if (isodd)
        {
            if (!minpq.isEmpty()&&num>=minpq.peek())
            {
                minpq.add(num);
                maxpq.add(minpq.poll());
            }else
                maxpq.add(num);

        }else
        {
            if (!maxpq.isEmpty()&&num<=maxpq.peek())
            {
                maxpq.add(num);
                minpq.add(maxpq.poll());
            }else
                minpq.add(num);
        }

        isodd = !isodd;

    }

    public Double GetMedian() {

        int cursize = maxpq.size() + minpq.size();

        if (cursize%2==1)
            return Double.valueOf(maxpq.peek());
        else
            return Double.valueOf(maxpq.peek()+minpq.peek()) / 2;


    }
}
