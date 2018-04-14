package leetgroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/8/3.
 * 找到值均为target的 一段子系列
 *
 * 左右分界法/一次循环法
 */
public class search_for_a_range {

    /*左右分界*/
    public int[] searchRange1(int[] A, int target) {
        int []res = {-1, -1};
        if (A == null || A.length == 0) return res;
        int start = 0, end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] < target) start = mid;
            else end = mid;
        }
        if (A[start] == target) res[0] = start;
        else if (A[end] == target) res[0] = end;
        else return res;
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] > target) end = mid;
            else start = mid;
        }
        if (A[end] == target) res[1] = end;
        else if (A[start] == target) res[1] = start;
        else return res;
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {




        int[] res = new int[]{-1,-1};

        int length = nums.length;

        if (length == 0)
            return res;

        int start = 0 ;
        int end = length-1;
        int mid = 0;
        while (nums[start] < nums[end])
        {
            mid = (start + end)/2;
            if (target > nums[mid])
                start = mid +1;
            else if (target < nums[mid])
                end = mid -1;
            else
            {
                if (nums[start] < target) start++;
                if (nums[end] > target) end -- ;    //这里如果用while直接弄到=target，那就不再是二分搜索， 最坏为O(n)
            }
        }

        if (nums[start] == target)
        {
            res[0] = start;
            res[1] = end;
        }


        return res;
    }

    public static void main(String[] args){

        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
