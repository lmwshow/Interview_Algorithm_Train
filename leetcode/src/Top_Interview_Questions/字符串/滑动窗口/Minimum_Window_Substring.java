package Top_Interview_Questions.字符串.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/10/10.
 */
public class Minimum_Window_Substring {

    public static String minWindow(String s, String t) {

        Map<Character,Integer> map = new HashMap<>();

        for (char c : t.toCharArray())
        {
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        int count = map.size();                                 //这里用map的大小来表示count
        int letf = 0;
        int right = 0;
        String res = "";
        int min = Integer.MAX_VALUE;

        while (right < s.length())
        {
            char c = s.charAt(right);

            if (map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0)                            //map的value == 0时 count --
                    count--;
            }
            right ++;
            
            while (count == 0)
            {

                char begin = s.charAt(letf);
                if (right - letf < min) {
                    min = right -letf;
                    res = s.substring(letf, right);
                }
                
                if (map.containsKey(begin))
                {
                    map.put(begin,map.get(begin)+1);            //map的value会一直减 可能小于0， 当加回去的时候  当大于0时count++ 跳出循环
                    if (map.get(begin) > 0)
                        count++;
                }
                
                letf++;
                
            }
        }
        
        
        return res;

    }
    
    public static void main(String[] args){
        
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        
    
    }
}
