package leetgroup;

/**
 * Created by Gracecoder on 2017/5/13.
 */
public class maximal_rectangle {

    /*
    遍历矩阵中所有的点，3重循环遍历完 以每个点作为矩阵起点的情况
     */
    public static int maximalRectangle(char[][] matrix) {

        int max = 0, maxw = Integer.MAX_VALUE, maxh = 0;                //maxw表示最大可取的宽度，即一个矩阵中当前的最大宽度

        int m = matrix.length;          //行数
        if (m == 0)
            return 0;
        int n = matrix[0].length;       //列数

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')                                //该点无法成为矩阵起点，直接略过
                    continue;

                maxw = Integer.MAX_VALUE;                               //每次以一个新的点为左上角点时，需要重置maxw
                for (int h = i, w = j; h < m; h++) {
                    int width = 0;
                    int height = h - i + 1;                             //高



                    if (matrix[h][w] == '1') {
                        int index = w;
                        while (w < n && matrix[h][w++] == '1')
                            width++;

                        maxw = width < maxw ? width : maxw;             //maxw是根据一个矩阵中所有行中的最短宽度来计算的
                        max = height * maxw > max ? height * maxw : max;

                        w = index;
                    }else                                               //该行第一个就不满足说明width = 0了，那么以（i,j）为起点的矩阵也就计算完毕了
                        break;


                }


            }


        return max;
    }


    public static void main(String[] args) {

        int res = maximalRectangle(new char[][]{});

        String str  = "我喜欢学习Java!";

        System.out.println(str.length());

        System.out.println(res);

    }
}
