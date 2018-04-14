package leetgroup;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/7/3.
 *
 * 新的起点会不断更新
 *
 * 这里可以换一种思路，如果最终stack为空,那么整个字符串就是有效的
 * 如果不为空，stack中残留的就是断点的index，  然后找出整个字符串由这些断点切分后的最长子段
 *
 * 注意，stack中存的是 索引下标
 */
public class longest_valid_parentheses {

    public static int longestValidParentheses(String s) {


        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int max = 0;

        for (int i = 0 ; i < length ; i ++)
        {
            if (s.charAt(i)=='(')
                stack.push(i);                                          //左括号 直接push
            else {
                if (stack.isEmpty())
                    stack.push(i);                                      //右括号，如果栈顶元素是左括号就pop, 其他情况即使出现了断点， push进去
                else
                {
                    if (s.charAt(stack.peek())=='(')
                        stack.pop();
                    else
                        stack.push(i);
                }
            }
        }

        if (stack.isEmpty())
            max = length;

        int last = length;
        while (!stack.isEmpty())
        {
            max = Math.max(max,last - stack.peek() -1);
            last = stack.pop();
        }

        return  Math.max(max,last);                                     //最后一段， 就是0到第一个断点的长度

    }


    public static void main(String[] args){

        String s = "())";
        System.out.println(longestValidParentheses(s));


    }
}
