package 贝壳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther: minGW
 * @Date: 2018/8/18 20:11
 * @Description:
 */
public class 取消社团预约 {

    static class Order {
        int start;
        int end;
        int seq;
    }


    static ArrayList<Integer> total;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Order[] orders = new Order[n];
        total = new ArrayList<Integer>();


        String[] parts;

        for (int i = 0; i < n; i++) {
            parts = in.readLine().split(" ");
            Order Order = new Order();
            Order.start = Integer.parseInt(parts[0]);
            Order.end = Integer.parseInt(parts[1]);
            Order.seq = i + 1;
            orders[i] = Order;
        }
        Arrays.sort(orders, (n1, n2) -> {
            return n1.start - n2.start;
        });

//        ArrayList<Integer> ans = new ArrayList<>();
//
//
//        for (int i = 0 ; i < orders.length ; i++)
//            core(orders,i,ans);
//
//
//        System.out.println(ans.size());
//
//        if (ans.size() > 0)
//        {
//            System.out.print((int)ans.get(0)+1);
//            for (int i = 1;  i < ans.size() ; i++)
//                System.out.print(" " +  (ans.get(i)+1));
//        }
//
//        System.out.println();

        if (solver(orders, 0, 1, false)) {
            if (total.size() == 0) {
                System.out.println(n);
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
            } else {
                Collections.sort(total);
                System.out.println(total.size());
                for (Integer i : total) System.out.print(i + " ");
            }
        } else {
            System.out.println(0);
        }

    }

    private static void core(Order[] orders, int index, ArrayList<Integer> ans) {

        boolean flag = true;

        for (int i = 0 ; i < orders.length ; i++)
        {
            if (i == index)
                continue;

            if (i+1 == index && i+2 < orders.length && orders[i].end > orders[i+2].start)
                flag = false;
            else if (i+1 < orders.length && orders[i].end > orders[i+1].start)
                flag = false;

        }

        if (flag)
            ans.add(index);

    }

    public static boolean solver(Order[] orders, int index, int last, boolean delete) {
        for (int i = index; i < orders.length; i++) {
            if (orders[i].start < last) {
                boolean flag = false;
                if (delete) {
                    return false;
                }
                if (i > 1) {
                    if (orders[i - 2].end <= orders[i].start && solver(orders, i + 1, orders[i].end, true)) {
                        flag = true;
                        total.add(orders[i - 1].seq);
                    }
                }
                if (i == 1 && total.size() < 1) {
                    if (solver(orders, i + 1, orders[i].end, true)) {
                        flag = true;
                        total.add(orders[i - 1].seq);
                    }
                }
                if (solver(orders, i + 1, last, true)) {
                    flag = true;
                    total.add(orders[i].seq);
                }
                return flag;
            } else {
                last = orders[i].end;
            }
        }
        return true;
    }
}
