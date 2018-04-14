package offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class 题58_翻转单词顺序列 {

    public static String ReverseSentence(String str) {

        if (str == null || str.length() == 0)
            return "";

        //如果都是空格 返回原字符串
        if (str.trim().equals(""))
            return str;

        StringBuilder sb = new StringBuilder("");
        String[] list = str.split(" ");
        for (int i = list.length - 1; i >= 0; i--)
            sb.append(list[i] + " ");
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    public static void main(String[] args) {

        String res = ReverseSentence(" ");
        System.out.println(res);

    }
}
