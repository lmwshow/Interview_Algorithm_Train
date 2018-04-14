package offer;

/**
 * Created by Gracecoder on 2017/12/9.
 */
public class 题12_机器人的运动范围 {

    public int movingCount(int threshold, int rows, int cols) {
        int[][] visit = new int[rows][cols];
        int res = 0;

        if (threshold < 0)
            return 0;

        solver(threshold, rows, cols, 0, 0, visit);

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (visit[i][j] == 1)
                    res++;
            }

        return res;

    }

    private void solver(int threshold, int rows, int cols, int i, int j, int[][] visit) {

        visit[i][j] = 1;

        if (i - 1 >= 0 && visit[i - 1][j] == 0 && bitsum(i - 1) + bitsum(j) <= threshold)
            solver(threshold, rows, cols, i - 1, j, visit);

        if (i + 1 < rows && visit[i + 1][j] == 0 && bitsum(i + 1) + bitsum(j) <= threshold)
            solver(threshold, rows, cols, i + 1, j, visit);

        if (j - 1 >= 0 && visit[i][j - 1] == 0 && bitsum(i) + bitsum(j - 1) <= threshold)
            solver(threshold, rows, cols, i, j - 1, visit);

        if (j + 1 < cols && visit[i][j + 1] == 0 && bitsum(i) + bitsum(j + 1) <= threshold)
            solver(threshold, rows, cols, i, j + 1, visit);
    }

    private int bitsum(int index) {

        int res = 0;
        while (index % 10 > 0) {
            res += index % 10;
            index /= 10;

        }
        return res;
    }

}
