package newcoder_2018_2_25;

import java.util.Scanner;

public class 逆序数 {


    public static int InversePairs(int [] array) {

        if (array == null || array.length == 0)
            return 0;

        int[] copy = array.clone();

        int count = InversePairsCore(array,copy,0,array.length-1);

        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int start, int end) {

        if (start >= end)
        {
            if (start == end)
                copy[start] = array[start];
            return 0;
        }

        int mid = ((end - start) >> 1) + start;

        int left = InversePairsCore(copy,array,start,mid);
        int right = InversePairsCore(copy,array,mid+1,end);

        int count = 0;

        int i = mid;
        int j = end;
        int index = end;

        while (i >= start && j > mid)
        {
            if (array[i] > array[j])
            {
                copy[index--] = array[i--];
                count += j - mid;
                count %= 1000000007;
            }
            else
                copy[index--] = array[j--];
        }

        while (i >= start)
            copy[index--] = array[i--];
        while (j > mid)
            copy[index--] = array[j--];


        return (left+ right + count) % 1000000007;



    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];

        for (int i = 0 ; i< n ; i++)
            nums[i] = in.nextInt();

        long res = 0;
        for (int i = 0 ; i < n ; i++)
        {
            for (int j = i + 1; j < n ; j++)
                if (nums[j] <= nums[i])
                    res++;
        }


        System.out.println(res);


    }
}
