package offer;

import java.util.PriorityQueue;
import java.util.Stack;

public class 题30_包含min函数的栈 {

    Stack<Integer> stack = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public void push(int node) {
        stack.push(node);
        pq.offer(node);
    }

    public void pop() {
        int node = stack.pop();
        pq.remove(node);
    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return pq.peek();

    }
}
