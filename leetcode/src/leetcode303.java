import java.util.Vector;

/**
 * Created by Gracecoder on 2017/2/8.
 */
public class leetcode303 {

    public static void main(String[] args){

        int[] nums = {-2, 0, 3, -5, 2, -1};
        Vector<Integer> sums = new Vector<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            sums.add(nums[i]);
        }

        NumArray numArray =new NumArray(nums);
        NumArray numArray1 = new NumArray(sums);
        int res = numArray.sumRange(0,5);
        int res1 = numArray1.sumRange1(0,5);
        System.out.println(res);
        System.out.println(res1);



    }

}


class NumArray
{
    int[] nums;
    Vector<Integer> sums = new Vector<>();

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i-1];                           //i位置元素代表0~i的sum

        this.nums = nums;
    }

    public NumArray(Vector<Integer> sums) {
        for (int i = 0; i < sums.size(); i ++)
        {
            if (i == 0)
                this.sums.add(sums.get(i));
            else
                this.sums.add(sums.get(i) + this.sums.lastElement());
        }
    }

    public int sumRange(int i, int j)
    {
        if (i == 0)
            return nums[j];

        return nums[j]-nums[i-1];                           //i~j的sum 等于0~j - 0~i-1的sum
    }

    public int sumRange1(int i,int j)
    {
        if (i == 0)
            return sums.get(j);

        return sums.get(j)-sums.get(i-1);
    }
}