package Top_Interview_Questions_2;

import java.util.*;

public class Question49_Group_Anagrams {

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


        List<List<String>> ans = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        
        System.out.println();
        
    }

}
