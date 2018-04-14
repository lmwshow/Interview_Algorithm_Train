package hihocoder.编程练习赛45;

import java.util.Scanner;

public class LR问题 {
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        String s = in.next();
        String t = in.next();

        if (s.length() != t.length())
        {
            System.out.println(-1);
            return;

        }

        char[] chars = s.toCharArray();

        Boolean falg = true;
        int count = 0;

        for (int i = 0 ;  i < chars.length ; i++)
        {
            if (chars[i] == t.charAt(i))
                continue;

            if (chars[i] == '_')
            {
                if (t.charAt(i) == 'R') {
                    falg = false;
                    break;
                }
                else
                {
                    int k = i +1;
                    while (chars[k] == '_')
                        k++;
                    if (chars[k] == 'R') {
                        falg = false;
                        break;
                    }
                    else
                    {
                        count += k - i;
                        chars[i] = 'L';
                        chars[k] = '_';
                    }
                }

            }else if (chars[i] == 'L') {
                falg = false;
                break;
            }else
            {
                if (t.charAt(i) == 'L')
                {
                    falg = false;
                    break;
                }
                else
                {
                    int k = i+1;
                    while (chars[k] != '_' && chars[k] != 'L')                //不一定 必须要下一个是'-', 可以一直是R 但不能出现L
                        k++;

                    if (chars[k] == 'L')
                    {
                        falg = false;
                        break;
                    }else
                    {
                        count += k - i;
                        chars[i] = '_';
                        chars[k] = 'R';
                    }

                }
            }

        }

        if (falg)
            System.out.println(count);
        else
            System.out.println(-1);

    
    }
}
