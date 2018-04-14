package dp;

import java.util.*;

/**
 * Created by Gracecoder on 2017/4/18.
 */
public class leetcode17电话号组合 {

    public static List<String> myletterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        Map<Character,List<String>> map = new HashMap<>();
        map.put('2',new ArrayList<>(Arrays.asList("a","b","c")));
        map.put('3',new ArrayList<>(Arrays.asList("d","e","f")));
        map.put('4',new ArrayList<>(Arrays.asList("g","h","i")));
        map.put('5',new ArrayList<>(Arrays.asList("j","k","l")));
        map.put('6',new ArrayList<>(Arrays.asList("m","n","o")));
        map.put('7',new ArrayList<>(Arrays.asList("p","q","r","s")));
        map.put('8',new ArrayList<>(Arrays.asList("t","u","v")));
        map.put('9',new ArrayList<>(Arrays.asList("w","x","y","z")));

        List<String> tmp = map.get(digits.charAt(0));
        result.addAll(tmp);



        for (int i = 1 ; i < digits.length();i ++)
        {
            char ch = digits.charAt(i);
            tmp = map.get(ch);
            Iterator tmpIterator = tmp.iterator();
            while (tmpIterator.hasNext())
            {
                String str= (String) tmpIterator.next();

                for (int j = 0 ; j < result.size(); j++)
                {
                    String curr = result.get(j);
                    if (curr.length() == i) {
                        curr += str;
                        result.add(curr);
                    }
                }
            }
        }

        Iterator iterator = result.iterator();
        while (iterator.hasNext())
        {
            String str = (String) iterator.next();
            if (str.length() != digits.length())
                iterator.remove();
        }

        return result;
    }



    /*
     solution with FIFO queue
     */
    public static List<String> letterCombinations(String digits) {

        LinkedList<String> ans = new LinkedList<String>();
        if (digits.length() == 0 ) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }

        return ans;
    }


    public static void main(String[] args){

        List<String> result = new ArrayList<>();
        result = letterCombinations("23");

        System.out.println(result.size());

        Iterator iterator = result.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
            iterator.remove();

        }

        System.out.println(result.size());


    }
}
