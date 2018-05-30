package hihocoder.编程练习赛50;

import java.util.Scanner;

//题目链接：http://hihocoder.com/problemset/problem/1704

public class 循环数组 {


    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int arr[] = new int[100005];
        Long all = 0L;
        Long sum = 0L;
        Long min = 0L;
        int locat = 0;
        for(int i = 0;i<n;i++){
            arr[i] = cin.nextInt();
            sum += arr[i];
            if(sum<=0){
                if(sum<min)
                    min = sum;
                locat = i;                  //locat之后又是先的一段开头了，和前面就可以分开讨论，因为已经当作旋转后的头了。   不需要将负数再加上前面的累积和  所以sum=0
                sum = 0L;
            }
            all +=arr[i];
        }
        if(all<0)                           //all<0 来判断整体的可行性
            System.out.println(-1);
        else {
            if(sum+min>0)
                System.out.println(locat+2);
            else
                System.out.println(-1);
        }
    }
}
