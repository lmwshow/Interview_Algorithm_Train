package leetgroup.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gracecoder on 2017/8/21.
 */
public class remove_element {
    public int leetcode_removeElement(int[] nums, int val) {

        int len =nums.length;
        int removeLen = 0;
        int startIndex = 0;
        Arrays.sort(nums);                                 //不要求和原来顺序一样
        for (int i = 0 ; i < len ; i++)
        {
            if (nums[i] != val)
                continue;
            else {
                startIndex = i;                         //获得开始的下标，和长度
                while (i<len&&nums[i++]==val)
                    removeLen++;
                break;
            }
        }

        int index = startIndex + removeLen;
        while (index < len)
            nums[startIndex++]=nums[index++];

        return len-removeLen;
    }

    public static int removeElement(int[] A, int elem) {

        int len =A.length;
        int removeLen = 0;
        int realIndex = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < len ; i++)
        {
            if (A[i]==elem)
                list.add(i);                  //逆序放，越后面的插前面
        }

        realIndex = len - list.size();


        for (int i = len-1 ; i >= 0&&!list.isEmpty() ; i--)
        {
            if (list.contains(i))
                continue;
            else {
                A[list.remove(0)] = A[i];           //删掉tar后，后面的往前面放
            }
        }


        return realIndex;
    }


    public static void main(String[] args){

        int[] nums = new int[]{2};
        removeElement(nums,3);

        for (int x: nums)
            System.out.println(x);

    }
    
}
