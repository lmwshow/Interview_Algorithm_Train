package offer;

public class 题56_数组中只出现一次的数字 {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : array)
            diff ^= num;

        // Get its last set bit
        //理解为通过判断第n位是否为1，来将原数组分为两个子数组，每个里面包含一个singlenumber，其他都出现2次
        diff = Integer.highestOneBit(diff);

        for (int x : array)
        {
            if ((diff & x) == 0)
                num1[0] ^= x;
            else
                num2[0] ^= x;
        }

        return;

    }

    public static void main(String[] args){

        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(new int[]{1,1,2,2,3,4,4,5,5,6,7,7},num1,num2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);




    }
}
