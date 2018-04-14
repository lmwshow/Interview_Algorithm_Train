package newcoder2018_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 幸运数字4 {


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int index = 1;
        while (k>0)
        {
            index++;
            k = k /index;
        }

        //后面需要k位， 前面n-k为已经定了

        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= n -k ; i++)
            list.add(i);




        for (int i = 1; i < n;i++)
        {

        }

        System.out.println(Integer.MAX_VALUE);


    
    }
}
