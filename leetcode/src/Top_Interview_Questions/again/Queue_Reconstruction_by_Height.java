package Top_Interview_Questions.again;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gracecoder on 2017/11/13.
 *
 * https://www.cnblogs.com/grandyang/p/5928417.html
 */
public class Queue_Reconstruction_by_Height {

    public static int[][] reconstructQueue(int[][] people) {


        if (people == null)
            return null;


        int[][] res = new int[people.length][2];

        //按身高从大到小排序，当身高相同时，按次序从小到大排序
        //然后遍历，每个元素按照K的次数 插入到index，因为前方的都是比它大的，后面的都是比它小的
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                else
                    return o2[0]-o1[0];
            }
        });

        //插入法，遍历，按照k的大小，插入到数组第k个位置，k之后的后移一位

        for (int i = 0 ; i < people.length ; i++)
        {
            for (int j = i; j > people[i][1] ; j--)
            {
                res[j][0] = res[j-1][0];
                res[j][1] = res[j-1][1];
            }

            res[people[i][1]][0] = people[i][0];
            res[people[i][1]][1] = people[i][1];

        }



        return res;
    }


    public static void main(String[] args){

        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        for (int[] x : reconstructQueue(people))
        {
            System.out.println(x[0]);
            System.out.println(x[1]);

        }
    }
}
