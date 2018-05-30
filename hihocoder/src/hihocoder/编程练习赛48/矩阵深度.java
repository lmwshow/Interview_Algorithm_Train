package hihocoder.编程练习赛48;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class 矩阵深度 {

    static class Matrix{
        int[] matrix;
        Set<Integer> set ;
        int count ;

        public Matrix() {
            this.matrix = new int[4];
            this.set = new LinkedHashSet<>();
            this.count = 0;
        }
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n =  in.nextInt();

        Matrix[] matrices = new Matrix[n+1];
        for (int i = 1 ; i <= n ; i++) {
            matrices[i] = new Matrix();
            matrices[i].set.add(i);
        }



        for (int i = 1 ; i <= n ; i ++)
        {
            matrices[i].matrix[0] = in.nextInt();
            matrices[i].matrix[1] = in.nextInt();
            matrices[i].matrix[2] = in.nextInt();
            matrices[i].matrix[3] = in.nextInt();

        }

        for (int i = 1; i <= n ; i++)
        {
            for (int j = 1 ; j <= n ; j++)
            {
                if (matrices[i].set.contains(j))
                    continue;

                if (isContain(matrices,i,j))
                {
                    matrices[i].count = matrices[i].count + matrices[j].count+1;

                    Iterator iterator = matrices[j].set.iterator();
                    while (iterator.hasNext())
                    {
                        Integer tmp = (Integer) iterator.next();
                        if (matrices[i].set.contains(tmp))
                            matrices[i].count--;
                        else
                            matrices[i].set.add(tmp);
                    }
                }
            }

            System.out.println(matrices[i].count);

        }

        return;



    }

    private static boolean isContain(Matrix[] matrices, int i, int j) {

        if ((matrices[i].matrix[0]>=matrices[j].matrix[0] && matrices[i].matrix[2]<=matrices[j].matrix[2]) && (matrices[i].matrix[1]>=matrices[j].matrix[1]&&matrices[i].matrix[3]<=matrices[j].matrix[3]))
            return true;
        return false;
    }
}
