package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/27 10:49
 * @Description
 *
 * 由于数组中有两个数字只出现一次，其他都出现两次，故将所有元素的异或结果 == A^B
 *
 * 我们可以通过 A^B 的结果 ，找到A，B某个不同位， 即位值=1的，说明在该为上A与B不同
 *
 * 根据这个不同位，可以将原数组分为两个子数组，同时AB在不同的子数组中
 */
public class 数组中只出现一次的数字 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array == null || num1 == null || num2 == null)
            return;

        int diff = 0;

        for (int x : array)
            diff ^= x;

        diff = Integer.highestOneBit(diff);
        //理解为通过判断第n位是否为1，来将原数组分为两个子数组，每个里面包含一个singlenumber，其他都出现2次
        //diff 的高位是1，其他为都是0

        for (int x : array)
        {
            if ((x & diff) == 0)
                num1[0] ^= x;
            else
                num2[0] ^= x;
        }

        return;

    }
}
