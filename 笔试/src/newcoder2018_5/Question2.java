package newcoder2018_5;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 19:43
 * @Description
 */
public class Question2 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        int day=0,num1=0,num2=0,num3=0;

        boolean flag = true;

        int count = 6;
        while (T-- > 0)
        {

            day = in.nextInt();
            num1 = in.nextInt();
            num2 = in.nextInt();
            num3 = in.nextInt();
            flag = true;

            while (day > 0) {
                count = 6;

                while (count > 0) {
                    if (num3 > 0 && count >= 3) {
                        count -= 3;
                        num3--;
                        continue;
                    } else if (num2 > 0 && count >= 2) {
                        count -= 2;
                        num2--;
                        continue;
                    } else if (num1 > 0 && count >= 1) {
                        count -= 1;
                        num1--;
                        continue;
                    } else {
                        System.out.println("No");
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                    break;

                day--;
            }

            if (flag)
                System.out.println("Yes");

        }



    }
}
