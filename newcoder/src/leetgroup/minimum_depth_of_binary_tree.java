package leetgroup;

/**
 * Created by Gracecoder on 2017/6/17.
 */
public class minimum_depth_of_binary_tree {

    public int run(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int min = Integer.MAX_VALUE;
        int curdepth = 1;
        
        int res = DFS(root,min,curdepth);

        return res;
    }

    private int DFS(TreeNode root, int min, int curdepth) {
        
        if (root.left==null&&root.right==null)
        {
            min = Math.min(curdepth,min);
            return min;
        }
        
        if (root.left != null)
            min = DFS(root.left,min,curdepth+1);
        
        if (root.right != null)
            min = DFS(root.right,min,curdepth+1);
        
        return min;
    }
}
