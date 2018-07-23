package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/7/22 18:28
 * @Description:
 */
public class Question1 {

    static int people = 4;
    static final String[] name = new String[]{"Alice", "Bob", "Cathy", "Dave"};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int base = 1;
        int index = 0;
        while (n > 0) {
            if (n > people * base) {
                n -= people * base;
                base *= 2;
            } else {
                index = (n / base);

                if (n % base == 0)
                    index--;
                break;
            }
        }

        System.out.println(name[index]);
    }
}
