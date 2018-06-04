import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/2 10:25
 * @Description:
 */
public class Main {

    static int max ;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        int max = Integer.MIN_VALUE,temp = max,zero = 0;
        int head = 0,tail = 0;
        while(tail<n) {
            if(temp<0) {
                temp = Math.max(temp, nums[tail]);
                if(temp>=0) head = tail;
            }else {
                temp += nums[tail];
            }
            max = Math.max(max, temp);
            if(nums[tail]==0&&zero++==3) {
                while(head<tail) {
                    temp -= nums[head];
                    if(nums[head++]==0) {
                        zero --;
                        break;
                    }
                }
            }
            tail++;
        }
        System.out.println(max);
    }
}
