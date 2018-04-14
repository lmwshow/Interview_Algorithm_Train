package leetgroup.回文;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/8/23.
 *
 * DFS回溯，重点在于在指定字符串的起点index
 */
public class palindrome_partitioning {

    public ArrayList<ArrayList<String>> partition(String s) {

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;

        ArrayList<String> cur = new ArrayList<>();



        helper(res,cur,s,0);

        return res;
    }

    private void helper(ArrayList<ArrayList<String>> res, ArrayList<String> cur, String s, int start) {

        if (start == s.length())
        {
            if (cur.size()!=0)
                res.add(new ArrayList<>(cur));
            return;
        }



        for (int i = start; i < s.length() ; i++)
        {
            String str = s.substring(start,i+1);                //start固定
            if (isPalindrome(str)) {
                cur.add(String.valueOf(str));

                helper(res,cur,s,i+1);

                cur.remove(cur.size()-1);
            }


        }
    }

    public static boolean isPalindrome(String s)
    {
        int len = s.length();
        if (len == 1)
            return true;

        int start = 0;
        int end = len -1 ;
        while (start <= end)
        {
            if (s.charAt(start)!=s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }


    public static void main(String[] args){

        StringBuilder str = new StringBuilder("aab");
        str.delete(0,3);

        System.out.println(str);

    }
}
