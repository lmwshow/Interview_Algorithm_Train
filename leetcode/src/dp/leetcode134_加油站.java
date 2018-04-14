package dp;

/**
 * Created by Gracecoder on 2017/4/28.
 */
public class leetcode134_加油站 {

    /*
    这样一直循环，最坏情况复杂度为O（n^2）
     */
    public static int mycanCompleteCircuit(int[] gas, int[] cost) {

        int start,next,gasCount,cur,length;
        gasCount = 0;
        length = gas.length;
        int resultindex = -1;

        for (int i = 0 ; i < length ; i ++)
        {
            start = cur = i;                                //起点
            next = (cur+1)%length;                          //下一个点
            gasCount = gas[cur];
            if (gasCount < cost[cur])                       //如果第一个点就不能走到下一个点，直接continue
                continue;

            while (next != start)                           //当下一个点，不等于起点
            {
                gasCount -= cost[cur];

                if (gasCount < 0)
                    break;

                cur = (cur+1)%length;
                next = (cur+1)%length;
                gasCount += gas[cur];
            }

            if (gasCount < cost[cur])                       //当下一个点就是起点是，判断最后一步能不能走到，走不到还是失败！
                continue;


            if (next == start) {
                resultindex = i;
                break;
            }

        }

        return resultindex;
    }



    /*
    I have thought for a long time and got two ideas:

    If car starts at A and can not reach B. Any station between A and B
    can not reach B.(B is the first station that A can not reach.)
    如果我们从A无法到达B，且B是第一个A无法到达的点，那么A-B之间的任何站 都到达不了B
    If the total number of gas is bigger than the total number of cost. There must be a solution.
    如果总的油量，小于总的消费，那么问题就无解
    (Should I prove them?)

    可能会疑问：为什么一个点A能到达B，数组的结尾，它就必然是这个唯一解，除非总油量小于总消费
    因为我们会这么想，A之前的一个点消费巨大，导致A无法绕一圈回来。  但是这已经在总油量和总消费的考虑里面了
    至于为什么是解，如果A能到达B，且C是A,B之间的一个点，也能到达B。 那么A到达B的油量剩余肯定会>=C到达B。 所以C如果能绕一圈到达A,那么A必然也可以。
     */


    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0 ;
        int total = 0 ;
        int result = 0;

        for (int i = 0 ; i < gas.length ; i++)
        {
            sum+= gas[i]-cost[i];
            if (sum < 0 )
            {
                result = i + 1;
                sum = 0;
            }

            total+= gas[i] - cost[i];
        }
        if (total < 0 )
            return -1;
        else
            return result;



    }




    public static void main(String[] args){


        int result = mycanCompleteCircuit(new int[]{1,2},new int[]{2,1});

        System.out.println(result);

    }
}
