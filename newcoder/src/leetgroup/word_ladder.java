package leetgroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/7/7.
 *
 * 从图论的角度，我们可以将只相差一个的字符串视为 邻居
 * 这道题的思想就是： 从start开始访问它的邻居， 然后接着访问邻居的邻居，直到找到end， 是一个典型的BFS结构
 */

//主要思想：广度优先搜索。先构造一个字符串队列，并将start加入队列。
// 1.对队列头字符串做单个字符替换
// 2.每次替换后,判断是否和end匹配，如果匹配，返回答案；
// 3.没有匹配，则在字典里面查询是否有“邻居字符串”,如果有，则将该字符串加入队列，同时将该字符串从字典里删除。重复1的过程，知道和end匹配。如果最后队列为空还未匹配到，则返回0.

public class word_ladder {
    public static int ladderLength(String start, String end, HashSet<String> dict) {

        Queue<String> queue = new LinkedList<>();

        queue.offer(start);

        int res = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++)
            {
                char[] cur = queue.poll().toCharArray();
                int strlen = cur.length;

                for (int j = 0; j <strlen ; j++)
                {
                    char ch = cur[j];
                    for (int k = 0 ; k < 26 ; k++)
                    {
                        cur[j]= (char) ('a'+k);
                        String curString = new String(cur);

                        if (curString.equals(end)) {
                            return res+1;
                        }


                        if (dict.contains(curString))
                        {
                            queue.offer(curString);
                            dict.remove(curString);
                        }
                    }

                    cur[j] = ch;
                }
            }

            res++;
        }

        return 0;
    }


    /*
        双端Hash
    * */
    public int betterladderLength(String start, String end, HashSet<String> dict) {
        //思路：双端HashSet,将其分为起始集合和结束集合，当起始集合中的单词变换一次后得到结束集合中的某词时可以结束
        //当起始、结束集合中有任意一个为空时，总的也为空
        //由于只有26个字母，因此，采用字母替换法所能达到的26*n在n较大时远远优于n*n
        //init
        HashSet<String> beginSet=new HashSet<String>();
        HashSet<String> endSet=new HashSet<String>();
        HashSet<String> visited=new HashSet<String>();

        beginSet.add(start);
        endSet.add(end);
        visited.add(start);
        int res=1;

        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            //保证每次对较少数目的endSet做处理
            if(beginSet.size()>endSet.size()){
                HashSet<String> temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }

            HashSet<String> temp=new HashSet<String>();

            for(String str:beginSet){
                char[] chs=str.toCharArray();
                for(int i=0;i<chs.length;i++){
                    char old=chs[i];
                    for(char ch='a';ch<='z';ch++){
                        chs[i]=ch;
                        String cur=String.valueOf(chs);
                        if(endSet.contains(cur)){
                            return res+1;
                        }
                        if(!visited.contains(cur)&&dict.contains(cur)){
                            temp.add(cur);
                            visited.add(cur);
                        }
                    }
                    chs[i]=old;
                }

            }
            beginSet=temp;
            res++;
        }
        return 0;
    }


    public static void main(String[] args){

        HashSet<String> hashSet = new HashSet();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");


        char[] ch = new char[]{'a'};
        String str = new String(ch);
        if (hashSet.contains(str))
            System.out.println("yes");



        int res = ladderLength("a","c",new HashSet<>(Arrays.asList("a","b","c")));

        System.out.println(res);

    }
}
