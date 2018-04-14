package leetgroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gracecoder on 2017/7/26.
 * 经典回溯法
 * 构造一个visit数组表示是否访问过 不需要其他额外了
 */
public class word_search {

    public static boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0)
            return true;
        if(board==null || board.length==0 || board[0].length==0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(search(board,word,0,i,j,used))
                    return true;
            }
        }
        return false;
    }
    private static boolean search(char[][] board, String word, int index, int i, int j, boolean[][] used)
    {
        if(index == word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || used[i][j] || board[i][j]!=word.charAt(index))
            return false;
        used[i][j] = true;
        boolean res = search(board,word,index+1,i-1,j,used)
                || search(board,word,index+1,i+1,j,used)
                || search(board,word,index+1,i,j-1,used)
                || search(board,word,index+1,i,j+1,used);
        used[i][j] = false;
        return res;
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        boolean res = exist(board, "AAB");
        System.out.println(res);

    }
}
