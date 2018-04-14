package Top_Interview_Questions;

/**
 * Created by Gracecoder on 2017/11/16.
 *
 * 汉明距离 采用异或即可 ^
 *
 * 还有 一句的 解决方案 ：  return Integer.bitCount(x ^ y);
 */
public class Hamming_Distance {
    public static int hammingDistance(int x, int y) {


//        int xor = x ^ y;
//
//        int res = 0;
//        String s = Integer.toBinaryString(xor);
//
//        for (char c : s.toCharArray())
//            if (c == '1')
//                res++;
//
//        return res;

        return Integer.bitCount(x ^ y);
    }


    public static void main(String[] args){


        System.out.println(hammingDistance(1,4));

        
    }



}
