package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/17 10:19
 * @Description:
 *
 * 1. 用数组模拟大数 +1, 关键点为如何快速判断是否到达最大数(最高位产生进位),打印数字的时候不能打印前置0
 *
 * 2. 全排列 递归实现，其实就是n个0-9的全排列
 */
public class 打印从1到最大的n位数 {

    public static void print1ToMaxNDigits(int n){

        if (n < 0)
            return;

        int[] number = new int[n];

        while (!Increment(number))
            printNumber(number);

    }

    private static void printNumber(int[] number) {

        boolean isBegining = true;
        for (int i = 0; i < number.length; i++){

            if (isBegining && number[i]!=0)
                isBegining = false;
            if (!isBegining)
                System.out.print(number[i]);
        }
    }

    private static boolean Increment(int[] number) {

        boolean isOverflow = false;
        int nTakeOver = 0;

        for (int i = number.length - 1; i >= 0 ; i--)
        {
            int nSum = number[i] + nTakeOver;
            if (i == number.length - 1)              //加1 只在个位上加
                nSum++;

            if (nSum >= 10)
            {
                if (i == 0)
                    isOverflow = true;
                else {

                    nTakeOver = 1;
                    nSum -= 10;
                    number[i] = nSum;

                }
            }else
            {
                number[i] = nSum;
                break;
            }
        }

        return isOverflow;

    }


    // 全排列
    public void print1ToMaxNDigits2(int n)
    {
        if (n <= 0)
            return;
        int[] number = new int[n];

        for (int i = 0 ; i < 10 ; i++)
        {
            number[0] = i;
            print1ToMaxNDigitsRecursively(number,n,0);
        }
    }

    private void print1ToMaxNDigitsRecursively(int[] number, int len, int index) {

        if (index == len - 1)
        {
            printNumber(number);
            return;
        }

        for (int i = 0 ; i < 10 ; i++)
        {
            number[index + 1] = i;
            print1ToMaxNDigitsRecursively(number,len,index+1);
        }
    }


    public static void main(String[] args){

        print1ToMaxNDigits(2);

    }
}
