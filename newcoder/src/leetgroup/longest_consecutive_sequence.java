package leetgroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/8/7.
 * <p>
 * 插入key的时候，因为只考虑 key—1 和 key+1 ，所以只关注左右边界值即可。 当插入的N连接起前后两段时,需要把前后两段的边界值改成新的 length
 *
 * We will use HashMap.
 * The key thing is to keep track of the sequence length and store that in the boundary points of the sequence.
 * For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
 *
 * Whenever a new element n is inserted into the map, do two things:
 *
 * 1.See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
 *   Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later.
 *   Store (left + right + 1) as the associated value to key n into the map.
 *
 * 2.Use left and right to locate the other end of the sequences to the left and right of n respectively,
 *   and replace the value with the new length.
 */
public class longest_consecutive_sequence {


    public int longestConsecutive(int[] nums) {

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int key : nums) {
            if (!map.containsKey(key)) {
                int left = map.containsKey(key - 1) ? map.get(key - 1) : 0;
                int right = map.containsKey(key + 1) ? map.get(key + 1) : 0;

                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(key, sum);

                // keep track of the max length
                max = Math.max(max, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(key - left, sum);
                map.put(key + right, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);


    }
}
