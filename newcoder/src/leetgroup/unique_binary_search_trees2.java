package leetgroup;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/6/22.
 */
public class unique_binary_search_trees2 {


    public static ArrayList<TreeNode> generateTrees(int n) {

        if (n == 0)
            return new ArrayList<>();

        return  genereTree(1,n);
    }

    private static ArrayList<TreeNode> genereTree(int start, int end) {

        ArrayList<TreeNode> list = new ArrayList<>();

        if (start > end)
        {
            list.add(null);
            return list;
        }

        if (start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }

        ArrayList<TreeNode> left,right;
        for (int i = start ; i <= end ; i ++)
        {
            left = genereTree(start,i-1);
            right = genereTree(i+1,end);

            for (TreeNode lnode : left)
                for (TreeNode rnode : right)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = lnode;
                    node.right = rnode;

                    list.add(node);
                }
        }

        return list;

    }

    public static void main(String[] args){

        ArrayList<TreeNode> list = generateTrees(0);
    }

}
