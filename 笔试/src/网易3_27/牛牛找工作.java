package 网易3_27;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//分析
//实际上对于每个难度的工作，只有报酬最高的那一种是可能成为答案的，剩下的都可以无视。
//由于只有N项工作和M个小伙伴，最多只会出现N+M种难度(能力值)，所以可以把难度和能力值映射到不超过N+M个数上(std通过排序+map来完成)。
//对这些难度(能力值)分别求出最高的报酬，再按i从小到大的顺序维护难度(能力值)不超过i的最大报酬。最后输出每个小伙伴对应的能力值以下的最高报酬即可。
//时间复杂度
//O((N+M)*log(N+M))
public class 牛牛找工作 {

    static Map<Long,Integer> map = new HashMap<>();  //映射新的下标
    static int cnt = 0;
    static long ans[] = new long[200005];                 //ans[i]表示 能力值为i时的 最大报酬
    static long d[] = new long[100005];
    static long p[] = new long[100005];
    static long value[] = new long[200005];
    static long a[] = new long[100005];


    public static void main(String[] args){


        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 1 ; i <=n ;i++)
        {
            d[i] = in.nextLong();
            p[i] = in.nextLong();
            value[i] = d[i];                //记录难度
        }

        for (int i = 1 ; i <= m;i++)
        {
            a[i] = in.nextLong();
            value[i+n] = a[i];              //记录能力值
        }

        Arrays.sort(value,1,m+n+1);                 //将能力值和难度放一起排序，准备维护数组ans
        map.put(value[1],++cnt);

        for (int i = 2 ; i <= n+m ;i++)
        {
            if (value[i]!=value[i-1])
            {
                cnt++;
                map.put(value[i],cnt);      //map记录当前难度(能力值)的排完序后在ans中的下标 且已过滤重复
            }
        }

        //将每个工作难度的报酬赋予 当前难度
        for (int i = 1 ; i <= n ; i++)
            ans[map.get(d[i])] = Math.max(ans[map.get(d[i])],p[i]);

        //维护ans数组，使ans[i]表示 能力值为i时的 最大报酬
        for (int i = 2 ; i <= m+n ;i++)
            ans[i] = Math.max(ans[i],ans[i-1]);

        for (int i = 1 ;i <=m ;i++)
            out.println(ans[map.get(a[i])]);


        out.close();




    }



    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {
            super(out);
        }

        public OutputWriter(Writer out) {
            super(out);
        }

        public void close() {
            super.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0;
        private int ptrbuf = 0;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (lenbuf == -1)
                throw new UnknownError();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = stream.read(inbuf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public Long nextLong(){
            long num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }

        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public char[] nextCharArray(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }
    }
}
