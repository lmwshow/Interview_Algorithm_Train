package newcoder2018_3;

import java.util.Scanner;

public class 幸运数字3 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long k = in.nextLong();

        StringBuilder sb = new StringBuilder(in.next());

        int index = 0;

        while (k--> 0)
        {
            index = sb.indexOf("47");
            if (index == -1)
            {
                System.out.println(sb.toString());
                return;
            }
            else {
                if ((index+1) % 2 == 1)     //奇数
                    sb.replace(index,index+2,"44");
                else
                    sb.replace(index,index+2,"77");
            }

            if (index+3 <= sb.length() && sb.substring(index,index+3).equals("447"))
                break;

        }

        if (k%2==1)
            sb.replace(index,index+3,"477");

        System.out.println(sb.toString());




    }
}
