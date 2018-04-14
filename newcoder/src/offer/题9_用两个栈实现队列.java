package offer;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/12/6.
 */
public class 题9_用两个栈实现队列 {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {

            stack1.push(node);

        }

        public int pop() {

            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

            int res = stack2.pop();
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
            return res;
        }

        //压到stack2后 去完key 不需要压回来， stack2中已经是队列的次序
        public int better_pop() throws Exception {
            if (!stack2.isEmpty())
                return stack2.pop();
            else
            {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());

                if (stack2.isEmpty())
                    throw new Exception("queue is empty");
                else
                    return stack2.pop();
            }
        }
    }
}
