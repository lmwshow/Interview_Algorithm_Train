import java.util.*;

/**
 * Created by limingwei on 16/12/12.
 */
public class leetcode18 {

    // 将四个数之和,分解为求3SUM,2SUM, 时间复杂度为O(n^3)  , 但是这样还是超时,需要优化
    public static List<List<Integer>> fourSum(int[] nums,int target)
    {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0 ; i < nums.length ; i ++)
        {
            list.clear();
            list.add(nums[i]);
            threeSum(i, nums, target - nums[i], list, lists);

        }

        return lists;
    }

    public static void threeSum(int index,int[] nums,int target,List<Integer> list,List<List<Integer>> lists)
    {

        for (int i = index + 1 ; i < nums.length && (nums.length - index) >3 ; i ++ )
        {
            List<Integer> varList = new ArrayList<>();
            varList.add(nums[index]);
            varList.add(nums[i]);
            twoSum(i, nums, target - nums[i], varList, lists);
        }
    }

    public static void twoSum(int index , int[] nums , int target ,List<Integer> list,List<List<Integer>> lists)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = index + 1 ; i < nums.length ; i ++)
        {
            List<Integer> varList = new ArrayList<>();
            varList.addAll(list);
            if (map.containsKey(target - nums[i]))
            {
                map.put(nums[i],i);
                varList.add(target - nums[i]);
                varList.add(nums[i]);
                Collections.sort(varList);                  //java ArrayList 排序  升序sort,降序reverse,调用Collections类
                if (!lists.contains(varList))
                    lists.add(varList);

            }
            else
                map.put(nums[i],i);             // 因为这里不需要 下标, 用0表示未被

        }
    }

    //如果使用一个变量list , 来存每一种结果那是不行的。 将list add 到lists中时,list的指针始终指向这个地址,改变list存其他结果,会同时改变lists里的结果
    //上面使用每次new一个 varList,这里直接用Array.asList()构造一个新list
    public static  List<List<Integer>> betterFourSum(int[] nums , int target)
    {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //先按变量,排除不可能情况:1.长度小于4  2.元素太小或太大,不存在4Sum == target
        int length = nums.length;
        if (nums == null || length < 4)
            return res;

        Arrays.sort(nums);          //从小到大 升序
        int max = nums[length - 1];
        if (nums[0]*4 > target || max * 4 < target)
            return res;

        int i,z;


        //存在结果
        for (i = 0 ; i < length ; i ++)
        {
            z = nums[i];

            //为了避免重复,因为对第一个数是z 已经讨论过
            if (i > 0 && nums[i-1] == z)
                continue;

            //z太小
            if (z + 3*max < target)
                continue;

            //z太大
            if (z * 4 > target)
                break;

            //z刚好是边界
            if (z*4 == target) {
                if (i + 3 < length && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, length - 1, res, z);
        }


        return res;
    }

    public static void threeSumForFourSum(int[] nums, int target, int low , int high,ArrayList<List<Integer>> fourSumList,int z1){

        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (nums[low]*3 > target || nums[high]*3 < target)
            return;

        int i ,z ;

        //i < high -1   相当于留出两个
        for (i = low ; i < high -1 ; i ++)
        {
            z = nums[i];

            if (i > low && nums[i - 1] ==z)
                continue;

            //z太小
            if (z + nums[high]*2 < target)
                 continue;

            //z太大
            if (z*3 > target)
                break;

            if (z*3 == target)
            {
                if (i + 2 <= high && nums[i + 2]==z)
                    fourSumList.add(Arrays.asList(z1,z,z,z));
                break;
            }

            twoSumForFourSum(nums,target - z ,i + 1,high,fourSumList,z1,z);
        }

    }

    public static void twoSumForFourSum(int[] nums, int target , int low , int high,ArrayList<List<Integer>> fourSumList,int z1,int z2)
    {
        if (low >= high)
            return;

        if (nums[low]*2 > target || nums[high]*2 < target)
            return;

        int i = low ,j = high , sum ,x ;
        while (i < j)
        {
            sum = nums[i] + nums[j];
            if (sum == target)
            {
                fourSumList.add(Arrays.asList(z1,z2,nums[i],nums[j]));

                //为了避免重复
                x = nums[i];
                while (++i < j && nums[i] == x);
                x = nums[j];
                while (--j > i && nums[j] == x);

            }

            if (sum < target)
                i ++;
            if (sum > target)
                j --;
        }
        return;
    }

    public static void main(String[] args){

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int[] nums = new int[]{-5,5,4,-3,0,0,4,-2};

        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i ++)
            System.out.println(nums[i]);
//        lists = fourSum(nums,4);
//        System.out.print("[");
//        for (int i = 0 ; i < lists.size() ; i++)
//        {
//            List<Integer> list = lists.get(i);
//            System.out.print("[");
//            for (int j = 0 ; j < list.size() ; j++)
//                if(j == 0)
//                    System.out.print(list.get(j));
//                else
//                    System.out.print(","+list.get(j));
//
//            System.out.print("]");
//        }
//        System.out.println("]");
    }

}
