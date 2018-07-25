package again;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/7/25 08:59
 * @Description:
 *
 * 关键在于自定义排序规则
 * 需要将小的数放前面  从高位到地位一位位比
 * 对于长度不同的比较，需要将短的 按自己的数 循环扩充至长度一样 再进行比较 比如  ABC要扩成5位 ABCAB
 *
 */
public class 把数组排成最小的数 {


    public static String PrintMinNumber(int [] numbers) {

        if (numbers == null || numbers.length == 0)
            return "";

        Integer[] num = new Integer[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++)
            num[i] = numbers[i];

        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
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
        });

        StringBuilder sb = new StringBuilder("");
        for (int x : num)
            sb.append(x);

        return sb.toString();

    }
}
