package 深信服6_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 20:46
 * @Description:
 */
public class Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;++i) {
            a[i] = sc.nextInt();
            if(a[i]!=(i+1)){
                map.put(i, a[i]);
                list.add(i);
            }
        }
        int temp = 0,count=0;
        int k1,v1;
        int k2,v2;
        while(!list.isEmpty()) {
            int i = list.get(0);
            temp = a[a[i]-1];
            a[a[i]-1] = a[i];
            a[i] = temp;
            list.clear();
            count++;
            for(int j=0;j<n;j++) {
                if(a[j]!=(j+1)){
                    list.add(j);
                }
            }
        }
        System.out.println(count);
    }
}
