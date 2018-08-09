package Top_Interview_Questions_2;

import java.util.*;

public class Question49_同构异性词 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        if (strs == null||strs.length==0)
            return ans;

        Map<String,List<String>> dic = new HashMap<>();
        List<String> list = new ArrayList<>();
        char[] chars;
        String cur;
        StringBuilder sb = new StringBuilder("");
        for (String s : strs)
        {
            chars = s.toCharArray();
            Arrays.sort(chars);
            cur = new String(chars);
            //之所以可以这样直接用map，是因为String重写了hashcode方法，它的hash值是根据内容来的。而不是判断两个对象的地址
            if (dic.containsKey(cur))
                dic.get(cur).add(s);
            else {
                dic.put(cur, new ArrayList<String>(Arrays.asList(cur)));
            }

            sb.delete(0,sb.length());

        }


        for (Map.Entry entry : dic.entrySet())
        {
            list = (List<String>) entry.getValue();
            Collections.sort(list);
            ans.add(list);
        }

        return ans;

    }


    public static void main(String[] args){

        String str = "Hello";
        String str1 = new String("Hello");
        char[] chars = new char[]{'H','e','l','l','o'};
        String str2 = chars.toString();
        System.out.println(str == str2);

        List<List<String>> ans = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        
        System.out.println();
        
    }

}
