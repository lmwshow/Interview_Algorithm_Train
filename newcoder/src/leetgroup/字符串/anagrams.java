package leetgroup.字符串;

import java.util.*;

/**
 * Created by Gracecoder on 2017/9/11.
 *
 * anagrams 同字母异形词分组
 * 采用hashmap key为 str 排序后的唯一值
 *
 * 对于String的排序，先转化成CharArray 在通过数组排序，然后转化回字符串
 */
public class anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        if (strs == null)
            return res;

        HashMap<String,List<String>> map = new HashMap<>();

        for (String cur : strs)
            solver(map,cur);

        for (Map.Entry<String,List<String>> entry : map.entrySet())
        {
            Collections.sort(entry.getValue());
            res.add(entry.getValue());
        }

        return res;

    }

    private void solver(HashMap<String, List<String>> map, String cur) {

        char[] curArray = cur.toCharArray();

        Arrays.sort(curArray);

        String key = new String(curArray);

        if (map.containsKey(key))
            map.get(key).add(cur);
        else
            map.put(key,new ArrayList<String>(Arrays.asList(cur)));

    }


    public static boolean isAnagram(String s, String t) {

        if (s == null || t == null)
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        s = new String(sArray);
        t = new String(tArray);


        return s.equals(t);
    }


    //判断是否是 同字符串，可以通过hash表记录每个字符出现的次数，如果hash表相等的话，就是同字异形体
    //这里采用滑动窗口的思想：
    //利用两个hash表一个表示p的字符  一个用记录s
    //一开始将s字符串的前p.length()个记录 比较一下。
    //然后去掉最前面，加入后一个。 再比较， 这样减小了时间复杂度

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length())
            return res;

        HashMap<Character,Integer> map =new HashMap<>();
        for (char c : p.toCharArray())
        {
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        HashMap<Character,Integer> tmpHash = new HashMap<>();

        int len = p.length();

        for (int i = 0 ; i < len ; i ++)
        {
            char c = s.charAt(i);
            if (tmpHash.containsKey(c))
                tmpHash.put(c,tmpHash.get(c)+1);
            else
                tmpHash.put(c,1);
        }

        if (map.equals(tmpHash))
            res.add(0);


        //向右移动，去掉开头，加入后一个
        for (int i = len ;i < s.length() ; i++)
        {
            int count = tmpHash.get(s.charAt(i-len));
            if (count == 1)
                tmpHash.remove(s.charAt(i-len));
            else
                tmpHash.put(s.charAt(i-len),count-1);

            tmpHash.put(s.charAt(i),tmpHash.get(s.charAt(i))==null?1:tmpHash.get(s.charAt(i))+1);


            if (map.equals(tmpHash))
                res.add(i - len + 1);

        }

        return res;

    }


    public static List<Integer> slidwindowfindAnagrams(String s, String p) {

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

    public static void main(String[] args){


        String a = "cbaebabacd";
        String b = "abc";

        List<Integer> res = slidwindowfindAnagrams(a,b);



        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        map1.put('a',1);
        map2.put('a',1);


        if (map1.equals(map2))
            System.out.println("yoxi");








    }
}
