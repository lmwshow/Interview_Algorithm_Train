package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/14 18:12
 * @Description https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 数组中出现次数超过一半的数字 {

    //因为有一个数的次数超过一半，通过记录cur当前数，和time 次数，遍历整个数组，最后留下的肯定是超过半数的那个数
    public int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length == 0)
            return 0;

        int cur = array[0];
        int time = 1;

        for (int i = 1; i < array.length ; i++)
        {
            if (array[i] == cur)
                time++;
            else
            {
                time -- ;
                if (time < 0)
                {
                    cur = array[i];
                    time = 1;
                }
            }
        }

        time = 0;
        for (int i = 0 ;  i < array.length ; i++)
            if (cur == array[i])
                time++;

        return time>(array.length >> 1)?cur:0;

    }
}
