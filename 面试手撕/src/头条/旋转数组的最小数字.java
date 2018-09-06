package 头条;

/**
 * @Auther: minGW
 * @Date: 2018/7/13 09:00
 * @Description:
 *
 * 二分，注意特殊情况,当*mid == *left 且 *mid == *right时，无法判断是哪半边，只能顺序查找。
 *
 * 测试输入数组以后可以使用可变参数
 */
public class 旋转数组的最小数字 {

    public static int minNumberInRotateArray(int...  array) {

        if (array == null || array.length == 0)
            return 0;

        //左右指针,左指针永远指向第一个子数组,右指针永远指向第二个子数组。
        //当左指针指向第一个子数组的最后一个元素，右指针指向第二个子数组的第一个元素时，找到最小值
        int left = 0 , right = array.length - 1;
        int mid = 0;

        while (left < right)
        {
            mid = ((right - left) >> 1) + left;

            if (right - left == 1)
                break;

            if (array[mid] == array[left] && array[mid] == array[right])
                return findMin(array, left, right);

            //令 left = mid ,所以始终指向第一个子数组
            else if (array[mid] >= array[left])
                left = mid;
            else
                right = mid;
        }


        return array[right];
    }


    private static int findMin(int[] array, int left, int right) {

        int min = Integer.MAX_VALUE;
        for (int num : array)
            if (num < min)
                min = num;

        return min;

    }


    public static void main(String[] args){

        System.out.println(minNumberInRotateArray(3,4,5,1,2));
    }
}
