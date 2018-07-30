package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/26 16:45
 * @Description:
 */
public class 数组中的逆序对 {

    static int ans = 0;
    public static int InversePairs(int... array) {

        ans = 0;
        if (array == null || array.length < 2)
            return ans;

        int[] tmp = new int[array.length];

        mergeSort(array,0,array.length-1,tmp);

        return ans;
    }

    private static void mergeSort(int[] array, int left, int right, int[] tmp) {

        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;

            mergeSort(array,left,mid,tmp);
            mergeSort(array,mid+1,right,tmp);
            mergeArray(array,left,mid,right,tmp);
        }

    }

    private static void mergeArray(int[] array, int left, int mid, int right,int[] tmp) {

        int i = left;
        int j = mid+1;
        int index = 0;

        while (i <= mid && j <= right)
        {
            if (array[i] <= array[j])
                tmp[index++] = array[i++];
            else
            {
                tmp[index++] = array[j++];
                ans += mid - i +1;
                ans %= 1000000007;
            }

        }

        while (i <= mid)
            tmp[index++] = array[i++];
        while (j <= right)
            tmp[index++] = array[j++];

        for (int k = 0 ; k < index ; k++)
        {
            array[left+k] = tmp[k];
        }

    }

    public static void main(String[] args){

        System.out.println(InversePairs(7,5,6,4));
    }
}
