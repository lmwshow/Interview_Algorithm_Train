package hihocoder.编程练习赛48;

import java.util.Scanner;

public class 折线中点 {
    
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] point = new int[n][2];
        double[] length = new double[n];

        for (int i = 0 ; i < n ; i ++)
        {
            point[i][0] = in.nextInt();
            point[i][1] = in.nextInt();

        }

        //length[i]表示从第1个点到第i+1个点 折线段的长度
        for (int i = 1 ; i < n ; i++)
            length[i] = length[i-1] + distance(point[i-1][0],point[i-1][1],point[i][0],point[i][1]);

        double half = length[n-1] / 2.0;
        int index = 0;
        for (int i = 1 ; i < n ; i++)
        {
            if (length[i] > half)
            {
                index = i;
                break;
            }
        }

        double rest = length[index] - half;
        double len = length[index] - length[index - 1];
        double rate = rest / len;

        int x1 = point[index][0];
        int y1 = point[index][1];
        int x2 = point[index-1][0];
        int y2 = point[index-1][1];

        double y = y1 - rate*(y1 - y2);
        double x = x1 - rate*(x1 - x2);

        //保留一位小数
        System.out.println(String.format("%.1f",x) + " " +String.format("%.1f",y));
        



    }

    private static double distance(int x1, int y1, int x2, int y2) {

        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }
}
