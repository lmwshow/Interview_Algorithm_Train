package hihocoder.编程练习赛41;

import java.util.*;

public class 反转子串 {

    //超时
    public static void chaoshi_main(String[] args) {

        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        String s = in.nextLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')')
                stack.push(s.charAt(i));
            else {
                while (stack.peek() != '(')
                    queue.offer(stack.pop());
                stack.pop();
                while (!queue.isEmpty())
                    stack.push(queue.poll());
            }
        }

        StringBuilder res = new StringBuilder("");
        while (!stack.isEmpty())
            res.append(stack.pop());

        System.out.println(res.reverse());


    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        StringBuilder head = new StringBuilder("");
        StringBuilder tail = new StringBuilder("");
        int left = 0;
        int right = s.length() - 1;

        int reversetime = 0;

        StringBuilder res = new StringBuilder(s);
        while (left < right && left != right-1) {
            while (left < right && res.charAt(left) != ((reversetime & 1) == 0 ? '(' : ')'))
                head.append(res.charAt(left++));

            if (left > right)
                break;

            while (left <= right && res.charAt(right) != ((reversetime & 1) == 0 ? ')' : '('))
                tail.insert(0, res.charAt(right--));

            StringBuilder sub = new StringBuilder(res.substring(left + 1, right)).reverse();
            res.delete(0, res.length());
            res.append(head).append(sub).append(tail);

            reversetime++;
            right = right - 2;

        }


        System.out.println(res.toString());

    }
}
