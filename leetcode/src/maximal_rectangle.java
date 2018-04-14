import java.util.Stack;

/**
 * Created by Gracecoder on 2017/5/15.
 */
public class maximal_rectangle {

    public static int maximalRectangle(char[][] matrix) {

        int max = 0;
        int m = matrix.length;
        if (m == 0)
            return max;
        int n = matrix[0].length;

        int[][] h = new int[m][n+1];

        for (int i = 0 ; i < m ; i ++)
            for (int j = 0 ; j < n ;j ++)
            {
                if (matrix[i][j] == '0')
                    h[i][j] = 0;
                else
                {
                    if (i==0)
                        h[i][j] = 1;
                    else
                        h[i][j] = h[i-1][j] + 1;
                }
            }

        for (int i = 0 ; i < m ;i++)
        {
            int tmp = func(h[i]);

            max = tmp> max? tmp:max;
        }

        return max;
    }

    private static int func(int[] ints) {

        int n = ints.length;
        int i =0;
        int max = 0;

        Stack<Integer> stack = new Stack();
        while (i < n)
        {
            if (stack.isEmpty()||ints[i] >= ints[stack.peek()])
                stack.push(i++);

            else
            {
                int width;
                int t = stack.pop();
                if (stack.isEmpty())
                    width = i;
                else
                    width = i - stack.peek() -1;

                max = ints[t]*width>max?ints[t]*width:max;

            }
        }

        return max;

    }

    public static void main(String[] args){

        System.out.println(func(new int[]{4,2,0,3,2,5}));

    }
}
