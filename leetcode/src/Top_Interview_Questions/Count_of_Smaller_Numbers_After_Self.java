package Top_Interview_Questions;

import java.util.*;

/**
 * Created by Gracecoder on 2017/11/30.
 * https://segmentfault.com/a/1190000007473854
 *
 * 用优先队列，nums从后往前遍历，每次从队列中去除大于cur当前值的，然后后面小于它的个数就是pq.size（）,再把当前值和取出来的都放回去。
 * 最后一组用例会超时
 *
 * 经典求逆序数问题，通过BST建树过程中，找到答案  (相比上面：主要还是需要能马上找出小于其val点的个数)
 * 建立二叉排序树，每个节点需要维护两个变量 leftSum 表示该节点左子树节点的个数（因为需要求大于该节点时，所有节点的个数）， cnt表示自身节点重复的个数
 * 由于我们是对nums从后往前遍历，所以对于当前点，插入时每次向右走时，我们都需要将结果累积到一个临时变量preNum中，表示走到当前步时，其逆序数的个数
 */
public class Count_of_Smaller_Numbers_After_Self {

    public List<Integer> timeout_countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<>();

        if (nums == null)
            return res;

        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = n-1 ; i >= 0 ; i-- )
        {
            int cur = nums[i];
            while (!pq.isEmpty())
            {
                if (cur <= pq.peek())
                    list.add(pq.poll());
                else
                    break;
            }

            res.add(0,pq.size());
            pq.offer(cur);
            for (int x:list)
                pq.offer(x);

            list.clear();

        }


        return res;

    }


    //solution2: 建立BST


    class Node{
        int val;
        int leftsum;
        int cnt = 1;        //初始化为1个
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }


    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<>();

        if (nums == null)
            return res;

        Node root = null;
        for (int i = nums.length - 1; i >=0 ; i--)
            root = insert(nums[i],root,0,res);

        return res;
    }

    private Node insert(int val, Node root, int preNum, List<Integer> res) {

        if (root == null)
        {
            root = new Node(val);
            res.add(0,preNum);                          //如果为空节点，新建节点
        }
        else if (root.val == val)
        {
            root.cnt++;
            res.add(0,root.leftsum+preNum);
            //如果与当前节点值相同，其逆序数等于其从开始向右走到这里小于它的所有节点个数preNum + 当前节点的左子树个数leftNum
            //因为逆序数求的是小于它的节点个数 所以这里不加自身cnt
        }else if (root.val > val)
        {
            root.leftsum ++;
            root.left = insert(val,root.left,preNum,res);
            //如果小于当前节点，那就进入左子树，当前节点左子树节点个数leftsum+1，然后插入节点。因为preNum表示当前节点逆序数的个数，而此时是往左走，所以不增加
        }else
        {
            root.right = insert(val,root.right,preNum + root.leftsum + root.cnt,res);
            //如果大于当前节点，那就进入右子树，此时需要更新preNum = preNum + root.leftsum + root.cnt
        }

        return root;



    }
}
