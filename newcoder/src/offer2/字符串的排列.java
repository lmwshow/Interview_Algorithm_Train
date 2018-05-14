package offer2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/5/14 17:18
 * @Description https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 字符串的排列 {
    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> ans = new ArrayList<>();

        if (str == null || str.length() < 1)
            return ans;

        if (str.length() == 1) {
            ans.add(str);
            return ans;
        }

        StringBuilder sb = new StringBuilder("");
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        do {
            for (char ch : chars)
                sb.append(ch);
            ans.add(sb.toString());
            sb.delete(0, sb.length());
        } while (nextPermutation(chars));

        return ans;


    }

    private static boolean nextPermutation(char[] chars) {

        if (chars == null || chars.length < 2)
            return true;

        int i = chars.length - 2;

        for (; i >= 0; i--) {

            if (chars[i] < chars[i+1])
            {
                int find = chars.length - 1;
                while (chars[find] <= chars[i])
                    find--;
                swap(chars,i,find);
                reverse(chars,i+1);
                return true;
            }
        }

        reverse(chars,0);
        return false;

    }

    private static void reverse(char[] chars, int start) {

        int end = chars.length - 1;
        while (end >= start)
            swap(chars,start++,end--);

        return;
    }

    private static void swap(char[] chars, int i, int j) {

        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }


    public static void main(String[] args){


        ArrayList<String> ans = Permutation("");

        System.out.println(ans.size());

    }
}
