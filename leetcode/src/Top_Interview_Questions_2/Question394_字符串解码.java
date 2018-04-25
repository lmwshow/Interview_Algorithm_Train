package Top_Interview_Questions_2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: minGW
 * @Date: 2018/4/25 09:21
 * @Description:
 */
public class Question394_字符串解码 {

    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder("");
        Deque<Character> deque = new LinkedList<>();
        char ch = ' ';
        int num = 0;
        int base = 10;
        for (int i = 0 ; i < s.length() ; i++)
        {
            ch = s.charAt(i);
            if (ch!=']')
                deque.addLast(ch);
            else {
                ch = deque.pollLast();
                while (ch != '[')
                {
                    sb.insert(0,ch);
                    ch = deque.pollLast();
                }

                num = deque.pollLast() - '0';
                //并不一定数字就是一位的
                while (!deque.isEmpty() && deque.getLast() >= '0' && deque.getLast() <= '9')
                {
                    ch = deque.pollLast();
                    num = (ch - '0')*base + num;
                    base = base*10;
                }
                while (num -- > 0)
                {
                    for (int j = 0 ; j < sb.length() ; j++)
                        deque.addLast(sb.charAt(j));
                }

                sb.delete(0,sb.length());
                base = 10;

            }

        }

        while (!deque.isEmpty())
            sb.append(deque.pollFirst());

        return sb.toString();


    }
}
