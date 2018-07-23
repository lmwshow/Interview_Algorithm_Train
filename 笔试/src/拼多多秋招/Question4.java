package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/7/22 19:47
 * @Description:
 */
public class Question4 {

    static int target = 0;
    static int finalmoney = Integer.MAX_VALUE;
    static int finalstep = 0;

    static int maxN = 10005;
    static int maxK = 10005;


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        char[] phone = in.readLine().toCharArray();
        int[] ans = new int[phone.length];

        for (int i = 0; i < n; i++)
            ans[i] = phone[i] - '0';
        int[] nums = new int[10];


        for (char c : phone)
            nums[c - '0']++;

        int step = 0;
        int rest = 0;       //距离靓号还差几个
        int money = 0;

        for (int i = 0; i < nums.length; i++) {

            step = 0;
            money = 0;
            if (nums[i] == 0)
                continue;

            rest = k - nums[i];
            while (rest > 0) {
                step++;
                if (i - step >= 0) {
                    if (rest > nums[i - step]) {
                        rest -= nums[i - step];
                        money += nums[i - step] * step;
                    } else {
                        money += rest * step;
                        rest = 0;
                        break;
                    }

                }
                if (i + step < nums.length) {
                    if (rest > nums[i + step]) {
                        rest -= nums[i + step];
                        money += nums[i + step] * step;
                    } else {
                        money += rest * step;
                        rest = 0;
                        break;
                    }

                }

            }

            if (money < finalmoney) {
                finalmoney = money;
                finalstep = step;
                target = i;
            }


        }

        int time = nums[target];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < finalstep; i++) {
            list.add(target - i);
            list.add(target + i);
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(phone[i] - '0')) {
                ans[i] = target;
                time++;
            }
        }

        rest = k - time;


        if (rest > 0 && target - finalstep >=0 && nums[target - finalstep] > 0) {
            for (int i = n - 1; rest > 0 && i >= 0; i--) {
                if (ans[i] == target - finalstep)
                {
                    ans[i] = target;
                    rest--;
                }
            }
        }

        if (rest > 0 && target + finalstep < n)
        {
            for (int i = 0; rest > 0 && i < n; i++) {
                if (ans[i] == target + finalstep)
                {
                    ans[i] = target;
                    rest--;
                }
            }
        }


        System.out.println(finalmoney);
//        System.out.println(target);
//        System.out.println(finalstep);

        for (int x : ans)
            System.out.print(x);

    }
}
