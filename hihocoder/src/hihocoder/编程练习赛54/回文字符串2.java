package hihocoder.编程练习赛54;

import java.util.Scanner;

public class 回文字符串2 {

    static int left;
    static int right;
    //插入一个字符 破坏一个回文，找到插入的位置，有多个位置时 输出最小位置
    //左右直接判断，得到第一个不相等的位置，那么插入到符号 就是这两个位置符号其中的一个，  然后往前遍历找最小位置

    public static void main(String[] args){

        left = 0;
        right = 0;
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        posPalindrome(str);


        StringBuilder sb = new StringBuilder(str.substring(0,left)).append(str.substring(left+1));


        //这里需要用临时变量， 因为静态left会在posPalindrome中改变
        int ansleft = left;
        int ansright = right;

        if (posPalindrome(sb.toString()))
        {
            while (ansleft > 0 && str.charAt(ansleft - 1) == str.charAt(ansleft))
                ansleft --;

            System.out.println(ansleft+1);

        }else
        {
            while (ansright > 0 && str.charAt(ansright - 1) == str.charAt(ansright))
                ansright--;
            System.out.println(ansright+1);

        }



    }

    private static boolean posPalindrome(String str) {
        int l = 0;
        int r = str.length() -1;

        int[] pos = new int[2];

        while (l < r)
        {
            if (str.charAt(l) != str.charAt(r)) {
                left = Math.min(l,r);
                right = Math.max(l,r);
                return false;
            }

            l++;
            r--;
        }


        left = Math.min(l,r);
        right = Math.max(l,r);

        return true;

    }
}
