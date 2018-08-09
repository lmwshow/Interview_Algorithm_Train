package again;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/8/8 09:27
 * @Description:
 */
public class 接雨水 {

    /*
        首先从左往右遍历，初始化在栈中放入数组的第一个元素索引 0， 用left记下，即记下了A[left]左边的壁高。
        然后往右遍历，当壁高比A[left]低时，将index入栈，直到遇到大于A[left]时，此时A[left] 成为了短板，需要计算一次水量。
        水量的计算方法可以通过总的矩阵和 - 栈中元素的A[index]值。
        然后将 letf 更新为 此时的 i， 将i入栈作为新一轮的左壁高 继续遍历

        这样的问题是，最后一轮，可能无法出现大于左壁高的数 就结束了，那么 最后面的水量就缺失了。
        这里是通过反向遍历 length-1 到 最后一轮的 left  将最后一部分加了回来
     */

    public static int trap(int[] height) {

        int ans = 0;
        if (height == null || height.length == 0)
            return ans;

        Stack<Integer> stack = new Stack();

        int left = 0;
        stack.push(left);

        for (int i = 1 ; i < height.length ; i++)
        {
            if (height[i] < height[left])
            {
                stack.push(i);
            }else
            {
                int tmp = (i - left)*height[left];

                while (!stack.isEmpty())
                    tmp -= height[stack.pop()];

                ans += tmp;

                left = i;
                stack.push(i);
            }
        }

        // 不等于1时  说明 有缺失
        if (stack.size() != 1)
        {
            stack.clear();
            int right = height.length - 1;
            stack.push(right);

            for (int i = height.length - 2; i >= left ; i--)
            {
                if (height[i] < height[right])
                    stack.push(i);
                else {
                    int tmp = (right - i)*height[right];

                    while (!stack.isEmpty())
                        tmp -= height[stack.pop()];

                    ans += tmp;
                    right = i;
                    stack.push(i);
                }
            }
        }

        return ans;

    }

    public static void main(String[] args){


        System.out.println(trap(new int[]{1}));

    }
}
