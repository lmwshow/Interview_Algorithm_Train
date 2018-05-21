package offer2;


import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/5/21 09:16
 * @Description: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class 数组中重复的数字 {

    //不使用辅助空间，因为所有数字在0到n-1
    /*
    1、判断输入数组有无元素非法
    2、从头扫到尾，只要当前元素值与下标不同，就做一次判断,numbers[i]与numbers[numbers[i]]，相等就认为找到了
    重复元素，返回true,否则就交换两者，继续循环。直到最后还没找到认为没找到重复元素，返回false
    */
    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || length < 2)
            return false;

        //判断每个元素是否合法
        for (int x : numbers)
            if (x >= numbers.length || x < 0)
                return false;

        for (int i = 0 ; i < length ; i++)
        {
            while (numbers[i]!=i)
            {
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[0] = numbers[i];
                    return true;
                }

                //交换numbers[i] 和 numbers[numbers[i]]

                int swap = numbers[i];
                numbers[i] = numbers[swap];
                numbers[swap] = swap;
            }
        }

        return false;

    }


    //使用辅助空间
    public boolean minGW_duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || length < 2)
            return false;

        List list = new ArrayList();
        for (int i = 0; i < length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }

            list.add(numbers[i]);
        }

        return false;
    }
}
