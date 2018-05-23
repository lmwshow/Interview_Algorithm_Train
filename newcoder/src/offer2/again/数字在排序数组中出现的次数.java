package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/17 09:02
 * @Description: https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路1:使用二分找到第一个k的位置 和最后一个k的位置 然后相减，代码比较冗余
 *
 * 思路2:因为array中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5.这两个数应该插入的位置，然后相减即可。
 */
public class 数字在排序数组中出现的次数 {

    //思路2
    public static int GetNumberOfK(int [] array , int k) {


        return biSearch(array, k+0.5) - biSearch(array, k-0.5) ;
    }

    private static int biSearch(int[] array, double key) {

        int left = 0;
        int right = array.length -1;

        while (left <= right)
        {
            int mid = ((right - left) >> 1) + left;
            if (array[mid] > key)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;


    }


    static int left;
    static int right;
    //数组有序，二分找出第一个k 和最后一个k的位置
    public static int MW_GetNumberOfK(int [] array , int k) {

        if (array == null || array.length == 0)
            return 0;
        left = 0;
        right = -1;         //为了找不到的时候，返回0
        lBinarySearch(array,k,0,array.length-1);
        rBinarySearch(array,k,0,array.length-1);

        return right - left +1;

    }

    private static void lBinarySearch(int[] array, int k, int start, int end) {


        while (start <= end)
        {
            int mid = ((end - start) >> 1) + start;
            if (array[mid] == k)
            {
                if (mid == start ||array[mid-1]!=k)         //防止越界
                {
                    left = mid;
                    return;
                }else
                    end = mid - 1;
            }else if (array[mid] > k)
                end = mid - 1;
            else
                start = mid +1;

        }

        return;
    }

    private static void rBinarySearch(int[] array, int k, int start, int end) {


        while (start <= end)
        {
            int mid = ((end - start) >> 1) + start;
            if (array[mid] == k)
            {
                if (mid == end || array[mid+1]!=k)          //防止越界
                {
                    right = mid;
                    return;
                }else
                    start = mid + 1;
            }else if (array[mid] > k)
                end = mid - 1;
            else
                start = mid +1;

        }

        return;
    }


    public static void main(String[] args){

        System.out.println(GetNumberOfK(new int[]{2,2,2,2,4,5,6,8},2));
    }
}
