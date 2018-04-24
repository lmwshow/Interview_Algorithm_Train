package Top_Interview_Questions_2.树;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/4/20 07:45
 * @Description: 1.使用优先队列，从后往前扫描。
 * 题目就转化为，当计算num[i]时，ans[i]等于当前优先队列中有多少个数小于num[i]，只需要逐个从优先队列里出队列，然后计算pq.size()即可，
 * 但是关键是ans[i-1]和ans[i]并不存在相关性，仍然需要保留之前队列中所有的数，所以就需要把出队列的元素，再逐个入队列。
 * 这成了无法通过所有用例的关键。
 * <p>
 * 2.既然问题的关键是我们需要保留之前的所有数字，那么有什么结构可以计算num[i]在之前所有元素中的位置，又可以完整保留当前插入的所有数呢？
 * 二叉排序树（BST）
 * 经典求逆序数问题，通过BST建树过程中，找到答案
 * 建立二叉排序树，每个节点需要维护两个变量 leftSum 表示该节点左子树节点的个数(因为插入时的右转，代表树中有leftSum个数小于当前数)，cnt表示自身节点重复的个数
 * 由于我们是对nums从后往前遍历，所以对于当前点，插入时每次向右走时，我们都需要将结果累积到一个临时变量preNum中，表示走到当前步时，其逆序数的个数
 */
public class Question315_计算右侧小于当前元素的个数 {

    static class Node {

        int val;
        int cnt = 1;        //表示重复的个数,初始化为1
        int leftSum;    //表示左子树节点的个数
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    //Solution2:BST
    public static List<Integer> countSmaller(int[] nums) {

        LinkedList<Integer> ans = new LinkedList<>();
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--)
            root = insert(root, nums[i], 0, ans);

        return ans;
    }

    //BST的建立
    private static Node insert(Node root, int num, int preSum, LinkedList<Integer> ans) {

        if (root == null) {
            ans.addFirst(preSum);
            return new Node(num);
        }

        if (root.val == num) {
            root.cnt++;
            ans.addFirst(root.leftSum + preSum);
        } else if (root.val < num) {
            preSum = preSum + root.leftSum + root.cnt;
            root.right = insert(root.right, num, preSum, ans);
        } else {
            root.leftSum++;
            root.left = insert(root.left, num, preSum, ans);
        }

        return root;

    }


    //Solution1:优先队列
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

        for (int i = n - 1; i >= 0; i--) {
            int cur = nums[i];
            while (!pq.isEmpty()) {
                if (cur <= pq.peek())
                    list.add(pq.poll());
                else
                    break;
            }

            res.add(0, pq.size());
            pq.offer(cur);
            for (int x : list)
                pq.offer(x);

            list.clear();

        }


        return res;

    }


    public static void main(String[] args) {

        List<Integer> ans = countSmaller(new int[]{2, 0, 1});

        for (int x : ans)
            System.out.println(x);
    }
}
