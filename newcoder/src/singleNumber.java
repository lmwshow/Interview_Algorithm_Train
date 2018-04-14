import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/10/2.
 */
public class singleNumber {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1)
                return (int) entry.getKey();
        }

        return 0;
    }



    public int singleNumber2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() != 3)
                return (int) entry.getKey();
        }

        return 0;
    }

    public int[] singleNumber3(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        int index = 0;

        for (int x : nums) {
            if (map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                res[index++] = (int) entry.getKey();
                if (index == 2)
                    return res;
            }

        }

        return res;
    }


    //异或可以用来找不同的数
    // https://segmentfault.com/a/1190000004886431

    public int[] singleNumber_XOR(int[] nums) {


        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for(int num: nums){
            diff^=num;
        }

        // Get its last set bit
        diff = Integer.highestOneBit(diff);
        //diff &= -diff;

        int[] result = new int[2];
        Arrays.fill(result,0);
        for(int num: nums){
            if((diff & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }

}
