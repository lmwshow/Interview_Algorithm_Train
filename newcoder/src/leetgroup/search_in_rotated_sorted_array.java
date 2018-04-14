package leetgroup;

/**
 * Created by Gracecoder on 2017/7/22.
 */
public class search_in_rotated_sorted_array {

    /*
	 * 用二分查找最小值的 index，即rotated的位置
	 * 这样的旋转 相当于右移
	 * 找出rot的位置
	 * realmid = （mid + rot）%length
	 */

    public int search(int[] A, int target) {

        int length = A.length;
        if(length == 0)
            return -1;
        int left = 0;
        int right = length-1;
        while(left < right)
        {
            int mid = (left +right)/2;
            if(A[mid] > A[right])
                left = mid +1;
            else
                right = mid;
        }
        int rot = left;
        left = 0;
        right = length-1;

        while(left <= right)
        {
            int mid = (left + right )/2;
            int realmid = (mid+rot)%length;
            if(A[realmid] == target) return realmid;
            if(A[realmid] < target)
                left = mid+1;
            else
                right = mid-1;
        }

        return -1;
    }
}
