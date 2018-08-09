package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/9 20:23
 * @Description:
 */
public class 单词查找 {

    static boolean ans = false;
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static boolean exist(char[][] board, String word) {

        ans = false;

        if (board == null || board.length == 0 || word == null)
            return ans;

        boolean[][] visit = new boolean[board.length][board[0].length];

        for (int i = 0 ; i < board.length ; i++)
        {
            for (int j = 0 ; j < board[0].length ; j ++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    visit[i][j] = true;
                    dfs(board,i,j,visit,1,word);
                    visit[i][j] = false;
                }

                if (ans)
                    break;
            }
        }

        return ans;
    }

    private static void dfs(char[][] board, int x, int y, boolean[][] visit,int index,String word) {

        if (index == word.length())
        {
            ans = true;
            return;
        }

        for (int i = 0 ; i < dir.length ; i++)
        {
            if (ans)
                break;

            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx >= 0 && nextx < board.length && nexty >= 0 && nexty < board[0].length && !visit[nextx][nexty] && board[nextx][nexty] == word.charAt(index))
            {
                visit[nextx][nexty] = true;
                dfs(board,nextx,nexty,visit,index+1,word);
                visit[nextx][nexty] = false;

            }
        }
    }


    public static void main(String[] args){

    }
}
