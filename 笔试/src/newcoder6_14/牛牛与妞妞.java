package newcoder6_14;

import 网易3_27.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @Auther: minGW
 * @Date: 2018/6/14 19:31
 * @Description: 30%
 */
public class 牛牛与妞妞 {

    static int[] retain = new int[14];
    static double sum = 46*45;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(sum * 0.3905);
        for (int i = 1 ; i <= 13 ; i++)
            retain[i] = 4;
        String[] parts = in.readLine().split(" ");
        int a1 = Integer.parseInt(parts[0]);
        int a2 = Integer.parseInt(parts[1]);
        int a3 = Integer.parseInt(parts[2]);
        retain[a1]--;
        retain[a2]--;
        retain[a3]--;
        int x = a1 + a2 + a3;
        parts = in.readLine().split(" ");
        int b1 = Integer.parseInt(parts[0]);
        int b2 = Integer.parseInt(parts[1]);
        int b3 = Integer.parseInt(parts[2]);
        retain[b1]--;
        retain[b2]--;
        retain[b3]--;
        int y = b1 + b2 + b3;

        int diff = x - y;

        int count = 0;

        for (int i = 1 ; i <= 13 ; i++)
        {
            if (retain[i] == 0)
                continue;

            int base = retain[i]--;
            int tmp = 0;
            for (int j = 1 ; j <= 13 ; j++) {
                if (retain[j] == 0)
                    continue;
                if (diff + i - j <= 0)
                    break;
                if (diff + i - j > 0)
                    tmp += base * retain[j];

            }
            count+=tmp;
            retain[i]++;
        }

        double ans = count/sum;


        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(ans));

    }
}
