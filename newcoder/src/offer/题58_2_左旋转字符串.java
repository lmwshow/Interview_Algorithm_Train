package offer;

public class 题58_2_左旋转字符串 {

    public static String LeftRotateString(String str,int n) {

        if (str == null || str.length() == 0)
            return "";

        if (str.trim().equals("") || n <= 0)
            return str;

        n = n % str.length();

        StringBuilder sb = new StringBuilder("");

        String left = str.substring(0,n);
        String right = str.substring(n,str.length());

        sb.append(right).append(left);

        return sb.toString();


    }

    public static void main(String[] args){

        System.out.println(LeftRotateString("     ",3));


    }
}
