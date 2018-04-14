package leetgroup;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/5/18.
 * <p>
 * 求第k行， 只用空间复制度O（k）
 */
public class pascals_triangle2 {

    public static ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> res = new ArrayList<>();

        if (rowIndex < 0)
            return res;
        res.add(1);

        for (int i = 0; i <= rowIndex; i++) {
            int tmp = 1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    res.add(j, 1);
                }
                else {
                    int cur = tmp + res.get(j);
                    tmp = res.get(j);
                    res.set(j, cur);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        ArrayList<Integer> res = getRow(2);

        System.out.println("over");

    }
}
