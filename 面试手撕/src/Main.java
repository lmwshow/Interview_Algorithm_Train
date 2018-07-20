import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/4/23 09:25
 * @Description: sleep的底层实现
 */
public class Main {

    class Num{
        int num;

        public Num(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(100);

//        List<String> strings = new ArrayList<String>();
//        unsafeAdd(strings,new Integer(42));
//        String s = strings.get(0);

        int ans = test();

        System.out.println(ans);
    }

    public static int test()
    {
        int x = 1;
        try
        {
            return x;
        }
        finally
        {
            ++x;
//            return x;
        }
    }
    private static void unsafeAdd(List<?> strings, Object o) {

    }

}
