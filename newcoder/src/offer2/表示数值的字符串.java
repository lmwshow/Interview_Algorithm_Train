package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/21 10:48
 * @Description: https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 可以通过这种扫描过去的方法，判断带符号整数，小数点，无符号整数，e|E，整数
 * 为了方便在函数调用中 遍历str  这里采用StringBuilder
 *
 * 方法2: 有限状态自动机 http://www.bo-song.com/leetcode-valid-number/
 */
public class 表示数值的字符串 {

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
