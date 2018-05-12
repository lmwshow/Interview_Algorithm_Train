package offer2;

import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/5/12 08:48
 * @Description: 判断序列是否是某个二叉树的后序遍历
 *
 * 通过先序、中序 或者 中序、后序遍历生成BST ，最关键的点是 注意递归时 小标的偏移量，两者无关，需要根据各自的index进行移动
 *
 * 这里判断序列是否是后序遍历，还可以通过找出BST 后序遍历的规则： 最后一个数是根，将序列分为左右两颗子树 左边全小于 右边全大于， 再递归判断子树
 */
public class 二叉搜索树的后序遍历序列 {

    public static boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0)
            return false;

        return isBST(sequence,0,sequence.length-1);



    }

    private static boolean isBST(int[] sequence, int start, int end) {

        if (start > end)
            return true;

        int key = sequence[end];

        int postion = 0;
        for (; postion < end ; postion++)
            if (sequence[postion] > key)
                break;

        for (int i = postion ;i < end ; i++)
            if (sequence[i] < key)
                return false;


        return isBST(sequence,start,postion-1)&&isBST(sequence,postion,end-1);
    }


    /*
    通过中序、后序生成BST
     */
    public static boolean minGW_VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0)
            return false;

        int[] copy = Arrays.copyOfRange(sequence, 0, sequence.length);
        Arrays.sort(copy);

        return minGW_isBST(sequence, 0, sequence.length - 1, copy, 0, copy.length - 1);

    }

    private static boolean minGW_isBST(int[] sequence, int postStart, int postEnd, int[] copy, int inStart, int inEnd) {

        if (postStart > postEnd || inStart > inEnd)
            return true;

        int key = sequence[postEnd];
        int postion = 0;
        while (inStart <= inEnd) {
            int mid = ((inEnd - inStart) >> 1) + inStart;
            if (copy[mid] == key) {
                postion = mid;
                break;
            }
            else if (copy[mid] < key)
                inStart = mid + 1;
            else
                inEnd = mid - 1;
        }
        
        if (copy[postion] == key)
            return minGW_isBST(sequence,postStart,postStart+(postion -inStart - 1),copy,inStart,postion-1)&&
                    minGW_isBST(sequence,postEnd-(inEnd-postion),postEnd-1,copy,postion+1,inEnd);
        else 
            return false;

    }
    
    public static void main(String[] args){
     
        System.out.println(VerifySquenceOfBST(new int[]{4,6,7,5}));
    }
}
