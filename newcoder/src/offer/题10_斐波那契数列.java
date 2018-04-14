package offer;

/**
 * Created by Gracecoder on 2017/12/7.
 */
public class 题10_斐波那契数列 {
    public static int Fibonacci(int n) throws Exception {

        if (n<0)
            throw new Exception("error,n should > 0");
        else if (n <=1)
            return n;
        else {
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 2; i <= n ;i++)
            {
                c = a+b;
                a = b;
                b = c;
            }


            return c;
        }

    }



    public static void main(String[] args){

        try {

            System.out.println(Fibonacci(2));
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
