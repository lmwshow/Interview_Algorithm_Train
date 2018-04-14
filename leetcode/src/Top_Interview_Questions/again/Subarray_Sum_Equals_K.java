package Top_Interview_Questions.again;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/11/18.
 *
 * 不能滑动窗口，窗口应用于窗口满足某一条件时 移动left直到窗口内不含可行解，但是这道题就算当前窗口有可行解，继续右移right仍可能有多的可行解，后面+-抵消的话
 * 条件不唯一，主要是这里不能先排序。
 *
 * 暴力双重循环解决
 *
 * 更好的idea： 我们知道要想计算 s[i,j] i到j的sum时，可以通过记忆化之前的s[0,i]和s[0,j] 然后通过s[0,j]-s[0,i] = s[i,j]
 * 所以通过一次遍历到j的时候 我们就可以用hashmap 记录所有s[0,j]的值，value为这样的前缀的个数 只要map中存在当前sum-target就说明 存在s[0,i]==sum - target，这里的sum当然也就是s[0,j]
 *
 *
 */
public class Subarray_Sum_Equals_K {

    public static int subarraySum(int[] nums, int k) {

        if (nums == null)
            return 0;

        int count = 0,left = 0,right = 0 ,cur = 0;

        for (int i = 0 ; i < nums.length ;i++)
        {
            for (int j = i ; j <nums.length ; j++)
            {
                cur += nums[j];
                if (cur == k)
                    count++;
            }
            cur = 0;
        }

        return count;
    }


    //preSum . hashmap
    public static int bettersubarraySum(int[] nums, int k) {

        if (nums == null)
            return 0;

        int count = 0,sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);                               //初始化，值为0的前缀 个数为1


        for (int i = 0 ; i < nums.length ;i++)
        {
            sum += nums[i];
            if (map.containsKey(sum-k))
                count += map.get(sum-k);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }


    public static void main(String[] args){

        System.out.println(subarraySum(new int[]{1,1,1},2));

    }
}
