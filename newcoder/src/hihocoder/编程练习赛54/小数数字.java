package hihocoder.编程练习赛54;

import java.util.Arrays;
import java.util.Scanner;

public class 小数数字 {

    static int[] remainde;
    static int[] result;

    public static void main(String[] args) {

        remainde = new int[1000000 + 5];
        result = new int[1000000 + 5];


        Scanner in = new Scanner(System.in);

        int P = in.nextInt();
        int Q = in.nextInt();

        printAns(P, Q);


    }

    private static void printAns(int p, int q) {

        int i = 0, j = 0, temp = 0, flag = 0;
        for (i = 0 ; i < 1000000 ; i++)
        {
            remainde[i] = 0;
            result[i] = 0;
        }
        
        for (i = 0 ; i < 1000000 ;i++)
        {
            result[i] = p/q;
            temp = p%q;
            remainde[i] = temp;
            
            for (j = 0 ; j < i;j++)
            {
                if ((temp == remainde[j] || temp == 0))
                {
                    //出现循环或者整除
                    flag = 1;
                    break;
                }
            }
            
            p = temp*10;
            if (flag == 1)
                break;
        }
        
        int[] ans = new int[10];
        for (j = 1;j <= i ;j++)
            ans[result[j]] = 1;
        
        for (j = 0 ;j < 10 ;j++)
            if (ans[j] == 1)
                System.out.print(j);
        
        System.out.println();
        
                
        
        
    }   
}
