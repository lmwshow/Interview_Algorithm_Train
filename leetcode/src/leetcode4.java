import java.util.Arrays;

/**
 * Created by limingwei on 16/12/7.
 */
public class leetcode4 {


    //采用数组合并的思想,然后取其第k个数,但是时间复杂度为O(m+n),不符合O(log(m+n))
    public static double findMedianSortedArrays(int[] nums1,int[] nums2)
    {

        int length1,length2,length,i=0,j=0,indexx = 0,indexy = 0;
        int flag = 0;
        length1 = nums1.length;
        length2 = nums2.length;
        length = length1 + length2;
        double res;

        if (length % 2 ==0)
        {
            flag = 0;
            indexx = length/2 - 1;
            indexy = length/2;
        }else
        {
            flag = 1;
            indexx = length / 2;
        }

        int[] nums3 = new int[length];
        int k = 0;

        while ( i < length1 && j <length2 )
        {
            nums3[k++] = nums1[i] < nums2[j] ? nums1[i++]:nums2[j++];
        }

        if ( k > (length / 2))
        {
            if (flag == 0)
                res = (double)(nums3[indexx]+nums3[indexy])/2.0;
            else
                res = (double)nums3[indexx];
        }
        else if (k == (length / 2))
        {
                if (i < length1)
                    if (flag == 0 )
                        res = (double)(nums3[k-1] + nums1[i])/2.0;          //i  此时指向 nums1 的下一个元素,k-1表示当前合并nums3的最后一个元素
                    else
                        res = (double)nums1[i];
                else
                    if (flag == 0)
                        res = (double)(nums3[k-1] + nums2[j])/2.0;
                    else
                        res = (double)nums2[j];
        }
        else
        {

            if (i < length1)
            {
                if (flag == 0)
                    res = (double)(nums1[i + length/2 - k - 1] + nums1[i + length/2 - k])/2.0;
                else
                    res = (double)nums1[i + length/2 - k];


            }
            else {
                if (flag == 0)
                    res = (double) (nums2[j + length/2 - k - 1] + nums2[j + length/2 - k]) / 2.0;
                else
                    res = (double) nums2[j + length/2 - k];

            }

        }

        return res;

    }


    /**
     * 类似二分查找，复杂度O(log(m+n))
     * 第一步，我们需要将题目改为寻找第k小的元素findKthSortedArrays。（这里k从1开始计算）
     * 第二部：实现findKthSortedArrays
     * @param nums1,nums2
     */


    public static double betterSolution(int[] nums1,int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0 )
            return (findKthSortedArrays(nums1,m,nums2,n,(m + n)/2)+findKthSortedArrays(nums1,m,nums2,n,(m + n)/2 + 1)) / 2.0;
        else
            return findKthSortedArrays(nums1,m,nums2,n,(m + n)/2 +1);

    }

    public static double findKthSortedArrays(int[] A , int m , int[] B ,int n , int k)
    {
        //首先确定A的长度比B小
        if (m > n)
            return findKthSortedArrays(B,n,A,m,k);

        //特殊情况:A为空的时候  不拿出来,会导致空指针异常  第k个元素 在数组中的下标为k - 1
        if (m == 0)
            return B[k - 1];

        //特殊情况2: k == 1 取第一个,此时 m已经确保大于 0
        if (k == 1)
            return Math.min(A[0],B[0]);

        int Acandi,Bcandi;              //A , B中选出的那个关键位置

        //这里需要斟酌一下：为什么不是k/2？ k/2±1？而是(k-1)/2
        //我的思考如下：
        //如果k==1,2，就是需要比较头两个元素，因此下标为0
        //如果k==3,4，就是需要比较第1个元素，因此下标为1
        if ((k - 1) / 2 >= m)
        {
            //数组下标是k,前面还有k个数
            //此时A[(kth-1)/2]已经越界 Acandi只能取A[m-1]  则Bcandi取 B[kth - m -1]
            Acandi = A[m-1];
            Bcandi = B[k - m - 1];

            if (Acandi == Bcandi)
                return Acandi;          //或者Bcandi 此时正好有m-1+k-m-1 = k -2 个数 比Acandi小

            //Acandi > Bcandi时
            //此时最多只有k-2个数比B[k - m -1 ]要小,也就是说Bcandi必然不可能是第k位,当时Acandi仍有可能是
            //所以A不变,舍弃B的前k-m个数, 下标从k-m到n-1,copyOfRange from应该是首元素下标,to是末元素下标+1
            else if (Acandi > Bcandi)
                return findKthSortedArrays(A,m, Arrays.copyOfRange(B,k-m,n),n-(k-m),k-(k-m));
            else
                return B[k-m-1];

        }

        else
        {
            //k=1,2->index 0; k =3,4->index1
            Acandi = A[(k-1)/2];
            Bcandi = B[(k-1)/2];

            if (Acandi == Bcandi)
                return Acandi;

            else if (Acandi > Bcandi)
            {
                //Acandi前面有(k-1)/2个数,Bcandi同理,所以这个序列总共有k+1个数,其中Acandi最大
                //最多只有k-1个数比Bcandi小,所以第k个数最小的情况是Bcandi,最大的情况是Acandi前一位(所以B的前半段,和A以及A的后半段肯定要删去的)
                //这种只是在我们事实上寻找的中间位就是K的情况下(当k为奇数时,没有偏差)
                //但当k为偶数时,偏移量需要往后一位,那就是第k个数最小是Bcandi后一位了,最大是Acandi,即保留A 删除B
                //k为偶数时，最多只有k-2个数比Bcandi小，所以第k个数是最大是A，最小是Bcandi的后一位
                //eg.k=8 时，A[3]>B[3],前面就只有6个数， 所以B[3]不可能是第8个

                //k值的改变是根据第k个之前的数被删多少而改变的, 后半段的删除不会造成影响
                if (k % 2 == 1)
                    //保留B,删除A
                    return findKthSortedArrays(Arrays.copyOfRange(A,0,(k-1)/2),(k-1)/2,Arrays.copyOfRange(B,(k-1)/2,n),n - (k-1)/2,k-(k-1)/2);

                else
                    //保留A,删除B
                    return findKthSortedArrays(Arrays.copyOfRange(A,0,(k-1)/2 + 1),(k-1)/2 + 1,Arrays.copyOfRange(B,(k-1)/2 +1,n),n -((k-1)/2+1),k- ((k-1)/2 +1));


            }
            else
            {
                if (k % 2 == 1)
                    return findKthSortedArrays(Arrays.copyOfRange(A,(k-1)/2,m),m - (k-1)/2,Arrays.copyOfRange(B,0,(k-1)/2),(k-1)/2,k-(k-1)/2);
                else
                    return findKthSortedArrays(Arrays.copyOfRange(A,(k-1)/2 + 1,m),m-((k-1)/2+1),Arrays.copyOfRange(B,0,(k-1)/2 + 1),(k-1)/2 + 1,k- ((k-1)/2 +1));


            }

        }

    }

    public static void main(String[] args){

        int[] nums = new int[]{2,3};
        int[] nums1 = Arrays.copyOfRange(nums,0,2);
        System.out.println(nums1[0]);
        System.out.println(nums1[1]);
        System.out.println(betterSolution(new int[]{2,3,4,5},new int[]{1}));
    }

}
