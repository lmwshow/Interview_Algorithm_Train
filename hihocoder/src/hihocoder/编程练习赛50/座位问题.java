package hihocoder.编程练习赛50;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 座位问题 {


    //定义座位之间存在的空间
    static class Space{

        int start;      //左边人坐的下标
        int end;        //右边人坐的下标
        int len;        //空间长度

        public Space(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    public static void main(String[] args){


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int nums[] = new int[m+2];      //座位号从1 到n,0 和 n+1 为边界，这里设为有人坐了
        int ans[] = new int[k];
        int index = 0;

        nums[0] = 0;
        nums[m+1] = n+1;
        for (int i = 1 ;i <= m;i++)
            nums[i] = in.nextInt();

        Arrays.sort(nums);
        //大顶堆，优先推出空间大的,但是len相等的情况下  让 start小的 优先
        PriorityQueue<Space> queue = new PriorityQueue<>(new Comparator<Space>() {
            @Override
            public int compare(Space o1, Space o2) {
                if (o1.len == o2.len)
                    return o1.start - o2.start;
                else
                    return o2.len - o1.len;
            }
        });

        Space spaces[] = new Space[m];
        for (int i = 0 ; i < nums.length-1 ;i++)
        {
            if (nums[i+1]-nums[i]-1 == 0)
                continue;
            queue.add(new Space(nums[i],nums[i+1],nums[i+1]-nums[i]-1));
        }

        for (int i = 0 ;i < k;i++)
        {
            Space cur = queue.poll();
            int mid = ((cur.end - cur.start) >> 1) + cur.start;
            ans[index++] = mid;

            queue.add(new Space(cur.start,mid,mid - cur.start -1));
            queue.add(new Space(mid,cur.end,cur.end - mid - 1));
        }


        for (int i = 0 ; i < index ; i++)
            System.out.println(ans[i]);


    }
}
