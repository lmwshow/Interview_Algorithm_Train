package leetgroup;

import java.util.*;

/**
 * Created by Gracecoder on 2017/5/16.
 *
 * 穷举法，从第一个数开始遍历，用 num 和temp分别记录同线和重合的点数目，最后之和即
 * 为最大值。具体就是，选一个进入，与其后的第二个点比较，组合成一条直线，进而判断其后的
 * 第三至第N个点在不在这条直线上。
 *
 * 一个点确定了，那么只需要斜率k相等，就在一条直线上，不需要再去算b。
 *
 * 而且这样就可以通过，相乘的方法去判断k是否相等， 即避免了分母=0 即垂直的情况，又避免了相除不精确的情况
 */

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

class K {
    int x;
    int y;

    public K(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class PointSet extends Point
{
    int count;

    public PointSet(int a, int b, int count) {
        super(a, b);
        this.count = count;
    }
}



public class max_points_on_a_line {




    public static int maxPoints(Point[] points) {

        int length = points.length;
        if (length <= 2)
            return length;

        int x,y,x1,y1,x2,y2;
        int dx1,dy1,dx2,dy2;
        int max = 2;

        for (int i = 0 ; i < length; i ++)
        {
            int num = 1;
            int dum = 0;                //表示重复点数（与当前基点的重复点数）
            x = points[i].x;
            y = points[i].y;
            for (int j = i+1; j < length ; j++)
            {
                x1 = points[j].x;
                y1 = points[j].y;

                dx1 = x1 - x;
                dy1 = y1 - y;

                if (dx1 == 0 && dy1 == 0)
                    dum ++;
                else {
                    for (int m = j ; m < length;m++)
                    {
                        x2 = points[m].x;
                        y2 = points[m].y;

                        dx2 = x2 - x;
                        dy2 = y2 - y;

                        if (dx1*dy2 == dx2 *dy1)
                            num++;
                    }

                }

                max = (num + dum) > max? (num+dum):max;
                num = 1;


            }
        }

        return max;


    }


    public static void main(String[] args) {


        int res = maxPoints(new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)});

        System.out.println(res);

    }


    public static void quickSort(Point[] points,int left,int right)
    {
           int i=left , j=right;
           Point tmp;
           if (left>right)
               return;

           tmp = points[left];

           while (i!=j)
           {
               while (points[right].x >= tmp.x && i < j)
                   j--;
               points[i] = points[j];

               while (points[left].x <= tmp.x && i < j)
                   i++;
               points[j] = points[i];

           }
           points[i] = tmp;

           quickSort(points,left,i-1);
           quickSort(points,i+1,right);
           return;

    }
}


