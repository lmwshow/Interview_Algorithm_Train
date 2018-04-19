package 网易实习面试4_17;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 纸上让我将 a 填充到 99 个 a
 * 那自然不能循环99次吧 我想着 1 2 4 8 .. 这样复制， 但是因为想太久 写太慢（因为逻辑不清） 考官就直接让我说想法了
 * 递归 1 , 2, 4 ... copy(str,target) 这样。。   其实我也不知道对不对
 */
public class 将一个字符复制到n个字符 {

    public static String copy(String str,int target)
    {

        StringBuilder ans = new StringBuilder(str);
        StringBuilder base = new StringBuilder(str);
        int curLen = target;
        while (curLen > base.length() || ans.length() < target)
        {
            if (curLen > base.length()) {
                curLen -= base.length();
                ans.append(base);
                base.append(base);
            }else {
                base.delete(1,base.length());
                ans.append(base);
                base.append(base);
                curLen--;
            }

        }

        return ans.toString();

    }

    public static void main(String[] args){

        Scanner in  = new Scanner(System.in);
        while (true) {
            String ans = copy("a", in.nextInt());
            System.out.println(ans);
            System.out.println(ans.length());

            System.out.println(new Object().hashCode());
        }
    }
}
