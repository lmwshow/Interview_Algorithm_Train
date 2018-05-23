package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/5/17 07:59
 * @Description: https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class 第一个只出现一次的字符 {

    public static int FirstNotRepeatingChar(String str) {

        int ans = str.length();
        if (str == null || str.length() == 0)
            return -1;

        Map<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for (char c : chars)
            map.put(c,map.getOrDefault(c,0)+1);

        for (Map.Entry entry : map.entrySet())
        {
            if ((int)entry.getValue() == 1 && str.indexOf((Character)entry.getKey())<ans)
                ans = str.indexOf((Character)entry.getKey());
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(FirstNotRepeatingChar("google"));
    }


}
