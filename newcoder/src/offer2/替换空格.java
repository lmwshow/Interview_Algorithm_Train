package offer2;

/**
 * @Auther: minGW
 * @Date: 2018/5/8 07:38
 * @Description: https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * StringBuffer 和 StringBuilder的区别
 */
public class 替换空格 {

    public String replaceSpace(StringBuffer str) {

        StringBuilder sb = new StringBuilder("");
        String replace = "%20";
        for (int i = 0 ; i < str.length() ; i ++)
        {
            if (str.charAt(i) == ' ')
                sb.append(replace);
            else
                sb.append(str.charAt(i));
        }

        return sb.toString();

    }

}
