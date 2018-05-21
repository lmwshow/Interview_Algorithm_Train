package offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/5/21 21:53
 * @Description: https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class 字符流中第一个不重复的字符 {


    int count[]=new int[256];
    //Insert one char from stringstream
    int index=1;
    public void Insert(char ch)
    {
        if(count[ch]==0){
            count[ch]=index++;              //用index表示在字符流中的下标，一开始count都是0,可以通过这个进行插入
        }
        else{
            count[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){
                temp=count[i];
                ch=(char)i;
            }
        }
        return ch;
    }


    static List<Character> list = new ArrayList<>();
    static Map<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public static void mw_Insert(char ch)
    {

        map.put(ch,map.getOrDefault(ch,0)+1);

        if (map.get(ch) == 1)
            list.add(ch);

        if (map.get(ch) == 2)
            list.remove(list.indexOf(ch));

    }
    //return the first appearence once char in current stringstream
    public static char mw_FirstAppearingOnce()
    {
        if (list.size() > 0)
            return list.get(0);
        else
            return '#';
    }

    public static void main(String[] args){

        StringBuffer stringBuffer = new StringBuffer("google");

        for (int i = 0 ; i < stringBuffer.length() ; i++)
        {
            Insert(stringBuffer.charAt(i));
            System.out.println(FirstAppearingOnce());
        }

    }

}
