package offer;

import java.util.HashMap;
import java.util.Map;

public class 题50_第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0)
            return -1;

        Map<Character,Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char c : chars)
            map.put(c,map.getOrDefault(c,0)+1);

        for (int i = 0 ; i < chars.length ; i ++)
            if (map.get(chars[i]) == 1)
                return i;

        return 0;
    }


}
