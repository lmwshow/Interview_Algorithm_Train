package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/8 10:08
 * @Description:
 */
public class 旋转矩阵 {


    //更方便的解法，可以先转置，然后对每一行逆序， 就可以得到旋转矩阵
    //但是转置只对 n*n 的方阵有效

    public static void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return;

        //转置
        transposition(matrix);

        //每行取逆序
        reverse(matrix);

        return;
    }

    private static void reverse(int[][] matrix) {

        for (int i = 0 ; i <matrix.length ; i++)
            reverseCore(matrix[i]);

        return;
    }

    private static void reverseCore(int[] matrix) {

        int left = 0;
        int right = matrix.length-1;
        while (left <= right)
        {
            int tmp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = tmp;

            left ++;
            right--;
        }
        return;

    }

    private static void transposition(int[][] matrix) {

        for (int i = 0 ; i < matrix.length ; i++)
        {
            for (int j = i + 1 ; j < matrix.length ; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return;
    }


    //--实实在在的旋转
    public static void myrotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return;

        int rows = matrix.length;

        int time = rows/2;          //每次对最外层进行旋转处理，对于整个矩阵只需要旋转rows/2次

        for (int i = 0; i < time ;i++)
            oneRotate(matrix,i);

        return;
    }

    private static void oneRotate(int[][] matrix, int level) {

        int start = level;
        int end = matrix.length - start - 1;

        for (int i = start ;i < end ;i++)                   //对于每一层，旋转end-start-1次，每次依次交换
        {
            int tmp = matrix[start][i];
            matrix[start][i] = matrix[end+start-i][start];
            matrix[end+start-i][start] = matrix[end][end+start-i];
            matrix[end][end+start-i] = matrix[i][end];
            matrix[i][end] = tmp;

        }

    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{5,1, 9, 11}, {2,4, 8, 10}, {13,3,6,7},{15,14,12,16}};
        rotate(nums);

        for (int[] num : nums){
            for (int x:num)
                System.out.println(x);
            System.out.println();
        }



    }
}
