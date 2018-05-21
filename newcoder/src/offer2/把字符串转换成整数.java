package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/21 08:31
 * @Description: https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class 把字符串转换成整数 {

    public static int StrToInt(String str) {

        if (str == null || str.length() == 0)
            return 0;

        boolean positive = true;
        int ans = 0;

//        if (str.equals("-2147483648"))
//            return Integer.MIN_VALUE;

        for (int i = 0 ; i < str.length() ; i++)
        {
            char cur = str.charAt(i);
            if (i == 0 && (cur == '+' || cur == '-'))
            {
                positive = cur == '+' ? true : false;
                continue;
            }else
            {
                if (cur >= '0' && cur <= '9')
                {

                    if ((Integer.MAX_VALUE - (cur - '0')) / 10 < ans || (Integer.MIN_VALUE + cur - '0')/10 >ans)
                        return 0;

                    if (!positive)
                        ans = ans * 10 - (cur - '0');
                    else
                        ans = ans * 10 + cur - '0';
                }
                else
                    return 0;
            }


        }

        return ans;

    }
    
    
    public static void main(String[] args){

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(StrToInt("-2147483650"));
    }
    
    
}
