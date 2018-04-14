package leetgroup.数组;


import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/8/19.
 *
 * dfs 在leetcode 上超时
 */
public class three_sum_closest {

    private static int closest;
    private static boolean needInit;

    public static int threeSumClosest(int[] num, int target) {
        closest = 0;
        needInit = true;                            //用于初始化closest,如果直接赋值Interger.MAX， 怕第一次算记录的时候 可能会溢出.
        Arrays.sort(num);                           //排序，对这种问题，如果时间复杂度允许，先排序


        //基本思想是：
        //先确定一个数,然后剩下两个数，从两段开始取，根据两段和与target的比较，往中间缩
        //如果后一个数和前一个相等，那么这种情况前面已经讨论过了，就直接跳过

        int i = 0;
        for (i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            judgeAndPut(num, i, i + 1, num.length - 1, target);
        }
        return closest;
    }

    private static void judgeAndPut(int[] num, int i, int p, int q, int target) {

        while (p < q) {
            int sum = num[i] + num[p] + num[q];
            if (needInit || Math.abs(sum - target) < Math.abs(closest - target)) {
                closest = sum;
            }
            needInit = false;

            if (sum <= target) {
                p++;
                while (p < q && num[p] == num[p - 1]) {
                    p++;
                }
            } else if (sum > target){
                q--;
                while (p < q && num[q] == num[q + 1]) {
                    q--;
                }
            }
        }

    }

//    private static int mindistance = Integer.MAX_VALUE;
//    private static int finalsum = 0;
//
//    static class Res{
//        int sum = 0;
//        int mindistance = Integer.MAX_VALUE;
//    }
//
//    public static int threeSumClosest(int[] nums, int target) {
//
//        int len = nums.length;
//
//        if (len < 3)
//            return finalsum;
//
//
//        Res res = new Res();
//
//        int[] visit = new int[len];
//
//
//        dfs(res,nums,0,visit,target,0,0);
//
//        return res.sum;
//
//    }
//
//    private static void dfs(Res res,int[] nums,int start, int[] visit, int target,int cursize,int cursum) {
//
//        if (cursize == 3)
//        {
//            int curdistance = Math.abs(target - cursum);
//            if (res.mindistance > curdistance) {
//                res.mindistance =curdistance;
//                res.sum = cursum;
//            }
//            return;
//        }
//
//        for (int i = start ; i < nums.length ; i++)
//        {
//            if (visit[i] == 1)
//                continue;
//
//            visit[i] = 1;
//            dfs(res,nums,i+1,visit,target,cursize+1,cursum+nums[i]);
//            visit[i] = 0;
//
//        }
//
//    }


    public static void main(String[] args){

        int res = threeSumClosest(new int[]{1,1,-1},0);

        System.out.println(res);

    }
}
