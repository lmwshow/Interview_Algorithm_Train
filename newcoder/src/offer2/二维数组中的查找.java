package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/8 07:34
 * @Description: https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 二维数组中的查找 {

    public boolean Find(int target, int [][] array) {

        boolean ans = false;
        if (array == null || array.length == 0)
            return ans;

        int rows = 0,cols = array[0].length-1;

        while (rows < array.length && cols >=0)
        {
            if (target > array[rows][cols])
                rows++;
            else if (target == array[rows][cols])
            {
                ans = true;
                break;
            }else
                cols--;
        }

        return ans;
    }
}
