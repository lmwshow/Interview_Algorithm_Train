package leetgroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/9/25.
 */
public class Roman_to_Integer {


    public static int romanToInt(String s) {

        Map<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        for (char ch :s.toCharArray())
        {
            sum += map.get(ch);
        }

        return sum;


    }

    public static void main(String[] args){

        System.out.println(romanToInt("IIIM"));


    }

}
