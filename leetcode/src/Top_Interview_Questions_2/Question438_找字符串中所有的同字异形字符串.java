package Top_Interview_Questions_2;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/4/27 08:38
 * @Description: 使用全排列超时
 *
 * 可以使用滑动窗口来求解同字异形问题
 */
public class Question438_找字符串中所有的同字异形字符串 {


    public List<Integer> concise_findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length())
            return res;

        int left = 0,right = 0,count = p.length();

        int[] map = new int[256];

        for (char c : p.toCharArray())
            map[c]++;

        //当右边界超过s.length 跳出循环
        while (right < s.length())
        {
            //先移动右边界，当窗口大小到达极限了，再改变左边界
            if(map[s.charAt(right++)]-- >= 1) count--;

            if (count == 0) res.add(left);

            //此时map[left]肯定是之前已经 -过的， 如果他大于等于0 说明是p字符串中需要的  count++， 如果是p中不需要的，那在加入前--后，这里必然会小于0
            if (right - left == p.length() && map[s.charAt(left++)]++>=0) count ++;

        }

        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return ans;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0 ; i < p.length(); i++)
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);

        int count = map.size();         //key的数量

        int left = 0,right = 0;
        char cur = ' ';
        while (right < s.length())
        {
            while (right - left< p.length())
            {
                cur = s.charAt(right ++);
                if (map.containsKey(cur))
                {
                    map.put(cur,map.get(cur) - 1);
                    if (map.get(cur) == 0)
                        count--;
                }

            }

            if (count == 0)
                ans.add(left);


            cur = s.charAt(left ++);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
                if (map.get(cur) == 1)
                    count++;
            }

        }


        return ans;

    }


    public static void main(String[] args){

        List<Integer> ans = findAnagrams("abab"
                ,"ab");
    }

}
