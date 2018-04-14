package newcoder2018_3.new3_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Question2{

    static int n, m;
    static long len = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        for (int i = 0; i < n; i++) {
            in.nextToken();
            b[i] = (int) in.nval;
        }
        Arrays.sort(a);
        Arrays.sort(b);

        long max = 0, now = 0;
        for (int i = 0; i < n; i++) {
            now += b[n - i - 1] - a[i];
            if(i % 3 == 2){
                now += m;
            }
            max = Math.max(max, now);
        }
        out.println(max);
        out.flush();
    }
}