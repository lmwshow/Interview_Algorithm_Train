package pingduoduo0801.pingduoduo_4_3;

import java.util.Scanner;

public class 三角形 {

    public static void main(String[] args){
        int h;
        float m;
        double eps = Math.pow(10, -6);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] numstr = str.split(":");
        h = Integer.parseInt(numstr[0]);
        m = Float.parseFloat(numstr[1]);
        h %= 12;
        float i_angle, h_angle, m_angle, result;
        i_angle = h * 30;
        h_angle = (m / 60) * 30;
        m_angle = (m / 60) * 360;
        result = Math.abs(m_angle - (i_angle + h_angle));
        if (result >= 180) {
            result = 360 - result;//System.out.println(1);
        }
        if (result - (int) result < eps) {
            System.out.printf("%.0f\n", result);
        } else {
            System.out.printf("%.1f\n", result);
        }

    }


}
