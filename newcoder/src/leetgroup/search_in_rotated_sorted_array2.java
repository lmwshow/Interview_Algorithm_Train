package leetgroup;

/**
 * Created by Gracecoder on 2017/7/22.
 */
public class search_in_rotated_sorted_array2 {

    public boolean search(int[] A, int target) {

        int left = 0, right = A.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (A[mid] == target) return true;

            // 题1 也可以用这种方法， 只需要把这个if 去掉即可
            // the only difference from the first one, trickly case, just updat left and right
            if ((A[left] == A[mid]) && (A[right] == A[mid])) {
                ++left;
                --right;
            } else if (A[left] <= A[mid]) {
                if ((A[left] <= target) && (A[mid] > target)) right = mid - 1;
                else left = mid + 1;
            } else {
                if ((A[mid] < target) && (A[right] >= target)) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

}
