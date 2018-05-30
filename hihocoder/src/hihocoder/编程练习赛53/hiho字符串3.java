package hihocoder.编程练习赛53;

import java.util.Scanner;

public class hiho字符串3 {

    //找规律  第n代的字符串为 n-1代+n-1代的后半部分+后半部分的后半部分+..一直二分到最后一个 + 最后一个后面该插入的字符

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("h");



        int t = in.nextInt();
        int x = 0;

        while (t-- > 0)
        {
            long k = in.nextLong();
            long tmp = k;
            while (tmp > 0)
            {
                tmp /= 2;
                x++;
            }

            for (int i = 2 ; i <= x ; i++) {
                generateNext(sb);
            }

            System.out.println(sb.charAt((int) k));



        }

    }

    private static void generateNext(StringBuilder sb) {

        int left=  0;
        int right = sb.length();
        int step = sb.length()/2;

        while (step >= 1)
        {
            left += step;
            sb.append(sb.substring(left,right));
            step /= 2;

        }


        if (sb.charAt(sb.length()-1) == 'h')
            sb.append('i');
        else if (sb.charAt(sb.length()-1) == 'i')
            sb.append('o');
        else if (sb.charAt(sb.length()-1) == 'o')
            sb.append('h');
    }
}
