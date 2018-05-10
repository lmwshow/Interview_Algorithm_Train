package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/10 07:37
 * @Description: https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 使用位运算， n&(n-1) 可以使最后一个1变为0
 */
public class 二进制中1的个数 {

    public int NumberOf1(int n) {

        int ans = 0;

        // n 可以为负数，所以条件为n!=0
        while (n != 0)
        {
            n = n&(n-1);
            ans++;
        }

        return ans;

    }
}
