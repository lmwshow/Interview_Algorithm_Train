package offer2;

import org.omg.CORBA.MARSHAL;

/**
 * @Auther: minGW
 * @Date: 2018/5/24 08:44
 * @Description: https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 矩阵中的路径 {

    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static boolean ans = false;

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        ans = false;
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0)
            return true;

        boolean[] visit = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (ans)
                    return ans;
                if (matrix[i * cols + j] == str[0]) {
                    visit[i * cols + j] = true;
                    DFS(matrix, rows, cols, i, j, str, 1, visit);
                    visit[i * cols + j] = false;

                }

            }

        return ans;
    }

    private static void DFS(char[] matrix, int rows, int cols, int curi, int curj, char[] str, int index, boolean[] visit) {

        if (index == str.length) {
            ans = true;
            return;
        }


        for (int i = 0; i < dir.length; i++) {
            int[] curdir = dir[i];
            int x = curi + curdir[0];
            int y = curj + curdir[1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && !visit[x * cols + y] && matrix[x * cols + y] == str[index])
            {
                visit[x * cols + y] = true;
                DFS(matrix,rows,cols,x,y,str,index+1,visit);
                visit[x * cols + y] = false;

            }
        }
    }

    
    public static void main(String[] args){
        
        System.out.println(hasPath(new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'},3,4,new char[]{'b','c','c','e','d'}));
    }
}
