package Top_Interview_Questions_2.图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    现在你总共有 n 门课需要选，记为 0 到 n - 1。
    一些课程在修之前需要先修另外的一些课程，比如要学习课程 0 你需要先学习课程 1 ，表示为: [0,1]
    给定 n 门课以及他们的先决条件，判断是否可能完成所有课程？
 */
public class Question207_是否存在合法拓扑关系 {


    // BFS 快点 因为使用了队列保存度为0的点，(不能使用优先队列，因为每次需要更新每个点的度)

    public boolean BFScanFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }



    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int limitLen = prerequisites.length;

        if (limitLen == 0)
            return true;

        int count = 0;
        int[] in = new int[numCourses];


        for (int i = 0 ; i < limitLen ; i++)
        {
            in[prerequisites[i][0]] ++;                 //prerequisites[i][1] 表示入点
        }

        int i = 0;
        int j = 0;

        while (count < numCourses)
        {
            for (i = 0; i < numCourses ; i++)
            {
                if (in[i] == 0)                     //找到不需要前提条件的 先完成，同时更新Din
                {
                    count++;
                    for (j = 0 ; j < limitLen ; j++)
                        if (prerequisites[j][1] == i)
                            in[prerequisites[j][0]]--;

                    in[i] = numCourses;             //使得不可能再为0

                    break;
                }
            }

            if (i == numCourses)
                return false;
        }

        return true;
    }



}
