package offer2;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 08:24
 * @Description: https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return ans;

        int number = (matrix.length + 1) >> 1;          //对于M*N矩阵，打圈的次数为(M+1)/2

        int rowstart = 0 ,rowend = matrix.length-1,colstart = 0,colend = matrix[0].length-1;
        for (int i = 0 ; i < number ; i++)
        {
            if (rowstart <= rowend && colstart <= colend) {
                for (int j = colstart; j <= colend; j++)
                    ans.add(matrix[rowstart][j]);
                rowstart++;
            }

            if (colend >= colstart && rowstart <= rowend)
            {
                for (int j = rowstart; j <= rowend; j++)
                    ans.add(matrix[j][colend]);
                colend--;
            }

            if (rowend >= rowstart  && colstart <= colend)
            {
                for (int j = colend; j >= colstart; j--)
                    ans.add(matrix[rowend][j]);
                rowend--;
            }

            if (colstart <= colend && rowstart <= rowend)
            {
                for (int j = rowend; j >= rowstart; j--)
                    ans.add(matrix[j][colstart]);
                colstart++;
            }

        }

        return ans;
    }

    public static void main(String[] args){

        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8}};

        ArrayList<Integer> ans = printMatrix(nums);

        ans.forEach((n)->System.out.println(n));
        //lambda表达式，函数式接口
        ans.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });


    }
}
