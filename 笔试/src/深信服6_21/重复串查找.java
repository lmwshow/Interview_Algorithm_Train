package 深信服6_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 19:40
 * @Description:
 */
public class 重复串查找 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int ans = solver(str);
        System.out.println(ans);
    }

    private static int solver(String str) {
        int ans = 0;
        if (str.length() == 0)
            return ans;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) != str.charAt(i)) {
                    continue;
                }
                int len = j - i;
                String temp1 = str.substring(i, j);
                if (j + len > str.length()) {
                    break;
                }
                String temp2 = str.substring(j, j + len);
                if (temp1.equals(temp2)) {
                    count = 2 * temp1.length();
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

}
