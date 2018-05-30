package hihocoder.编程练习赛53;

import java.io.*;
import java.util.*;

public class 继承顺位 {


    //构建树,然后先序遍历树(不是二叉树)
    static class King {
        String name;
        List<King> son;
        King parent;

        public King(String name, List<King> son, King parent) {
            this.name = name;
            this.son = son;
            this.parent = parent;
        }
    }

    static final String BIRTH = "birth";
    static final String DEATH = "death";


    public static void main(String[] args) {


//        InputReader in = new InputReader(System.in);
//        OutputWriter out = new OutputWriter(System.out);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        King root = new King(in.next(),new ArrayList<>(),null);
        Map<String, King> map = new HashMap<>();
        map.put(root.name,root);
        List<String> deathlist = new ArrayList<>();
        deathlist.add(root.name);
        String state;
        String name;
        for (int i = 0; i < n; i++) {
            state = in.next();
            if (state.equals(DEATH))
                deathlist.add(in.next());
            else {
                name = in.next();
                King son = new King(in.next(),new ArrayList<>(),map.get(name));
                map.get(name).son.add(son);
                map.put(son.name, son);

            }
        }

        preoreder(root,deathlist);


//        for (String ans : list) {
//            if (!deathlist.contains(ans))
//                System.out.println(ans);
//
//            for (String sonName : map.get(ans)) {
//                if (!deathlist.contains(sonName))
//                    System.out.println(sonName);
//            }
//        }

//        out.println();

//        out.close();


    }

    private static void preoreder(King root, List<String> deathlist) {


        if (!deathlist.contains(root.name))
            System.out.println(root.name);

        for (int i = 0 ; i < root.son.size() ;i++)
            preoreder(root.son.get(i),deathlist);

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

        public Long nextLong() {
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

