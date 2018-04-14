package offer.again;

/**
 * Created by Gracecoder on 2017/12/8.
 *
 * 对于排序或者部分排序的队列，都可以用二分查找
 *
 * 这里旋转数组，可以通过和array[0] 和 array[length-1] 比较大小，判断当前的位置在哪一段
 *
 * 旋转数组分为两段递增序列，要找的最小值，就是第二段的开头,而它与第一段结尾相邻，相距为1.
 *
 * 第一段的开头 大于 或者 等于 第二段结尾
 * 有两种:
 *      1.当旋转后仍是排序序列，即元素都一样
 *      2.当array[left]==array[right]==array[mid] 无法判断 mid 是在哪一段序列中 比如1,0,1,1,1 和1，1，1，0，1 此时只能顺序查找
 */
public class 题11_旋转数组的最小数字 {

    public static int minNumberInRotateArray(int [] array) {

        if(array == null||array.length == 0)
            return 0;

        int left = 0 ;
        int right = array.length - 1;
        int mid = 0;

        while (array[left]>=array[right])
        {
            if (right - left == 1)
                return array[right];

            mid = (right - left)/2 + left;

            if (array[left] == array[right] && array[left] == array[mid])
                return minInOrder(array,left,right);

            if (array[mid] >= array[left])
                left = mid;
            else if (array[mid] <= array[right])
                right = mid;
        }

        return array[mid];

    }

    private static int minInOrder(int[] array, int left, int right) {
        int res = array[left];

        for (int i = left + 1; i <= right ; i++)
            if (array[i]<res)
                res = array[i];

        return res;
    }


    public static void main(String[] args){

        System.out.println(minNumberInRotateArray(new int[]{1,0,1,1,1}));


    }
}
