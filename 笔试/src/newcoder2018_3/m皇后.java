package newcoder2018_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class m皇后 {

    //O(n^2 暴力 时间会超时)
    //这题对内存也有限制，不能用图，只能用点
    //可以将8个方向，分成四个方向，即4条对称轴
    //且对每次对一个方向遍历， 遍历的时候先对点进行排序， 然后来回个遍历一次，一次遍历只能算出一个方向是否存在其他店，所以需要来回各一遍
    static int[] degree = new int[8];


    static class Point{
        int x;
        int y;
        int count = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //计算左右方向,x相等的情况下，根据y从小到大排，否则根据x从小到大
    static int cmp1(Point point1,Point point2)
    {
        if (point1.x == point2.x)
            return point1.y - point2.y;
        else
            return point1.x - point2.x;
    }

    //计算上下方向,y相等的情况下，根据x从小到大排，否则根据y从小到大
    static int cmp2(Point point1,Point point2)
    {
        if (point1.y == point2.y)
            return point1.x - point2.x;
        else
            return point1.y - point2.y;
    }

    //计算右上和左下方向,(x-y)相等的情况下，根据x从小到大排序
    static int cmp3(Point point1,Point point2)
    {
        //斜率为1线上的点
        if (point1.x + point1.y == point2.x + point2.y)
            return point1.x - point2.x;
        else
            return (point1.x + point1.y) - (point2.x + point2.y);
    }

    //计算右上和左下方向
    static int cmp4(Point point1,Point point2)
    {
        //斜率为-1线上的点
        if (point1.x - point1.y == point2.x - point2.y)
            return point1.x - point2.x;
        else
            return (point1.x - point1.y) - (point2.x - point2.y);
    }

    public static void main(String[] args){


        Point[] test = new Point[4];
        test[0] = new Point(4,4);
        test[1] = new Point(2,2);
        test[2] = new Point(3,3);
        test[3] = new Point(2,4);

        Arrays.sort(test, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return cmp4(o1,o2);
            }
        });





        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Point[] points = new Point[m];


        for (int i = 0 ;i < m ; i++)
            points[i] = new Point(in.nextInt(), in.nextInt());


        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return cmp1(o1,o2);
            }
        });

        for (int i =0; i < m-1;i++)
            if (points[i].x == points[i+1].x) points[i].count++;
        for (int i = m-1; i > 0; i--)
            if (points[i].x == points[i-1].x) points[i].count++;


        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return cmp2(o1,o2);
            }
        });

        for (int i = 0 ; i < m-1;i++)
            if (points[i].y == points[i+1].y) points[i].count++;
        for (int i = m-1; i > 0; i--)
            if (points[i].y == points[i-1].y) points[i].count++;

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return cmp3(o1,o2);
            }
        });

        for (int i = 0 ; i < m-1;i++)
            if (points[i].x+points[i].y == points[i+1].x + points[i+1].y) points[i].count++;
        for (int i = m-1; i > 0; i--)
            if (points[i].x+points[i].y == points[i-1].x + points[i-1].y) points[i].count++;

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return cmp4(o1,o2);
            }
        });

        for (int i = 0 ; i < m-1;i++)
            if (points[i].x-points[i].y == points[i+1].x - points[i+1].y) points[i].count++;
        for (int i = m-1; i > 0; i--)
            if (points[i].x-points[i].y == points[i-1].x - points[i-1].y) points[i].count++;


        int[] ans = new int[9];

        for (int i = 0; i < m ;i ++)
            ans[points[i].count]++;

        System.out.print(ans[0]);

        for (int i = 1 ; i < 9; i++)
            System.out.print(" " + ans[i]);


    }


}
