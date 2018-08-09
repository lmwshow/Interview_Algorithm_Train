package again;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/8/7 16:48
 * @Description:
 */
public class 最长有效字符串 {

    /*
    使用栈，往栈中压入每个元素的下标,遇到')' 如果栈顶是'('出栈，否则继续
    这样最后栈中会残留 无效字符的小标，这些下标之间的间隔 都是有效子串的长度，取最长的即可
    如果最后栈为空，那说明整个字符串为有效串
     */


    public int longestValidParentheses(String s) {

        int ans = 0;
        if (s == null || s.length() == 0)
            return ans;

        Stack<Integer> stack = new Stack<>();

        //作为哨兵，方便后面计算
        stack.push(-1);
        for (int i = 0 ; i < s.length() ; i++)
        {
            //stack.size() 因为里面有个-1， 所以大于1才表示有元素
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(')
                stack.pop();
            else
                stack.push(i);
        }

        if (stack.size() == 1)
            ans = s.length();
        else
        {
            int end = s.length();
            while (!stack.isEmpty())
            {
                ans = Math.max(ans,end - stack.peek() - 1);
                end = stack.pop();
            }
        }

        return ans;

    }
}
