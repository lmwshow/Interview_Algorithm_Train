package Top_Interview_Questions_2;

public class Question8_String_to_Integer {

    public static int myAtoi(String str) {

        if (str == null || str.trim().length() < 1)
            return 0;

        //处理前后空格
        char[] arr = str.trim().toCharArray();
        int flag = 1 , index = 0;
        int res = 0;

        if (arr[0] == '+')
            index ++;
        if (arr[0] == '-')
        {
            flag = 0;
            index ++;
        }

        while (index < arr.length)
        {
            if (arr[index] >= '0' && arr[index] <= '9')
            {
                if (Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && arr[index] - '7' > 0))
                {
                    if (flag == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                res = res * 10 + arr[index] - '0';
            }
            else
                break;

            index ++;
        }
        if (flag == 0)
            res = -res;
        return res;



    }


    public static void main(String[] args){

        System.out.println(myAtoi("-12321"));

    }

}