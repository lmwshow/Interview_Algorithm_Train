package offer.again;

public class 题39_数组中出现次数超过一半的数字 {

    //发现如果是排序好的，那么数组最中间的数 必然就是这个数字(存在的话)
    //但是排序本身就是O（nlogn）  如果转化为求第n/2个数的话，就有现成的O（n）的算法
    //即 快速排序的 Patition 部分


    //solution2: 如果要求不能改变数组，那可以根据数组的性质，超过一半的数字出现的个数 比 其他所有数字出现的次数都多
    //用两个变量，保存当前的数字，另一个保存当前数字出现的个数，读取下一个数，与当前数相同的话 次数+1  否则次数减1 当次数为0时，换成下一个数 次数置为1.
    //那么最后一个把次数变为1的就是  我们要找的数

    public static int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length ==0)
            return 0;

        int left = 0;
        int right = array.length - 1;
        int mid = array.length >> 1;
        int index = Patition(array,left,right);

        while (index != mid)
        {
            if (index < mid)
                index = Patition(array,index+1,right);
            else
                index = Patition(array,left,index-1);
        }

        int res = array[mid];
        int time = 0;

        //判断x的个数是否超过一半

        for (int x : array)
            if (x == res)
                time++;

        if ((time << 1) > array.length)
            return res;
        else
            return 0;
    }

    private static int Patition(int[] array, int left, int right) {

        int key = array[left];

        while (left < right)
        {
            while (left < right && array[right] >= key)
                right--;
            array[left] = array[right];
            while (left < right && array[left] <= key)
                left++;
            array[right] = array[left];
        }

        array[left] = key;
        return left;
    }



    //solution2

    public static int MoreThanHalfNum_Solution2(int [] array) {

        if (array == null || array.length ==0)
            return 0;

        int res = array[0];
        int time = 1;

        for (int i = 1 ; i < array.length ; i++)
        {
            if (array[i] == res)
                time++;
            else
            {
                time--;
                if (time==0)
                {
                    res = array[i];
                    time = 1;
                }
            }
        }

        time = 0;

        //判断x的个数是否超过一半

        for (int x : array)
            if (x == res)
                time++;

        if ((time << 1) > array.length)
            return res;
        else
            return 0;
    }


    public static void main(String[] args){


        System.out.println(MoreThanHalfNum_Solution2(new int[]{1,2,3,2,2,5,4,2}));

    }
}
