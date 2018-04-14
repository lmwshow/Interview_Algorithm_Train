package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class 题38_字符串的排列 {
    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

//        ArrayList<Character> curPath = new ArrayList<>();       //用Character判断，是否已存在 无法解决含有重复的字符
        ArrayList<Integer> curPath = new ArrayList<>();
        solver(chars,curPath,res);

        return res;
    }

    private static void solver(char[] chars, ArrayList<Integer> curPath, ArrayList<String> res) {

        if (curPath.size() == chars.length)
        {
            StringBuilder tmp = new StringBuilder("");
            for (int x : curPath)
                tmp.append(chars[x]);
            if (!res.contains(tmp.toString()))              //避免重复
                res.add(tmp.toString());
            return;
        }

        for (int i = 0 ; i < chars.length ; i++)
        {
            if (!curPath.contains(i))
            {
                curPath.add(i);
                solver(chars,curPath,res);
                curPath.remove(curPath.size() -1);
            }
        }
        return;

    }
    
    public static void main(String[] args){
        
    
        ArrayList<String> list = new ArrayList<>();
        list = Permutation(new String("aAAAa"));
        
        System.out.println("");
        
        
    }
}
