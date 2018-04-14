package Top_Interview_Questions_2;

import java.util.Stack;

public class Question20_Valid_Parentheses {

    public static boolean isValid(String s) {

        if (s == null)
            return false;

        Stack<Character> stack = new Stack();
        for (int i = 0 ;i < s.length() ;i ++)
        {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else
            {
                if (!stack.isEmpty() && (((c == ')') && (stack.peek() == '('))||((c == ']') && (stack.peek() == '['))||((c == '}') && (stack.peek() == '{'))))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args){

        System.out.println(isValid("]"));


    }

}