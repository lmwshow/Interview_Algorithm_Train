package Top_Interview_Questions_2;

public class Question9_Palindrome_Number {

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int tmp = x ;

        int y = 0;

        while (tmp > 0)
        {
            y = y * 10 + tmp % 10;
            tmp = tmp/10;
        }
        
        return y == x;

    }
    
    public static void main(String[] args){
     
        System.out.println(121);
        
    
    }
}
