package Top_Interview_Questions_2.again;

import java.util.ArrayList;
import java.util.List;



public class Question22_生成括号 {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;

        StringBuilder sb = new StringBuilder("");

        solver(res,sb,0,0,n);

        return res;

    }

    private static void solver(List<String> res, StringBuilder sb, int left, int right, int n) {

        if (sb.length() == 2*n)
        {
            String str = sb.toString();
            res.add(str);
            return;
        }


        if (left < n)       // (的总数要小于n
        {
            sb.append('(');
            solver(res,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left)   // )的数量小于(时，才能添加)
        {
            sb.append(')');
            solver(res,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args){

        List<String> res =new ArrayList<>();

        res = generateParenthesis(3);

        for (int i = 0 ; i < res.size(); i ++)
            System.out.println(res.get(i));

    }

}
