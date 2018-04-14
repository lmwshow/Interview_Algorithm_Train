package 网易3_27;

import java.util.*;

public class Main1 {

    static int ans ;

    public static int Permutation(int[] nums) {

        if (nums == null || nums.length < 2)
            return ans;

        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);

        do{

            for (int x : nums)
                tmp.add(x);
            ans = Math.max(ans,solver(tmp));
            tmp.clear();
        }while (nextPermutation(nums));

        return ans;

    }

    private static int solver(List<Integer> tmp) {

        int curScore = 0;
        int curSum = 0;
        for (int x : tmp)
        {
            curScore += (curSum%10)*x;
            curSum += x;
        }

        return curScore;

    }


    public static boolean nextPermutation(int[] nums) {

        if (nums == null || nums.length < 2)
            return true;

        int i = nums.length - 2;

        for (; i >= 0 ; i--)
        {
            if (nums[i] < nums[i+1]) {
                int find = nums.length-1;
                while (nums[find] <= nums[i])
                    find--;
                swap(nums, i, find);
                reverse(nums,i+1);
                return true;
            }

        }

        reverse(nums,0);
        return false;

    }

    //利用swap 来逆转
    private static void reverse(int[] nums, int start) {

        int end = nums.length - 1;
        while (start < end)
            swap(nums,start++,end--);
        return;
    }

    private static void swap(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int[] nums = new int[a+b+c+d];
        int m1 = in.nextInt();
        int index = 0;
        for (int i = 0; i < a;i++)
            nums[index++] = m1;
        int m2 = in.nextInt();
        for (int i = 0; i < b;i++)
            nums[index++] = m2;
        int m3 = in.nextInt();
        for (int i = 0; i < c;i++)
            nums[index++] = m3;
        int m4 = in.nextInt();
        for (int i = 0; i < d;i++)
            nums[index++] = m4;

        ans = 0;

        System.out.println(Permutation(nums));


    }


}
