package Top_Interview_Questions_2;

import java.util.Map;
import java.util.Stack;

public class Question32_Longest_Valid_Parentheses {



    //使用栈，往栈中压入每个元素的下标,遇到')' 如果栈顶是'('出栈，否则继续
    //这样最后栈中会残留 无效字符的小标，这些下标之间的间隔 都是有效子串的长度，取最长的即可
    //如果最后栈为空，那说明整个字符串为有效串
    //
    public static int longestValidParentheses(String s) {

        if (s == null || s.length() < 2)
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);                         //作为哨兵，方便后面计算

        for (int i = 0 ; i < s.length() ; i++)
        {
            //stack.size() 因为里面有个-1， 所以大于1才表示有元素

            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek())=='(')
                stack.pop();
            else
                stack.push(i);
        }

        int ans = 0;
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

    public static void main(String[] args){


        System.out.println(longestValidParentheses("())(()))(("));


    }
}
