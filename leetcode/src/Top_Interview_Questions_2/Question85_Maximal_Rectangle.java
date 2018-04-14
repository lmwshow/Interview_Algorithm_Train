package Top_Interview_Questions_2;

public class Question85_Maximal_Rectangle {


    // 暴力模拟 O（n^3），可以活用直方图的最大矩阵面积，优化到O(n^2)
    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int max=0,maxh = Integer.MAX_VALUE,weight = 0;

        for (int i = 0 ; i < matrix.length ; i++)
        {
            for (int j = 0 ; j < matrix[0].length ; j++)            //遍历将所有点依次为矩阵左上点 模拟
            {
                if (matrix[i][j] == '0')
                    continue;
                for (int k = j ; k < matrix[0].length ; k++) {

                    if (matrix[i][k] == '0') {
                        break;
                    }
                    weight++;
                    maxh = Math.min(maxh, getHeigh(matrix, i, k));
                    max = Math.max(max, weight * maxh);
                }

                weight = 0;
                maxh = Integer.MAX_VALUE;
            }


        }

        return max;

    }

    private static int getHeigh(char[][] matrix, int i, int j) {

        int ans = 0;
        while (i < matrix.length)
            if (matrix[i++][j] == '1')
                ans++;
            else
                break;

        return ans;

    }

    public static void main(String[] args){


//        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(maximalRectangle(new char[][]{{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}}));

    }

}