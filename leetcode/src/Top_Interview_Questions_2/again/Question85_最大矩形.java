package Top_Interview_Questions_2.again;

import java.util.Stack;

public class Question85_最大矩形 {


    // 暴力模拟 O（n^3），可以活用直方图的最大矩阵面积，优化到O(n^2)
    // 首先需要思考如何将矩阵转为 直方图， 因为直方图是一维数组描述的， 所以这里可以用二维数组表示n个直方图
    public static int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int max = 0;

        int[][] heigths = new int[matrix.length][matrix[0].length+1];

        for (int i = 0; i < matrix.length; i++)                         //构建直方图
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    heigths[i][j] = 0;
                else
                    heigths[i][j] = (i == 0 ? 1 : heigths[i - 1][j]+1);
            }


        for (int i = 0; i < heigths.length; i++) {
            max = Math.max(max, largestRectangleArea(heigths[i]));
        }

        return max;

    }

    private static int largestRectangleArea(int[] heigth) {
        if (heigth == null || heigth.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0,curindex = 0,i=0;

        while (i < heigth.length){

            if (stack.isEmpty() || heigth[i] >= heigth[stack.peek()])
            {
                stack.push(i++);
            }

            else
            {
                curindex = stack.pop();         //这是是个ifelse 虽然每次第一次进来的时候 curindex = i-1 但是由于不是一直循环计算到结束，所以curindex会变化，后面就不再是i-1了
                max = Math.max(max,heigth[curindex]*(stack.isEmpty()?i:(i - stack.peek() -1)));
            }
        }

        return max;
    }


    public static void main(String[] args) {


        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(maximalRectangle(new char[][]{{'0', '0', '1', '0'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '0'}, {'1', '1', '0', '0'}, {'1', '1', '1', '1'}, {'1', '1', '1', '0'}}));

    }

}