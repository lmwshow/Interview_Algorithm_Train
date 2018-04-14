package offer;

/**
 * Created by Gracecoder on 2017/12/4.
 *
 * 二维数组行列各自有序，从右上开始遍历，可以直接排除一列，如果target小于右上的值
 * 直接可以把当前列给排除掉，如果大于直接可以把当前行排除掉
 */
public class 题4_二维数组中的查找 {

    public static boolean Find(int target, int [][] array) {

        if (array == null || array.length == 0)
            return false;

        int n = array.length;
        int m = array[0].length;

        int rows = 0;
        int cols = m - 1;

        while (rows < n && cols >=0)
        {
            if (array[rows][cols] > target)
                cols --;
            else if (array[rows][cols] < target)
                rows++;
            else
                return true;
        }

        return false;

    }


    public static void main(String[] args){

        int[][] array = new int[][]{{1,3,9},{2,8,12},{7,15,20}};

        int[][] array1 = new int[][]{{}};

        int[][] array2 = null;

        System.out.println(Find(6,array2));

    }
}
