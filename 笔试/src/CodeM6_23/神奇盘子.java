package CodeM6_23;

/**
 * @Auther: minGW
 * @Date: 2018/6/23 14:36
 * @Description:
 */
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;

public class 神奇盘子 {
    public static String format4(double value) {
        /*
         * %.2f % 表示 小数点前任意位数 2 表示两位小数 格式后的结果为 f 表示浮点型
         */
        return new Formatter().format("%.12f", value).toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radius = scanner.nextInt();
        int s_x = scanner.nextInt();
        int s_y = scanner.nextInt();
        int e_x = scanner.nextInt();
        int e_y = scanner.nextInt();
        double k = (1.0) * s_y / s_x;
        double qie_x = 0.0;double qie_y = 0.0;
        double qie_fan_x = 0.0;double qie_fan_y = 0.0;
        qie_x = Math.sqrt(radius*radius/(1+k*k));
        qie_y = Math.sqrt(radius*radius-qie_x*qie_x);
        if(s_x<0)
            qie_x *= -1;
        if(s_y<0)
            qie_y *= -1;
        qie_fan_x = qie_x * (-1);qie_fan_y = qie_y * (-1);
        double way_1 = 0.0;
        double way_2 = 0.0;
        way_1 = Math.sqrt((s_x-e_x)*(s_x-e_x)+(s_y-e_y)*(s_y-e_y));
        way_2 = Math.sqrt((s_x-qie_x)*(s_x-qie_x)+(s_y-qie_y)*(s_y-qie_y))+
                Math.sqrt((e_x-qie_fan_x)*(e_x-qie_fan_x)+(e_y-qie_fan_y)*(e_y-qie_fan_y));
        if(way_1-way_2<0.000001) {
            System.out.println(format4(way_1));
        }
        else {
            System.out.println(format4(way_2));
        }
    }
}