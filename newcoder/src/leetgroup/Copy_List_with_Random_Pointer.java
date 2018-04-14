package leetgroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/3/22.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class Copy_List_with_Random_Pointer {

    /*
    自己的方案：
    首先第一次遍历，复制每个node，构成了个基本的单链表
    第二次遍历：对每个node的随机后继， 使用for循环查出 它与头结点的距离，再根据这个距离在找复制的单链表上找到随机后继，指向它。
    时间复杂度O（n^2）
    严格来说会超时
     */
    public static RandomListNode mycopyRandomList(RandomListNode head) {

        if (head == null)
            return null;
        RandomListNode tmp = head;
        RandomListNode copyListhead = new RandomListNode(tmp.label);
        copyListhead.next = null;
        copyListhead.random = tmp.random == null? null:copyListhead;
        RandomListNode tmp1 = copyListhead;
        while (tmp.next != null)
        {
            tmp = tmp.next;
            tmp1.next = new RandomListNode(tmp.label);
            tmp1 = tmp1.next;
        }
        tmp1.next = null;

        tmp = head;
        tmp1 = copyListhead;
        RandomListNode start,randomNode;
        start = head;                                   // 用于计算每个node的随机后继，距离头结点的距离， start在计算距离时初始化为head，在根据距离再copy上后移时初始化copyListhead

        int length=0;
        while (tmp!= null)
        {
            randomNode = tmp.random;
            if (randomNode == null)
                tmp1.random = null;
            else
            {
                for (length = 0; start != randomNode; start = start.next, length++) ;
                start = copyListhead;
                for (int i = 0; i < length; start = start.next, i++) ;
                tmp1.random = start;
                start = head;
            }
            tmp = tmp.next;
            tmp1 = tmp1.next;

        }

        return copyListhead;
    }


    private static RandomListNode copyRandomList(RandomListNode head) {

        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode tmp = head,copy;
        while (tmp!=null)
        {
            map.put(tmp,new RandomListNode(tmp.label));
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp!=null)
        {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }

        return map.get(head);


    }

    public static void main(String[] args){
        RandomListNode head = new RandomListNode(-1);
        head.next = null;
        head.random = head;
        head.next = new RandomListNode(4);
        head.next.next = new RandomListNode(3);
        head.next.next.next = null;

        RandomListNode res = copyRandomList(head);
        while (head!= null)
        {
            System.out.println(head.label);
//            if (head.random!=null)
//                System.out.println(head.random.label);


            head = head.next;

        }

    }
}

