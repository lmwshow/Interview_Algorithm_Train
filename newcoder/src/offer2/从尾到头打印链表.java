package offer2;

import offer2.util.ListNode;

import java.util.ArrayList;

/**
 * @Auther: minGW
 * @Date: 2018/5/8 07:43
 * @Description: https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> ans = new ArrayList<>();

        ListNode tmp = listNode;

        while (tmp!=null)
        {
            ans.add(0,tmp.val);
            tmp = tmp.next;
        }

        return ans;

    }
}
