package hihocoder.编程练习赛49;

import java.util.Scanner;

public class 相似颜色 {
    
    public static void main(String[] args){


        Scanner in = new Scanner(System.in);

        String str = in.next();
        String x = str.substring(1,3);
        String y = str.substring(3,5);
        String z = str.substring(5);

        StringBuilder res = new StringBuilder("#");
        res.append(helper(x));
        res.append(helper(y));
        res.append(helper(z));

        System.out.println(res.toString());

    }

    private static char helper(String string) {

        char c = string.charAt(0);
        char d = string.charAt(1);
        int a = 0;
        int b = 0;

        if (c>='0' && c<='9')
            a = c - '0';
        else
            a = c - 'a' + 10;

        if (d>='0' && d<='9')
            b = d - '0';
        else
            b = d - 'a' + 10;

        int x = a*16 + b;

        if (((a*16 + a)-x) > (x- ((a-1)*16 +a -1)))
            return (char) ((int)c - 1);
        else
            return c;


    }
}
