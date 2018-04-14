package Top_Interview_Questions_2;

import java.util.HashMap;
import java.util.Map;

public class Question76_Minimum_Window_Substring {

    public static String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        int count = map.size();

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while (right < s.length()) {
            char cur = s.charAt(right++);
            map.put(cur, map.getOrDefault(cur, 0) - 1);
            if (map.get(cur) == 0)
                count--;

            while (count == 0) {
                if (min > (right - left + 1)) {
                    ans[0] = left;
                    ans[1] = right;
                    min = right - left + 1;
                }

                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0)
                    count++;
                left++;
            }
        }
        
        
        return s.substring(ans[0],ans[1]);

    }
    
    
    public static void main(String[] args){
        
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        
    }

}
