package 头条;

/**
 * @Auther: minGW
 * @Date: 2018/9/7 14:22
 * @Description:
 */
public class 错排 {



    //这属于完全错排问题
    int totalWrong(int n)
    {
        int[] dp = new int[n + 1];
        dp[1]=0;dp[2]=1;
        for(int i=3;i<=n;++i)
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        return dp[n];
    }
    //可以看看只跟前两个变量值有关，所以可以使用两个变量来节省空间
    int totalWrong2(int n)
    {
        int a=0,b=1;
        int ans=1;
        for(int i=3;i<=n;++i){
            ans=(i-1)*(a+b);
            a=b;b=ans;
        }
        return (n==1)?0:ans;
    }
}
