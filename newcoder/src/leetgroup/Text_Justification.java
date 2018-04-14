package leetgroup;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/9/8.
 */
public class Text_Justification {

    public static ArrayList<String> fullJustify(String[] words, int maxWidth) {

        ArrayList<String> ArrayList = new ArrayList<>();

        int l = 0, r = 0;
        int len = words.length;
        int restWidth = maxWidth;

        while (r < len) {
            String tmp = words[r];
            restWidth -= tmp.length();

            if (restWidth < 0) {
                helper(ArrayList, words, new StringBuilder(), l, r - 1, maxWidth);
                l = r;
                restWidth = maxWidth;
            } else if (restWidth == 0) {
                helper(ArrayList, words, new StringBuilder(), l, r, maxWidth);
                l = r + 1;
                r = l;
                restWidth = maxWidth;
            } else {
                restWidth -= 1;
                r++;
            }


        }

        //插入最后一条，如果restWidth 小于 maxWidth,说明还有字符串未插入。最后一条要左对齐
        if (restWidth != maxWidth) {
            StringBuilder str = new StringBuilder("");

            for (int i = l; i < r; i++) {
                str.append(words[i]);
                if (i != r - 1)
                    str.append(" ");
            }
            while (str.length() < maxWidth)
                str.append(" ");
//        helper(ArrayList,words,new StringBuilder(),l,r-1,maxWidth);

            ArrayList.add(new String(str));
        }

        return ArrayList;
    }

    private static void helper(ArrayList<String> ArrayList, String[] words, StringBuilder str, int l, int r, int maxWidth) {

        if (l > r)
            return;
        int nums = r - l + 1;
        int realLen = 0;
        for (int i = l; i <= r; i++)
            realLen += words[i].length();

        int restWidth = maxWidth - realLen;
        int averspace = nums == 1 ? restWidth : restWidth / (nums - 1);
        int extraspace = nums == 1 ? restWidth : restWidth % (nums - 1);
        String space = new String("");
        for (int i = 0; i < averspace; i++)
            space = space + " ";

        if (nums == 1) {
            str.append(words[l]);
            str.append(space);
        } else
            for (int i = l; i <= r; i++) {
                str.append(words[i]);

                //多出来的，分给左边的，也需要平均
                if (i - l < extraspace) {
                    str.append(" ");
                }

                if (i != r)
                    str.append(space);

            }

        ArrayList.add(new String(str));

    }

    public static void main(String[] args) {

        String[] words = new String[]{"what", "must", "be", "shall", "be."};
        ArrayList<String> res = fullJustify(words, 12);
        System.out.println(res);

    }
}
