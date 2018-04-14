package dp.dfs_backtracking查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/4/11.
 */
public class leetcode77组合数 {

    public static List<List<Integer>> mycombine(int n, int k) {

        List<List<Integer>> combineList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            combineList.add(tmp);
        }

        int length = combineList.size();

        if (k == 1)
            return combineList;
        else
            for (int i = 1 ; i < k ;i++)
                combineList.remove(--length);                   //根据k的大小，删除倒数k-1个元素

        int curlength = 1;
        while (--k > 0) {
            for (int i = 0; i < combineList.size(); i++) {
                List<Integer> tmp = combineList.get(i);
                if (tmp.size() == curlength) {                                   //因为不断向List里面添加先组合，加入的是已经在当前轮插入过的，就不需要再插入了
                    int last = tmp.get(curlength - 1);
                    if (last < n && (n-last)>=k) {                              //相当于减枝，后面不够了
                        last++;
                        tmp.add(last);
                        combineList.set(i, tmp);
                    }
                    while (last < n && (n-last)>=k) {                                           //如果最后一个元素仍然小于n，那么还可以换一个大的继续插入。 这时候要先拷贝出来，再删除最后一个刚插入的元素，然后插入新的
                        last++;
                        List<Integer> tmp1 = new ArrayList<>();
                        tmp1.addAll(combineList.get(i));
                        tmp1.remove(curlength);
                        tmp1.add(last);
                        combineList.add(tmp1);
                    }
                }

            }
            curlength++;

        }

        return combineList;
    }

    //LinkedList 和 ArrayList都实现了 List接口，  LinkedList更适用于插入

    //递归
    //Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).

    //Here C(n,k) is divided into two situations. Situation one, number n is selected, so we only need to select k-1 from n-1 next. Situation two, number n is not selected, and the rest job is selecting k from n-1.
    public static List<List<Integer>> combine(int n, int k) {

        if (k == n || k == 0)
        {
            List<Integer> row = new LinkedList<>();
            for (int i = 1 ; i <=k ; i++)
                row.add(i);

            return new LinkedList<>(Arrays.asList(row));

        }

        List<List<Integer>> result = combine(n-1,k-1);
//        result.forEach(e -> e.add(n));
        for (int i = 0; i < result.size(); i++)
            result.get(i).add(n);
        result.addAll(combine(n-1,k));
        return result;


    }


    //DFS 和 Backtracking
    //C++ 可以通过值传递curr和引用传递res， 达到DFS的目的
    //但是 java对于List的传递 都是引用，故我们采用在最终add到res里是，使用new ArrayList<Integer>(curr) 来根据curr创建一个新的list变量
    public static List<List<Integer>> DFScombine(int n,int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (n<=0)
            return res;
        List<Integer> curr = new ArrayList<>();

        DFS(res,curr,n,k,1);
        return res;
    }

    private static void DFS(List<List<Integer>> res, List<Integer> curr, int n, int k, int level) {

        if (curr.size() == k)
        {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if (curr.size() > k)
            return;

        for (int i = level; i <= n ; i++)
        {
            curr.add(i);
            DFS(res,curr,n,k,i+1);                           //进入下一层，i已经用过了
            curr.remove(curr.size()-1);                     //回溯
        }
    }


    public static void main(String[] args) {

        List<List<Integer>> combineList = DFScombine(3, 3);
        System.out.println("sasd");

    }

//        public static void main(String[] args)
//        {
//            Integer n1 = new Integer(47);
//            Integer n2 = 47;
//            Integer n3 = 47 ;
//            System.out.println(n2 == n1);
//            System.out.print(n2 == n3);
//            System.out.print(",");
//            System.out.println(n1 != n2);
//        }
}
