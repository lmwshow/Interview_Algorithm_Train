package offer;

import java.util.HashMap;
import java.util.Map;

public class 题48_最长不含重复字符的子字符串 {

    public static int MaxLengthOfSubString(String str)
    {
        if (str == null || str.length() == 0)
            return 0;

        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        char tmp ;

        while (right < str.length())
        {
            tmp = chars[right];
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
            if (map.get(tmp) > 1)
                count++;
            
            while (count > 0)
            {
                map.put(chars[left],map.get(chars[left])-1);
                if (map.get(chars[left]) == 1)
                    count--;
                left++;
            }

            right++;

            max = Math.max(right - left,max);

        }
        
        return max;
    }
    
    
    public static void main(String[] args){
        
        System.out.println(MaxLengthOfSubString("tmmzuxt"));
        
    
    }
}
