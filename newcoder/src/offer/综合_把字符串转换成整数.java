package offer;

public class 综合_把字符串转换成整数 {

    public static int StrToInt(String str) {

        if (str == null || str.length() == 0)
            return 0;

        int num = 0;
        boolean minus = false;
        int i = 0;
        if (str.charAt(0) == '-')
            minus = true;
        if (str.charAt(0) == '-' || str.charAt(0) == '+')
            i ++;
        for (; i < str.length() ; i++)
        {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                if ((!minus && num > (Integer.MAX_VALUE -(str.charAt(i) - '0'))/10))
                {
                    num = 0;
                    break;
                }
                num = num*10 + str.charAt(i) - '0';
            }else
            {
                num = 0;
                break;
            }
                
        }

        if (minus)
            num = -num;

        return num;
    }


    public static void main(String[] args){

        System.out.println(StrToInt("-123"));


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        


    }

}
