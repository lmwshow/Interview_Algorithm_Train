import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/6/15 19:25
 * @Description:
 */
public class 托米历险记 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];

        String[] parts = in.readLine().split(" ");
        for (int i = 0 ; i < n ; i++)
            nums[i] = Integer.parseInt(parts[i]);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(25,0);
        map.put(50,0);

        for (int i = 0 ; i < n ; i++)
        {
            int rest = nums[i] - 25;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (rest == 25)
            {
                if (map.get(25)==0)
                {
                    System.out.println("NO");
                    return;
                }
                map.put(25,map.get(25)-1);
            }
            if (rest == 50)
            {
                if (map.get(50)==0 && map.get(25)<2)
                {
                    System.out.println("NO");
                    return;
                }

                if (map.get(50) > 0)
                    map.put(50,map.get(50)-1);
                else
                    map.put(25,map.get(25)-2);
            }
            if (rest == 75)
            {
                if (map.get(25)>=3 || (map.get(50)>=1&&map.get(25)>=1)) {
                    if(map.get(50)>=1&&map.get(25)>=1)
                    {
                        map.put(50,map.get(50)-1);
                        map.put(25,map.get(25)-1);
                    }
                    else
                        map.put(25,map.get(25)-3);

                }
                else
                {
                    System.out.println("NO");
                    return;
                }
            }
        }


        System.out.println("YES");


    }
}
