package offer2;

import offer.util.ListNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/19 09:43
 * @Description: https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 孩子们的游戏_圆圈中最后剩下的数 {

    //如果直接使用数组模拟环，下标要理清，但是时间肯定比使用链表要慢点
    public static int LastRemaining_Solution(int n, int m) {

        if (n < 1)
            return -1;

        int[] array =new int[n];
        int i = -1,step = 0,count = n;

        while (count > 0)           //跳出循环时将最后一个元素也设置为了-1
        {
            i++;                    //指向上一个被删除对象的下一个元素
            if (i >= n) i = 0;      //模拟环
            if (array[i] == -1) continue;       //跳过被删除的对象
            step ++;                            //记录步数
            if (step == m)
            {
                array[i] = -1;
                step = 0;
                count --;
            }
        }

        return i;

    }

        //这里是使用额外空间来构成一个循环链表
    public static int minGW_LastRemaining_Solution(int n, int m) {


        if (n <= 0)
            return -1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        for (int i = 1; i < n ; i++)
        {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        
        cur.next = head;
        ListNode pre = cur;
        cur = head;
        while (cur.next != cur)
        {
            for (int i = 1 ; i < m ; i++) {
                pre = cur;
                cur = cur.next;
            }

            pre.next = cur.next;
            cur = cur.next;
                
        }
        
        
        return cur.val;
    }
    
    public static void main(String[] args){
        System.out.println(LastRemaining_Solution(3,0));
    }

}
