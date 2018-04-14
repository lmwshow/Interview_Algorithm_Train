package leetgroup;

/**
 * Created by Gracecoder on 2017/10/2.
 */
public class Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String cur = strs[0];

        for (int i = 0 ; i < cur.length() ; i ++) {

            char tmpchar = cur.charAt(i);

            for (int j = 1; j < strs.length; j ++) {

                if (i >= strs[j].length() || strs[j].charAt(i) != tmpchar)
                    return cur.substring(0,i);

            }
        }

        return cur;

    }
}
