package newcoder2018_3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    static class Edge{
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws ParseException {

//        Scanner in = new Scanner(System.in);
//
//        Edge[] edges = new Edge[1];
//        Arrays.sort(edges, new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return 0;
//            }
//        });
//        Edge edge = new Edge(in.nextInt(),in.nextInt(),in.nextInt());


        Map<Integer,Map<String,Integer>> map = new HashMap<>();

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = "2015-01-01 19:03:34";

        String date2 = "2015-01-03 15:03:34";



        Date date1 = format1.parse(date);
        System.out.println(date1);

    }
}
