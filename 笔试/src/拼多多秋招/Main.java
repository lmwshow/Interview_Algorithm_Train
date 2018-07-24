package 拼多多秋招;

/**
 * @Auther: minGW
 * @Date: 2018/7/22 20:56
 * @Description:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.valueOf(str[i]));
        }
//      while(true){
//          String s= in.nextLine();
//          if(s.equals(""))
//              break;
//          list.add(Integer.valueOf(s));
//      }

        for (Integer l : list)
            System.out.println(l);
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        int num = 0;
        while (i < j) {
            if (list.get(i) + list.get(j) > 300) {
                num++;
                j--;
            }
            if (list.get(i) + list.get(j) <= 300) {
                num++;
                j--;
                i++;
            }
        }
        if (i == j) {
            num++;
        }
        System.out.println(num);
    }
}

