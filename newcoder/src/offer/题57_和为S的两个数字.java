package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 题57_和为S的两个数字 {

    //和相同，选乘积最小的一对
    //其实在排序的数组中，最早找到的组合 它的乘积就是最小的

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2)
            return res;


        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int x : array)
        {
            if (list.contains(sum - x))
            {
                if (x*(sum - x) < min)
                {
                    res.clear();
                    res.add(x > (sum -x)? (sum-x):x);
                    res.add(x > (sum -x)? x:(sum-x));
                    min = x*(sum - x);
                }
            }
            list.add(x);
        }

        return res;


    }

    //不适用辅助空间
    public static ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2)
            return res;


        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = array.length - 1;
        int cur = 0;

        while (right > left)
        {
            cur = array[left] + array[right];
            if ((cur == sum )&& (array[left]*array[right] < min))
            {
//                res.clear();
                res.add(array[left]);
                res.add(array[right]);
//                min = array[left]*array[right];
                break;
            }

            else if (cur < sum)
                left++;
            else
                right--;

        }

        return res;

    }


    public static void main(String[] args){

        ArrayList<Integer> res = FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);

        Iterator iterator = res.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());



    }
}
