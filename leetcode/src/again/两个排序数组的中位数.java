package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/6 21:16
 * @Description: http://blog.csdn.net/hk2291976/article/details/51107543
 */
public class 两个排序数组的中位数 {

    /*
    要求在log(n+m)的复杂度内找出中位数
    割的思想，通过切一刀，将有序数组分为左右两个部分，如果切在数字上，表示该数字被划分到左右两个子数组
    左边最大值Li,右边最小值Ri
    当L1 <= R2 && L2 <= R1 , 那么说明这个割是在正确的位置!
    如果L1 > R2,那么说明L1需要左移，R2需要右移
    如果L2 > R1,那么说明R1需要右移，L2需要左移

    对于找第k个数，确定了第一个数组割的位置，第二个数组的位置也就确定了!
    针对两个数组取中位数，涉及到奇偶问题。
    想办法让两个数组长度相加一定为奇数或者偶数：虚拟加入‘#’(这个trick在manacher算法中也有应用)，让单个数组长度恒为奇数（2n+1恒为奇数）。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1==null || nums1.length == 0)
            return MedOfArray(nums2);
        if (nums2==null || nums2.length == 0)
            return MedOfArray(nums1);

        int n = nums1.length;
        int m = nums2.length;

        //保证数组1一定最短，减少二分次数
        if (n > m)
            return findMedianSortedArrays(nums2,nums1);

        //我们目前是虚拟加了'#'所以数组1是2*n+1长度 让数组恒为奇数
        int L1 = 0,L2 = 0,R1 = 0,R2 = 0,c1,c2,lo = 0,hi = 2*n;

        /*
            在虚拟数组里表示“割”
            不仅如此，割更容易，如果割在‘#'上等于割在2个元素之间，割在数字上等于把数字划到2个部分。

            奇妙的是不管哪种情况：
            Li = (Ci-1)/2
            Ri = Ci/2
         */

        //二分
        while (lo <= hi)
        {
            //c1 是二分的结果
            c1 = ((hi - lo) >> 1) + lo;

            //本来是 (m+n)/2 - c1 现在c1已经是虚拟后的结果， (2*m + 2*n)/2 = m +n
            c2 = m + n - c1;

            L1 = c1 == 0? Integer.MIN_VALUE : nums1[(c1 - 1) >> 1];//map to original element
            R1 = c1 == 2*n? Integer.MAX_VALUE : nums1[c1 >> 1];
            L2 = c2 == 0? Integer.MIN_VALUE : nums2[(c2 - 1) >> 1];
            R2 = c2 == 2*m ? Integer.MAX_VALUE : nums2[c2 >> 1];

            if (L1 > R2)
                hi = c1 - 1;
            else if (L2 > R1)
                lo = c1 + 1;
            else
                break;

        }

        return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;


    }

    private double MedOfArray(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;


        return (nums[nums.length >> 1] + nums[(nums.length-1) >> 1])/2.0;
    }
}
