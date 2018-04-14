package Top_Interview_Questions_2;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question128_最长连续序列 {

    static int ans;


    //使用Hashmap，关键点是map 将最长连续序列的长度 保存在序列的边界点。
    //For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
    // 然后去查看 x-1,和x+1 这两个点是否存在,存在就更新连续长度，同时更新该连续序列的两个边界点。
    // 正因为只是保存在边界点，所以不需要遍历序列所有点 去更新当前长度，有效减少了复杂度
    public int longestConsecutive(int[] nums) {

        ans = 0;
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

    public int BaolilongestConsecutive(int[] nums) {

        ans = 0;

        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);

        int tmp = 1;

        for (int i = 1; i < nums.length; i++) {
            //过滤重复点
            if (nums[i] == nums[i - 1])
                continue;

            if (nums[i] - nums[i - 1] == 1)
                tmp++;
            else {
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
        }

        return Math.max(ans, tmp);
    }
}
