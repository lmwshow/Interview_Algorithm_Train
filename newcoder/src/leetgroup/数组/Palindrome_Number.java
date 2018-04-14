package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/22.
 */
public class Palindrome_Number {
    public static boolean isPalindrome(int x) {

        int len = 1;
        int tmp =x;

        if (x < 0)
            return false;
        while (tmp/10!=0)
        {
            tmp = tmp/10;
            len++;
        }
        int max = (int) Math.pow(10,len-1);
        while (max >= 10)
        {
            if (x/max != x%10)
                return false;
            else
            {
                x -= x/max*max;
                x /= 10;
                max /= 100;
            }
        }
        return true;
    }

    public static void main(String[] args){

        boolean res = isPalindrome(-2147447412);

        System.out.println(res);

    }
}
