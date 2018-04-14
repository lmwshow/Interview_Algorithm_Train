package leetgroup;


import java.util.*;

/**
 * Created by Gracecoder on 2017/7/8.
 *
 */

//看来裸广搜还是不行了，最后只能想到图论的方法，将字典抽象成一张图（由广搜层次决定节点的连接）
//广搜的时候建立起节点和它广搜层次的映射（使用hashmap），然后从end开始向回深搜这个广度优先图，获得最终路径
//（注意，从广度优先图的最终end开始搜索，能够有效增加速度，因为start节点只有一个，避免了对end的遍历）
public class word_ladder_2 {

    static HashMap<String,Integer> graph = new HashMap<String,Integer>();
    static ArrayList<ArrayList<String>> final_ans = new ArrayList<>();
    static ArrayList<String> path = new ArrayList<>();


    public static ArrayList<ArrayList<String>> myfindLadders(String start, String end, HashSet<String> dict) {

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        Queue<ArrayList<String>> routeQueue = new LinkedList<>();   //存储路径的队列

        ArrayList<String> tmpList = new ArrayList<>();              //当前路径
        tmpList.add(start);

        queue.offer(start);
        routeQueue.offer(tmpList);

        boolean flag = false;

        while (!queue.isEmpty() && !flag)
        {
            int num = queue.size();
            for (int i = 0 ; i < num ; i++)
            {
                char[] tmp = queue.poll().toCharArray();
                int length = tmp.length;
                ArrayList<String> route = routeQueue.poll();             //因为queue和routeQueue 在添加路径的时候是对应的，所以pop时也是对应的

                for (int j = 0 ; j < length ; j++)
                {
                    char old = tmp[j];

                    for (char ch = 'a'; ch <= 'z'; ch++)
                    {
                        tmp[j] = ch;
                        String curString = new String(tmp);


                        if (dict.contains(curString)||curString.equals(end))
                        {
                            if (!route.contains(curString)) {
                                route.add(curString);
                                routeQueue.offer(new ArrayList<>(route));
                                route.remove(route.size() - 1);
                                queue.offer(curString);
                            }

//                            dict.remove(curString);
                            //避免重复，这里因为falg这个条件，所以不会死循环
                            //这里有问题， 会造成，后面需要经过此点的路径不通畅， 会造成答案遗漏。
                            //所以不能这样简单的remove

                        }

                        if (curString.equals(end))
                            flag = true;

                    }

                    tmp[j] = old;
                }
            }
        }


        //因为这里是通过flag 跳出循环的 所以routeQueue中，包含了最短路劲能到达的所有点。但是不一样是终点，这里还要筛选
        while (!routeQueue.isEmpty()) {
            ArrayList<String> tmp = routeQueue.poll();
            if (tmp.get(tmp.size() - 1).equals(end))
                res.add(tmp);
        }
        return res;
    }


    public static void main(String[] args){

        String start = "hit";
        String end = "cog";

        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        ArrayList<ArrayList<String>> res = findLadders(start,end,dict);

    }

    private static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {


        bfs(start.length(), start, end, dict);
        dfs(start.length(), end, start, dict, path);
        return final_ans;
    }

    private static void dfs(int length, String cur, String end, HashSet<String> dict, ArrayList<String> newPath) {

        if (cur.equals(end)){
            newPath.add(end);
            Collections.reverse(newPath);
            final_ans.add(newPath);
            return ;
        }
        newPath.add(cur);
        int next_deep = 0;
        if (graph.get(cur)!=null)  next_deep = graph.get(cur);
        for (int i = 0; i < length; i ++){
            for (char j = 'a'; j <= 'z'; j ++){
                String next = cur.substring(0,i)+j+cur.substring(i+1);
                if (graph.get(next)!=null && graph.get(next) == next_deep-1){
                    ArrayList<String> newPathArray = new ArrayList<>(newPath);
                    dfs(length, next, end, dict, newPathArray);

                }
            }
        }
    }

    private static void bfs(int length, String start, String end, HashSet<String> dict) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        graph.put(start,1);
        int deep = 1;
        while (!queue.isEmpty())
        {
            String head = queue.poll();
            if (head.equals(end))
                continue;

            for (int i = 0 ; i < length; i++)
                for (char j = 'a'; j <= 'z'; j ++){
                    String tail = head.substring(0,i)+j+head.substring(i+1);
                    if (dict.contains(tail)&&!graph.containsKey(tail)){
                        deep = graph.get(head);
                        graph.put(tail, deep+1);
                        queue.add(tail);
                    }
                }
        }
    }
}
