package Top_Interview_Questions.链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gracecoder on 2017/10/13.
 *
 * 在栈中，用来表示最小点的链表不需要包含所有点，根据栈的性质，只需要判断当前插入值和当前最小值的大小即可，
 * 而不需要与当前最小值的前缀去比较，因为插入点是在当前点之前出栈的，无需担心当前点出栈后，应该轮到该插入点
 *
 * 比如入栈 3，5，2  表示最小值的队列2->3 即可 因为5在3后面，且没有3小，3出栈不关紧要，就算2出栈后  ，最小值队列为3 也是 35的最小值
 * 如果此时加入4， 即 3，5，2，4  表示最小值的队列还是2->3 无需在意 4比5 小
 *
 * 即插入点只需要关系是否比 当前最小值的队列的头结点小即可
 *
 * 最小值的队列：意义当头结点还在栈中时，头结点就是栈中最小值，头结点pop出去时，前缀节点就是当前栈最小值
 *
 * 这里的节点：需要两个指针 一个表示栈节点 一个表示min队列节点
 *
 *
 *
 * 有更好的解法:leetcode
 *
 *   The question is ask to construct One stack. So I am using one stack.

     The idea is to store the gap between the min value and the current value;
 */
public class MinStack {


    private LinkNodeList linkNodeList;

    class LinkNode{
        int val;
        LinkNode next = null;
        LinkNode minnext = null;

        public LinkNode() {
        }

        public LinkNode(int val) {
            this.val = val;
        }
    }

    class LinkNodeList{
        LinkNode head = new LinkNode();
        List<Integer> list = new ArrayList<>();                 //超时， 常量 还是得链表表示顺序队列
        LinkNode minNode = new LinkNode(Integer.MAX_VALUE);


        private void insertFirst(LinkNode node)
        {
            node.next = head.next;
            head.next = node;

            if (node.val < minNode.val) {
                node.minnext = minNode;
                minNode = node;
            }

//            list.add(0,node.val);

        }

        private LinkNode deleteFirst()
        {
            LinkNode first = head.next;
            head.next = first.next;

            if (first == minNode)
            {
                minNode = minNode.minnext;
            }

//            list.remove(0);
            return first;
        }

        private LinkNode getFirst()
        {
            return head.next;
        }

        private int getMinNode()
        {
//            List<Integer> tmp = new ArrayList<>(list);
//            Collections.sort(tmp);                                  //超时
            return minNode.val;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        linkNodeList = new LinkNodeList();
    }

    public void push(int x) {
        linkNodeList.insertFirst(new LinkNode(x));
    }

    public void pop() {
        linkNodeList.deleteFirst();
    }

    public int top() {
        return linkNodeList.getFirst().val;
    }

    public int getMin() {
        return linkNodeList.getMinNode();
    }
}
