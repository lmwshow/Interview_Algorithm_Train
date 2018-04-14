package Top_Interview_Questions_2.滑动窗口类似求最值系列;

import java.util.Stack;

public class Question155_最小栈 {

    //如果要求只是用一个栈，我们可以在栈中存最小值和当前值的距离

    long min;
    Stack<Long> stack;

    public Question155_最小栈(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
            return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }




    //----------------------------------------------//
//    Stack<Integer> stack;
//    PriorityQueue<Integer> pq;
//
//    /** initialize your data structure here. */
//    public Question155_最小栈() {
//
//        stack = new Stack<>();
//        pq = new PriorityQueue<>();
//
//    }
//
//    public void push(int x) {
//
//        stack.push(x);
//        pq.offer(x);
//
//    }
//
//    public void pop() {
//
//        pq.remove(stack.pop());
//
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return pq.peek();
//    }

}
