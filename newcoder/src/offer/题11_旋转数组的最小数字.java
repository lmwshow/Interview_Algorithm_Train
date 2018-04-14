package offer;

/**
 * Created by Gracecoder on 2017/12/8.
 *
 * 对于排序或者部分排序的队列，都可以用二分查找
 *
 * 这里旋转数组，可以通过和array[0] 和 array[length-1] 比较大小，判断当前的位置在哪一段
 */
public class 题11_旋转数组的最小数字 {

    public static int minNumberInRotateArray(int [] array) {

        if(array == null||array.length == 0)
            return 0;

        int left = 0 ;
        int right = array.length - 1;

        while (left <= right)
        {
            int mid = (right - left)/2 +left;
            if (array[mid] < array[mid+1] && array[mid] < array[mid-1])
                return array[mid];

            if (array[mid] >= array[0])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return array[left];

    }


    public static void main(String[] args){

        System.out.println(minNumberInRotateArray(new int[]{1,0,1,1,1}));


    }
}
