package hihocoder.编程练习赛63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/10 12:24
 * @Description 思想:归并 递归
 */
public class 洗牌 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int t = Integer.parseInt(parts[1]);

        int len = (int) Math.pow(2,n);
        int[] nums = new int[len];

        parts = in.readLine().split(" ");
        for (int i = 0 ; i < parts.length ; i++)
            nums[i] = Integer.parseInt(parts[i]);

        int[] tmp = new int[len];

        if ((t & 1) == 1)
            solver(nums,0,len-1,tmp);

        for (int x : nums)
            System.out.println(x);
    }

    private static void solver(int[] nums,int left,int right,int[] tmp) {

        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;
            solver(nums,left,mid,tmp);
            solver(nums,mid+1,right,tmp);
            //交换左右部分
            change(nums,left,mid,right,tmp);


        }


    }

    private static void change(int[] nums, int left, int mid, int right, int[] tmp) {

        int index = 0;
        int i = mid + 1;

        while (i <= right)
            tmp[index++] = nums[i++];

        i = left;
        while (i <= mid)
            tmp[index++] = nums[i++];

        for (i = 0 ; i < index ; i++)
            nums[left+i] = tmp[i];
    }
}
