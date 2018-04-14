package leetgroup.数学;

/**
 * Created by Gracecoder on 2017/9/7.
 */
public class 二进制相加 {

    public static String addBinary(String a, String b) {

        StringBuilder sum = new StringBuilder("");

        int lena = a.length();
        int lenb = b.length();

        int i = lena-1;
        int j = lenb-1;
        int k = 0;

        while (i >= 0 && j>=0)
        {
            int cur = ( a.charAt(i)-'0' )+ ( b.charAt(j) - '0') + k;
            sum.insert(0,cur%2);
            k = cur/2;
            i--;
            j--;
        }

        while (i>=0)
        {
            int cur =  ( a.charAt(i)-'0' ) + k;
            sum.insert(0,cur%2);
            k = cur/2;
            i--;
        }

        while (j>=0)
        {
            int cur =  ( b.charAt(j)-'0' ) + k;
            sum.insert(0,cur%2);
            k = cur/2;
            j--;
        }

        if (k!=0)
            sum.insert(0,k);


        return sum.toString();

    }

    public static void main(String[] args){

        String res = addBinary("1","111");
        System.out.println(res);


    }
}
