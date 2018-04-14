package Top_Interview_Questions_2;

public class Question240_搜索二维矩阵2 {


    /*
    该矩阵具有以下特性：

        每行的元素从左到右升序排列。
        每列的元素从上到下升序排列。

     每次比较右上角的元素x, 如果大于x,不可能在当前行，如果小于x不可能在当前列， 每次排除一行或一列
     */

    public boolean searchMatrix(int[][] matrix, int target) {


        if (matrix == null || matrix.length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length-1;

        int cur = 0;
        while (i < matrix.length && j >= 0)
        {
            cur = matrix[i][j];
            if (cur == target)
                return true;
            else if (cur < target)
                i++;
            else
                j--;
        }

        return false;
    }

}
