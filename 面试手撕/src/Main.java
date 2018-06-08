import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/4/23 09:25
 * @Description: sleep的底层实现
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(100);

        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings,new Integer(42));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List<?> strings, Object o) {
        strings.add(o);
    }

}
