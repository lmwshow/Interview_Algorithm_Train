package leetgroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Gracecoder on 2017/5/11.
 */
public class minimum_window_substring {

    public static String minWindow(String S, String T) {

        int start = 0,end = 0,dist = Integer.MAX_VALUE,head=0;
        int count = T.length();
        int[] needCharCount = new int[256];

        //ASCII字符最多256个
        char[] chS = S.toCharArray();
        char[] chT = T.toCharArray();
        for (char c: chT)
            needCharCount[c]++;

        while (end < S.length())
        {
            char cur = chS[end];
            if (needCharCount[cur] > 0)
                count--;
            needCharCount[cur]--;                           //每次都needCharCount[cur]--， 真正需要的字符计数最小为0，有重复会出现负数，比如窗口内有2个B，那么B的计数就会是-1，而不需要的字符计数会小于0

            end++;

            while (start<end && count == 0)
            {
                if (end - start< dist) {
                    head =start;
                    dist = end - start;
                }

                needCharCount[chS[start]]++;                     //这里每次都needCharCount[start]++，这里遍历的都是之前已经遍历过的，所以每次都++,并不会使得不需要的字符大于0.一旦需要的字符计数大于0，那么count+1，变成无效窗口
                if (needCharCount[chS[start]] >0) {
                    count++;
                }

                start++;

            }

        }



        return dist==Integer.MAX_VALUE? "":S.substring(head, head+dist);
    }


    public static void main(String[] args){

        System.out.println(minWindow("DEABEDC","ABC"));

    }
}
