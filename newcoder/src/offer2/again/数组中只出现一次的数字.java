package offer2.again;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/5/18 08:02
 * @Description: https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class 数组中只出现一次的数字 {

    /*显然，对于找出只出现一次的数字，可以使用异或运算，关键是这里有两个数字出现一次
      也就是说，遍历array进行异或运算,只能获得a^b的结果，而不能得到a,b的值

      如果数组中只含有一个数为一次，那么就可得到这个数。 那能不能把array转化成两个子数组，每个数组中只含一个只出现一次的数呢？
      根据 a^b 的结果，找到最高一位为1的数，由于a,b在这一位上是不同的，可以通过Integer.highestOneBit 构造一个该位为1，其他都为0的数
      然后用它(通过与运输)将数组分为两个子数组，一个子数组的元素在该位为1，另一个子数组的元素在该位均为0，所以a,b分别在其中一个数组。
    */
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int x : array)
            diff ^= x;

        // Get its last set bit
        //理解为通过判断第n位是否为1，来将原数组分为两个子数组，每个里面包含一个singlenumber，其他都出现2次
        //diff 的高位是1，其他为都是0
        diff = Integer.highestOneBit(diff);

        for (int x : array) {
            if ((x & diff) == 0)
                num1[0] ^= x;
            else
                num2[0] ^= x;
        }
        return;

    }


    //使用辅助空间
    public static void MW_FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : array)
            map.put(x, map.getOrDefault(x, 0) + 1);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1)
                iterator.remove();
        }

        int[] ans = new int[2];

        int index = 0;
        for (Map.Entry entry : map.entrySet())
            ans[index++] = (int) entry.getKey();

        num1[0] = ans[0];
        num2[0] = ans[1];

    }

    public static void main(String[] args) {

        int[] num1 = new int[1];
        int[] num2 = new int[1];

        FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
    }
}
