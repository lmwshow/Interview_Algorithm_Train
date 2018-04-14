package leetgroup;

/**
 * Created by Gracecoder on 2017/5/10.
 *
 * 直接两头判断，遇到非字符跳过，这样就遍历一遍。 同时先小字母化，可以在判断是否为字符过程中 省去大写字母的情况
 *
 * 一开始先选择遍历一遍，把非字符都去掉先， 再去两头判断，多了遍历一遍的过程
 */
public class valid_palindrome {

    public static boolean isChar(char c)
    {
        if (('a'<=c&&c<='z')||('0'<=c&&c<='9'))
            return true;
        return false;
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int left = 0 ;
        int right = s.length()-1;
        while (left<right)
        {
            while (left < right && !isChar(s.charAt(left)))
                left++;
            while (left < right && !isChar(s.charAt(right)))
                right--;

            if (s.charAt(left)!=s.charAt(right))
                return false;

            left++;
            right--;

        }
        return true;

//        String tmp = new String("");
//        int length = s.length();
//        int i = 0;
//
//        while (i < length) {
//            while (i < length && (('a' <= s.charAt(i) && s.charAt(i) <= 'z') ||('0' <= s.charAt(i) && s.charAt(i) <= '9'))) {
//                tmp += s.charAt(i);
//                i++;
//            }
//
//            i++;
//        }

//        System.out.println(tmp);

//        int left = 0;
//        int right = s.length() - 1;
//
//        while (left < right && tmp.charAt(left) == tmp.charAt(right)) {
//            left++;
//            right--;
//        }
//        if (left < right)
//            return false;
//
//        return true;
    }


    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
