package Top_Interview_Questions_2;

/**
 * @Auther: minGW
 * @Date: 2018/4/28 08:51
 * @Description: https://leetcode-cn.com/problems/hamming-distance/description/
 */
public class Question461_汉明距离 {

    //汉明距离 亦或
    public int XorhammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance(int x, int y) {

        int ans = 0;

        while (x != 0 && y != 0)
        {
            if (x%2 != y%2)
                ans++;

            x = x >> 1;
            y = y >> 1;
        }

        while (x != 0)
        {
            if ((x & 1) == 1)       //末位是1的话
                ans++;

            x = x >> 1;
        }

        while (y != 0)
        {
            if ((y & 1) == 1)       //末位是1的话
                ans++;

            y = y >> 1;
        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println(hammingDistance(7,1));
    }
}
