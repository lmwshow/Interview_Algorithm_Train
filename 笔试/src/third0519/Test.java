package third0519;

/**
 * Created by Gracecoder on 2017/5/25.
 */
public class Test {
    public static Test t1 = new Test();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        Test t2 = new Test();
    }
}
