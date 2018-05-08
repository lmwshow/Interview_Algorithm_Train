package offer2;

import offer2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/8 07:46
 * @Description: https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        TreeNode ans = null;

        if (pre == null || in == null)
            return ans;

        ans = reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);

        return ans;
    }

    private TreeNode reConstructBinaryTreeCore(int[] pre, int pstart, int pend, int[] in, int istart, int iend) {

        if (pstart > pend || istart > iend)
            return null;

        TreeNode cur = new TreeNode(pre[pstart]);
        int iIndex = 0;
        for (int i = istart; i <= iend; i++,iIndex++) {
            if (pre[pstart] == in[i])
                break;
        }


        //递归时，先序和中序的下标不再对应，这里根据iIndex移动
        cur.left = reConstructBinaryTreeCore(pre,pstart+1,pstart+iIndex,in,istart,istart+iIndex-1);
        cur.right = reConstructBinaryTreeCore(pre,pstart+iIndex+1,pend,in,istart+iIndex+1,iend);

        return cur;
    }
}
