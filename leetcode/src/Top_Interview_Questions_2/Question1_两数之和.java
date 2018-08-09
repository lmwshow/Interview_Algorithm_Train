package Top_Interview_Questions_2;

import java.util.HashMap;
import java.util.Map;

public class Question1_两数之和 {

    public static int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length < 2)
            return null;

        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }

            map.put(nums[i],i);
        }

        return res;

    }

    public static void main(String[] args){

        int[] res = twoSum(new int[]{2, 7, 11, 15},10);

        for (int x : res)
            System.out.println(x);


    }
}
