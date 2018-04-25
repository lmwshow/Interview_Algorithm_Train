package Top_Interview_Questions_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/4/25 09:42
 * @Description:
 */
public class Question406_根据身高重建队列 {




    public static int[][] reconstructQueue(int[][] people) {

        if (people == null || people.length == 0)
            return people;

        //用map记录一下每个身高的具体人数
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] height : people)
            map.put(height[0],map.getOrDefault(height[0],0)+1);

        //lambda表达式用于排序时，元素只能是对象
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int[] cur = new int[2];
        int t = 0;
        int index = 0;
        for (int i = people.length - 1; i >= 0 ; i--)
        {
            cur = people[i];
            map.put(cur[0],map.get(cur[0])-1);
            if (cur[1] == map.get(cur[0]))
                continue;
            else {
                t = cur[1] - map.get(cur[0]);
                index = i;
                for (int j = 0 ; j < t ;j++)
                {
                    people[index] = people[index + 1];
                    index ++;
                }
                people[index] = cur;
            }
        }


        return people;


    }
    
    public static void main(String[] args){
        int[][] people = new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        reconstructQueue(people);
    }
}
