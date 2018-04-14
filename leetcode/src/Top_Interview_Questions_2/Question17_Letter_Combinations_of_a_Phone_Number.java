package Top_Interview_Questions_2;

import java.util.*;

public class Question17_Letter_Combinations_of_a_Phone_Number {

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;

        Map<Character,List<Character>> map = new HashMap<>();

        map.put('2',Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));

        StringBuilder sb = new StringBuilder("");
        solver(map,digits,res,sb,0);

        return res;
    }

    private static void solver(Map<Character, List<Character>> map, String digits, List<String> res, StringBuilder sb, int start) {

        if (start >= digits.length())
        {
            String tmp = sb.toString();
            res.add(tmp);
            return;
        }

        List<Character> tmp = map.get(digits.charAt(start));

        Iterator iterator = tmp.iterator();
        while (iterator.hasNext())
        {
            char c = (char) iterator.next();
            sb.append(c);
            solver(map,digits,res,sb,start+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }



    public static void main(String[] args){

        List<String> res = letterCombinations("23");

        Iterator iterator = res.iterator();
        while (iterator.hasNext())
        {
            String str = (String) iterator.next();
            System.out.println(str);

        }



    }
}
