package Top_Interview_Questions_2.again;

import java.util.Stack;

public class Question42_接雨水 {



    
    /*
        首先从左往右遍历，初始化在栈中放入数组的第一个元素索引 0， 用left记下，即记下了A[left]左边的壁高。
        然后往右遍历，当壁高比A[left]低时，将index入栈，直到遇到大于A[left]时，此时A[left] 成为了短板，需要计算一次水量。
        水量的计算方法可以通过总的矩阵和 - 栈中元素的A[index]值。
        然后将 letf 更新为 此时的 i， 将i入栈作为新一轮的左壁高 继续遍历

        这样的问题是，最后一轮，可能无法出现大于左壁高的数 就结束了，那么 最后面的水量就缺失了。
        这里是通过反向遍历 length-1 到 最后一轮的 left  将最后一部分加了回来
     */

    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int left = 0 ;
        int length = height.length;
        int sum = 0 ;
        stack.push(left);                       //初始化

        for (int i = 1 ; i < length ; i ++)
        {
            if (height[i] < height[left])
                stack.push(i);
            else
            {
                int high = height[left];
                int tmp = (i - left)*high;

                while (!stack.isEmpty())
                    tmp -= height[stack.pop()];

                sum += tmp;
                stack.push(i);
                left = i;
            }

        }

        // 不等于时  说明 有缺失
        if(stack.size() != 1) {
            stack.clear();
            int right = length - 1;

            stack.push(length - 1);
            for (int i = length - 2; i >= left; i--) {
                if (height[i] < height[right])
                    stack.push(i);
                else {
                    int high = height[right];
                    int tmp = (right - i) * high;

                    while (!stack.isEmpty())
                        tmp -= height[stack.pop()];

                    sum += tmp;
                    stack.push(i);
                    right = i;
                }
            }
        }

        return sum;
    }
    
    public static void main(String[] args){
        
    
        System.out.println(trap(new int[]{9,6,8,8,5,6,3}));
        
    }
}
