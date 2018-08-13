package 网易考拉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/8/11 16:47
 * @Description:
 */
public class 丰收 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];
        String[] parts = in.readLine().split(" ");
        for (int i = 0 ; i < n ; i++)
            nums[i] = Integer.parseInt(parts[i]);



        for(int i = 1;i<n;i++){
            nums[i] += nums[i-1];
        }

        int m = Integer.parseInt(in.readLine());

        parts = in.readLine().split(" ");
        int k = 0;
        while(m-- >0){
            int cur = Integer.parseInt(parts[k++]);
            int ans = binarySearch(nums, cur);
            while(nums[ans] < cur){
                ans ++;
            }
            System.out.println(ans+ 1);

        }

    }

    public static int binarySearch(int[] nums, int x){
        int left = 0;int right  = nums.length-1;
        while(left<right){
            int mid = ((right - left) >> 1) + left;
            if(x == nums[mid]) return mid;
            else if(x > nums[mid]) left = mid +1;
            else right = mid -1;
        }
        return left ;
    }

}
