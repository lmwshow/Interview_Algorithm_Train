package sort;

import java.util.Random;

/**
 * @Auther: minGW
 * @Date: 2018/5/7 10:46
 * @Description:
 * 比较排序算法的一种。内省排序的实现过程是这样的，首先由快速排序开始，当递归深度超过一定程度时，

    转换为堆排序。所以内省排序既能在常规数据集上实现快速排序的高性能，又能在最坏情况下仍保持
 */
public class sort_neixing_asc {


    public static int sort_neixing_asc(int[] array, int start, int end, int level) {
        level++;

        int length = end - start + 1;
        if (length < 2)
            return level;
        else if (length == 2) {
            if (array[start] > array[end])
                swap(array, start, end);

            return level;
        } else {

            //得出最大值和最小值
            int min = array[start], max = array[end];
            for (int i = start; i < start + length; i++) {
                if (array[i] < min)
                    min = array[i];
                if (array[i] > max)
                    max = array[i];
            }

            //找出合适的中间数(按中间值找,最好是像计数排序一样先统计比元素小的个数,然后按照个数确定哪个做中间数)
            //这是遍历数组找出和中间值偏移最小的值,作为keyPoint

            int absMid = (min + max) >> 1;
            int offset = Math.abs(array[start] - absMid);
            int relativeMid = array[start];
            int midIndex = start;

            //找出中间值
            for (int i = start; i < start + length; i++)
                if (Math.abs(array[i] - absMid) < offset) {
                    offset = Math.abs(array[i] - absMid);
                    relativeMid = array[i];
                }

            int[] newArray = new int[length];
            for (int i = 0; i < length; i++)
                newArray[i] = -1;

            for (int i = start, startIndex = 0, endIndex = length - 1; i < start + length; i++) {
                if (array[i] < relativeMid)
                    newArray[startIndex++] = array[i];
                if (array[i] > relativeMid)
                    newArray[endIndex--] = array[i];
            }

            for (int i = 0; i < newArray.length; i++)
                if (newArray[i] == -1)
                    newArray[i] = relativeMid;

            //通过中间值，找出分界值keyPoint
            for (int i = start, newIndex = 0; i < start + length; i++, newIndex++) {
                array[i] = newArray[newIndex];
                if (array[i] == relativeMid)
                    midIndex = i;
            }

            //深度小于10时使用快速排序
            if (level < 10) {
                sort_neixing_asc(array, start, midIndex - 1, level);
                sort_neixing_asc(array, midIndex + 1, end, level);
            } else {
                //递归深度大于10时,使用堆排序
                heap_sort_asc(array, array.length);
            }

            return level;

        }
    }

    private static void swap(int[] array, int start, int end) {

        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;

    }

    /**
     * 产生随机数组
     */

    public static int[] createRandomArray(int n, int max) {
        int[] array = new int[n];
        boolean[] bool = new boolean[max];
        for (int i = 0; i < array.length; i++) {
            int num;
            do {
                num = new Random().nextInt(max);
            } while (bool[num]);
            bool[num] = true;
            array[i] = num;
        }
        return array;
    }


     /*
    堆排序算法
     */

    public static void heap_sort_asc(int[] arr, int len) {

        //调整前半部分元素，调整完之后第一个元素是序列的最大的元素
        for (int i = (len >> 1) - 1; i >= 0; i--)
            heap_adjsut(arr, i, len);


        for (int i = len - 1; i > 0; i--) {
            // 将第1个元素与当前最后一个元素交换，保证当前的最后一个位置的元素都是现在的这个序列中最大的
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            heap_adjsut(arr, 0, i);
        }
    }

    /**
     * 将数组arr构建大根堆
     *
     * @param arr 待调整的数组
     * @param i   待调整的数组元素的下标
     * @param len 数组的长度
     */
    private static void heap_adjsut(int[] arr, int i, int len) {

        int child;
        int temp;

        //从上往下调整，知道没有子节点，或者没有破坏堆性质
        for (; 2 * i + 1 < len; i = child) {
            child = 2 * i + 1;    //左子节点的位置

            if (child < len - 1 && arr[child + 1] > arr[child])            //存在右子节点，且大于左子节点
                child++;

            // 如果较大的子节点大于父节点，那么把较大的子节点往上移动
            if (arr[child] > arr[i]) {
                temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
            } else {
                break;
            }

        }


    }

    public static void main(String[] args) {

        int[] array;
        array = createRandomArray(200, 1000);
        //升序
        sort_neixing_asc(array, 0, array.length - 1, 0);

        for (int x : array)
            System.out.println(x);
    }

}
