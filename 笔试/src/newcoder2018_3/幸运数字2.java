package newcoder2018_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.Query;
import javax.swing.plaf.SliderUI;
import javax.swing.text.GapContent;
import javax.swing.text.html.MinimalHTMLWriter;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.ws.Holder;


public class 幸运数字2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextInt();
        long r = in.nextInt();
        long sum = 0;
        long k = 0;
        long n = l;
        while(!isft(n)){
            n++;
        }
        if(n>=r) {System.out.println(n *(r-l+1));
            return;
        }
        sum+=(n * (n-l+1));
        while(n<r){
            long next = nextft(n);
            if(next >r){
                sum += next *(r-n);
                System.out.println(sum);
                return;
            }
            sum += next *(next-n);
            n = nextft(n);
        }
        System.out.println(sum);
    }

    public static long nextft(long n ) {
        if(n <4 ) return 4;
        char[] s = String.valueOf(n).toCharArray();
        for(int i = s.length-1;i>=0;i--){
            if(s[i] =='4'){
                s[i] +=3;
                long sum = 0;
                for(int j = 0;j<s.length;j++){
                    sum = sum* 10 +(s[j] -'0');
                }
                return sum;
            }
            else{
                s[i] -= 3;
            }

        }
        long sum = 4;
        for(int j = 0;j<s.length;j++){
            sum = 10*sum + (s[j]-'0');
        }
        return sum;
    }

    public static boolean isft(long n ) {
        if(n == 0) return false;
        while(n>0){
            long x = n%10;
            if(x !=4 && x != 7) return false;
            n = n/10;
        }
        return true;
    }
}