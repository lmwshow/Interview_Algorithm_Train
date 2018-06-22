import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/15 19:37
 * @Description:
 *
 * 关键在取最后一位数的时候，  当前最小value + 剩余没用的 无法再取的金币，  可能可以取到一个更大的数 也错。 不只是一位，需要循环遍历，同时更新剩余钱数
 */


//正解
//#include <iostream>
//#include <string>
//#include <cstdio>
//
//using namespace std;
//
//        int main()
//        {
//        int a[10];
//        string b;
//        int n, i, max, pos, v = 1, j, min = 0x3f3f3f3f;
//        char c;
//        cin >> n;
//        for (i = 0; i < 9; i++)
//        {
//        cin >> a[i];
//        if (a[i] <= min)
//        {
//        min = a[i];   //min 花费最少
//        pos = i + 1; //pos 数字
//        }
//        }
//        max = n / min;    //多少个最小花费的数，也就是组成的最大数应该有max位！！！
//        c = pos + '0';    //c是花费最少的那个坐标值，因为要使得组成的数字最大,首先考虑的是位数最多
//        b.assign(max, c); //先给b赋值 max个c
//
//        n = n % min;      //n 钱剩余数
//        //下面考虑这个max位的数能不能更大，那也只用考虑坐标比最小数坐标大的数
//        //只有最小数后面的 数的坐标 才可能让这个数变大呀~~
//        //因为要尽可能的大，所以字符串 b 从前面开始遍历 能否把某一位增大
//        //原始序列 a 从后面最大的坐标开始，到 最小花费的坐标，
//        for (j = 0; j < max; j++)
//        {
//        for (i = 8; i >= pos; i--)
//        {
//        if((min+n) >= a[i])  //如果最小的花费 + 剩余的钱 >= i 所需要的钱，也就是可以替换
//        {
//        b[j] = i + 1 + '0';  //替换 b 的当前位
//        n = n + min - a[i];  // 更新剩余的钱 n
//        break;              // 可以开始判断 b 的下一位了。
//        }
//        }
//        }
//        if (b.empty())
//        cout << "-1" << endl;
//        else
//        cout << b << endl;
//        return 0;
//        }

public class 填数字 {

    static class Element{
        int num;
        int value;

        public Element(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10];
        for(int i=1;i<10;i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<10;i++){
            if(min>=a[i]){
                min=a[i];
            }
        }
        if(n<min){
            System.out.println(-1);return ;
        }
        StringBuilder s = new StringBuilder();
        int val = n/min;
        for(int i=9;i>0;i--){
            while(val>0 && n-a[i]>=(val-1)*min){
                s.append(i);
                n-=a[i];
                val--;
            }
        }
        System.out.println(s);




    }
}

