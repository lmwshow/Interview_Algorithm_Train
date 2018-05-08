package offer2;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/8 08:11
 * @Description: https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 以前的思想都是入栈即普通的入栈，出栈是先从一个栈中移到另一个栈，出栈一个，然后移动回来。
 *
 * 其实移动回来是多余的，就放在另一个栈中，作为一个类似缓存的作用就可以了
 */
public class 用两个栈实现队列 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {
        //不需要来回移动
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        return stack2.pop();

    }
}
