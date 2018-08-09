package Top_Interview_Questions_2;

import java.util.Stack;

/**
 * 直方图的最大矩阵算法
 */

public class Question84_直方图中的最大矩阵 {


    static int ans;

    public static int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0)
            return 0;

        ans = Integer.MIN_VALUE;

        int len = heights.length;

        int[] h = new int[len + 1];           //最后加一个0，把最后未计算的 都计算掉

        for (int i = 0; i < heights.length; i++)
            h[i] = heights[i];

        Stack<Integer> stack = new Stack<>();
        int cur = 0,i=0;
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] < h[i])
                stack.push(i++);
            else {
                cur = stack.pop();
                ans = Math.max(ans, h[cur] * (stack.isEmpty()?i:(i - stack.peek()-1)));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(
                largestRectangleArea(new int[]{0}));

    }
}
