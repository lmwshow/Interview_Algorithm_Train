package hihocoder.树练习;

import hihocoder.util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/6 13:39
 * @Description:
 */
public class LCA {

    static final int mx = 10000;        //最大顶点数
    static int n,root;                  //实际节点数，树根结点
    static int[] indeg = new int[mx];   //顶点入度，用来判断树根
    static List<Integer>[] tree = new ArrayList[mx];       //树的邻接表(不一定是二叉树)
    static List<Integer>[] query = new ArrayList[mx];      //输入所有跟x相关的查询

    static int[] father = new int[mx];
    static int[] rnk = new int[mx];                         //节点的父亲和秩
    //加入rank[N]来记录每个节点的秩（即树的高度），并按秩进行合并，可避免合并时的最糟糕情况，（树形为一条直线）

    static int[] ancestor = new int[mx];             //已访问节点集合的祖先
    static boolean[] visit = new boolean[mx];	                                 //访问标志


    /*
    输入树
     */
    private static void inputTree(BufferedReader in) throws IOException {

        n = Integer.parseInt(in.readLine());    //树的顶点数

        for (int i = 0 ; i < n ; i++)              //初始化树，顶点编号从0开始
        {
            tree[i] = new ArrayList<>();
            indeg[i] = 0;
        }

        //n个点,n-1条边
        for (int i = 0; i < n - 1; i++) {
            String[] parts = in.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            tree[x].add(y);                 //x->y有一条边
            indeg[y]++;                 //加入邻接表，y入度加一
        }

        for (int i = 0 ; i < n ; i++)   //寻找树根，入度为0的顶点
            if (indeg[i]==0)
            {
                root = i;
                break;
            }

    }

    /*
    输入查询
     */

    private static void inputQuires(BufferedReader in) throws IOException {

        for (int i = 0; i < n ; i++)    //清空上次查询
            query[i] = new ArrayList<>();

        int m = Integer.parseInt(in.readLine());        //查询的个数

        for (int i = 0 ; i < m ; i++)
        {
            String[] parts = in.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);         //查询x和y的LCA
            int y = Integer.parseInt(parts[1]);

            query[x].add(y);
            query[y].add(x);
        }
    }

    /*
     并查集操作
     */

    private static void makeSet()  //初始化并查集
    {
        for (int i = 0 ; i < n ;i ++)
        {
            father[i] = i;
            rnk[i] = 0;
        }
    }

    private static int findSet(int x)  //查找父节点
    {
        if (x != father[x])
            father[x] = findSet(father[x]);

        return father[x];
    }

    private static void unionSet(int x, int y) //合并
    {
        x = findSet(x);
        y = findSet(y);
        if (x == y)
            return;

        //加入rank[N]来记录每个节点的秩（即树的高度），并按秩进行合并，可避免合并时的最糟糕情况，（树形为一条直线）
        if (rnk[x] > rnk[y]) father[y] = x;
        else
        {
            father[x] = y;
            rnk[y] += (rnk[x] == rnk[y])?1:0;
        }
    }


    /*
    Tarjan 核心代码
    在调用Tarjan之前已经初始化并查集给每个节点创建了一个集合，并且把集合的祖先赋值为自己了，因而这里不用给根节点x单独创建。

    深搜后序访问树，将访问过的节点与父节点合并，如果此时要查询的点已经访问过，那当前祖先就是最近公共祖先。
     */

    private static void Tarjan(int x)
    {
        for (int i = 0 ; i < tree[x].size() ; i++)
        {
            Tarjan(tree[x].get(i));             //访问子树
            unionSet(x,tree[x].get(i));         //将子树节点与根节点x的集合合并
            ancestor[findSet(x)] = x;           //合并后的集合的祖先为x
        }

        visit[x] = true;    //标记已访问
        for (int i = 0; i < query[x].size(); i++) //与根节点x有关的查询
            if (visit[query[x].get(i)]) //如果查询的另一个节点已访问，则输出结果
                System.out.println(ancestor[findSet(query[x].get(i))]);
    }

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {

            inputTree(in);      //输入树
            inputQuires(in);    //输入查询

            makeSet();
            for (int i = 0 ; i < n;i++)
                ancestor[i] = i;

            Tarjan(root);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    	/*前面例子相关的一个输入输出如下：
	8
	0 1   0 2   0 3   1 4   1 5   5 7   3 6
	7
	1 4   4 5   4 7   5 7   0 5   4 3   1 6
	7和4的最近公共祖先为：1
	5和4的最近公共祖先为：1
	5和7的最近公共祖先为：5
	1和4的最近公共祖先为：1
	6和1的最近公共祖先为：0
	3和4的最近公共祖先为：0
	0和5的最近公共祖先为：0
	*/



}
