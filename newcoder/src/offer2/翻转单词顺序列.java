package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/19 09:15
 * @Description: https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 1.先使用spilt,再逆序输出字符串，需要额外空间O(n)
 *
 * 2.先翻转整个句子，再翻转句子中的每个单词
 */
public class 翻转单词顺序列 {


    public static String ReverseSentence(String str) {

        if (str == null || str.length() == 0 || str.trim().length() == 0)
            return str;

        StringBuilder sb = new StringBuilder(str);

        sb.reverse();

        System.out.println(sb.toString());

        int left = 0;
        int right = 0;
        while (right < sb.length())
        {
            if (sb.charAt(left) == ' ')
            {
                left ++;
                right ++;
            }else if (sb.charAt(right) == ' ' || right == sb.length()-1)
            {
                if (right == sb.length() - 1)
                    reverse(sb,left,right);
                else
                    reverse(sb,left,right-1);
                left = ++right;
            }else
                right++;
        }

        return sb.toString();

    }

    private static void reverse(StringBuilder sb, int left, int right) {

        while (left < right)
        {
            char tmp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,tmp);
            left++;
            right--;

        }
        return;
    }

//    public static String ReverseSentence(String str) {
//
//        if (str == null || str.length() == 0)
//            return str;
//
//
//        //都是空格的话 返回原字符串
//        if (str.trim().length() == 0)
//            return str;
//
//        String[] strings = str.split(" ");
//
//        StringBuilder ans = new StringBuilder("");
//
//        for (int i = strings.length - 1; i >= 0 ; i--)
//        {
//
//            ans.append(strings[i]);
//
//            if (i > 0)
//                ans.append(" ");
//        }
//
//        return ans.toString();
//
//    }
    
    public static void main(String[] args){
        
        System.out.println(ReverseSentence("wonderful"));
    }
}
