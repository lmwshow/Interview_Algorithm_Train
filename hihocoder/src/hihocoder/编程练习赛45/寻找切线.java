package hihocoder.编程练习赛45;

import java.util.Scanner;

public class 寻找切线 {

    
    //因为只用找一条 ， 先定一个最左点， 然后找斜率最大的 比较方便
    public static void main(String[] args){


        Scanner in =  new Scanner(System.in);

        int n = in.nextInt();

        int[][] map = new int[n][2];
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n ; i++)
        {
            map[i][0] = in.nextInt();
            map[i][1] = in.nextInt();
            
            if (map[i][0] < min)
            {
                min = map[i][0];
                res[0] = i;
            }
                
        }

        System.out.println(res[0]);

        
        double maxk = Double.MIN_VALUE;
        
        for (int i = 0 ; i < n ; i++)
        {
            if (i == res[0])
                continue;
            
            if (map[i][0] == map[res[0]][0])
            {
                res[1] = i;
                break;
            }

            double x = map[i][0];
            double y = map[i][1];

            if ((y-map[res[0]][1])/(x - map[res[0]][0]) > maxk)
            {
                maxk = (y-map[res[0]][1])/(x - map[res[0]][0]);
                res[1] = i;
            }
        }

        res[0]++;
        res[1]++;
        System.out.print(res[0] +" " + res[1]);
        
        
        
    }
}
