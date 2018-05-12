package offer2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/12 07:46
 * @Description: https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 判断序列是否为出栈序列  卡塔兰数的应用
 */
public class 栈的压入弹出序列 {

    static int ans = 0;

    //模拟栈的入栈出栈，遍历出栈序列，当栈顶等于当前出栈元素时，出栈，否则入栈。 看最后栈是否为空
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA == null || pushA.length == 0)
            return true;

        Stack<Integer> stack = new Stack<>();
        int pushindex = 0,popindex = 0;

        while (popindex < popA.length)
        {
            while (stack.isEmpty() || stack.peek()!=popA[popindex])
            {
                if (pushindex == pushA.length)
                    break;

                stack.push(pushA[pushindex++]);
            }

            if (stack.peek()!=popA[popindex])
                break;

            stack.pop();
            popindex++;
        }

        if (stack.isEmpty() && popindex == popA.length)
            return true;

        return false;

    }



    //所有出栈序列的总数
    public static boolean CatalanNumber(int [] pushA,int [] popA) {

        if (pushA == null || pushA.length == 0)
            return true;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        allPopOrder(list,cur,pushA,0,stack);

        System.out.println(ans);
        return true;

    }

    private static void allPopOrder(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> cur, int[] pushA, int index, Stack<Integer> stack) {

        if (index == pushA.length)
        {
            ans++;
//            while (!stack.isEmpty())
//                cur.add(stack.pop());
//            list.add(new ArrayList<>(cur));
            return;
        }


        stack.push(pushA[index]);           //入栈
        allPopOrder(list,cur,pushA,index+1,stack);
        stack.pop();                        //回溯

        if (!stack.isEmpty()) {             //出栈
            int tmp = stack.peek();
            cur.add(stack.pop());
            allPopOrder(list,cur,pushA,index,stack);
            stack.push(tmp);                //回溯
        }





    }


    public static void main(String[] args){

        IsPopOrder(new int[]{1,2,3,4,5},new int[]{1,2,3,4,5});
    }
}
