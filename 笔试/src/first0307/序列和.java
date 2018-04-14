package first0307;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/3/9.
 * 需要找到长度大于等于L，且小于100 的子序列和为N的序列
 * 容易观察到合法的长度范围很小,于是我们从L开始枚举,然后找到第一个输出即可。   即关键是先确定L
 * 设a为开头，b为结尾
 * L = b-a+1     N = （a + b）* L /2
 * L-1 = b - a <= a + b
 * ==> N-L*(L-1)/2>=0       且 N-L*(L-1)/2 = （a + b）* L /2 - L*(b - a)/2 = aL
 * 则可以确认L  以及a
 */
public class 序列和 {

    public static List<Long> findSequence(int L0,long N)
    {
        List<Long> res = new ArrayList<>();

        for (int L = L0; L <= 100 ; L++)
        {
            if (N-L*(L-1)/2>=0 && (N-L*(L-1)/2)%L==0)
            {
                long start = (N-L*(L-1)/2)/L;
                for (int i =0 ; i < L; i ++)
                    res.add(start++);
                return res;
            }
        }

        return res;
    }
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        int L = in.nextInt();
        
        List<Long> res = findSequence(L,N);
        if (res.size() == 0) {
            System.out.println("No");
            return;
        }

        for (int i =0 ; i < res.size(); i++)
            if (i == 0)
                System.out.print(res.get(i));
            else
                System.out.print(" " + res.get(i));

    }
}
