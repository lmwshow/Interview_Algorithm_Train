package Top_Interview_Questions.图;

import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/10/16.
 */
public class Course_Schedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        int limitLen = prerequisites.length;

        if (limitLen == 0)
            return true;

        int count = 0;
        int[] in = new int[numCourses];


        for (int i = 0 ; i < limitLen ; i++)
        {
            in[prerequisites[i][0]] ++;                 //prerequisites[i][0] 表示终点， 先行条件
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
                        if (prerequisites[j][1] == i)               //如果有边的终点是i 就把起点的入度-1
                            in[prerequisites[j][0]]--;              //prerequisites[j][0]表示起点 prerequisites[j][1]表示终点

                    in[i] = numCourses;             //使得不可能再为0

                    break;
                }
            }

            if (i == numCourses)
                return false;
        }

        return true;

    }

    public static void main(String[] args){

        System.out.println(canFinish(2,new int[][]{{1,0}}));


    }
}
