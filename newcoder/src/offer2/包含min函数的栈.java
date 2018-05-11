package offer2;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 08:56
 * @Description: https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 可以使用优先队列
 */
public class 包含min函数的栈 {

    int curmin = 0;
    Stack<Integer> minStack = new Stack<>();    //最小栈,栈中存元素与当前最小值的差值

    public void push(int node) {

        if (minStack.size() == 0)
            curmin = node;

        minStack.push(node-curmin);       //node-curmin小于0时，说明最小值发生改变
        if (node < curmin)
            curmin = node;

    }

    public void pop() {

        int cur = minStack.pop();
        if (cur < 0)
            curmin -= cur;

    }

    public int top() {

        return minStack.peek() + curmin;
    }

    public int min() {

        return curmin;
    }


}
