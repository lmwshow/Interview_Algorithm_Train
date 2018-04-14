package Top_Interview_Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/10/13.
 */
public class Majority_Element {

    public int majorityElement(int[] nums) {

        int len = nums.length;

        int condition = len/2;

        Map<Integer,Integer> map = new HashMap<>();

        for (int x : nums)
        {
            if (map.containsKey(x))
            {
                map.put(x,map.get(x)+1);
            }else
                map.put(x,1);

            if (map.get(x) > condition)
                return x;
        }

        return 0;
    }
}


