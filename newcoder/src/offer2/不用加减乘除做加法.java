package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/19 10:39
 * @Description: https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 首先看十进制是如何做的： 5+7=12，三步走
 * 第一步：相加各位的值，不算进位，得到2。
 * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
 * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
 * 同样我们可以用三步走的方式计算二进制值相加
 */
public class 不用加减乘除做加法 {

    public int Add(int num1,int num2) {

        int sum = 0;
        int carry = 0;

        do {
            sum = num1 ^ num2;          //第一步：不计算进位，那么可以用异或来计算
            carry = (num1 & num2) << 1; //第二步：计算进位，只有两个都为1的时候回产生进位，然后左移一位 即为进位产生的数的大小
            num1 = sum;
            num2 = carry;
        }while (num2!=0);              //一直循环相加 直到 进位产生的数字为0

        return sum;
    }
}
