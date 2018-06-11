package hihocoder.编程练习赛63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/10 12:07
 * @Description
 */
public class 命名 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0)
        {
            String S = in.readLine();
            String T = in.readLine();
            
            StringBuilder part1 = new StringBuilder("");
            StringBuilder part2 = new StringBuilder("");
            for (int i = 0 ; i < S.length() ; i++)
            {
                if ((i & 1) == 0)
                    part1.append(S.charAt(i));
                else 
                    part2.append(S.charAt(i));
                
            }
            
            if ((find(S,part1)&&find(T,part2))|| (find(S,part2)&&find(T,part1)))
                System.out.println("Yes");
            else 
                System.out.println("No");
                
                
        }

    }

    private static boolean find(String s, StringBuilder sub) {

        int index = 0;
        for (int i = 0 ; i < s.length() ; i++)
        {
            if (s.charAt(i) == sub.charAt(index))
                index++;
            if(index == sub.length())
                return true;
        }


        return false;
    }
}
