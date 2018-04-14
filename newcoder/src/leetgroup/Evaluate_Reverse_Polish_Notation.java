package leetgroup;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/6/29.
 */
public class Evaluate_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {

        if (tokens.length == 0)
            return 0;

        Stack<Integer> operandstack = new Stack<>();

        //逆波兰表达式，遇到一个操作符，就直接先把前两个操作数运算掉，不需要保存操作符

        for (int i = 0; i < tokens.length; i++)                   //将运算符放入操作栈，操作数放入操作数栈，表达式算出来之后会是操作数，递归放入操作数栈
        {
            String token = tokens[i];
            if (token.contains("+") || token.contains("-") || token.contains("*") || token.contains("/")) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    Integer operand2 = operandstack.pop();                  //先出来的是操作数2
                    Integer operand1 = operandstack.pop();
                    Integer result = op(operand1, token, operand2);

                    operandstack.push(result);

                } else {
                    //注意一下操作数是负数
                    if (token.charAt(0) == '-') {
                        operandstack.push(Integer.valueOf(token));
                    } else {
                        String[] cur = new String[token.length()];
                        for (int j = 0; j < token.length(); j++) {
                            cur[j] = String.valueOf(token.charAt(j));
                        }

                        operandstack.push(evalRPN(cur));
                    }

                }

            } else
                operandstack.push(Integer.valueOf(token));
        }


        return operandstack.pop();


    }

    private static Integer op(Integer operand1, String curop, Integer operand2) {

        switch (curop) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0;
        }


    }


    public static void main(String[] args) {

        int res = evalRPN(new String[]{"3", "-4", "+"});
        System.out.println(res);

//        String token = "18+20";
//        if (token.contains("+")||token.contains("-")||token.contains("*")||token.contains("/"))
//        {
//            System.out.println("yes");
//
//        }

    }
}
