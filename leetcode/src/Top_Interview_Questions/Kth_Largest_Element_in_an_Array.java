package Top_Interview_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Gracecoder on 2017/10/17.
 *
 * 多种解法，O(N lg N) running time + O(1) memory
 *          O(N lg K) running time + O(K) memory
 *          O(N) best case / O(N^2) worst case running time + O(1) memory  用快排的部分
 *          O(N) guaranteed running time + O(1) space       将nums随机化
 */
public class Kth_Largest_Element_in_an_Array {

    class mycompare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2)
                return 1;
            else if (o1 == o2)
                return 0;
            else
                return -1;
        }
    }

    public int findKthLargest(int[] nums, int k) {

//        Integer[] nums1 = new Integer[]{1,2,3};
//        Arrays.sort(nums1,new mycompare());

        Arrays.sort(nums);
        return nums[nums.length - k];

    }



    public static void main(String[] args){

        Random random = new Random();
        System.out.println(random.nextInt(2));


    }
}
