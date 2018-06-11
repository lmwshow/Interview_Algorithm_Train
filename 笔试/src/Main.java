import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.crypto.spec.IvParameterSpec;

import java.util.*;
public class Main {

    public static void main(String[] args) throws
            SecurityException, IllegalArgumentException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        double total1 = 0;
        int sum = 0;

        for(int i = 0;i<n;i++){
            parts = in.readLine().split(" ");
            int p = Integer.parseInt(parts[0]);
            int d = Integer.parseInt(parts[1]);
            sum+= p;
            if(d == 1) total1 += p *0.8;
            else total1 += p;
        }
        double min = total1;
        for(int i = 0;i<m;i++){
            parts = in.readLine().split(" ");
            int full = Integer.parseInt(parts[0]);
            int minus = Integer.parseInt(parts[1]);
            if(sum >= full && sum - minus < min){
                min = sum - minus;
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(min));

        System.out.printf("%.2f",min);

    }
}