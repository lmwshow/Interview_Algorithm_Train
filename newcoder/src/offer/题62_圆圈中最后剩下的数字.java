package offer;

public class 题62_圆圈中最后剩下的数字 {

    public static int LastRemaining_Solution(int n, int m) {

        if (n <= 0)
            return -1;

        int[] cycle = new int[n];

        int count = 0;
        int step = 1;
        int curindex = 0;
        int nextStep = 1;

        while (count < n)
        {
            while (step < m)
            {
                nextStep = (curindex +1) % n;
                while (cycle[nextStep] == -1)               //跳到下一步未访问过的
                    nextStep = (nextStep +1) % n;

                curindex = nextStep;
                step ++;

            }

            step = 1;
            cycle[curindex] = -1;

            if (count == n - 1)
                return curindex;

            count ++;

            while (cycle[curindex] == -1)
                curindex = (curindex +1) % n;

        }
        return -1;

    }


    public static void main(String[] args){

        System.out.println(LastRemaining_Solution(5,2));

    }
}
