
public class MergeSort {

    //归并排序需要辅助空间
    static boolean MergeSort(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return true;

        int[] tmp = new int[nums.length];

        mergeSort(nums,0,nums.length-1,tmp);

        for (int x : nums)
            System.out.println(x);


        return true;
    }

    private static void mergeSort(int[] nums, int left, int right, int[] tmp) {

        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;

            mergeSort(nums,left,mid,tmp);
            mergeSort(nums,mid+1,right,tmp);
            mergeArray(nums,left,mid,right,tmp);

        }

    }

    //将两个有序序列a[left...mid] b[mid+1....right]合并
    private static void mergeArray(int[] nums, int left, int mid, int right, int[] tmp) {

        int i = left;
        int j = mid+1;
        int index = 0;

        while (i <= mid && j <= right)
        {
            if (nums[i] < nums[j])
                tmp[index++] = nums[i++];
            else
                tmp[index++] = nums[j++];
        }

        while (i <= mid)
            tmp[index++] = nums[i++];
        while (j <= right)
            tmp[index++] = nums[j++];

        for (i = 0 ; i < index ;i++)
            nums[left+i] = tmp[i];

    }




    //辅助空间由原数组克隆，然后轮流当辅助数组，减少了合并数组过程中，辅助数组将结果赋值回来的过程
    //但是这样子，不能确定最终 copy 是ans 还是 nums是ans，这种方法用来求逆序对倒可行
    static boolean MergeSort2(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return true;

        int[] copy = nums.clone();

        //参数为 num copy
        mergeSort2(nums,0,nums.length-1,copy);

        for (int x : nums)
            System.out.println(x);


        return true;
    }

    private static void mergeSort2(int[] nums, int left, int right, int[] copy) {

        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;

            //这里参数是 copy  nums
            mergeSort2(copy,left,mid,nums);
            mergeSort2(copy,mid+1,right,nums);


            int i = left;
            int j = mid + 1;
            int index = left;
            while (i <= mid && j <= right)
            {
                if (nums[i] < nums[j])
                    copy[index++] = nums[i++];
                else
                    copy[index++] = nums[j++];
            }

            while (i <= mid)
                copy[index++] = nums[i++];
            while (j <= right)
                copy[index++] = nums[j++];
        }
    }


    public static void main(String[] args){

        long start = System.currentTimeMillis();
        MergeSort(new int[]{3,5,1,2,4,6,8,9,123,12,1,2,4,745,3,7,3,4,5,7,23,-3});
        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }
}
