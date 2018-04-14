/**
 * Created by Gracecoder on 2017/2/13.
 */
public class test {

    private static int a;
    private int b;

    public void test(final int c) {
        int d = 1;
        class Inner {
            public void print() {
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(d);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }

    public static void testStatic(final int c) {
        int d = 1;
        class Inner {
            public void print() {
                System.out.println(a);
                //定义在静态方法中的局部类不可以访问外部类的实例变量
                //System.out.println(b);
                System.out.println(c);
                System.out.println(d);
            }
        }
    }

    
    public static void main(String[] args){

        test x = new test();
        x.test(1);
        
    }
}
