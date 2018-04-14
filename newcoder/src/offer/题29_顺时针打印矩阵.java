package offer;

import java.util.ArrayList;
import java.util.List;

public class 题29_顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while (startRow <= endRow && startCol <= endCol)
        {
            for (int i = startCol ; i <= endCol ; i++)
                res.add(matrix[startRow][i]);
            startRow++;
            for (int i = startRow; i <= endRow ; i++)
                res.add(matrix[i][endCol]);
            endCol--;

            //往左 往上 需要避免重复
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--)
                    res.add(matrix[endRow][i]);
                endRow--;
            }

            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--)
                    res.add(matrix[i][startCol]);
                startCol++;
            }
        }
        
        return res;


    }
    
    public static void main(String[] args){
            
        int[][] matrix = new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        
        ArrayList<Integer> res = printMatrix(matrix);
        
        for (int x:res)
            System.out.println(x);
            
        
    }
}
