package 网易考拉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/8/11 15:57
 * @Description:
 */
public class 小易的字典 {

    public static String Permutation(char[] nums,int target) {


        StringBuilder ans = new StringBuilder("");
        Arrays.sort(nums);


        for (int i = 1 ; i < target ; i++)
        {
            if (!nextPermutation(nums))
                return null;
        }

        for (char c : nums)
            ans.append(c);
        return ans.toString();

    }

    public static boolean nextPermutation(char[] nums) {

        if (nums == null || nums.length < 2)
            return true;

        int i = nums.length - 2;

        for (; i >= 0 ; i--)
        {
            if (nums[i] < nums[i+1]) {
                int find = nums.length-1;
                while (nums[find] <= nums[i])
                    find--;
                swap(nums, i, find);
                reverse(nums,i+1);
                return true;
            }

        }

        reverse(nums,0);
        return false;

    }

    //利用swap 来逆转
    private static void reverse(char[] nums, int start) {

        int end = nums.length - 1;
        while (start < end)
            swap(nums,start++,end--);
        return;
    }

    private static void swap(char[] nums, int i, int j) {

        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        char[] chars = new char[n + m];
        for (int i = 0; i < n ; i++)
            chars[i] = 'a';
        for (int i = n; i < chars.length ; i++)
            chars[i] = 'z';

        String ans = Permutation(chars,k);

        System.out.println(ans);


    }
}
