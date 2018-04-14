import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/5/15.
 */
public class leetcode84Largest_Rectangle_in_Histogram {

    /*
    超时 O（n^2）
     */
    public static int mylargestRectangleArea(int[] heights) {

        int length = heights.length;
        int max = 0, tmp = 0;
        for (int i = 0; i < length; i++) {
            int minh = heights[i];
            max = heights[i] > max ? heights[i] : max;

            for (int j = i + 1; j < length; j++) {
                minh = heights[j] < minh ? heights[j] : minh;
                tmp = minh * (j + 1 -i);
                max = tmp > max ? tmp : max;
            }
        }

        
        return max;
    }



    public static int largestRectangleArea(int[] heights) {

        int length = heights.length;

        Stack<Integer> stack = new Stack<>();

        int max = 0,i = 0;
        int[] h = new int[length+1];                                         //需要最后一个元素置0，栈中的元素才能全部推出
        h = Arrays.copyOf(heights,length+1);                       //长度为length+1， 最后一个默认0

        while (i < h.length) {


            if (stack.isEmpty()||h[stack.peek()]<=h[i])
            {
                stack.push(i++);
            }else
            {
                int t = stack.pop();
                int width;
                if (stack.isEmpty())
                    width = i;
                else
                    width = i - stack.peek() - 1;                              //当栈不为空是，已当前出栈元素为高的矩阵，宽是i到栈顶元素的下标后一位
                max = Math.max(max,h[t]*width);
            }
        }


        return max;
    }

    
    public static void main(String[] args){
        
        System.out.println(largestRectangleArea(new int[]{4,2,0,3,2,5}));
        
    }

}
