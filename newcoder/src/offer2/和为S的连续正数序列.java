package offer2;

import java.util.ArrayList;

/**
 * @Auther: minGW
 * @Date: 2018/5/18 08:32
 * @Description: https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class 和为S的连续正数序列 {

    //滑窗
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int left = 1;
        int right = 1;
        ArrayList<Integer> tmp = new ArrayList<>();
        int curSum = 0;

        while (right < sum)
        {
            while (curSum < sum)
            {
                curSum += right;
                tmp.add(right++);
            }

            if (curSum == sum)
                ans.add(new ArrayList<>(tmp));

            if (curSum >= sum)
            {
                curSum -= left;
                tmp.remove(0);
                left++;
            }

        }


        return ans;

    }

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ans = FindContinuousSequence(3);

        System.out.println(ans.size());
        ans.forEach((list)->
        {
            list.forEach((x)->System.out.println(x));
        });
    }

}
