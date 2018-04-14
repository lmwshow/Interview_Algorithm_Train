package leetgroup;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/7/4.
 */
public class valid_parentheses {
    public static boolean isValid(String s) {

        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();

        for ( int i = 0 ; i < s.length() ; i ++)
        {

            char cur = s.charAt(i);

            if (cur=='('||cur=='['||cur=='{')
                stack.push(cur);
            else {

                if (stack.isEmpty())
                    return false;


                if (cur == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        break;
                }

                else if (cur == ']')
                {
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        break;
                }
                else
                {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        break;
                }


            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }



    public static void main(String[] args){

        boolean res = isValid("()]");
        System.out.println(res);

    }
}
