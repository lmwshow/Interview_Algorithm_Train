package leetgroup.NP;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Gracecoder on 2017/7/20.
 *
 * n皇后问题  经典的回溯法   两个皇后不能出现在同一行 同一列 同一对角线
 */
public class n_queens {

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        helper(n,0,new int[n], res);
        return res;
    }

    //一行一行递归下去，每填完一行进行合法性检验，合法则继续
    private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> res)
    {
        //columnForRow表示第i行皇后的位置为columnForRow[i]
        if(row == n)
        {
            String[] item = new String[n];
            for(int i=0;i<n;i++)
            {
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(columnForRow[i]==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item[i] = strRow.toString();
            }
            res.add(item);
            return;
        }
        for(int i=0;i<n;i++)
        {
            columnForRow[row] = i;
            if(check(row,columnForRow))
            {
                helper(n,row+1,columnForRow,res);
            }
        }
    }
    private boolean check(int row, int[] columnForRow)
    {
        for(int i=0;i<row;i++)
        {
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
                return false;
        }
        return true;
    }

//    public static ArrayList<String[]> solveNQueens(int n) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        ArrayList<String[]> res = new ArrayList<>();
//
//        DFS(res,list,n);
//
//        return res;
//
//    }
//
//    private static void DFS(ArrayList<String[]> res, ArrayList<Integer> list, int n) {
//
//        if (list.size() == n)
//        {
//            String[] cur = new String[n];
//            int index = 0;
//            char[] ch = new char[n];
//            for (int i = 0 ; i < n; i++)
//                ch[i]='.';
//
//            Iterator iterator = list.iterator();
//            while (iterator.hasNext())
//            {
//                int i = (int) iterator.next();
//                ch[i] = 'Q';
//                String str = new String(ch);
//                ch[i] = '.';
//                cur[index++] = str;
//            }
//
//
//            res.add(cur);
//
//            return;
//        }
//
//        boolean flag = false;
//
//        for (int i = 0 ; i < n; i++)
//        {
//            if (list.contains(i))
//                continue;
//            for (int j = 0; j < list.size(); j++)
//            {
//                if (Math.abs(list.get(j) - i) == Math.abs(j - list.size()))         //判断同一对角线 可以用|x2-x1|==|y2-y1|  这里list index表示行数 list.get(index)表示列数
//                {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                flag =false;
//                continue;
//            }
//            list.add(i);
//            DFS(res,list,n);
//            list.remove(list.size() - 1);
//        }
//
//    }

}
