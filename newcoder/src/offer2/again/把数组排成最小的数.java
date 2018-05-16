package offer2.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/5/16 09:28
 * @Description https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 关键在于自定义排序规则
 * 需要将小的数放前面  从高位到地位一位位比
 * 对于长度不同的比较，需要将短的 按自己的数 循环扩充至长度一样 再进行比较 比如  ABC要扩成5位 ABCAB
 */
public class 把数组排成最小的数 {

    static class MyCompare implements Comparator
    {

        @Override
        public int compare(Object o1, Object o2) {
            Integer x = (Integer)o1;
            Integer y = (Integer)o2;

            List<Integer> xlist = new ArrayList<>();
            List<Integer> ylist = new ArrayList<>();

            while (x > 0)
            {
                xlist.add(0,x%10);
                x /= 10;
            }

            while (y > 0)
            {
                ylist.add(0,y%10);
                y /= 10;
            }

            int index = 0;
            while (xlist.size() < ylist.size())
                xlist.add(xlist.get(index++));
            while (ylist.size() < xlist.size())
                ylist.add(ylist.get(index++));


            int curx = 0;
            int cury = 0;

            for (int i = 0 ; i < xlist.size();i++)
            {
                curx = xlist.get(i);
                cury = ylist.get(i);

                if (curx > cury)
                    return 1;
                else if (curx < cury)
                    return -1;

            }

            return 0;

        }
    }

    public static String PrintMinNumber(int [] numbers) {

        if (numbers == null || numbers.length == 0)
            return "";

        Integer[] num = new Integer[numbers.length];
        for (int i = 0 ;i < numbers.length ; i++)
            num[i] = numbers[i];

        Arrays.sort(num,new MyCompare());


        StringBuilder sb = new StringBuilder("");

        for (int x : num)
            sb.append(x);


        return sb.toString();
    }




    static int min;

    //将String转为Int比较大小，会越界，String可能超出Integer范围，关键还是String的比较器重写
    public static String DFS_PrintMinNumber(int [] numbers) {


        if (numbers == null || numbers.length == 0)
            return null;

        String[] strs = new String[numbers.length];
        int index = 0;
        for (int num : numbers)
            strs[index ++] = Integer.toString(num);

        min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        dfs(strs,list,sb);

        return Integer.toString(min);

    }

    private static void dfs(String[] strings, List<Integer> list, StringBuilder sb) {

        if (list.size() == strings.length)
        {
            int cur = Integer.parseInt(sb.toString());
            if (cur < min)
                min = cur;
            return;
        }

        for (int i = 0 ; i < strings.length ; i++)
        {
            if (list.contains(i))
                continue;

            list.add(i);
            sb.append(strings[i]);
            dfs(strings,list,sb);
            sb.delete(sb.length() - strings[i].length(),sb.length());
            list.remove(list.size()-1);
        }


    }

    public static void main(String[] args){

        System.out.println(
        PrintMinNumber(new int[]{1,2,123,1212}));


    }
}
