package leetgroup.NP;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/8/7.
 *
 * 回溯 NP套路
 * 一步一步往前试探，走一步验证当前有效性
 *
 * 这里的验证每一步有效性比较简单。 放 '（' 没有条件， 放')'值需要需要之前的'（'数量大于0 即可
 */
public class generate_Parenthesis {

    public ArrayList<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();
        if (n == 0)
            return res;

        char[] tmp = new char[2*n];

        helper(res,tmp,0,n,n,n,0);
        return res;
    }

    private void helper(ArrayList<String> res, char[] tmp,int index, int n,int lrest,int rrest,int x) {

        if (index == 2*n)
        {
            StringBuilder str = new StringBuilder();
            for (char c: tmp
                 ) {
                str.append(c);
            }

            res.add(String.valueOf(str));
            return;
        }

        if (lrest > 0)
        {
            x++;
            lrest --;
            tmp[index] = '(';
            helper(res,tmp,index+1,n,lrest,rrest,x);
            tmp[index] = ' ';
            x--;
            lrest ++;

        }
        if (rrest > 0)
        {

            if (x > 0)
            {
                rrest -- ;
                tmp[index] = ')';
                x--;
                helper(res,tmp,index +1 ,n,lrest,rrest,x);
                x++;
                rrest++;
            }


        }

    }
}
