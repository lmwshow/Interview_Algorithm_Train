package offer.again;

//找出BST 后序遍历的规则， 最后一个数是根，将序列分为左右两颗子树 左边全小于 右边全大于， 再递归判断子树

public class 题33_二叉搜索树的后序遍历序列 {

    public static boolean VerifySquenceOfBST(int [] sequence) {


        if (sequence == null || sequence.length == 0)
            return false;

        return isBST(sequence,0,sequence.length-1);


    }

    private static boolean isBST(int[] sequence, int start, int end) {

        if (start >= end)
            return true;

        int root = sequence[end];

        int partion = 0;
        int i = 0;

        for (i = 0 ; i < end ; i ++)
            if (sequence[i] > root)
                break;

        partion = i;

        for (int j = partion ; j < end; j++)
            if (sequence[j]<root)
                return false;

        return isBST(sequence,start,partion-1)&&isBST(sequence,partion,end-1);


    }


    public static void main(String[] args){

        System.out.println(VerifySquenceOfBST(new int[]{2,4,6,8,12,10,13,7}));


    }
}
