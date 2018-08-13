package 网易考拉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;


public class 瞌睡
{
    static int M=(int)10e6+10;
    static int sleep[] = new int[M];
    static int score[] = new int[M];
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = in.readLine().split(" ");

        for (int i = 1 ; i <= n ; i++)
            score[i] = Integer.parseInt(parts[i-1]);

        parts = in.readLine().split(" ");

        int ans=0;

        int max=0;
        sleep[0]=0;
        for(int i=1;i<=n;++i){
            int statue=Integer.parseInt(parts[i-1]);
            sleep[i]=sleep[i-1];
            if(statue==1){
                ans+=score[i];
            }else {

                sleep[i]+=score[i];
            }
            if(i>=k){
                max = Math.max(max, sleep[i]-sleep[i-k]);
            }
        }

        System.out.println(ans+max);
    }


}