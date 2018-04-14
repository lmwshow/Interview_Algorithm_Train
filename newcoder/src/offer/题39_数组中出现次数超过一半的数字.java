package offer;

public class 题39_数组中出现次数超过一半的数字 {

    //发现如果是排序好的，那么数组最中间的数 必然就是这个数字(存在的话)
    //但是排序本身就是O（nlogn）  如果转化为求第n/2个数的话，就有现成的O（n）的算法
    //即 快速排序的 Patition 部分

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


    public static void main(String[] args){


        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,5,4}));

    }
}
