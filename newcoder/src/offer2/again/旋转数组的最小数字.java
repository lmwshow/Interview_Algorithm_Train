package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/9 07:45
 * @Description: https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * 关键点是原数组是非递减的，所以二分时，会有一种情况无法判断最小值在左边还是在右边
 *
 * 这次思路是有了，是个好题! 就放这里了
 */
public class 旋转数组的最小数字 {

    public static int minNumberInRotateArray(int [] array) {

        int ans = 0;
        if (array == null || array.length == 0)
            return ans;

        int left = 0 ,right = array.length-1;
        int mid = 0;
        while (left <= right)           // <=
        {
            mid = ((right - left) >> 1) + left;
            if (array[mid] > array[left])
                left = mid + 1;
            else if (array[mid] < array[right])
                right = mid;
            else 
                return findMin(array, left, right);
                
        }
        
        ans = array[left];
        return ans;
        
        

    }

    private static int findMin(int[] array, int left, int right) {
        
        int min = Integer.MAX_VALUE;
        for (int num : array)
            if (num < min)
                min = num;
        
        return min;
        
    }


//    public static int minNumberInRotateArray(int [] array) {
//
//        if(array == null||array.length == 0)
//            return 0;
//
//        int left = 0 ;
//        int right = array.length - 1;
//        int mid = 0;
//
//        while (array[left]>=array[right])
//        {
//            if (right - left == 1)
//                return array[right];
//
//            mid = (right - left)/2 + left;
//
//            if (array[left] == array[right] && array[left] == array[mid])
//                return minInOrder(array,left,right);
//
//            if (array[mid] >= array[left])
//                left = mid;
//            else if (array[mid] <= array[right])
//                right = mid;
//        }
//
//        return array[mid];
//
//    }



    public static void main(String[] args){
        
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
}
