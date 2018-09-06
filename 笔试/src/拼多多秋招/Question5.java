package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/8/30 18:56
 * @Description:
 */
public class Question5 {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long hp = Long.parseLong(in.readLine());
        long normalAttack = Long.parseLong(in.readLine());
        long buffedAttack = Long.parseLong(in.readLine());

        long ans = 0;
        if (2 * normalAttack >= buffedAttack) {
            ans = hp / normalAttack;
            long resthp = hp - ans * normalAttack;
            if (resthp > 0)
                ans++;
        } else {
            ans = (hp / buffedAttack);
            long resthp = hp - ans * buffedAttack;
            ans = ans * 2;
            if (resthp > 0) {
                ans++;
                if (resthp > normalAttack)
                    ans++;
            }

        }

        System.out.println(ans);

    }
}
