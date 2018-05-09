package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/9 08:20
 * @Description:
 */
public class 斐波那契数列 {

    public static int Fibonacci(int n) {

        if (n == 0)
            return 0;
        int a = 1, b = 1, ans = 1;
        for (int i = 0; i < n - 2; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
    
    public static void main(String[] args){

        for (int i = 1 ; i <= 39 ; i++)
            System.out.println(Fibonacci(i));
    }
}
