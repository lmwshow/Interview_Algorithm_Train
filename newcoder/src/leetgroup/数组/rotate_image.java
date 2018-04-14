package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/15.
 */
public class rotate_image {

    /*
    旋转90度，也可以先转置，然后把列数 逆序一下
    https://leetcode.com/problems/rotate-image/discuss/
     */

    public void rotate(int[][] matrix) {

        /*
        这道题虽然操作起来有一点繁琐，但是思路比较简单，就是考察一下数组的基本操作。
        基本思路是把图片分为行数/2层，然后一层层进行旋转，
        每一层有上下左右四个列，然后目标就是把上列放到右列，右列放到下列，下列放到左列，左列放回上列，中间保存一个临时变量即可。
        因为每个元素搬运的次数不会超过一次，时间复杂度是O(矩阵的大小)，空间复杂度是O(1)。

        但是这样还是用到了一个额外空间，但是能ac.

        对一次转化 （i,j）-->(j,n-1-i)  ，我们逆着来，就可以用一个tmp，直接完成一轮转换
         */


        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return;
        int layerNum = matrix.length/2;
        for(int layer=0;layer<layerNum;layer++)
        {
            for(int i=layer;i<matrix.length-layer-1;i++)
            {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length-1-i][layer];
                matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
                matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
                matrix[i][matrix.length-1-layer] = temp;
            }
        }



    }
}
