package offer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/10 08:01
 * @Description: https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 */
public class 调整数组顺序使奇数位于偶数前面 {

    //使用辅助空间
    public void reOrderArray(int[] array) {

        if (array == null || array.length == 0)
            return;

        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();

        for (int num : array)
            if ((num & 1) == 0)
                evenQueue.add(num);
            else
                oddQueue.add(num);

        int index = 0;
        while (!oddQueue.isEmpty())
            array[index++] = oddQueue.poll();
        while (!evenQueue.isEmpty())
            array[index++] = evenQueue.poll();

        return;
    }
}
