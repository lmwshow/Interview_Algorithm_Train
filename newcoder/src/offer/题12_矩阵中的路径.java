package offer;

/**
 * Created by Gracecoder on 2017/12/9.
 * <p>
 * 回溯法 需要回退
 */
public class 题12_矩阵中的路径 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean res = false;
        if (matrix == null || str == null || matrix.length < str.length)
            return res;

        int[] visit = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            if (res)
                break;
            if (matrix[i] == str[0]) {
                visit[i] = 1;
                res = solver(matrix, i, rows, cols, str, 1, visit);
                visit[i] = 0;
            }
        }

        return res;
    }

    private static boolean solver(char[] matrix, int index, int rows, int cols, char[] str, int cur, int[] visit) {

        boolean res = false;

        if (cur == str.length)
            return true;


        //在每一个位置,只能选择走一步
        //上
        if (index - cols >= 0 && matrix[index - cols] == str[cur] && visit[index - cols] == 0) {
            visit[index - cols] = 1;
            res = res || solver(matrix, index - cols, rows, cols, str, cur + 1, visit);
            visit[index - cols] = 0;
        }
        //下
        if (!res && index + cols < matrix.length && matrix[index + cols] == str[cur] && visit[index + cols] == 0) {
            visit[index + cols] = 1;
            res = res || solver(matrix, index + cols, rows, cols, str, cur + 1, visit);
            visit[index + cols] = 0;

        }
        //左
        if (!res && index - 1 >= 0 && matrix[index - 1] == str[cur] && visit[index - 1] == 0) {
            visit[index - 1] = 1;
            res = res || solver(matrix, index - 1, rows, cols, str, cur + 1, visit);
            visit[index - 1] = 0;

        }
        //右
        if (!res && index + 1 < matrix.length && matrix[index + 1] == str[cur] && visit[index + 1] == 0) {
            visit[index + 1] = 1;
            res = res || solver(matrix, index + 1, rows, cols, str, cur + 1, visit);
            visit[index + 1] = 0;

        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(hasPath(new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'}, 3, 4, new char[]{'e', 'e', 'd', 'a', 's', 'a', 'b', 'c', 'e', 's'}));

    }
}
