package again;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/8/10 18:43
 * @Description:
 *
 * 找出数组中的最长连续子序列的长度
 * [100, 4, 200, 1, 3, 2]
 * output: 4    [1,2,3,4]
 *
 * 使用O(n)的时间复杂度
 */
public class 最长连续子序列 {

    // 因为需要在O(n)内完成，这里使用map作为辅助空间
    // 保存以当前元素为边界点的连续序列长度，插入新元素时，首先判断左右是否已经存在，若存在则更新长度，注意只更新边界两点的长度，中间的没必要更新


    //使用Hashmap，关键点是map 将最长连续序列的长度 保存在序列的边界点。
    //For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
    // 然后去查看 x-1,和x+1 这两个点是否存在,存在就更新连续长度，同时更新该连续序列的两个边界点。
    // 正因为只是保存在边界点，所以不需要遍历序列所有点 去更新当前长度，有效减少了复杂度

    public int betterlongestConsecutive(int[] nums) {

        int ans = 0;
        if (nums == null || nums.length == 0)
            return ans;

        Map<Integer,Integer> map = new HashMap<>();

        int left = 0,right = 0,sum=0;
        for (int x : nums)
        {
            //过滤重复值
            if (map.containsKey(x))
                continue;

            left = map.containsKey(x-1)?map.get(x-1):0;
            right = map.containsKey(x+1)?map.get(x+1):0;

            sum = left + right +1;

            map.put(x,sum);

            ans = Math.max(sum,ans);

            map.put(x-left,sum);
            map.put(x+right,sum);



        }

        return ans;

    }



    public static int longestConsecutive(int... nums) {

        int ans = 0;
        if (nums == null || nums.length == 0)
            return ans;

        Map<Integer,Integer> map = new HashMap<>();

        for (int x : nums)
        {
            if (map.containsKey(x))
                continue;
            if (!map.containsKey(x - 1) && !map.containsKey(x + 1))
                map.put(x,1);

            else if (map.containsKey(x-1) && map.containsKey(x + 1))
            {
                int left = x - map.get(x-1) ;
                int right = x + map.get(x + 1);
                int len = map.get(x-1) + map.get(x + 1) + 1;
                map.put(x,len);
                map.put(left,len);
                map.put(right,len);
            }else if (map.containsKey(x - 1))
            {
                int left = x - map.get(x-1);
                int len = map.get(x-1) + 1;
                map.put(x,  len);
                map.put(left, len);

            }else
            {
                int right = x  + map.get(x + 1);
                int len = map.get(x + 1) + 1;
                map.put(x, len);
                map.put(right,len);

            }


            ans = Math.max(ans,map.get(x));



        }

        return ans;

    }


    public static void main(String[] args){
        
        System.out.println(longestConsecutive(100, 4, 200, 1, 3, 2,5));
    }
}
