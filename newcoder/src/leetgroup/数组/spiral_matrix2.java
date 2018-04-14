package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/17.
 */
public class spiral_matrix2 {

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int k =1;

        while (rowBegin <= rowEnd && colBegin <= colEnd)
        {
            for (int i = colBegin ; i <= colEnd ; i ++)
                matrix[rowBegin][i] =k++;

            rowBegin ++;

            for (int i = rowBegin ; i <= rowEnd ; i++)
                matrix[i][colEnd] = k++;

            colEnd --;

            //从左到右，从上到下遍历完之后，要进行判断，看右到左，下到上是否会重复
            if (colEnd >= colBegin)
            {
                for (int i = colEnd ; i >=colBegin ; i--)
                    matrix[rowEnd][i] = k++;

                rowEnd--;
            }

            if (rowEnd >= rowBegin)
            {
                for (int i = rowEnd ; i >= rowBegin; i --)
                    matrix[i][colBegin] = k++;
                colBegin ++;
            }
        }

        return matrix;
    }


    public static void main(String[] args){

        int[][] res = generateMatrix(3);

        System.out.println("11");
        

    }
}
