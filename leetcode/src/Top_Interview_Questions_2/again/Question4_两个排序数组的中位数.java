package Top_Interview_Questions_2.again;

// http://blog.csdn.net/hk2291976/article/details/51107543

public class Question4_两个排序数组的中位数 {

    //割，通过切一刀，能够把有序数组分成左右两个部分，切的那一刀就被称为割(Cut)，割的左右会有两个元素，分别是左边最大值和右边最小值。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0)
            return MedOfArray(nums2);
        if (nums2.length == 0)
            return MedOfArray(nums1);

        int n = nums1.length;
        int m = nums2.length;

        //保证数组1一定最短
        if (n > m)
            return findMedianSortedArrays(nums2,nums1);

        int L1=0,L2=0,R1=0,R2=0,c1,c2,lo = 0, hi = 2*n;  //我们目前是虚拟加了'#'所以数组1是2*n+1长度 让数组恒为奇数

        /*
            在虚拟数组里表示“割”
            不仅如此，割更容易，如果割在‘#'上等于割在2个元素之间，割在数字上等于把数字划到2个部分。+

            奇妙的是不管哪种情况：
            Li = (Ci-1)/2
            Ri = Ci/2
         */

        //二分
        while (lo <= hi)
        {
            //c1是二分的结果
            c1 = (lo + hi) / 2;

            //本来是 (m+n)/2 - c1 现在c1已经是虚拟后的结果， (2*m + 2*n)/2 = m +n
            c2 = m + n - c1;

            L1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1 - 1)/2];   //map to original element
            R1 = c1 == 2*n ? Integer.MAX_VALUE : nums1[c1 / 2];
            L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];
            R2 = (c2 == 2*m)?Integer.MAX_VALUE:nums2[c2/2];

            if (L1 > R2)
                hi = c1 - 1;
            else if(L2 > R1)
                lo = c1 + 1;
            else
                break;

        }

        return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;


    }

    private double MedOfArray(int[] nums) {

        if (nums.length == 0)
            return -1;

        return (nums[nums.length/2] + nums[(nums.length-1)/2])/2.0;
    }
}
