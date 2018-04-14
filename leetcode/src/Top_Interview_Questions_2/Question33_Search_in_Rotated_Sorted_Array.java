package Top_Interview_Questions_2;

public class Question33_Search_in_Rotated_Sorted_Array {

    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = ((right -left) >> 1) + left;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if ((nums[left] <= target) && (nums[mid] > target)) right = mid - 1;
                else left = mid + 1;
            } else {
                if ((nums[mid] < target) && (nums[right] >= target)) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;

    }


    public static void main(String[] args){

        System.out.println(search(new int[]{2,4,5,9,-2,-1,0},-3));

    }

}