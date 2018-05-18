package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/18 09:04
 * @Description: https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class 左旋转字符串 {

    public static String LeftRotateString(String str,int n) {

        if (str == null || str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder("");

        n = n % str.length();

        sb.append(str.substring(n,str.length())).append(str.substring(0,n));

        return sb.toString();
    }

    public static void main(String[] args){

        System.out.println(LeftRotateString("",3));
    }
}
