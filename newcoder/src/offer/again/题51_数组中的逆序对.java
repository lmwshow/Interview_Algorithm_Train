package offer.again;

//归并排序的时间复杂度是O(nlogn) 比直观的O(n^2)要快
//但同时归并排序需要一个长度为n的辅助数组，相当于用空间换来时间
public class 题51_数组中的逆序对 {

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

        System.out.println(InversePairs(new int[]{1,2,3,0}));

    }
}
