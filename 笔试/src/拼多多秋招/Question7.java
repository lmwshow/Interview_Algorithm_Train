package 拼多多秋招;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/8/30 19:46
 * @Description:
 */
public class Question7 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        int rest = a % b;
        if (rest == 0)
        {
            System.out.println(0 + " " + 0);
            return;

        }

        Map<Integer,Integer> map = new HashMap<>();

        int index = 0;
        map.put(rest,index);


        while (rest!=0)
        {
            rest *= 10;
            index++;
            rest = rest%b;

            if (map.containsKey(rest))
            {
                System.out.println(map.get(rest) + " " + (index - map.get(rest)));
                return;
            }else
                map.put(rest,index);

        }

        System.out.println(index + " " + 0);

    }
}

