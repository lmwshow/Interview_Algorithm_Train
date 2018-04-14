package Top_Interview_Questions.again;

/**
 * Created by Gracecoder on 2017/10/30.
 *
 * 被二分先入为主,然而矩阵是m*n的 无法通过先对对角线二分再对两个点分别行列二分解决
 *
 * 换一种方式利用每行每列sorted 的 性质  O（m+n）
 * 从右上角开始遍历，因为每一行，每一列都是排序好的
 * 如果target 大于 右上角的元素， 那么说明第一行就不会包括target，因为当前元素已经是第一行最大的元素了，row++
 * 如果target 小于 右上角的元素，那么说明当前列不会包含target，因为当前元素已经是当前列最小的元素了，col--
 *
 * 之所以从右上角开始，是因为这样 能够排除某一列或者某一行
 * 如果从左上角开始，那么存在的情况就会有两种，当前列或者当前行，那样就必须要遍历全部了
 */
public class Search_a_2D_Matrix_II {

    public static boolean searchMatrix(int[][] matrix, int target) {

       if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
           return false;

       int row = 0;
       int col = matrix[0].length - 1;

       while (col >= 0 && row < matrix.length)
       {
           if (target == matrix[row][col])
               return true;
           else if (target < matrix[row][col])
               col --;
           else
               row++;
       }

       return false;

    }

    public static void main(String[] args){


        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}},5));

        System.out.println(searchMatrix(new int[][]{{-5}},-10));

        System.out.println((1+2)>>1);


    }
}
