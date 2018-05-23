package offer2.again;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: minGW
 * @Date: 2018/5/18 08:46
 * @Description: https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class 和为S的两个数字 {

    //不使用辅助空间，由于是排序好的序列，就好办了：左右加逼
    public ArrayList<Integer> Better_FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2)
            return res;


        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = array.length - 1;
        int cur = 0;

        while (right > left)
        {
            cur = array[left] + array[right];
            if ((cur == sum )&& (array[left]*array[right] < min))
            {
                res.add(array[left]);
                res.add(array[right]);
                //必然最小
                break;
            }

            else if (cur < sum)
                left++;
            else
                right--;

        }

        return res;

    }

    //使用Map辅助空间
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (array == null || array.length < 2)
            return ans;

        Set<Integer> set = new HashSet<>();
        int product = Integer.MAX_VALUE;
        for (int num : array)
        {
            if (set.contains(sum - num) && (num *(sum - num)) < product)
            {
                ans.clear();
                ans.add(sum-num);
                ans.add(num);
            }

            set.add(num);

        }


        return ans;


    }

    public static void main(String[] args){

        ArrayList<Integer> ans = new ArrayList<>();

        ans = FindNumbersWithSum(new int[]{1,2,3,4,5},10);

        ans.forEach((x)->System.out.println(x));
    }
}
