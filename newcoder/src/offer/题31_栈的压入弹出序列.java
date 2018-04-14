package offer;

import java.util.Stack;

public class 题31_栈的压入弹出序列 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (popA == null || pushA == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        int pushindex = 0;
        int popindex = 0;

        while (popindex < popA.length)
        {
            while (stack.isEmpty() || stack.peek()!=popA[popindex]) {
                if (pushindex == pushA.length)
                    break;

                stack.push(pushA[pushindex++]);
            }

            if (stack.peek()!=popA[popindex])
                break;

            stack.pop();
            popindex++;
        }

        if (stack.isEmpty() && popindex == popA.length)
            return true;

        return false;



    }
}
