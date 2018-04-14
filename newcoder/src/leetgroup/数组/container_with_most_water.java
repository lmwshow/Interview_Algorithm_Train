package leetgroup.数组;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/8/19.
 *
 * O(n^2)的方法，双重循环，leetcode超时
 *
 */
public class container_with_most_water {


//    解法1：大家都能想到的，穷举所有(i,j)可能，找一个最大的。
//    public int maxArea(int[] height) {
//
//        int maxarea = 0;
//
//        for (int i = 0 ; i < height.length ; i++) {
//
//            for (int j = i; j < height.length; j++)
//                maxarea = Math.max((j - i) * Math.min(height[i], height[j]), maxarea);
//        }
//
//
//        return maxarea;
//    }

//    解法2：可以对解法1中的第二个循环中的j做预先判断从而跳过某些情况。在我们检查比i小的各个j时，计算面积的短板不会超过ai本身。平均到距离上，j不会在一定距离上靠近i。
//    public static int maxArea(int[] height) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int maxArea = 0;
//        for(int i = 1; i < height.length; i++){
//            if(height[i] == 0)continue;
//            int maxPossibleIdx = i - maxArea/height[i];
//            for(int j = 0; j < i && j <= maxPossibleIdx; j++) {
//                int area = (i - j) * Math.min(height[i], height[j]);
//                if(area > maxArea) {
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
//    }


// O(n)的复杂度。保持两个指针i,j；分别指向长度数组的首尾。如果ai 小于aj，则移动i向后（i++）。反之，移动j向前（j--）。
// 如果当前的area大于了所记录的area，替换之。
// 这个想法的基础是，如果i的长度小于j，无论如何移动j，短板在i，不可能找到比当前记录的area更大的值了，只能通过移动i来找到新的可能的更大面积。
    public static int maxArea(int[] height){
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        if(j <=0)return 0;
        while(i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if(height[i] < height[j]){
                i++;

            }else {
                j--;
            }
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }



    public static void main(String[] args){




    }
}
