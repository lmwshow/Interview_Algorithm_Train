package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/10 07:40
 * @Description:https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 类似求2^n次，可以对递归进行优化，折半
 */
public class 数值的整数次方 {

    public static double Power(double base, int exponent) {

        if (base == 0 || base == 1)
            return base;

        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;

        //考虑exponent为负的情况
        if (exponent < 0)
        {
            base = 1/base;
            exponent = -exponent;
        }

        if ((exponent&1) == 1)
            return base*Power(base,exponent-1);
        else
            return Power(base*base,exponent >> 1);

    }
    
    public static void main(String[] args){
     
        System.out.println(Power(2,-4));
    }
}
