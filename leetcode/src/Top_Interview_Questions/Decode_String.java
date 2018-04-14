package Top_Interview_Questions;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/11/9.
 *
 * 通常一想就是用栈
 */
public class Decode_String {

    public static String decodeString(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int numIndex = 0,repeate = 0,len = s.length(),count = 0;


        for (int i = 0 ; i < len ; i ++)                   //len 跟着sb 变化，每次处理后，对i赋值为重复过后的下一个正确index即可
        {
            while (sb.charAt(i) >= '0' && sb.charAt(i)<='9')
            {
                repeate = repeate*10 + sb.charAt(i) - '0';          //当reapte是多位数的时候
                i++;
                count ++;
            }
            if (sb.charAt(i)== '[') {
                stack.push(count);                                  //先入栈数字的位数
                stack.push(repeate);                                //然后重复次数
                stack.push(i);                                      //最后[的下标
            }
            else if (sb.charAt(i)==']')
            {
                numIndex = stack.pop()-1;
//                repeate = sb.charAt(numIndex) - '0';
                repeate = stack.pop();
                count = stack.pop();
                StringBuilder sub = new StringBuilder();
                for (int j = 0 ; j < repeate ; j++)
                    sub.append(sb.substring(numIndex+2,i));

                String pre = sb.substring(0,numIndex-count+1);
                String tail = sb.substring(i+1);

                sb = new StringBuilder(pre + sub + tail);

                len = sb.length();
                i = i - count - 2 + repeate -1;

            }

            repeate = 0;
            count = 0;

        }

        return sb.toString();

    }

    public static void main(String[] args){

        System.out.println(decodeString("3[a]2[bc]"));


    }

}
