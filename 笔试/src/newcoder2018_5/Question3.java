package newcoder2018_5;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 20:28
 * @Description
 */
public class Question3 {


    //这里使用连接矩阵表示图，当N=10000时  内存溢出 ，  应该使用链接表表示图

    static int MAX=10000;//(此路不通)

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int S = in.nextInt();
        int T = in.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0 ; i < N; i++)
            for (int j = 0 ; j < N; j++)
                if (i!=j)
                    map[i][j] = MAX;


        for (int i = 0 ; i < M; i++)
            map[in.nextInt()-1][in.nextInt()-1] = in.nextInt();

//        int[][] map = {
//                {0,3,M},{M,0,3},{1,M,0}
//        };

        int ans = 0;

        int start = S-1;
        int[] shortPath = Dijsktra(map,start);
        ans+=shortPath[T-1];

        start = T-1;
        shortPath = Dijsktra(map,start);

        ans+=shortPath[S-1];
        System.out.println(ans);


    }



    public static int[] Dijsktra(int[][] weight,int start){
        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        //返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length;        //顶点个数
        int[] shortPath = new int[n];    //存放从start到其他各点的最短路径
        String[] path=new String[n]; //存放从start到其他各点的最短路径的字符串表示
        for(int i=0;i<n;i++)
            path[i]=new String(start+"-->"+i);
        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已求出

        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;

        for(int count = 1;count <= n - 1;count++)  //要加入n-1个顶点
        {

            int k = -1;    //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][i] < dmin)
                {
                    dmin = weight[start][i];

                    k = i;
                }

            }

            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;

            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for(int i = 0;i < n;i++)
            {                 // System.out.println("k="+k);
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]){
                    weight[start][i] = weight[start][k] + weight[k][i];

                    path[i]=path[k]+"-->"+i;

                }

            }

        }

        return shortPath;
    }
}
