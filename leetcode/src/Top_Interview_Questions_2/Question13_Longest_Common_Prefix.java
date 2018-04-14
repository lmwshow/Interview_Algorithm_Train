package Top_Interview_Questions_2;

public class Question13_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        String cur = strs[0];

        for (int i = 0 ;i < cur.length() ; i++)
        {
            char curChar = cur.charAt(i);
            for (int j = 1; j < strs.length ; j++)
            {
                if (i >= strs[j].length() || strs[j].charAt(i) != curChar)
                    return cur.substring(0,i);
            }
        }

        return cur;

    }


    public static void main(String[] args){


        byte a=0;
        System.out.println(a);

    }
}
