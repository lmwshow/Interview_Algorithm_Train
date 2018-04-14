package dp;

/**
 * Created by Gracecoder on 2017/3/6.
 */
public class leetcode96 {

    /*
    Binary Search Tree  二叉搜索树 排序树
    定义状态G(n):节点数为n的唯一二叉搜索树的数量
    F(i,n),1 <= i <= n :表示以i为根节点，总节点数为n的二叉搜索树的数量. 节点标记从1到n
    ==》 G(n) = F(1，n) + F（2，n） +...+ F(n,n)
    F(i,n) = G(i-1)*G(n-i)  ,1 <= i <= n
    e.g. 求n个节点 以i为root的二叉搜索树的个数 = 左子树的个数* 右子树的个数
         左子树的节点数为i-1 右子树的节点数为n-i

    G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*G(0)
     */
    public int numTrees(int n) {

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n ; i++)
            for (int j = 1 ; j <= i; j++)
                G[i] += G[j-1]*G[i-j];

        return G[n];

    }
}
