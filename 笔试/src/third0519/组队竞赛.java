package third0519;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/5/24.
 */
public class 组队竞赛 {

    public static void main(String[] args){

        int n;
        long res = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        int[] score = new int[3*n];
        for (int i =0 ; i < score.length ; i ++)
            score[i] = in.nextInt();

        Arrays.sort(score);

        for (int i = n ; i < 3*n ; i += 2)
            res += score[i];

        System.out.println(res);


    }
}
