package hihocoder.编程练习赛47;

import java.util.Scanner;

public class 删除树节点 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] weight = new int[n+1];
        int[] parent = new int[n+1];
        int[] index = new int[n+1];

        for (int i = 1 ; i <= n ; i++)
            weight[i] = in.nextInt();

        for (int i = 1 ; i <= n ; i++)
            parent[i] = in.nextInt();

        for (int i = 1 ; i <= n ; i++)
            index[i] = i;

        if (n == 1)
        {
            System.out.println(0);
            return;
        }

        for (int i = 1 ; i <= n ; i++)
        {
            if (weight[i] < k) {
                index[i] = index[parent[i]];
                parent[i] = -1;
            }
            else
                parent[i] = index[parent[i]];
        }

        System.out.print(parent[1]);

        for (int i = 2 ; i <= n ; i++)
            System.out.print(" " + parent[i]);

        System.out.println();

        return;



    }
}
