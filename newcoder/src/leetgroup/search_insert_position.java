package leetgroup;

/**
 * Created by Gracecoder on 2017/8/4.
 */
public class search_insert_position {

    public static int searchInsert(int[] A, int target) {

        int length = A.length;

        if (length == 0)
            return 0;

        int low = 0 ;
        int high = A.length - 1;
        int mid = 0;
        while (low <= high)
        {
            mid = (low + high )/2;

            if (A[mid] == target)
                return mid;
            else if (A[mid] < target)
                low = mid + 1;
            else
                high = mid -1;
        }

        return low;
    }

    public static void main(String[] args){

        int res = searchInsert(new int[]{1,3,5,6},0);

        System.out.println(res);

    }
}
