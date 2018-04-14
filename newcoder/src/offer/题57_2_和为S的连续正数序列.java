package offer;

import java.util.ArrayList;
import java.util.Iterator;

public class 题57_2_和为S的连续正数序列 {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 1)
            return res;

        int left = 1;
        int right = 1;
        int max = (sum >> 1) + 1;
        int curSum = 1;
        while (right <= max)
        {

            while (curSum < sum) {
                right++;
                curSum += right;
            }

            if (curSum == sum)
            {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left ; i <= right ; i++)
                    tmp.add(i);
                res.add(tmp);

                curSum -= left;
                left ++;
            }else
            {
                while (curSum > sum)
                {
                    curSum -= left;
                    left++;
                }
            }

        }

        return res;
    }

    private static int Sum(int left, int right) {

        return ((right +left)*(right - left +1))>>1;
    }


    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(1);

        Iterator iterator = res.iterator();
        
        while (iterator.hasNext())
        {
            ArrayList<Iterator> tmp = (ArrayList<Iterator>) iterator.next();
            Iterator it = tmp.iterator();
            while (it.hasNext())
                System.out.print(it.next());
            
            System.out.println();
            
                
        }

    }
}
