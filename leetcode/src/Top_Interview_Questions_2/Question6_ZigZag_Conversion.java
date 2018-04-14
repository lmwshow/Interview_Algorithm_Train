package Top_Interview_Questions_2;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Question6_ZigZag_Conversion {

    public static String convert(String s, int numRows) {

        if (s == null || s.length()==0 || numRows == 0)
            return new String("");
        if (numRows == 1)
            return s;

        StringBuilder res = new StringBuilder("");

        for (int i = 0 ; i < numRows ; i++)
        {
            //按照规律的话 不止一种步数，有两种，那么就一次走一组

            int step1 = 2*(numRows - 1 - i);      //2(numRows - 1) - 2i
            int step2 = 2*i;

            int pos = i;
            if (pos < s.length())
                res.append(s.charAt(pos));

            //一次走一组
            while (pos < s.length())
            {
                if (step1!=0)
                {
                    pos+=step1;
                    if (pos >= s.length())
                        break;
                    res.append(s.charAt(pos));
                }

                if (step2!=0)
                {
                    pos+=step2;
                    if (pos >= s.length())
                        break;
                    res.append(s.charAt(pos));
                }
            }
        }

        return res.toString();



    }


    public static void main(String[] args){

        System.out.println(convert("ABC",2));


    }
}
