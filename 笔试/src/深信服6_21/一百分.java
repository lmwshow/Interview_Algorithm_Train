package 深信服6_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 20:16
 * @Description:
 */
public class 一百分 {

    static int maxN = 15;
    static int maxM = 105;
    static boolean[][] map = new boolean[maxN][maxM];
    static List<Integer> ans = new ArrayList<>();
    static List<Integer> finalans = new ArrayList<>();
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        nums = new int[n + 1];

        for (int i = 1; i <= n; i++)
            nums[i] = Integer.parseInt(in.readLine());

        dfs(1, 0);

        System.out.println(finalans.size());
        for (int x : finalans)
            System.out.println(x);
    }

    private static void dfs(int index, int score) {

//        if (start > n || cursum == 100) {
//            finalans.addAll(ans);
//            return;
//        }
//
//
//        if (cursum + nums[start] > 100)
//            return;
//
//        ans.add(start);
//        dfs(start + 1, cursum + nums[start]);
//        ans.remove(ans.size() - 1);

        if(score == 100){
            finalans.addAll(ans);
            return;
        }
        if(index == nums.length || score > 100)return;
        ans.add(index);
        dfs(index+1,score+nums[index]);
        ans.remove(ans.size()-1);
        dfs(index+1,score);


    }
}
