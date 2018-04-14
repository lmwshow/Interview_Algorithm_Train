package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/12/20.
 */
public class 题21_调整数组顺序使奇数位于偶数前 {

    //空间换时间 O(n)
    public static void reOrderArray(int [] array) {

        if (array == null || array.length==0 || array.length == 1)
            return;

        int curindex = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < array.length ; i++)
        {
            if ((array[i]&1) == 0)      //偶数
                list.add(array[i]);
            else
                array[curindex++] = array[i];
        }

        for (int x : list)
            array[curindex++] = x;

        return;

    }

    public static void main(String[] args){

        int[] nums = new int[]{1,2,3,7,8,10,20,19,5,-3};
        reOrderArray(nums);
        for (int x : nums)
            System.out.println(x);


    }
}
