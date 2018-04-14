package leetgroup;

/**
 * Created by Gracecoder on 2017/8/8.
 *
 * 回溯？如果能找出 出迷宫的路 就不需要改。 如果找不到 需要封上
 *
 * First, check the four border of the matrix. If there is a element is
 * 'O', alter it and all its neighbor 'O' elements to '1'.
 * Then ,alter all the 'O' to 'X'
 * At last,alter all the '1' to 'O'
 */
public class surrounded_regions {

    public static void solve(char[][] board) {

        if (board == null || board.length <3 || board[0].length<3 || board.length != board[0].length)
            return;


//        int[][] visit = new int[board.length][board[0].length];

        int row = board.length;
        int col = board[0].length;


        for (int i = 0 ; i < row ; i++)
        {
            check(board,i,0,row,col);
            if (col > 1)
                check(board,i,col-1,row,col);
        }

        for (int j = 1 ; j < col -1 ; j++)
        {
            check(board,0,j,row,col);
            if (row > 1)
                check(board,row-1,j,row,col);
        }

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(board[i][j]=='O')
                    board[i][j]='X';
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(board[i][j]=='1')
                    board[i][j]='O';

//        int i= 1,j= 1;
//        for (; i < board.length-1 ; i ++)
//            for (; j < board[0].length-1 ; j ++)
//                if (board[i][j] == 'O') {
//                    helper(board, i, j, visit);
//                }
//        return;

//        helper(board,i,j,visit);
//        return;

        return;
    }

    private static void check(char[][] board, int i, int j, int row, int col) {

        if (board[i][j] == 'O')
        {
            board[i][j] = '1';
            if (i > 1)
                check(board,i-1,j,row,col);
            if (i < row -1)
                check(board,i+1,j,row,col);
            if (j > 1)
                check(board,i,j-1,row,col);
            if (j < col -1)
                check(board,i,j+1,row,col);
        }
    }



    private static boolean helper(char[][] board, int i, int j,int[][] visit) {



        //true表示不用封
        if (board[i][j]=='O' && (i==0 ||i ==board.length-1 || j ==0 || j==board[0].length-1))
            return true;

        if (visit[i][j]==0 && board[i][j]=='O')
        {
            boolean res1,res2,res3,res4;
            visit[i][j] = 1;
            res1 = helper(board,i+1,j,visit);
            res2 = helper(board,i-1,j,visit);
            res3 = helper(board,i,j-1,visit);
            res4 = helper(board,i,j+1,visit);
            visit[i][j] = 0;

            if (res1 || res2 || res3 || res4)
                return true;
            else {
                board[i][j] = 'X';
                return false;
            }

        }

        return false;

    }

    public static void main(String[] args){

        char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};

        solve(board);
    }
}
