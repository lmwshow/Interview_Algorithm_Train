package again;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/8/9 20:52
 * @Description:
 */
public class 直方图中的最大矩阵 {

    //使用stack保存下标索引，当前元素大于栈顶元素时入栈，即栈中是递增的
    //遇到小于栈顶元素时，开始出栈，并计算以每个栈顶元素为height时的最大矩阵，因为此时长度可以计算出来
    static int ans;

    public static int largestRectangleArea(int... heights) {

        if (heights == null || heights.length == 0)
            return 0;

        ans = Integer.MIN_VALUE;


        //需要最后一个height为0， 才能将栈中元素全都出栈，把最后未计算的 都计算掉
        int[] copy_heights = Arrays.copyOf(heights,heights.length +1);

        Stack<Integer> stack = new Stack<>();
        int cur = 0,i=0;
        while (i < copy_heights.length) {
            if (stack.isEmpty() || copy_heights[stack.peek()] < copy_heights[i])
                stack.push(i++);
            else {
                cur = stack.pop();
                ans = Math.max(ans, copy_heights[cur] * (stack.isEmpty()?i:(i - stack.peek()-1)));

            }
        }

        return ans;
    }


    public static void main(String[] args){

        System.out.println(largestRectangleArea(0));
    }

}
