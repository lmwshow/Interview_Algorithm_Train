package offer;

/**
 * Created by Gracecoder on 2017/12/16.
 *
 * 模拟大数+1 打印
 *
 * 全排列  递归
 */
public class 打印从1到最大的n位数 {

    public static void print1tomaxNDigits(int n)
    {
        if (n < 0)
            System.out.println("输入错误");
        int[] number = new int[n];

        while (!Increment(number))
            printNumber(number);

    }

    private static void printNumber(int[] number) {

        boolean isBeginning=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning&&number[i]!=0)
                isBeginning=false;
            if(!isBeginning){
                System.out.print(number[i]);
            }
        }
    }

    private static boolean Increment(int[] number) {

        boolean isOverflow = false;
        int nTakeOver = 0;

        for (int i = number.length - 1 ; i >=0 ; i --)
        {
            int nSum = number[i] + nTakeOver;
            if (i == number.length - 1)                     //加1 只在个位上加
                nSum ++;

            if (nSum > 10)
            {
                if (i == 0)
                    isOverflow = true;
                else
                {
                    nTakeOver = 1;
                    nSum = nSum -10;
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


    //全排列
    //第二中方法实现，全排序实现
    public void PrintMaxOfNdigits(int[] number,int length,int index){
        if(index ==length-1){
            printNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index+1]=i;
            PrintMaxOfNdigits(number, length, index+1);
        }
    }

    public void Test1(int n){
        if(n<=0)
            return;
        int[] number = new int[n];
        for(int i=0;i<10;i++){
            number[0]=i;
            PrintMaxOfNdigits(number, n, 0);
        }
    }

}
