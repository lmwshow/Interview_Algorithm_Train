package offer;

public class 题61_扑克牌顺子 {
    public static boolean isContinuous(int[] numbers) {

        if (numbers == null || numbers.length < 5)
            return false;

        int[] count = new int[14];

        int min = 14;
        int max = 0;

        for (int x : numbers) {
            count[x]++;
            if (count[x]>1 && x!=0) return false;
            if (x != 0 && x < min)
                min = x;
            if (x != 0 && x > max)
                max = x;

        }

        if (max - min >= 5)
            return false;

        for (int i = min; i <= min + 4; i++) {
            if (count[i] > 1)           //min 不会是0
                return false;
            else if (count[i] == 1)
                continue;
            else {
                count[0]--;
                if (count[0] < 0)
                    return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println(isContinuous(new int[]{0, 1, 3, 5, 0}));

    }
}
