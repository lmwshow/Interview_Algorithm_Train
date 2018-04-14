package offer;

/**
 * Created by Gracecoder on 2017/12/7.
 */
public class 青蛙跳台阶 {

    public int JumpFloor(int target) throws Exception {
        if (target<0)
            throw new Exception("error,n should > 0");
        else if (target <=1)
            return target;
        else {
            int a = 1;
            int b = 1;
            int c = 0;
            for (int i = 2; i <= target ;i++)
            {
                c = a+b;
                a = b;
                b = c;
            }


            return c;
        }
    }
}
