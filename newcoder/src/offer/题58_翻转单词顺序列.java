package offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class 题58_翻转单词顺序列 {


    public static String ReverseSentence(String str) {

        if (str == null || str.length() == 0 || str.trim().length() == 0)
            return str;

        StringBuilder sb = new StringBuilder(str);

        sb.reverse();

        System.out.println(sb.toString());

        int left = 0;
        int right = 0;
        while (right < sb.length())
        {
            if (sb.charAt(left) == ' ')
            {
                left ++;
                right ++;
            }else if (sb.charAt(right) == ' ' || right == sb.length()-1)
            {
                if (right == sb.length() - 1)
                    reverse(sb,left,right);
                else
                    reverse(sb,left,right-1);
                left = ++right;
            }else
                right++;
        }

        return sb.toString();

    }

    private static void reverse(StringBuilder sb, int left, int right) {

        while (left < right)
        {
            char tmp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,tmp);
            left++;
            right--;

        }
        return;
    }

//    public static String ReverseSentence(String str) {
//
//        if (str == null || str.length() == 0)
//            return "";
//
//        //如果都是空格 返回原字符串
//        if (str.trim().equals(""))
//            return str;
//
//        StringBuilder sb = new StringBuilder("");
//        String[] list = str.split(" ");
//        for (int i = list.length - 1; i >= 0; i--)
//            sb.append(list[i] + " ");
//        sb.deleteCharAt(sb.length() - 1);
//
//        return sb.toString();
//
//    }

    public static void main(String[] args) {

        String res = ReverseSentence(" ");
        System.out.println(res);

    }
}
