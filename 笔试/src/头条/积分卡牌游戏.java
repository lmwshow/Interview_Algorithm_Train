package 头条;

/**
 * @Auther: minGW
 * @Date: 2018/8/12 10:42
 * @Description:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class 积分卡牌游戏
{
    static int MAX=(int)1e5+10;
    static int sorce[][] = new int[2][2*MAX];
    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int cur=1, pre=0;

        initdpArray();

        sorce[0][MAX]=0;

        String[] parts = null;

        for(int i=0;i<n;++i)
        {
            parts = in.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            for(int j=0;j<2*MAX;++j)
            {
                if(sorce[pre][j]!=-1) {
                    sorce[cur][j] = Math.max(sorce[cur][j], sorce[pre][j]);
                    sorce[cur][j - x] = Math.max(sorce[cur][j - x], sorce[pre][j] + y);
                    sorce[cur][j + x] = Math.max(sorce[cur][j + x], sorce[pre][j] + y);
                }
            }
            if (pre == 0)
                pre = 1;
            else
                pre = 0;

            if (cur == 0)
                cur = 1;
            else
                cur = 0;
            pre^=1;
            cur^=1;
        }

        System.out.println(sorce[pre][MAX]);
    }

    private static void initdpArray() {

        for(int i=0;i<2*MAX;i++)
            sorce[0][i]=sorce[1][i]=-1;

    }


}
