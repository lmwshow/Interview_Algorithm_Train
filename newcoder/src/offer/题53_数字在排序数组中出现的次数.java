package offer;

public class 题53_数字在排序数组中出现的次数 {



    public static int GetNumberOfK(int [] array , int k) {

        if (array == null || array.length == 0)
            return 0;

        int first = GetFirstK(array,k);
        int last = GetLastK(array,k);

        if (first > -1 && last > -1)
            return last - first +1;
        else
            return 0;

    }

    private static int GetLastK(int[] array, int k) {
        int l = 0;
        int r = array.length-1;

        while (r >= l) {

            if (l < 0 || r >= array.length)
                return -1;
            int mid = ((r - l) >> 1) + l;

            if (array[mid] == k) {
                if ((mid < array.length -1 && array[mid + 1] != k) || mid == array.length-1)
                    return mid;
                else
                    l = mid + 1;
            }
            else if (array[mid] > k)
                r = mid - 1;
            else
                l = mid + 1;

        }

        return -1;
    }

    private static int GetFirstK(int[] array, int k) {

        int l = 0;
        int r = array.length-1;

        while (r >= l) {
            if (l < 0 || r >= array.length)
                return -1;

            int mid = ((r - l) >> 1) + l;

            if (array[mid] == k) {
                if ((mid > 0 && array[mid - 1] != k) || mid == 0)
                    return mid;
                else
                    r = mid - 1;
            }
            else if (array[mid] > k)
                r = mid - 1;
            else
                l = mid + 1;

        }


        return -1;

    }

    public static void main(String[] args){

        System.out.println(GetNumberOfK(new int[]{1,3,3,3,3,4,5},2));

    }
}
