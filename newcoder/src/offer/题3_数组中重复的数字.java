package offer;

/**
 * Created by Gracecoder on 2017/12/2.
 */
public class 题3_数组中重复的数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (numbers == null)
            return false;

        for (int i = 0; i < length; i++)
            if (numbers[i]<0 || numbers[i]>=length)
                return false;

        for (int i = 0; i < numbers.length ; i++)
        {
            //移动，将数据刚在对应大小下标数组中
            while (numbers[i]!=i)
            {
                if (numbers[numbers[i]]==numbers[i])
                {
                    duplication[0] = numbers[i];
                    return true;
                }

                //swap
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }

        return false;

    }


    //想象成链表，错误。
    public static boolean my_duplicate(int numbers[],int length,int [] duplication) {

        if (numbers == null)
            return false;

        for (int i = 0; i < length; i++)
            if (numbers[i]<0 || numbers[i]>=length)
                return false;

        int curIndex = numbers[0];          //第一个访问的数是numbers[0]
        int k = 0;
        while (k++ < length)
        {
            if (numbers[curIndex] == -1)
            {
                duplication[0] = curIndex;
                return true;
            }
            int tmp = curIndex;
            curIndex = numbers[curIndex];
            numbers[tmp] = -1;
        }



        return false;

    }


    public static void main(String[] args){

        boolean res = my_duplicate(new int[]{2,1,3,0,4},5,new int[1]);
        System.out.println(res);
        
    }




    //类似题：Find_All_Numbers_Disappeared_in_an_Array

}
