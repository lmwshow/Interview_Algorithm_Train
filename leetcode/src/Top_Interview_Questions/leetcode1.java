package Top_Interview_Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by limingwei on 16/12/3.
 */
public class leetcode1 {

    //时间复杂度O(n^2)
    public static int[] twoSum(int[] nums , int target)
    {
        int result[] = new int[2];
        int remain , index_x, index_y ;

        for (int i = 0 ; i < nums.length ; i++)
        {
            index_x = i;
            remain = target - nums[i];
            for (int j = i+1 ; j < nums.length ; j ++)
                if (nums[j] == remain)
                {
                    index_y = j;
                    result[0] = index_x;
                    result[1] = index_y;

                    return result;
                }
        }

        return result;
    }

    //使用hash_table 时间复杂度O(n)
    public static int[] hashSolutin_n(int[] nums , int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; i ++)
        {
            Integer index = map.get(target - nums[i]);
            if (index == null)
            {
                map.put(nums[i],i);
            }
            else
                return i>index?new int[]{index,i}:new int[]{i,index};
        }
        return new int[]{0,0};
    }


    public static void main(String[] args){

        int nums[] = {1,2,2};
        int result[] = new int[2];
        result = hashSolutin_n(nums,6);
        System.out.println(result[0]+"" +result[1]);


    }

}
