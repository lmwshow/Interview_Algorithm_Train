import java.util.HashMap;
import java.util.Map;

/**
 * Created by limingwei on 16/12/6.
 */
public class leetcode3 {

    /**
     * 双重for循环 O(n^2)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s)
    {
        int maxLength=0 ,length=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0 ; i < s.length() ; i ++)
        {
            map.clear();
            for (int j = i ; j < s.length() ; j ++)
            {
                if (map.containsKey(s.charAt(j)))
                    break;                                  //跳出这个for循环 需要break

                map.put(s.charAt(j), 1);
                length++;
            }
            if (length > maxLength)
                maxLength = length;
            length = 0;
        }

        return maxLength;
    }


    /**
     * 出现重复字符的时候,下一次的循环开始位置该出现在哪里? 可以不一直像上面一样j右移
     * 判断当前j位置的字符,重复位置出现在k(k必然会小于j) ,那么下一个起始位置应该是k+1, 需要直接跳过这段重复
     * 时间复杂度为O(n)
     * @param
     */

    public static int betterSolution(String s)
    {
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0,j = 0 ; i < s.length() ; i ++)                   //j表示不断更新的起点
        {
            if (map.containsKey(s.charAt(i)))
            {
                j = Math.max(j,map.get(s.charAt(i)) + 1);               //需要取Max的原因是,重复位置k可能比当前起点小,然而此时取k+1为起点的话,长度肯定会比当前max要小
            }

            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);

        }

        return max;
    }


    public static void main(String[] args){


        System.out.println(betterSolution("pwwkew"));
    }

}
