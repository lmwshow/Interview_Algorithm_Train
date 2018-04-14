import java.util.HashMap;

/**
 * Created by Gracecoder on 2017/9/14.
 */
public class llongest_substring_without_repeating_characters {

    public int lengthOfLongestSubstring(String s) {

        int max = 0,tmp = 0,left = 0 ,right = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while (right < s.length())
        {
            char c = s.charAt(right);
            if (map.containsKey(c))
            {
                max = Math.max(right-left,max);
                left = Math.max(map.get(c)+1,left);         //left不能回退 例如"abba" 需要取Max的原因是,重复位置k可能比当前起点小,然而此时取k+1为起点的话,长度肯定会比当前max要小
                map.put(c,right);

            }else
            {
                map.put(c,right);
            }
            right++;


        }

        return Math.max(right-left,max);

    }
}
