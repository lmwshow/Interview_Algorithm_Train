package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/19 09:29
 * @Description:
 *
 * 1.找到形式，遍历判断过去即可
 * 表示数值的字符串 遵循模式  A[.[B]][e|EC] 或者  .B[e|EC] 其中A为数值的整数部分，B为紧跟小数点后的小数部分，C为指数部分
 * 在小数里可以没有整数部分，因此A部分不是必需的。如果一个数没有整数部分，那么小数部分不能为空。有整数部分的话，小数点后面部分可以为空
 */
public class 表示数值的字符串 {

    static int index = 0;

    public static boolean isNumeric(char... str) {

        boolean ans = false;
        if (str == null || str.length == 0)
            return ans;

        index = 0;
        ans = scanInteger(str);

        if (index < str.length && str[index] == '.')
        {
            index ++;

            // 下面一行代码用||的原因:
            // 1. 小数可以没有整数部分，如.123等于0.123
            // 2. 小数点后面可以没有数字 如233.等于233.0
            // 3. 当然，小数点前面和后面可以都有数字，如233.666

            // || ans , 或运算放后面, 是因为如果放前面会因为或运算的机制，直接跳过扫描整数，造成逻辑错误
            ans = scanUnsignedInteger(str) || ans;
        }

        if (index < str.length && (str[index]=='e' || str[index]=='E'))
        {
            index ++;

            ans = ans && scanInteger(str);
        }

        return ans && (index == str.length);
    }

    private static boolean scanInteger(char[] str) {

        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;

        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(char[] str) {

        int before = index;
        while (index < str.length && str[index] <= '9' && str[index] >= '0')
            index ++;

        return index - before > 0;

    }

    public static void main(String[] args){
        System.out.println(isNumeric('1','2','3','.','4','5','e','+','6'));
    }
}
