package Top_Interview_Questions_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question46_全排列 {
    
    //全排列 三种 递归 递归去重  非递归
    
    public static List<List<Integer>> permute(int[] nums){
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            return ans;
        
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        
        //全排列递归 就是对每个元素，和其之后的元素依次交换得到序列
        getAllPermutations(ans,tmp,nums,0);

        return ans;
    }

    private static void getAllPermutations(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int cur) {
        
        if (tmp.size() == nums.length)
        {
            ans.add(new ArrayList<>(tmp));
            return;
        }else 
        {
            for (int i = cur; i < nums.length; i++)
            {
                swap(nums,cur,i);
                tmp.add(nums[cur]);
                getAllPermutations(ans,tmp,nums,cur+1);
                tmp.remove(tmp.size()-1);
                swap(nums,cur,i);
            }
        }
        
    }

    private static void swap(int[] nums, int left, int right) {
        
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        
    }
    
    
    public static void main(String[] args){

        List<List<Integer>> ans = permute(new int[]{3,2,1});
        
        for (List<Integer> tmp : ans)
        {
            for (int x : tmp)
                System.out.println(x);
                
            System.out.println();
            
        }


    }
}
