package hihocoder.编程练习赛63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/6/10 12:57
 * @Description
 */
public class 密码更改 {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String S = in.readLine();

        int len = S.length();
        int oldPass = Integer.parseInt(S);
        int[] oldPassToArray = new int[len];
        int index = 0;
        for (char x : S.toCharArray())
            oldPassToArray[index++] = x - '0';

        int newPass = 0;

        boolean[] visit = new boolean[len];

        int maxDistance = (int)Math.pow(10,len)>>1;

        //newPass 表示 距离 oldPass 最大的数，但是可能不符合规则， 要过滤一下 使得newPass变动最小的基础上满足规则
        if (oldPass > maxDistance)
            newPass = oldPass - maxDistance;
        else
            newPass = oldPass + maxDistance;

        int[] ans = filter(newPass,visit,len);
        for (int i = 0 ; i < ans.length ; i++)
            System.out.print(ans[i]);




    }

    private static int[] filter(int newPass,boolean[] visit,int len) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();         //小顶堆

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            pq.add(i);
            pq1.add(i);
        }

        int[] tmp = new int[len];
        int index = len -1;
        while (newPass!=0)
        {
            tmp[index--] = newPass % 10;
            newPass /= 10;
        }

        boolean first = true;
        boolean flag = true;        //选择哪一个

        //如果第一个不同的位选择比newPass小，后面尽量大，已减小进位，  反之尽量小
        for (int i = 0 ; i < len; i++)
        {
            if (first)
            {
                if (visit[tmp[i]])
                {
                    //需要选一个距离tmp[i]最近的数字，而不是选当前最大的
                    int k = 0;
                    int curmin = tmp[i];
                    while (!pq.isEmpty() && pq.peek() > tmp[i]) {
                        list.add(pq.peek());
                        curmin = pq.poll() - tmp[i];
                    }

                    //判断越界
                    if (!pq.isEmpty() && curmin > (tmp[i] - pq.peek())) {
                        tmp[i] = pq.poll();     //接下来用大顶堆
                        pq1.remove(tmp[i]);
                    } else {
                        tmp[i] = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        flag = false;       //接下来用小顶堆
                        pq1.remove(tmp[i]);
                    }

                    visit[tmp[i]] = true;

                    for (int j = 0; j < list.size(); j++)
                        pq.add(list.get(j));

                    list.clear();

                    first = false;
                }
                else
                {
                    visit[tmp[i]] = true;
                    pq.remove(tmp[i]);
                    pq1.remove(tmp[i]);
                }
            }
            else {
                if (flag)
                    tmp[i] = pq.poll();
                else
                    tmp[i] = pq1.poll();

                visit[tmp[i]]=true;
            }

        }

        return tmp;

    }
}
