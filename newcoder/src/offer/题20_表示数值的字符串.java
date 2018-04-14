package offer;

/**
 * Created by Gracecoder on 2017/12/19.
 *
 * 可以通过这种扫描过去的方法，判断带符号整数，小数点，无符号整数，e|E，整数
 * 为了方便在函数调用中 遍历str  这里采用StringBuilder
 *
 * 方法2: 有限状态自动机
 */
public class 题20_表示数值的字符串 {

    public static boolean isNumeric(char[] str) {

        if (str == null)
            return false;

        StringBuilder sb = new StringBuilder();
        for (char c: str)
            sb.append(c);

        //首先判断前面是否是一个整数
        boolean numeric = scanInteger(sb);

        if (sb.length()!=0 && sb.charAt(0)=='.')
            numeric = scanUnsignedInteger(sb.deleteCharAt(0)) || numeric;
        //如果出现'.'，则接下来是小数部分， 这里用||的原因是 1.小数可以有没整数部分 2.小数点后面可以没有数字 3.小数点前后都可以有数字  但是不能前后都没有

        if (sb.length()!=0 && (sb.charAt(0)=='e' || sb.charAt(0)=='E'))
            numeric = numeric && scanInteger(sb.deleteCharAt(0));
        //这里用&& ， 是因为e前面不能没有数字  同时e后面也不能没有数字


        return numeric && sb.length() == 0;

    }

    private static boolean scanInteger(StringBuilder sb) {

        if (sb.length()!=0 && (sb.charAt(0)=='-'||sb.charAt(0)=='+'))
            return scanUnsignedInteger(sb.deleteCharAt(0));
        return scanUnsignedInteger(sb);

    }

    private static boolean scanUnsignedInteger(StringBuilder sb) {

        boolean res = false;

        while (sb.length()!=0&&sb.charAt(0)>='0'&&sb.charAt(0)<='9') {
            res = true;
            sb.deleteCharAt(0);
        }

        return res;
    }

    public static void main(String[] args){

        isNumeric(new char[]{'1','2','e'});
    }

}
