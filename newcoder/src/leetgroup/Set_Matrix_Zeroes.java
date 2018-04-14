package leetgroup;

/**
 * Created by Gracecoder on 2017/7/12.
 */
public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        if (m == 0)
            return;;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] line = new int[n];

        for (int i = 0; i < m ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = 1;
                    line[j] = 1;
                }
            }
        }

        for (int i = 0 ; i < m ; i++)
        {
            if (row[i] == 1)
            {
                for (int j = 0 ; j < n; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int i = 0 ; i < n ; i++)
        {
            if (line[i] == 1)
                for (int j = 0 ; j < m; j++)
                    matrix[j][i] = 0;
        }

    }
}
