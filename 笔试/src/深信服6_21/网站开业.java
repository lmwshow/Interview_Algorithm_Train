package 深信服6_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 19:44
 * @Description:
 */
public class 网站开业 {

    static int maxN = 1000005;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int [] nums = new int[n];
        for(int i = 0;i<n;i++)
            nums[i] = Integer.parseInt(in.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<n;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        System.out.println(Math.min(list.size(), 10));
        for(int i =0;i<Math.min(list.size(), 10);i++)
           System.out.println(list.get(i));
    }


}


