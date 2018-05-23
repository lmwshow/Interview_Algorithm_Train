package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/21 09:38
 * @Description: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class 构建乘积数组 {

    public int[] multiply(int[] A) {

        if (A == null || A.length == 0)
            return A;

        //head[i] 表示 A[0]*A[1]...*A[i]
        //tail[i] 表示 A[i]*..A[n-1]
        int[] head = new int[A.length];
        int[] tail = new int[A.length];
        head[0] = A[0];
        tail[A.length - 1] = A[A.length-1];
        for (int i = 1; i < A.length ; i++)
            head[i] = A[i]*head[i-1];

        for (int i = A.length -2 ; i>= 0 ; i--)
            tail[i] = A[i]*tail[i+1];

        int[] ans = new int[A.length];
        ans[0] = tail[1];
        ans[A.length - 1] = head[A.length -2 ];

        for (int i = 1 ; i < A.length - 1; i++)
            ans[i] = head[i-1]* tail[i+1];

        return ans;



    }
}
