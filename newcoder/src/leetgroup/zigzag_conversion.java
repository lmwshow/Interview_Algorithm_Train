package leetgroup;

/**
 * Created by Gracecoder on 2017/9/20.
 *
 * 按照规律的话 不止一种步数，有两种，那么就一次走一组
 */
public class zigzag_conversion {

    public static String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows <=0)
            return "";
        if (numRows ==1 )
            return s;
        
        StringBuilder res = new StringBuilder("");



        for (int i = 0 ; i < numRows ; i++)
        {
            int step1 = (numRows - i -1)*2;
            int step2 = i*2;

            int pos = i;
            if (pos < s.length())
                res.append(s.charAt(pos));

            while (true)
            {
                pos += step1;
                if (pos >= s.length())
                    break;
                if (step1 > 0)
                    res.append(s.charAt(pos));

                pos += step2;
                if (pos >= s.length())
                    break;

                if (step2 > 0)
                    res.append(s.charAt(pos));

            }
        }

        return res.toString();
        
    }
    
    public static void main(String[] args){
        
        System.out.println(convert("123456789", 3));
        
    }
}
