package Top_Interview_Questions_2.again;

public class Question34_搜索范围 {


    public static int[] searchRange(int[] nums, int target) {


        int[] res = new int[]{-1, -1};

        int length = nums.length;

        if (length == 0)
            return res;

        int start = 0;
        int end = length - 1;
        int mid = 0;
        while (nums[start] < nums[end]) {
            mid = (start + end) / 2;
            if (target > nums[mid])
                start = mid + 1;
            else if (target < nums[mid])
                end = mid - 1;
            else {
                if (nums[start] < target) start++;
                if (nums[end] > target) end--;    //这里如果用while直接弄到=target，那就不再是二分搜索， 最坏为O(n)
            }
        }

        if (nums[start] == target) {
            res[0] = start;
            res[1] = end;
        }


        return res;
    }

    public static void main(String[] args){

        int[] ans = searchRange(new int[]{},0);

        System.out.println(ans[0]);
        System.out.println(ans[1]);



    }

}
