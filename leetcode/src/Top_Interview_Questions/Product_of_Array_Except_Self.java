package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/10/21.
 *
 * 出现0的情况，0的个数大于2 就GG。 只能有一个 记录位置和没有这个0的乘积
 *
 * better: 左右扫描一遍，通过i左边的乘积和i右边的乘积计算
 */
public class Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {

        int totalProduct = 1;
        int zeroIndex = -1;
        int zeroNums = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0)
            {
                zeroNums++;
                zeroIndex = i;
            }else
                totalProduct *= nums[i];
        }

        int[] res = new int[nums.length];

        if (zeroNums > 1)
            return res;
        if (zeroNums == 1)
        {
            res[zeroIndex] = totalProduct;
            return res;
        }

        for (int i = 0 ; i < res.length ; i++)
        {
            res[i] = totalProduct/nums[i];
        }

        return res;

    }
}
