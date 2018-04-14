package offer;

//http://blog.csdn.net/yi_afly/article/details/52012593
//从1到n整数中1出现的次数：O(logn)算法

public class 题43_整数中1出现的次数_1到n {

    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n ;
        while ( round > 0)
        {
            int weight = round % 10;
            round /= 10;
            count += round*base;
            if (weight == 1)
                count += (n%base) +1;
            else if (weight > 1)
                count += base;

            base*=10;
        }

        return count;


    }
}
