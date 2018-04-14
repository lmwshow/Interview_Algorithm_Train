package leetgroup.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/9/24.
 */
public class strStr {

    private static int[] next;

    private static void getNext(String p) {
        int k = -1;
        int j = 0;
        next[0] = -1;

        while(j < p.length())
        {
            if(k == -1 || p.charAt(k) == p.charAt(j))
            {
                k++;
                j++;
                next[j] = k;
            }else
                k = next[k];
        }

    }


    private static int kmpCompare(String s,String p)
    {
        int i = 0;
        int j = 0;

        while (i < s.length())
        {
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }else
                j = next[j];

            if (j == p.length())
                return i-j;
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length()|| haystack.length() ==0) {
            return -1;
        }

        int len = needle.length();

        next = new int[len +1 ];

        getNext(needle);

        return kmpCompare(haystack,needle);


    }



}
