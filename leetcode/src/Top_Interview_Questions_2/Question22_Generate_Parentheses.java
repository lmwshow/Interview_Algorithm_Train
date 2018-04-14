package Top_Interview_Questions_2;


import java.util.ArrayList;
import java.util.List;

public class Question22_Generate_Parentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if (n == 0)
            return res;

        StringBuilder sb = new StringBuilder("");
        solver(res,sb,n,0);

        return res;
    }

    private static void solver(List<String> res, StringBuilder sb, int n, int pre) {

        if (sb.length() == 2*n)
        {
            if (pre==0) {
                String str = sb.toString();
                res.add(str);
            }
            return;
        }

        else
        {
            sb.append('(');
            solver(res,sb,n,pre+1);
            sb.deleteCharAt(sb.length()-1);

            if (pre>0)
            {
                sb.append(')');
                solver(res,sb,n,pre-1);
                sb.deleteCharAt(sb.length()-1);
            }

        }


    }


    public static void main(String[] args){

        List<String> res =new ArrayList<>();

        res = generateParenthesis(3);

        for (int i = 0 ; i < res.size(); i ++)
            System.out.println(res.get(i));

    }

}