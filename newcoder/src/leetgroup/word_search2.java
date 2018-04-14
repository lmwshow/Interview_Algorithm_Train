package leetgroup;

import javax.xml.soap.SAAJResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gracecoder on 2017/7/28.
 *
 * 回溯 + 字典树Trie
 * https://leetcode.com/problems/word-search-ii/discuss/
 *
 * 59ms: Use search and startsWith in Trie class like this popular solution.
 * 33ms: Remove Trie class which unnecessarily starts from root in every dfs call.
 * 30ms: Use w.toCharArray() instead of w.charAt(i).
 * 22ms: Use StringBuilder instead of c1 + c2 + c3.
 * 20ms: Remove StringBuilder completely by storing word instead of boolean in TrieNode.
 * 20ms: Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
 * 18ms: check validity, e.g., if(i > 0) dfs(...), before going to the next dfs.
 * 17ms: De-duplicate c - a with one variable i.
 * 15ms: Remove HashSet completely. dietpepsi's idea is awesome.
 */
public class word_search2 {

    public static List<String> findWords(char[][] board, String[] words) {


        List<String> res = new ArrayList<>();
        if (board==null || words == null)
            return res;
        TrieNode root = buildTrie(words);

        for (int i = 0 ; i < board.length ; i ++)
            for (int j = 0 ; j < board[0].length; j ++)
            {
                dfs(res,board,i,j,root);
            }

        return res;

    }

    private static void dfs(List<String> res, char[][] board, int i, int j, TrieNode p) {

        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null)
            return;

        p = p.next[c-'a'];

        if (p.word!=null)       //findone
        {
            res.add(p.word);
            p.word = null;      //de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(res,board, i - 1, j ,p);
        if (j > 0) dfs(res,board, i, j - 1, p);
        if (i < board.length - 1) dfs(res,board, i + 1, j, p);
        if (j < board[0].length - 1) dfs(res,board, i, j + 1, p);
        board[i][j] = c;

    }




    private static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String w: words)
        {
            TrieNode p = root;
            for (char c : w.toCharArray())
            {
                if (p.next[c-'a']==null)
                    p.next[c-'a'] = new TrieNode();
                p = p.next[c-'a'];
            }

            p.word = w;
        }

        return root;
    }

    static class TrieNode
    {
        String word;        //用来表示该节点表示的word

        TrieNode[] next = new TrieNode[26];
    }



    public static void main(String[] args){

        char[][] board = new char[][]{{'o', 'a', 'a','n'}, {'e', 't', 'a','e'}, {'i', 'h', 'k','r'},{'i','f','l','v'}};
        String[] strings = new String[]{"oath","pea","eat","rain"};
        List<String> res = findWords(board, strings);
        System.out.println(res.size());

        for (String word : res) {
            System.out.println(word);


        }


    }
}
