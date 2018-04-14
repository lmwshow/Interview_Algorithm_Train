package offer.again;

/**
 * Created by Gracecoder on 2017/12/19.
 *
 * 有限状态自动机
 * http://www.bo-song.com/leetcode-valid-number/
 *
 * 由正则表达式————>NFA(非确定有限状态自动机)—————>DFA
 */
public class 题20_表示数值的字符串 {

    public static boolean isNumber(String s) {
        s = s.trim();
        return state1(s);
    }

    private static boolean state1(String s) {
        //i'm not an end state
        if(s.isEmpty() == true){
            return false;
        }
        //go to state 2
        if(s.charAt(0) == '-' || s.charAt(0) == '+'){
            return state2(s.substring(1));
        }
        //go to state 3
        else if(isNumber(s.charAt(0))){
            return state3(s.substring(1));
        }
        //go to state 4
        else if(s.charAt(0) == '.'){
            return state4(s.substring(1));
        }
        //not an acceptable char
        else{
            return false;
        }
    }

    private static boolean state2(String s) {
        //i'm not an end state
        if(s.isEmpty() == true){
            return false;
        }
        //go to state 3
        if(isNumber(s.charAt(0))){
            return state3(s.substring(1));
        }
        //go to state 4
        else if(s.charAt(0) == '.'){
            return state4(s.substring(1));
        }
        //not an acceptable char
        else{
            return false;
        }
    }

    private static boolean state3(String s) {

        //i'm an end state, got an integer
        if(s.isEmpty() == true){
            return true;
        }

        //go to state 3
        if(isNumber(s.charAt(0))){
            return state3(s.substring(1));
        }
        //go to state 5
        else if(s.charAt(0) == '.'){
            return state5(s.substring(1));
        }

        //go to state 6
        else if (s.charAt(0) == 'e')
        {
            return state6(s.substring(1));
        }

        //not an acceptable char
        else
            return false;

    }

    private static boolean state4(String s) {

        //i'm not an end state
        if(s.isEmpty()){
            return false;
        }
        //go to state 5
        if(isNumber(s.charAt(0))){
            return state5(s.substring(1));
        }
        //not an acceptable char
        else{
            return false;
        }
    }

    private static boolean state5(String s) {

        if (s.isEmpty())
            return true;

        if (isNumber(s.charAt(0)))
            return state5(s.substring(1));

        else if (s.charAt(0)=='e')
            return state6(s.substring(1));

        else
            return false;
    }

    private static boolean state6(String s) {

        if (s.isEmpty())
            return false;

        if (s.charAt(0)=='-'||s.charAt(0)=='+')
            return state7(s.substring(1));
        else if (isNumber(s.charAt(0)))
            return state8(s.substring(1));

        else
            return false;
    }

    private static boolean state7(String s) {

        if (s.isEmpty())
            return false;

        if (isNumber(s.charAt(0)))
            return state8(s.substring(1));
        else
            return false;
    }

    private static boolean state8(String s) {

        if (s.isEmpty())
            return true;

        if (isNumber(s.charAt(0)))
            return state8(s.substring(1));
        else
            return false;
    }


    private static boolean isNumber(char ch)
    {
        return ch>='0'&&ch<='9';
    }

}
