package leetgroup.数组;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/8/16.
 *
 * This is a very simple and easy to understand solution.
 * I traverse right and increment rowBegin, then traverse down and decrement colEnd,
 * then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.

 * The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates.
 * If anyone can do the same thing without that check, please let me know!
 */
public class spiral_matrix {

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            //避免重复

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;

    }
    
    
    public static void main(String[] args){

        int[][] nums = new int[][]{{1},{7},{13}};

        ArrayList<Integer> res = spiralOrder(nums);

        for (int x : res)
            System.out.println(x);

    
    }
}
