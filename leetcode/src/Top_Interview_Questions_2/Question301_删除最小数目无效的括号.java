package Top_Interview_Questions_2;

import java.util.*;

/**
 * 删除最少的无效括号，使表达式合法
 * 1.BFS：使用队列，遍历删除0个，1个...n个括号的所有情况，每一层队列里面的元素表示删除了多少个括号
 *        判断该层字符串是否有效，一旦存在有效，不再入队列，将该层字符串判断完即可。
 *        为了保证不存在重复，可以使用set或map记录当前已经存在的合法字符串
 *
 * 更好的做法：
 * 2.DFS
 * 关键点：1.对于某个有效字符串，只生成一次。 不依赖set集合
 *        2.不需要预处理
 *
 * 首先判断字符串是否有效可以通过使用stack 或者一个简单便利counter
 * 为了让不符合要求的字符串，变得合法，需要移除一个')' 重点是移除哪一个，答案是移除前缀中任意一个都可以，但是为了保证不重复，这里限制只能移除前面一系列‘）’中的第一个
 * 在移除过后，我们就可以得到前面的合法字符串，然后就可以递归判断剩余字符串。
 * 这里需要记录最后一个移除的位置，然后通过移除这个位置之后的‘)’来保证不重复
 *
 * 最后还有一个问题就是，‘（’多了怎么办？
 * 只需要将字符串反转，然后重用代码就可以了
 *
 *
 */

public class Question301_删除最小数目无效的括号 {

    //DFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s,ans,0,0,new char[]{'(',')'});
        return ans;
    }

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {

        for (int stack= 0,i = last_i; i < s.length() ; i++)
        {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;

            for (int j = last_j ; j <= i ; j++)
            {
                if (s.charAt(j)== par[1] && (j == last_j || s.charAt(j-1)!=par[1]))
                    remove(s.substring(0,j)+s.substring(j+1),ans,i,j,par);
            }
                return;

        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')  // 刚完成从左到右
            remove(reversed,ans,0,0,new char[]{')','('});
        else    //完成从右到左
            ans.add(reversed);

    }

    //BFS
    public List<String> BFSremoveInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        if(s == null || s.length() == 0)
            return ans;

        Queue<String> queue = new LinkedList<>();
        Map<String,Boolean> map = new HashMap<>();
        queue.add(s);
        map.put(s,true);
        boolean find = false;
        int curLevel = 0;
        String curString ;
        while (!queue.isEmpty())
        {
            curLevel = queue.size();            //遍历当前层，删除最少的合法字符串，在越上层
            for (int i = 0 ; i < curLevel ; i++)
            {
                curString = queue.poll();
                if (isValid(curString))
                {
                    ans.add(curString);
                    find = true;
                }

                if (!find)                          //如果还未找到，递归删除下一个字符，将不重复的入队列
                {
                    for (int j = 0 ; j < curString.length() ; j++)
                    {
                        if (curString.charAt(j) != ')' && curString.charAt(j)!='(')
                            continue;

                        //将这个括号从字符串中去除
                        String sub = curString.substring(0,j)+curString.substring(j+1);
                        if (!map.containsKey(sub))
                        {
                            map.put(sub,true);
                            queue.add(sub);
                        }
                    }
                }
            }

        }
        return ans;

    }

    private boolean isValid(String curString) {
        int count = 0;

        for (int i = 0 ; i < curString.length() ; i++)
        {
            if (curString.charAt(i) == '(')
                count++;
            else if (curString.charAt(i) == ')')
                count--;

            if (count < 0)
                return false;
        }

        return count == 0;
    }


}
