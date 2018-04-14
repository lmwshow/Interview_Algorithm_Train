package dp;

/**
 * Created by Gracecoder on 2017/4/29.
 * 等级更高的孩子分到的糖果需要比相邻两个的多
 */
public class leetcode135_分糖果 {

    public static int candy(int[] ratings) {

        int preHigh = 0 ;
        int leastNums = ratings.length;
        int index = 0;
        int increase = 1;

        while (index < ratings.length-1)
        {
            while (index < ratings.length-1 && ratings[index] < ratings[index+1])
            {
                leastNums += increase;
                increase ++;
                index ++;
            }

            preHigh = increase;    //上一个极高点的 高度，当下面一个点的增量达到preHigh-1 时， 两者就持平了，需要极高点再+1 才能满足了
            increase = 0;
            
            while (index < ratings.length-1 && ratings[index] > ratings[index+1])
            {
                if (increase == preHigh -1)
                    increase ++;                    //这次增量加上去就会和前一个极高点持平，需要给极高点也加一点

                leastNums += increase;
                increase ++;
                index++;
            }

            while (index < ratings.length-1 &&ratings[index] == ratings[index+1])
                index++;

            increase = 1;
        }

        return leastNums;
    }

    /*
    另一种好的方法是， 进行两次循环， 一次从左到右，保证右边高级别的孩子糖比左边的多。
    一次从右到左，保证左边高级别的孩子糖比右边多
    两次完后，就能实现高级别孩子的糖比相邻的多
     */

    public static void main(String[] args){
        int result = candy(new int[]{2,2});

        System.out.println(result);


    }
}
