package leetgroup;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/5/18.
 */
public class pascals_triangle {

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;

        for (int i = 0; i < numRows; i++)
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0 ; j <= i ; j++)
            {
                if (j == 0 || j==i)
                    tmp.add(1);                      //下标对好
                else
                    tmp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(tmp);
        }

        return res;
    }


    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> res = generate(5);

        System.out.println("over");

    }
}
