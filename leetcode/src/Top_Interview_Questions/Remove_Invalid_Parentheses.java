package Top_Interview_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/11/4.
 */
public class Remove_Invalid_Parentheses {

    public static List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<>(null);

        if (s == null || s.length() == 0)
            return res;

        DFS(res,s,0,0,new char[]{'(',')'});


        return res;
    }

    private static void DFS(List<String> res, String s, int last_i, int last_j, char[] chars) {

        for (int count = 0, i = last_i; i < s.length() ; i++)
        {
            if (s.charAt(i) == chars[0]) count ++;
            if (s.charAt(i) == chars[1]) count --;
            if (count >= 0) continue;                                   //靠这里跳出for循环的
            for (int j = last_j ; j < s.length() ; j++)
            {
                if (s.charAt(j) == chars[1] && (j==last_j || s.charAt(j-1)!=chars[1]))
                    DFS(res,s.substring(0,j)+s.substring(j+1,s.length()),i,j,chars);

            }

            return;                          //从这里return说明对于当前非法的字符串，已经遍历完最后一个删除位置到当前位置所有可能的删除的情况
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (chars[0] == '(') // finished left to right,如果等于 '('说明进行完第一次遍历，还需要第二次
            DFS(res, reversed, 0, 0, new char[]{')', '('});
        else // finished right to left
            res.add(reversed);



    }

    public static void main(String[] args){

        List<String> res = new ArrayList<>();

        res = removeInvalidParentheses("()())()");

        for (String x : res)
            System.out.println(x);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        Stack<Integer> tmp = (Stack<Integer>) stack.clone();
        stack.pop();

        System.out.println(tmp.size());


    }
}
