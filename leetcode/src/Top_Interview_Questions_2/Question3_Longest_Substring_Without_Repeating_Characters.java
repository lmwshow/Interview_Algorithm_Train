package Top_Interview_Questions_2;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.HashMap;
import java.util.Map;

public class Question3_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null)
            return 0;

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;

        while (right < chars.length) {

            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            if (map.get(chars[right]) > 1)
                count++;

            while (count > 0) {
                map.put(chars[left], map.get(chars[left]) - 1);
                if (map.get(chars[left]) == 1)
                    count--;
                left++;

                max = Math.max(max, right - left + 1);
            }


            right++;

        }

        return max;
    }
    
    public static void main(String[] args){
        
    
    }
}
