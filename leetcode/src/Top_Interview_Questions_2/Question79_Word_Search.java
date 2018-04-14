package Top_Interview_Questions_2;

public class Question79_Word_Search {


    public static boolean exist(char[][] board, String word) {

        if (board == null || word == null || board.length == 0 || word.length() == 0)
            return false;

        boolean[][] visit = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (solver(board, i, j, word, 0,visit))
                    return true;
            }

        return false;

    }

    private static boolean solver(char[][] board, int i, int j, String word, int index,boolean[][] visit) {

        if (index == word.length())
            return true;

        boolean ans = false;

        if (!visit[i][j]&& board[i][j] == word.charAt(index)) {
            visit[i][j] = true;

            if (index == word.length()-1)
                return true;

            if (i - 1 >= 0)
                ans |= solver(board, i - 1, j, word, index + 1,visit);
            if (i + 1 < board.length)
                ans |= solver(board, i + 1, j, word, index + 1,visit);
            if (j - 1 >= 0)
                ans |= solver(board, i, j - 1, word, index + 1,visit);
            if (j + 1 < board[0].length)
                ans |= solver(board, i, j + 1, word, index + 1,visit);

            visit[i][j] = false;


        } else
            return false;

        return ans;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{{'b'}};

        System.out.println(exist(board, "b"));

    }
}
