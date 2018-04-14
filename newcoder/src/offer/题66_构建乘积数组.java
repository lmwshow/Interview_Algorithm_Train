package offer;

//不能使用除法，直观的方法是对每个元素 连乘n-1个数 得到答案，这样需要O(n^2)时间发咋读
//更高效的方法是，将B[i]的计算分为两部分，左半部分*右半部分
//用两个数组分别遍历一次 用乘法 计算出左半部分 和右半部分的乘积  这样能在O(n)内完成求解
public class 题66_构建乘积数组 {

    public int[] multiply(int[] A) {

        if (A == null)
            return null;

        int[] res = new int[A.length];

        int[] C = new int[A.length];
        int[] D = new int[A.length];

        C[0] = 1;
        D[A.length - 1] = 1;

        for (int i = 1;i < A.length; i++)
            C[i] = C[i-1]*A[i-1];

        for (int i = A.length -2 ; i >= 0 ; i--)
            D[i] = D[i+1]*A[i+1];

        for (int i = 0; i < A.length ; i++)
            res[i] = C[i] * D[i];

        return res;
    }
}
