package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/17 08:20
 * @Description: https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * <p>
 * 归并排序的应用
 */
public class 数组中的逆序对 {

    public static int InversePairs(int[] array) {

        int count = 0;
        if (array == null || array.length == 0)
            return count;

        int[] copy = array.clone();

        count = InversePairsCore(array, copy, 0, array.length - 1);

        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int start, int end) {

        if (start >= end) {
            if (start == end)
                copy[start] = array[start];
            return 0;
        }

        int mid = ((end - start) >> 1) + start;

        //轮流当辅助数组，减少了合并数组过程中，辅助数组将结果赋值回来的过程。但是这样子，不能确定最终有序数组 copy还是 nums，这种方法用来求逆序对倒可行
        int left = InversePairsCore(copy, array, start, mid);
        int right = InversePairsCore(copy, array, mid + 1, end);

        //合并，当左边大于右边时，逆序对增加右边剩余元素的个数
        int count = 0;
        int i = mid;
        int j = end;
        int index = end;

        while (i >= start && j > mid) {
            if (array[i] > array[j]) {
                copy[index--] = array[i--];
                count += j - mid;
                count %= 1000000007;
            } else
                copy[index--] = array[j--];
        }

        while (i >= start)
            copy[index--] = array[i--];
        while (j > mid)
            copy[index--] = array[j--];

        return (left + right + count) % 1000000007;
    }


    public static void main(String[] args){

        System.out.println(InversePairs(new int[]{1,2,3,0}));

    }
}
