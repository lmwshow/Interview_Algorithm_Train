package leetgroup.NP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/8/5.
 *
 * 这里是判断是否是有效的数读 ， 而不是让我们填写数字
 * 自己的写法，只用了一个map，分开判断3种情况，这样相当于遍历了3次数组。
 * 然而可以发现 行列判断的方法极其相似，可以放在一次遍历，
 * 那么能否将第三种情况 也放在一次遍历中完成呢，需要找出九宫格坐标 和i,j之间的规律
 *
 * http://www.cnblogs.com/ganganloveu/p/4170632.html
 */
public class valid_sudoku {


    public boolean isValidSudoku(char[][] board) {



        for (int i = 0 ; i < 9; i++) {

            Map<Character,Boolean> maprow = new HashMap<>();        //check_row
            Map<Character,Boolean> mapcol = new HashMap<>();        //check_column
            Map<Character,Boolean> mapsubgrid = new HashMap<>();    //check_subgrid

            for (int j = 0; j < 9; j++) {

                if(board[i][j] != '.')
                {
                    if(maprow.get(board[i][j]) != null)
                        return false;
                    maprow.put(board[i][j],true);
                }
                if(board[j][i] != '.')
                {
                    if(mapcol.get(board[j][i]) != null)
                        return false;
                    mapcol.put(board[j][i],true);
                }

                //找出规律
                if(board[i/3*3+j/3][i%3*3+j%3] != '.')
                {
                    if(mapsubgrid.get(board[i/3*3+j/3][i%3*3+j%3]) != null)
                        return false;
                    mapsubgrid.put(board[i/3*3+j/3][i%3*3+j%3],true);
                }
            }
        }
        return true;
    }


//    private static Map<Character,Integer> map = new HashMap<>();
//
//    public static boolean isValidSudoku(char[][] board) {
//
//        int m = board.length;
//        int n = board[0].length;
//
//        //对每一行进行判断
//        for (int i = 0 ; i < m; i ++) {
//            for (int j = 0; j < n; j++) {
//
//                if (board[i][j]>='1'&& board[i][j]<='9')
//                {
//                    if (map.containsKey(board[i][j]))
//                        return false;
//                    else
//                        map.put(board[i][j],1);
//                }else if (board[i][j] != '.')
//                    return false;
//                else
//                    continue;
//
//            }
//            map.clear();
//        }
//
//
//        //对每一列进行判断
//        for (int j = 0 ; j < n ; j ++)
//        {
//            for (int i = 0 ; i < m ; i++)
//            {
//                if (board[i][j]>='1'&& board[i][j]<='9')
//                {
//                    if (map.containsKey(board[i][j]))
//                        return false;
//                    else
//                        map.put(board[i][j],1);
//                }else if (board[i][j] != '.')
//                    return false;
//                else
//                    continue;
//            }
//            map.clear();
//        }
//
//        //判断每个九宫格
//        int tmpi = 0,tmpj = 0;
//        while (true) {
//
//            for (int i = tmpi; i < tmpi + 3; i++) {
//                for (int j = tmpj; j < tmpj + 3; j++) {
//                    if (board[i][j] >= '1' && board[i][j] <= '9') {
//                        if (map.containsKey(board[i][j]))
//                            return false;
//                        else
//                            map.put(board[i][j], 1);
//                    } else if (board[i][j] != '.')
//                        return false;
//                    else
//                        continue;
//                }
//            }
//            map.clear();
//            tmpj += 3;
//            if (tmpj >= 9)
//            {
//                tmpj = 0 ;
//                tmpi += 3;
//            }
//
//            if (tmpi >= 9)
//                break;
//
//        }
//
//        return true;
//
//    }


}
