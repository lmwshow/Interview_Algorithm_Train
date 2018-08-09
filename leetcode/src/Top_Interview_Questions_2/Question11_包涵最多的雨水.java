package Top_Interview_Questions_2;

public class Question11_包涵最多的雨水 {

    public int maxArea(int[] height) {

        if(height == null || height.length < 2)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right)
        {
            maxArea = Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;

    }
}
