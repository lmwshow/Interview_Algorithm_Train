package hihocoder.编程练习赛54;

import java.util.Arrays;
import java.util.Scanner;

public class 最小差值 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strings = in.nextLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        int[][] nums = new int[N][M];
        for (int i=0;i < N;++i) {
            strings = in.nextLine().split(" ");
            for (int j = 0;j < M;++j)
                nums[i][j] = Integer.parseInt(strings[j]);

            Arrays.sort(nums[i]);
        }

        int[] index = new int[N];
        int[] n = new int[N];

        //一开始是从每个数组中选出最小值
        for (int i = 0;i < N;++i)
            n[i] = nums[i][0];

        int min = Integer.MAX_VALUE;
        while (true) {
            int a = Integer.MAX_VALUE;
            int a_index = 0;
            int b = Integer.MIN_VALUE;

            for (int i = 0;i < N;++i) {
                if (n[i] < a) {
                    a = n[i];
                    a_index = i;
                }

                if (n[i] > b)
                    b = n[i];
            }

            if (b-a < min)
                min = b-a;

            //对最小的那个数 选择从那个数组选下一个大的，直到选到第M个，  遍历所有情况
            index[a_index]++;
            if (index[a_index] == M)
                break;

            n[a_index] = nums[a_index][index[a_index]];
        }

        System.out.print(min);

    }


}
