package hihocoder.编程练习赛48;

import java.util.Scanner;

public class 最小先序遍历 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] node = new int[n];
        int start = 0;

        for (int i = 0 ; i < n ; i ++) {
            node[i] = in.nextInt();
            if (node[i] == 1)
                start = i;
        }

        System.out.println(node[start]);

        solver(node,0,start-1);
        solver(node,start+1,n-1);


        return;

    }

    private static void solver(int[] node, int start, int end) {

        if (start > end)
            return;
        else if (start == end)
        {
            System.out.println(node[start]);
            return;

        }

        else {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = start ; i <= end ; i ++)
            {
                if (node[i] < min) {
                    min = node[i];
                    index = i;
                }
            }

            System.out.println(node[index]);

            solver(node,start,index-1);
            solver(node,index+1,end);
        }

    }
}
